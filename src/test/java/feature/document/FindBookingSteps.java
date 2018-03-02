package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.example.BookingDao;
import com.api.example.fixture.helpers.BookingHelper;
import com.api.example.fixture.helpers.CustomerProfileHelper;
import com.api.example.fixture.helpers.TravellerHelper;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.queryparams.FindBookingQueryParams;
import com.api.example.fixture.invoke.queryparams.FindBookingQueryParamsFactory;
import com.api.example.fixture.invoke.requests.booking.FindBookingRequest;
import com.api.example.fixture.invoke.response.findbookingresponse.Booking;
import com.api.example.fixture.invoke.response.getbookingresponse.GetBookingResponse;
import com.api.example.fixture.invoke.services.ServiceFactory;
import com.api.example.fixture.invoke.services.booking.FindBookingService;
import com.api.example.fixture.invoke.services.booking.GetBookingService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.api.example.fixture.asserters.models.FindBookingExpectedErrors.FIND_BOOKING_EXPECTED_ERRORS;
import static com.api.example.fixture.asserters.models.FindBookingExpectedErrors.FIND_BOOKING_NO_RESULT_FOUND;

/**
 * Created by dwebb on 11/9/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class FindBookingSteps {

    protected static Logger LOG = LogManager.getLogger(FindBookingSteps.class);
    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private ServiceFactory serviceFactory;
    private FindBookingService findBookingService;
    private GetBookingService getBookingService;
    private TravellerHelper travellerHelper;
    private CustomerProfileHelper customerProfileHelper;
    @Autowired
    private BookingHelper commitBookingHelper;
    private String bookingRef;
    private String dbBooking;
    private GetBookingResponse getBooking;

    public FindBookingSteps() {
    }

    /*@Given("^a booking exists$")
    public void aBookingExists() throws Throwable {
        String bookingInExample = bookingDao.getRandomBooking();
        assertThat(bookingInExample).isNotNull().withFailMessage("Expected at least one booking in Example.");
        GetBookingPathParams params = GetBookingPathParams.builder().bookingId(bookingInExample).build();
        getBookingService = serviceFactory.get(new GetBookingRequest(ExampleHeaders.getValid("Digital").build(), params));
        getBookingService.invoke();
        getBookingService.assertThat().theBookingDetailsAreReturnedWithAReferenceNumber(bookingInExample);

    }*/

    @When("^I search for the booking using \"([^\"]*)\"$")
    public void iSearchForTheBookingUsing(String params) throws Throwable {
        FindBookingQueryParams criteria = FindBookingQueryParamsFactory.SetBookingParams(getBookingService.getResponse(), params);
        findBookingService = serviceFactory.get(new FindBookingRequest(ExampleHeaders.getValid("Digital").build(), criteria));
        findBookingService.invoke();
    }

    @Then("^the booking is returned$")
    public void theBookingIsReturned() throws Throwable {
        findBookingService.assertThat().theBookingHasABookingReference(bookingRef);
    }

    @When("^I search for the booking using \"([^\"]*)\" and \"([^\"]*)\" characters of the firstname$")
    public void iSearchForTheBookingUsingAndCharactersOfTheFirstname(String field, int charcount) throws Throwable {
        FindBookingQueryParams criteria = FindBookingQueryParamsFactory.SetBookingParams(getBookingService.getResponse(), field, charcount);
        findBookingService = serviceFactory.get(new FindBookingRequest(ExampleHeaders.getValid("Digital").build(), criteria));
        findBookingService.invoke();
    }

    @Then("^the booking \"([^\"]*)\" is returned$")
    public void theBookingIsReturned(String returns) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        switch (returns) {
            case "error":
                findBookingService.assertThatErrors().wereReturned();
                break;
            case "result":
                findBookingService.assertThat().theBookingHasABookingReference(getBookingService.getResponse().getBookingContext().getBooking().getBookingReference());
        }
        throw new PendingException();
    }

    @Then("^an error is returned informing me that I cannot search by only \"([^\"]*)\"$")
    public void anErrorIsReturnedInformingMeThatICannotSearchByOnly(String field) throws Throwable {
        findBookingService.assertThatErrors().containedTheCorrectErrorMessageFor(field, FIND_BOOKING_EXPECTED_ERRORS);
    }

    @When("^I search for the booking using \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iSearchForTheBookingUsingIn(String fields, String caseFormat) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        FindBookingQueryParams criteria = FindBookingQueryParamsFactory.SetBookingParams(getBookingService.getResponse(), fields, caseFormat);
        findBookingService = serviceFactory.get(new FindBookingRequest(ExampleHeaders.getValid("Digital").build(), criteria));
        findBookingService.invoke();
    }

    @When("^I search for a booking using an invalid booking reference$")
    public void iSearchForABookingUsingAnInvalidBookingReference() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        FindBookingQueryParams params = FindBookingQueryParamsFactory.invalidBooking();
        findBookingService = serviceFactory.get(new FindBookingRequest(ExampleHeaders.getValid("Digital").build(), params));
        findBookingService.invoke();
    }

    @Then("^an error is returned informing me that the booking reference is invalid$")
    public void anErrorIsReturnedInformingMeThatTheBookingReferenceIsInvalid() throws Throwable {
        findBookingService.assertThatErrors().containsText("bookingref");
    }

    @When("^I search for a booking with unmatchable criteria using \"([^\"]*)\"$")
    public void iSearchForABookingWithUnmatchableCriteriaUsing(String params) throws Throwable {
        FindBookingQueryParams criteria = FindBookingQueryParamsFactory.BookingWithUnmatchableSearchCriteria(params);
        findBookingService = serviceFactory.get(new FindBookingRequest(ExampleHeaders.getValid("Digital").build(), criteria));
        findBookingService.invoke();
    }

    @Then("^an error is returned saying that no search results match the criteria$")
    public void anErrorIsReturnedSayingThatNoSearchResultsMatchTheCriteria() throws Throwable {
        // findBookingService.assertThatErrors().containsText("unmatchedsearchcriteria");
        findBookingService.assertThat().HasAnErrorForFieldInAdditionalInformation(FIND_BOOKING_NO_RESULT_FOUND);
    }

    @When("^I search for the booking with a missing header \"([^\"]*)\"$")
    public void iSearchForTheBookingWithAMissingHeader(String header) throws Throwable {

        FindBookingQueryParams criteria = FindBookingQueryParams.builder().firstName("Ted").lastName("Tester").build();
        findBookingService = serviceFactory.get(new FindBookingRequest(ExampleHeaders.getValid("").build(), criteria));
        findBookingService.invoke();
    }

    @Then("^the error message is returned\"([^\"]*)\"$")
    public void theErrorMessageIsReturned(String expectedField) throws Throwable {
        String message = getMessageForField(expectedField);
        findBookingService.assertThatErrors().containsOnly(expectedField, message);
    }

    private String getMessageForField(String expectedField) {
        switch (expectedField) {
            case "lastname":
                return "Please enter either a title or First Name of the passenger";
            case "firstname":
                return "Please enter either a title or Last Name of the passenger";
        }
        throw new IllegalArgumentException("this field is not handled.");
    }

    @When("^I search for the booking but with empty \"([^\"]*)\"$")
    public void iSearchForTheBookingButWithEmpty(String emptyQueryParam) throws Throwable {
        FindBookingQueryParams criteria = FindBookingQueryParamsFactory.EmptyTheField(emptyQueryParam, FindBookingQueryParamsFactory.Basic_FindBookingParams(getBooking, false));
        findBookingService = serviceFactory.get(new FindBookingRequest(ExampleHeaders.getValid("Digital").build(), criteria));
        findBookingService.invoke();
    }

    @Given("^there are valid bookings$")
    public void thereAreValidBookings() throws Throwable {
        dbBooking = bookingDao.getRandomBooking();
        if (dbBooking == null) {
            bookingRef = commitBookingHelper.createNewBooking().getBookingConfirmation().getBookingReference();
            getBooking = commitBookingHelper.getBookingDetails(bookingRef);

        } else {
            bookingRef = dbBooking;
            getBooking = commitBookingHelper.getBookingDetails(bookingRef);
        }
    }


    @When("^I search for a booking$")
    public void iSearchForABooking() throws Throwable {
        FindBookingQueryParams criteria = FindBookingQueryParamsFactory.Basic_FindBookingParams(getBooking, false);
        findBookingService = serviceFactory.get(new FindBookingRequest(ExampleHeaders.getValid("Digital").build(), criteria));
        findBookingService.invoke();
    }

    @Then("^the bookings matching the search criteria are returned$")
    public void theBookingsMatchingTheSearchCriteriaAreReturned() throws Throwable {
        findBookingService.assertThat().bookingsAreReturned();
        findBookingService.assertThat().theBookingHasABookingReference(bookingRef);
        findBookingService.assertThat().theBookingHasCustomerDetails(bookingRef, getBooking.getBookingContext().getBooking().getBookingContact());
        findBookingService.assertThat().theBookingHasDateAndStatus(bookingRef, getBooking.getBookingContext().getBooking().getBookingDateTime(), getBooking.getBookingContext().getBooking().getBookingStatus());
    }

    @Then("^the bookings are returned in date time order$")
    public void theBookingsAreReturnedInDateTimeOrder() throws Throwable {
        findBookingService.assertThat().bookingsAreReturned();
        List<Booking> bookings = findBookingService.getResponse().getBookings();
        findBookingService.assertThat().theBookingsAreInDateTimeOrder(bookings);

    }

    @When("^I search for the booking using invalid  \"([^\"]*)\" of customer$")
    public void iSearchForTheBookingUsingInvalidOfCustomer(String arg0) throws Throwable {
        FindBookingQueryParams criteria;
        criteria = FindBookingQueryParamsFactory.BookingWithInvalidEmailIdAsSearchCriteria();
        findBookingService = serviceFactory.get(new FindBookingRequest(ExampleHeaders.getValid("Digital").build(), criteria));
        findBookingService.invoke();
    }


    @When("^I search for the booking using \"([^\"]*)\" of customer via \"([^\"]*)\"$")
    public void iSearchForTheBookingUsingOfCustomerViaChannel(String params, String channel) throws Throwable {
        FindBookingQueryParams criteria;
        criteria = FindBookingQueryParamsFactory.SetBookingParams(getBooking, params, false);
        findBookingService = serviceFactory.get(new FindBookingRequest(ExampleHeaders.getValid(channel).build(), criteria));
        findBookingService.invoke();
    }

    @When("^I search for a booking using only \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void iSearchForABookingUsingOnlyWithValue(String parameter, String value) throws Throwable {
        FindBookingQueryParams queryParams = FindBookingQueryParamsFactory.searchWithOnlyThisParameter(parameter, value);
        findBookingService = serviceFactory.get(new FindBookingRequest(ExampleHeaders.getValid("Digital").build(), queryParams));
        findBookingService.invoke();
    }

    @Then("^the error message is returned informing me that the header is required$")
    public void theErrorMessageIsReturnedInformingMeThatTheHeaderIsRequired() throws Throwable {
        findBookingService.assertThatErrors().containsText("Missing X-POS-Id header parameter");
    }

    @When("^I search for the booking using \"([^\"]*)\" of customer$")
    public void iSearchForTheBookingUsingOfCustomer(String params) throws Throwable {
        FindBookingQueryParams criteria;
        criteria = FindBookingQueryParamsFactory.SetBookingParams(getBooking, params, false);
        findBookingService = serviceFactory.get(new FindBookingRequest(ExampleHeaders.getValid("Digital").build(), criteria));
        findBookingService.invoke();
    }

    @When("^I search for a booking using the travelfrom dates$")
    public void iSearchForABookingUsingTheTravelfromDates() throws Throwable {
        FindBookingQueryParams criteria = FindBookingQueryParamsFactory.Basic_FindBookingParamsWithDates(getBooking, false);
        findBookingService = serviceFactory.get(new FindBookingRequest(ExampleHeaders.getValid("Digital").build(), criteria));
        findBookingService.invoke();
    }



}
