package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.FlightFinder;
import com.api.example.fixture.helpers.BasketHelper;
import com.api.example.fixture.helpers.FlightHelper;
import com.api.example.fixture.helpers.Passengers;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.queryparams.FlightQueryParams;
import com.api.example.fixture.invoke.queryparams.FlightQueryParamsFactory;
import com.api.example.fixture.invoke.requests.FlightsRequest;
import com.api.example.fixture.invoke.response.basket.AddFlight;
import com.api.example.fixture.invoke.response.flights.Flight;
import com.api.example.fixture.invoke.services.FlightsService;
import com.api.example.fixture.invoke.services.ServiceFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static com.api.example.fixture.asserters.models.AddFlightExpectedErrors.ADD_FLIGHT_VALID_ERRORS;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by AndrewGr on 09/11/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class AddFlightToBasketValidationSteps {

    protected static Logger LOG = LogManager.getLogger(AddFlightToBasketValidationSteps.class);
    @Autowired
    private BasketHelper basketHelper;
    @Autowired
    private FlightFinder flightFinder;
    @Autowired
    private ServiceFactory serviceFactory;

    private Flight flight;
    private AddFlight addFlight;

    //@Autowired
    public AddFlightToBasketValidationSteps() {

    }

/*    @Given("^a valid add flight request$")
    public void iHaveFoundAFlightToAddToMyBasket() throws Throwable {
        FlightQueryParams queryParams = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight()).build();
        FlightsService flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), queryParams));
        flightsService.invoke();
        addFlight = basketHelper.CreateAddFlightRequest(flightsService.getOutboundFlight());
    }

    @Then("^a missing field error is returned$")
    public void aMissingFieldErrorIsReturned() throws Throwable {
        //empty as manual test now
        //  assertThat(basketClient.getErrors().toString()).contains("Missing field");
        //assertThat(basketHelper.getBasketService().getResponse().getBasket().getAdditionalProperties().toString()).contains("Missing");
    }
    */

    @Given("^the maximum number of flights maximum is (\\d+)$")
    public void theMaximumNumberOfFlightsMaximumIs(int arg0) throws Throwable {
        //nothing here, need to check in config
        //TODO: check in DB for configured max flights
    }

    @And("^I have added (\\d+) flights to my basket$")
    public void iHaveAddedFlightsToMyBasket(int numberOfFlights) throws Throwable {
        basketHelper.addNumberOfFlightsToBasket(numberOfFlights);

    }

    @When("^I add the flight to my basket$")
    public void iAddTheFlightToMyBasket() throws Throwable {
        basketHelper.myBasketContainsAFlightWithPassengerMix("1 Adult");
    }

    @Given("^my basket contains \"([^\"]*)\" flight$")
    public void myBasketContainsFlight(int numberOfFlights) throws Throwable {
        basketHelper.addNumberOfFlightsToBasket(numberOfFlights);
    }

    @Given("^a cancelled flight$")
    public void aCancelledFlight() throws Throwable {
//        flight = flightsClient.getACanceledFlight();
//        LOG.info("Found canceled Flight: " + flight.getFlightKey());
        throw new PendingException();
    }

    @Given("^a Sold Out flight$")
    public void aSoldoutFlight() throws Throwable {
//        flight = flightsClient.getASoldOutFlight();
//        LOG.info("Found Sold Out Flight: " + flight.getFlightKey());
        throw new PendingException();
    }

    @Given("^I have a valid flight that exceeds the infant on own seat limit$")
    public void iHaveAValidFlightThatExceedsTheInfantOnOwnSeatLimit() throws Throwable {
        String passengerMix = "2 Adult, 2 Infant OOS";
        FlightQueryParams params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight(27), new Passengers(passengerMix));
        FlightsService flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), params));
        flightsService.invoke();
        flight = flightsService.getOutboundFlight();
    }

    @When("^I try to add the flight to my basket$")
    public void iTryToAddTheFlightToMyBasket() throws Throwable {
        flight = new FlightHelper().updateInfantQuantity(25, flight, true);
        basketHelper.addAFlightToMyBasket(flight);
    }

    @Then("^the \"([^\"]*)\" error should be returned$")
    public void theErrorShouldBeReturned(String parameter) throws Throwable {
        basketHelper.getBasketService().assertThatErrors().containedTheCorrectErrorMessageFor(parameter, ADD_FLIGHT_VALID_ERRORS);
    }

    @And("^the flight is not added to the basket$")
    public void theFlightIsNotAddedToTheBasket() throws Throwable {
        basketHelper.getBasketService().assertThatErrors().wereReturned();
    }

    @Given("^I have a flight fare that has different price now to what it was when first received$")
    public void iHaveAFlightFareThatHasDifferentPriceNowToWhatItWasWhenFirstReceived() throws Throwable {
        String passengerMix = "1 Adult";
        FlightQueryParams params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight(13), new Passengers(passengerMix));
        FlightsService flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), params));
        flightsService.invoke();
        flight = flightsService.getOutboundFlight();
        flight.getFareTypes().get(0).getPassengers().get(0).setBasePrice(299.13);
    }

    @Then("^the \"([^\"]*)\" warning should be returned$")
    public void theWarningShouldBeReturned(String arg0) throws Throwable {
        basketHelper.getBasketService().assertThat().thePriceChangedWarningIsReturned();
    }

    @And("^the flight is added to the basket$")
    public void theFlightIsAddedToTheBasket() throws Throwable {
        basketHelper.getBasket(basketHelper.getBasketService().getResponse().getBasket().getCode());
        basketHelper.getBasketService().assertThat().theBasketContainsTheFlight(flight);
    }

    @Given("^I have a flight request with missing \"([^\"]*)\"$")
    public void iHaveAFlightRequestWithMissing(String fieldKey) throws Throwable {
        String passengerMix = "1 Adult";
        FlightQueryParams params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight(13), new Passengers(passengerMix));
        FlightsService flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), params));
        flightsService.invoke();
        flight = flightsService.getOutboundFlight();
        addFlight = new FlightHelper().SetFieldAsMissing(fieldKey, basketHelper.CreateAddFlightRequest(flight));
    }

    @When("^I attempt to add the flight to my basket$")
    public void iAttemptToAddTheFlightToMyBasket() throws Throwable {
        basketHelper.addFlightToBasketAsChannel(addFlight, "Digital");
    }

    @Given("^I have a flight request with invalid \"([^\"]*)\"$")
    public void iHaveAFlightRequestWithInvalid(String fieldKey) throws Throwable {
        String passengerMix = "1 Adult";
        FlightQueryParams params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight(13), new Passengers(passengerMix));
        FlightsService flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), params));
        flightsService.invoke();
        flight = flightsService.getOutboundFlight();
        addFlight = new FlightHelper().SetFieldAsInvalid(fieldKey, basketHelper.CreateAddFlightRequest(flight));
    }

    @Then("^the \"([^\"]*)\" invalid field error should be returned$")
    public void theInvalidFieldErrorShouldBeReturned(String parameter) throws Throwable {
        basketHelper.getBasketService().assertThatErrors().containedTheCorrectValueBasedErrorMessageFor(parameter, ADD_FLIGHT_VALID_ERRORS, new FlightHelper().GetFieldValue(addFlight, parameter));
    }

    @Given("^a valid flight exists with \"([^\"]*)\" seats available$")
    public void aValidFlightExistsWithSeatsAvailable(String passengerMix) throws Throwable {
        FlightQueryParams params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight(3), new Passengers(passengerMix));
        FlightsService flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), params));
        flightsService.invoke();
        flight = flightsService.getOutboundFlight();
    }

    @When("^I try to add the flight to my basket with the pasenger mix \"([^\"]*)\"$")
    public void iTryToAddTheFlightToMyBasketWithThePasengerMix(String arg0) throws Throwable {
        flight = new FlightHelper().updateInfantQuantity(2, flight, false);
        basketHelper.addAFlightToMyBasket(flight);
    }

    @Then("^the infants are not associated to one adult$")
    public void theInfantsAreNotAssociatedToOneAdult() throws Throwable {
        basketHelper.getBasketService().assertThat().aSingleAdultCannotHaveMultipleInfantsOnTheirLap();
    }

    @Then("^error \"([^\"]*)\" is returned$")
    public void errorIsReturned(String parameter) throws Throwable {
        basketHelper.getBasketService().assertThatErrors().containedTheCorrectErrorMessageFor(parameter, ADD_FLIGHT_VALID_ERRORS);
    }

    @And("^the total number of passengers is (\\d+)$")
    public void theTotalNumberOfPassengersIs(int totalPax) throws Throwable {
        basketHelper.getBasketService().assertThat().theTotalNumberOfOutboundPassengersIs(totalPax);
    }
}
