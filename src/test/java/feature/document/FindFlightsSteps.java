package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.FlightFinder;
import com.api.example.fixture.helpers.Passengers;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.queryparams.FlightQueryParams;
import com.api.example.fixture.invoke.queryparams.FlightQueryParamsFactory;
import com.api.example.fixture.invoke.requests.FlightsRequest;
import com.api.example.fixture.invoke.services.FlightsService;
import com.api.example.fixture.invoke.services.ServiceFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;

import static com.api.example.fixture.asserters.models.FindFlightExpectedErrors.FIND_FLIGHT_VALID_ERRORS;

/**
 * Created by daniel on 21/09/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class FindFlightsSteps {

    protected static Logger LOG = LogManager.getLogger(FindFlightsSteps.class);

    @Autowired
    FlightFinder flightFinder;
    @Autowired
    private ServiceFactory serviceFactory;
    private FlightsService flightService;


    public FindFlightsSteps() {
    }

    @Given("^a flight exists$")
    public void aFlightExists() throws Throwable {
        flightFinder.findAValidFlight();
    }

    @When("^I call the find flights service for a valid flight$")
    public void iCallTheFindFlightsServiceForAValidFlight() throws Throwable {
        FlightQueryParams params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight()).adult("1").build();
        flightService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), params));
        flightService.invoke();
    }

    @Then("^flight is returned$")
    public void flightIsReturned() throws Throwable {
        flightService.assertThat().atLeastOneOutboundFlightWasReturned();
    }

    @Given("^the maximum number of passengers is (\\d+)$")
    public void theMaximumNumberOfPassengersIs(int numberOfPassengers) throws Throwable {
        //nothing to add at the moment - could be a variable to read later
    }

    @When("^I search for flight with \"([^\"]*)\"$")
    public void iSearchForFlightWith(String params) throws Throwable {
        FlightQueryParams queryParams = FlightQueryParamsFactory.InvalidFlightParams(flightFinder, params);
        flightService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), queryParams));
        flightService.invoke();
    }

    @When("^I search for flight with \"([^\"]*)\" exceeding maximum$")
    public void iSearchForFlightWithExceedingMaximum(String passengerMix) throws Throwable {
        FlightQueryParams params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight(PassengerMixTotal(passengerMix)), new Passengers(passengerMix));
        flightService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), params));
        flightService.invoke();
    }

    @Then("^Outbound Date is before today error is returned$")
    public void outboundDateIsBeforeTodayErrorIsReturned() throws Throwable {
        flightService.assertThatErrors().containsText("before today");

    }

    @Then("^Inbound Date is before Outbound Date error is returned$")
    public void inboundDateIsBeforeOutboundDateErrorIsReturned() throws Throwable {
        flightService.assertThatErrors().containsText("Inbound Date is before Outbound Date");
    }

    @Then("^No origin airport error is returned$")
    public void noOriginAirportErrorIsReturned() throws Throwable {
        flightService.assertThatErrors().containsText("origin airport ");
    }

    @Then("^No destination airport error is returned$")
    public void noDestinationAirportErrorIsReturned() throws Throwable {
        flightService.assertThatErrors().containsText("destination airport ");
    }

    @Then("^incorrect destination airport error is returned$")
    public void incorrectDestinationAirportErrorIsReturned() throws Throwable {
        // assertThat(flightsClient.getErrors().toString()).contains("destination airport ");
        flightService.assertThatErrors().containsText("not flown");
    }

    @Then("^incorrect origin airport error is returned$")
    public void incorrectOriginAirportErrorIsReturned() throws Throwable {
        flightService.assertThatErrors().containsText("origin airport");
    }

    @Then("^maximum passengers error is returned$")
    public void maximumPassengersErrorIsReturned() throws Throwable {
        //assertThat(flightsClient.getErrors().toString()).contains("Maximum passengers");
       //flightService.assertThatErrors().containsText("Maximum passengers");
    }

    @Then("^route not flown error is returned$")
    public void routeNotFlownErrorIsReturned() throws Throwable {
        //assertThat(flightsClient.getErrors().toString()).containsIgnoringCase("Route not flown");
        flightService.assertThatErrors().containsText("Route not flown");
    }

    @Then("^multiple error messages returned$")
    public void multipleErrorMessagesReturned() throws Throwable {
        flightService.assertThatErrors().returnedGreaterThan(1);
    }

    public int PassengerMixTotal(String passengerMix) {
        List<String> types = Arrays.asList(passengerMix.split("\\s*,\\s*"));
        int total = 0;

        for (String t : types) {
            String[] a = t.split("\\s+");
            total += Integer.parseInt(a[0]);
        }

        return total;
    }

    @Then("^the flight has a flight key$")
    public void theFlightHasAFlightKey() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        flightService.assertThat().atLeastOneOutboundFlightWasReturned().theFlightHasAFlightKey();
    }

    @When("^I call the find flights service for a valid flight via \"([^\"]*)\"$")
    public void iCallTheFindFlightsServiceForAValidFlightVia(String channel) throws Throwable {
        FlightQueryParams params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight()).adult("1").build();
        flightService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channel).build(), params));
        flightService.invoke();
    }

    @Then("^\"([^\"]*)\" error is returned$")
    public void errorIsReturned(String parameter) throws Throwable {
        flightService.assertThatErrors().containedTheCorrectErrorMessageFor(parameter, FIND_FLIGHT_VALID_ERRORS);
    }
}
