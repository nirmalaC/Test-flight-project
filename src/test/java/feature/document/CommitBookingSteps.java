package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.FlightFinder;
import com.api.example.fixture.helpers.BasketHelper;
import com.api.example.fixture.helpers.BookingHelper;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.queryparams.FlightQueryParams;
import com.api.example.fixture.invoke.queryparams.FlightQueryParamsFactory;
import com.api.example.fixture.invoke.requests.FlightsRequest;
import com.api.example.fixture.invoke.requests.booking.CommitBookingRequest;
import com.api.example.fixture.invoke.response.basket.Basket;
import com.api.example.fixture.invoke.response.bookingconfirmation.BookingConfirmationResponse;
import com.api.example.fixture.invoke.response.flights.Flight;
import com.api.example.fixture.invoke.services.FlightsService;
import com.api.example.fixture.invoke.services.ServiceFactory;
import com.api.example.fixture.invoke.services.booking.CommitBookingService;
import com.api.example.fixture.invoke.services.booking.GetBookingService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static com.api.example.fixture.asserters.models.CommitBookingExpectedErrors.COMMIT_BOOKING_VALID_ERRORS;
import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * Created by prite on 09/11/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class CommitBookingSteps {
    protected static Logger LOG = LogManager.getLogger(CommitBookingSteps.class);

    private FlightQueryParams params;
    private FlightsService flightsService;
    private Integer availableSeatsBeforeAddToBasket;
    private Integer availableSeatsAfterAddToBasket;
    private CommitBookingService commitBookingService;
    private String channelUsed;
    private BookingConfirmationResponse bookingResponse;
    private GetBookingService getBookingService;
    private Basket basket;

    @Autowired
    private BasketHelper basketHelper;
    @Autowired
    private BookingHelper commitBookingHelper;
    @Autowired
    private ServiceFactory serviceFactory;
    @Autowired
    private FlightFinder flightFinder;
    private Flight flight;

    @Given("^I have a valid booking$")
    public void iHaveAValidBooking() throws Throwable {
        CommitBookingRequest commitBookingRequest = commitBookingHelper.createNewBookingRequest();
    }

    @When("^I do the commit booking for \"([^\"]*)\"$")
    public void iDoTheCommitBookingFor(String parameter) throws Throwable {
        CommitBookingRequest commitBookingRequest = commitBookingHelper.createNewBookingRequestForError(parameter);
        commitBookingService = serviceFactory.get(commitBookingRequest);
        commitBookingService.invoke();
    }

    @Then("^an error message is returned for each \"([^\"]*)\"$")
    public void anErrorMessageIsReturnedForEach(String parameter) throws Throwable {
        commitBookingService.assertThatErrors().containedTheCorrectErrorMessageFor(parameter, COMMIT_BOOKING_VALID_ERRORS);
    }

    @Given("^I have a basket with a valid flight for \"([^\"]*)\"$")
    public void iHaveABasketWithAValidFlightFor(String channel) throws Throwable {
        this.channelUsed = channel;
        params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight()).adult("1").build();
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channel).build(), params));
        flightsService.invoke();
        flight = flightsService.getOutboundFlight();
        availableSeatsBeforeAddToBasket = flight.getInventory().getAvailable();
        basketHelper.addFlightToBasketAsChannel(flight, channel);
    }

    @When("^I do the commit booking$")
    public void iDoTheCommitBooking() throws Throwable {
        CommitBookingRequest commitBookingRequest;
        if (channelUsed == "") {
            channelUsed = "Digital";
        }
        commitBookingRequest = commitBookingHelper.createNewBookingRequestForChannelBasedOnBasket(channelUsed, basketHelper.getBasketService().getResponse());
        basketHelper.getBasket(basketHelper.getBasketService().getResponse().getBasket().getCode(), channelUsed);
        commitBookingService = serviceFactory.get(commitBookingRequest);
        commitBookingService.invoke();
        commitBookingService.assertThat().gotAValidResponse();
        bookingResponse = commitBookingService.getResponse();
    }

    @Then("^the inventory is deallocated once the flight is cancelled$")
    public void theInventoryIsDeallocatedOnceTheFlightIsCancelled() throws Throwable {
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channelUsed).build(), params));
        flightsService.invoke();
        flightsService.assertThat().hasNumberOfSeatsAvailableEqualTo(availableSeatsBeforeAddToBasket);
    }

    @Then("^the inventory is not deallocated once the flight is cancelled$")
    public void theInventoryIsNotDeallocatedOnceTheFlightIsCancelled() throws Throwable {
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channelUsed).build(), params));
        flightsService.invoke();
        flightsService.assertThat().hasNumberOfSeatsAvailableEqualTo(availableSeatsBeforeAddToBasket);
    }

    @And("^an error message is returned for the cancelled flight$")
    public void anErrorMessageIsReturnedForTheCancelledFlight() throws Throwable {
        commitBookingService.assertThatErrors().containsText("Flight is cancelled");
    }

    @Then("^an error message is returned for duplicate booking$")
    public void anErrorMessageIsReturnedForDuplicateBooking() throws Throwable {
        commitBookingService.assertThatErrors().containsText("Duplicate booking");
    }

    @Then("^an error message is returned for not allocating booking$")
    public void anErrorMessageIsReturnedForNotAllocatingBooking() throws Throwable {
        commitBookingService.assertThatErrors().containsText("Unable to allocate booking");
    }

    @Given("^I have multiple flights with passenger mix for \"([^\"]*)\"$")
    public void iHaveMultipleFlightsWithPassengerMixFor(String channel) throws Throwable {
        this.channelUsed = channel;
        //1st flight
        params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight()).adult("1").build();
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channel).build(), params));
        flightsService.invoke();
        flight = flightsService.getOutboundFlight();
        basketHelper.addFlightToBasketAsChannel(flight, channel);

        //2nd flight
        params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight()).adult("1").child("1").infant("1").build();
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channel).build(), params));
        flightsService.invoke();
        flight = flightsService.getInboundFlight();
        basketHelper.addFlightToBasketAsChannel(flight, channel);
    }

    @And("^a booking reference is returned")
    public void aBookingReferenceIsReturned() throws Throwable {
        assertThat(bookingResponse.getBookingConfirmation().getBookingReference()).isNotEmpty();
    }

    @And("^the inventory is allocated before the commit booking$")
    public void theInventoryIsAllocatedBeforeTheCommitBooking() throws Throwable {
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channelUsed).build(), params));
        flightsService.invoke();
        flightsService.assertThat().hasNumberOfSeatsAvailableEqualTo(availableSeatsBeforeAddToBasket);
    }

    @Then("^the inventory is not allocated after the commit booking$")
    public void theInventoryIsNotAllocatedAfterTheCommitBooking() throws Throwable {
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channelUsed).build(), params));
        flightsService.invoke();
        flightsService.assertThat().hasNumberOfSeatsAvailableEqualTo(availableSeatsBeforeAddToBasket);
    }

    @And("^the inventory is not yet allocated before the commit booking$")
    public void theInventoryIsNotYetAllocatedBeforeTheCommitBooking() throws Throwable {
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channelUsed).build(), params));
        flightsService.invoke();
        flightsService.assertThat().hasNumberOfSeatsAvailableEqualTo(availableSeatsBeforeAddToBasket);
    }

    @Then("^the inventory is allocated after the commit booking$")
    public void theInventoryIsAllocatedAfterTheCommitBooking() throws Throwable {
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channelUsed).build(), params));
        flightsService.invoke();
        flightsService.assertThat().hasNumberOfSeatsAvailableEqualTo(availableSeatsBeforeAddToBasket);
    }

    @Given("^I have committed a booking via \"([^\"]*)\"$")
    public void iHaveCommittedABookingVia(String channel) throws Throwable {
        bookingResponse = commitBookingHelper.createNewBooking(commitBookingHelper.createNewBookingRequestForChannel(channel));
    }

    @Then("^the inventory is allocated$")
    public void theInventoryIsAllocated() throws Throwable {
        flightsService.assertThat().theNumberOfSeatsAvailableOnTheFlightIsLessThan(availableSeatsBeforeAddToBasket);
    }

    @Then("^Order is created from Cart$")
    public void orderIsCreatedFromCart() throws Throwable {
        commitBookingHelper.getBookingDetails(bookingResponse.getBookingConfirmation().getBookingReference(), channelUsed);
        commitBookingHelper.getGetBookingService().assertThat().theBasketWasAddedToTheBooking(basketHelper.getBasketService().getResponse());
    }

    @Then("^Passenger details are created with status as Booked$")
    public void passengerDetailsAreCreatedWithStatusAsBooked() throws Throwable {
        commitBookingHelper.getBookingDetails(bookingResponse.getBookingConfirmation().getBookingReference(), channelUsed);
        commitBookingHelper.getGetBookingService().assertThat().thePassengersDetailsAreStoredInTheBooking(basketHelper.getBasketService().getResponse());
    }

    @Then("^Customer profile is linked with the booking$")
    public void customerProfileIsLinkedWithTheBooking() throws Throwable {
        commitBookingHelper.getBookingDetails(bookingResponse.getBookingConfirmation().getBookingReference(), channelUsed);
        commitBookingHelper.getGetBookingService().assertThat().theCustomerDetailsAreAssociatedWithTheBooking(commitBookingHelper.GetCustomerProfileService().getResponse().getCustomer());
    }

    @Then("^Created date time is stored$")
    public void createdDateTimeIsStored() throws Throwable {
        commitBookingHelper.getBookingDetails(bookingResponse.getBookingConfirmation().getBookingReference(), channelUsed);
        commitBookingHelper.getGetBookingService().assertThat().theBookingTimeIsRecorded();
    }

    @Then("^Inventory is not allocated again$")
    public void inventoryIsNotAllocatedAgain() throws Throwable {
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channelUsed).build(), params));
        flightsService.invoke();
        flight = flightsService.getOutboundFlight();
        flightsService.assertThat().hasNumberOfSeatsAvailableEqualTo(availableSeatsAfterAddToBasket);
    }

    @And("^the seats are allocated$")
    public void theSeatsAreAllocated() throws Throwable {
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channelUsed).build(), params));
        flightsService.invoke();
        flight = flightsService.getOutboundFlight();
        availableSeatsAfterAddToBasket = flight.getInventory().getAvailable();
    }

}