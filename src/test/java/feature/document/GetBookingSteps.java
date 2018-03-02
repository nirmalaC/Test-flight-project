package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.example.BookingDao;
import com.api.example.exceptions.ExampleCompromisedException;
import com.api.example.fixture.helpers.BookingHelper;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.pathparams.GetBookingPathParams;
import com.api.example.fixture.invoke.requests.booking.GetBookingRequest;
import com.api.example.fixture.invoke.services.ServiceFactory;
import com.api.example.fixture.invoke.services.booking.GetBookingService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static com.api.example.exceptions.ExampleCompromisedException.ExampleCompromisedExceptionMessages.INSUFFICIENT_DATA;
import static com.api.example.fixture.asserters.models.GetBookingExpectedErrors.GET_BOOKING_VALID_ERRORS;

/**
 * Created by tejaldudhale on 14/11/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class GetBookingSteps {

    private String dbBooking;

    @Autowired
    private BookingHelper commitBookingHelper;
    private String bookingRef;

    @Autowired
    private BookingDao bookingDao;
    private GetBookingService getBookingService;
    @Autowired
    private ServiceFactory serviceFactory;

    /*@When("^I request the booking details for \"([^\"]*)\"$")
    public void iRequestTheBookingDetailsFor(String channel) throws Throwable {
        dbBooking = bookingDao.getRandomBooking();
        ExampleHeaders headers = ExampleHeaders.getValid(channel).build();
        GetBookingPathParams params = GetBookingPathParams.builder().bookingId(dbBooking).build();
        getBookingService = serviceFactory.get(new GetBookingRequest(headers, params));
        getBookingService.invoke();
    }



    @Then("^I get respective allowed functions \"([^\"]*)\" in response based on booking status and permission$")
    public void iGetRespectiveAllowedFunctionsInResponseBasedOnBookingStatusAndPermission(String allowedFunction) throws Throwable {
        //List<String> allowedFunctions = getListOfAllowedFunction(allowedFunction);
        //getBookingService.assertThat().theFollowingListOfAllowedFunctionsIsReturned(allowedFunctions);
    }

    @Given("^I have booking with \"([^\"]*)\"$")
    public void iHaveBookingWith(String status) throws Throwable {
        dbBooking = bookingDao.getRandomBooking(status);

    }

    @Given("^I have booking which are departing at \"([^\"]*)\"$")
    public void iHaveBookingWhichAreDepartingAt(String departingParam) throws Throwable {
        //check if the booking exists in the database if yes GetBooking
        dbBooking = bookingDao.getRandomBooking(departingParam);
    }

    @Then("^I get the allowed functions \"([^\"]*)\" in the booking details response based on departure time and user$")
    public void iGetTheAllowedFunctionsInTheBookingDetailsResponseBasedOnDepartureTimeAndUser(String allowedFunction) throws Throwable {
        //Do not call other step defs!
        //iGetRespectiveAllowedFunctionsInResponseBasedOnBookingStatusAndPermission(allowedFunction);
    }
    */

    @When("^I search for a booking with invalid reference number$")
    public void iSearchForABookingWithInvalidReferenceNumber() throws Throwable {
        String invalidBookingId = String.valueOf(bookingDao.getInvalidBookingReference());
        GetBookingPathParams params = GetBookingPathParams.builder().bookingId(invalidBookingId).build();
        getBookingService = serviceFactory.get(new GetBookingRequest(ExampleHeaders.getValid("Digital").build(), params));
        getBookingService.invoke();
    }

    @Then("^I get error in response informing me that there are no bookings$")
    public void iGetErrorInResponseInformingMeThatThereAreNoBookings() throws Throwable {
        getBookingService.assertThatErrors().containedTheCorrectErrorMessageFor("not found", GET_BOOKING_VALID_ERRORS);
    }

    @Given("^I have an existing booking$")
    public void iHaveAnExistingBooking() throws Throwable {
        dbBooking = bookingDao.getRandomBooking();
        if (dbBooking == null) {
            bookingRef = commitBookingHelper.createNewBooking().getBookingConfirmation().getBookingReference();
        } else {
            bookingRef = dbBooking;
        }
        if (bookingRef.isEmpty()) {
            throw new ExampleCompromisedException(INSUFFICIENT_DATA);
        }
    }

    @When("^I search for a booking with reference number$")
    public void iSearchForABookingWithReferenceNumber() throws Throwable {
        GetBookingPathParams params = GetBookingPathParams.builder().bookingId(bookingRef).build();
        getBookingService = serviceFactory.get(new GetBookingRequest(ExampleHeaders.getValid("Digital").build(), params));
        getBookingService.invoke();
    }

    @Then("^Booking details with matching reference number are returned$")
    public void bookingDetailsWithMatchingRefernceNumberAreReturned() throws Throwable {
        getBookingService.assertThat().theBookingDetailsAreReturnedWithAReferenceNumber(bookingRef);
        getBookingService.assertThat().theBookingDetailsAreReturnedWithStatus("COMPLETED");

    }

}
