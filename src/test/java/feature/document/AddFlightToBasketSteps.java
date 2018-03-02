package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.FlightFinder;
import com.api.example.database.example.models.ExampleFlightDbModel;
import com.api.example.fixture.helpers.BasketHelper;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.queryparams.FlightQueryParams;
import com.api.example.fixture.invoke.queryparams.FlightQueryParamsFactory;
import com.api.example.fixture.invoke.requests.FlightsRequest;
import com.api.example.fixture.invoke.response.basket.AddFlight;
import com.api.example.fixture.invoke.response.flights.Flight;
import com.api.example.fixture.invoke.response.flights.FlightsResponse;
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

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Dan on 01/11/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class AddFlightToBasketSteps {

    private static Logger LOG = LogManager.getLogger(AddFlightToBasketSteps.class);
    @Autowired
    private FlightFinder flightFinder;
    @Autowired
    private BasketHelper basketHelper;
    @Autowired
    private ServiceFactory serviceFactory;
    private String basketCode;
    private ExampleFlightDbModel availableFlight;

    private Integer availableSeatsBeforeAddToBasket;
    private FlightsService flightsService;
    private FlightsResponse foundFlights;
    private Flight outboundFlight;

    private List<AddFlight> addFlights;

    public AddFlightToBasketSteps() {

    }


    private void findAFlightForOneAdult(String channel) {
        FlightQueryParams params = FlightQueryParamsFactory.generateFlightSearchCriteria(availableFlight).adult("1").build();
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channel).build(), params));
        flightsService.invoke();
    }

    @When("^I add the flight to my basket via the \"([^\"]*)\" channel$")
    public void iAddTheFlightToMyBasketViaTheChannel(String channel) throws Throwable {
        basketHelper.addFlightToBasketAsChannel(flightsService.getOutboundFlight(), channel);
    }

    @Then("^the inventory is allocated via the \"([^\"]*)\" channel$")
    public void theInventoryIsAllocated(String channel) throws Throwable {
        //check inventory is allocated in OtherDB
        findAFlightForOneAdult(channel);
        flightsService.assertThat().theNumberOfSeatsAvailableOnTheFlightIsLessThan(availableSeatsBeforeAddToBasket);
        //make sure that basket is empty before adding stuff in
        basketCode = basketHelper.getBasketService().getResponse().getBasket().getCode();
        basketHelper.emptyBasket(basketCode, channel);
    }

    @Given("^my basket contains flight$")
    public void myBasketContainsFlight() throws Throwable {

    }

    @When("^call empty basket service$")
    public void callEmptyBasketService() throws Throwable {
        basketCode = basketHelper.getBasketService().getResponse().getBasket().getCode();
        basketHelper.emptyBasket(basketCode, "Digital");
    }

    @Then("^basket is empty$")
    public void basketIsEmpty() throws Throwable {
        LOG.info("Basket is empty ID: ", basketHelper.getBasketService().getResponse().getBasket().getAdditionalProperties());
        assertThat(basketHelper.getBasketService().getResponse().getBasket().getAdditionalProperties().containsValue(basketCode));
    }

    @Given("^my basket contains flight with passengerMix \"([^\"]*)\"$")
    public void myBasketContainsFlightWithPassengerMix(String passengerMix) throws Throwable {
        basketHelper.myBasketContainsAFlightWithPassengerMix(passengerMix);
    }

    @Then("^the inventory is not yet allocated$")
    public void theInventoryIsNotYetAllocated() throws Throwable {
        FlightQueryParams queryParams = FlightQueryParamsFactory.generateFlightSearchCriteria(availableFlight).adult("1").build();
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), queryParams));
        flightsService.invoke();
        flightsService.assertThat().hasNumberOfSeatsAvailableEqualTo(availableSeatsBeforeAddToBasket);
        //make sure that basket is empty before adding stuff in
        basketCode = basketHelper.getBasketService().getResponse().getBasket().getCode();
    }

    @Then("^the flight is added to the basket via the \"([^\"]*)\"$")
    public void theFlightIsAddedToTheBasketViaThe(String channel) throws Throwable {
        assertThat(basketHelper.getBasketService().getResponse().getBasket().getOutbounds()).isNotEmpty();
        //make sure that basket is empty before adding stuff in
        basketCode = basketHelper.getBasketService().getResponse().getBasket().getCode();
    }

    @Given("^my basket contains flight with passengerMix \"([^\"]*)\" added via \"([^\"]*)\"$")
    public void myBasketContainsFlightWithPassengerMixAddedVia(String passengerMix, String channel) throws Throwable {
        basketHelper.myBasketContainsAFlightWithPassengerMix(passengerMix, channel);
    }

    @Then("^the base price is returned$")
    public void theBasePriceIsReturned() throws Throwable {
        basketHelper.getBasketService().assertThat().theBasePriceIsReturnedForEachPassenger();
    }

    @Then("^the selected bundle is added to each passenger$")
    public void theSelectedBundleIsAddedToEachPassenger() throws Throwable {
        basketHelper.getBasketService().assertThat().theFareBundleIsAddedToEachPassenger(basketHelper.getFareTypeUsed());
    }

    @Given("^there are multiple valid flights with different departure airports that have different default currencies$")
    public void thereAreMultipleValidFlightsWithDifferentDepartureAirportsThatHaveDifferentDefaultCurrencies() throws Throwable {
        addFlights = basketHelper.findMultipleFlightsWithDifferentBaseCurrencies();
    }

    @When("^I add the flights to the basket$")
    public void iAddTheFlightsToTheBasket() throws Throwable {
        for (AddFlight flight : addFlights) {
            basketHelper.addFlightToBasketAsChannel(flight, "Digital");
        }
    }

    @Then("^the default currency is defined by first departure airport$")
    public void theDefaultCurrencyIsDefinedByFirstDepartureAirport() throws Throwable {
        basketHelper.getBasketService().assertThat().theCurrencyOfTheBasketIsDefinedAsTheFirstFlight(addFlights);
    }

    @Given("^I have found a valid flight via the \"([^\"]*)\" channel$")
    public void iHaveFoundAValidFlightViaTheChannel(String channel) throws Throwable {
        availableFlight = flightFinder.findAValidFlight();
        findAFlightForOneAdult(channel);
        foundFlights = flightsService.getResponse();
        availableSeatsBeforeAddToBasket = foundFlights.getOutbound().getResult().getJourneys().get(0).getFlights().get(0).getInventory().getAvailable();
    }

    @Then("^the baseprice and associated taxes are the same in the basket$")
    public void theBasepriceAndAssociatedTaxesAreTheSameInTheBasket() throws Throwable {
        basketHelper.getBasketService().assertThat().flightBasePriceAndFeesAreTheSameForASinglePassenger(foundFlights.getOutbound().getResult().getJourneys().get(0).getFlights().get(0));

    }

    @Given("^I have a outbound flight in my basket via the  \"([^\"]*)\" channel$")
    public void iHaveAOutboundFlightInMyBasketViaTheChannel(String channel) throws Throwable {
        availableFlight = flightFinder.findAValidFlight();
        findAFlightForOneAdult(channel);
        outboundFlight = flightsService.getOutboundFlight();
        basketHelper.addFlightToBasketAsChannel(flightsService.getOutboundFlight(), channel);
    }

    @When("^I add the inbound flight to my basket via the \"([^\"]*)\" channel$")
    public void iAddTheInboundFlightToMyBasketViaTheChannel(String channel) throws Throwable {
        //basketHelper.addInbFlightToBasketAsChannel(flightsService.getOutboundFlight(), channel);
    }

    @Given("^a flight that is nearly full$")
    public void aFlightThatIsNearlyFull() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the remaining seats have been allocated$")
    public void theRemainingSeatsHaveBeenAllocated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I search for the flight$")
    public void iSearchForTheFlight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^it is not returned in the list of available flights$")
    public void itIsNotReturnedInTheListOfAvailableFlights() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^there is one seat unallocated on a flight$")
    public void thereIsOneSeatUnallocatedOnAFlight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^two Agent Desktop channels attempt to add the flight to a basket at the same time$")
    public void twoAgentDesktopChannelsAttemptToAddTheFlightToABasketAtTheSameTime() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the one flight is allocated$")
    public void theOneFlightIsAllocated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the second returns an error$")
    public void theSecondReturnsAnError() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the infant is autoallocated to first Adult$")
    public void theInfantIsAutoallocatedToFirstAdult() throws Throwable {
        basketHelper.getBasketService().assertThat().infantIsNowOnLapOfFirstAdult();
    }

    @Then("^the infant is autoallocated to only Adult$")
    public void theInfantIsAutoallocatedToOnlyAdult() throws Throwable {
        basketHelper.getBasketService().assertThat().infantIsNowOnLapOfFirstAdult();
    }

    @Given("^my basket contains flight with multiple passengers for a \"([^\"]*)\" bundle$")
    public void myBasketContainsFlightWithMultiplePassengersForABundle(String bundles) throws Throwable {
        FlightQueryParams params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight("Flexible Fares")).adult("2").build();
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), params));
        flightsService.invoke();
        basketHelper.addFlightToBasketAsChannelUsingFareCode(flightsService.getOutboundFlight("Flexi"), "Digital", "Flexi");
    }

    @Given("^I multiple flights added to basket as a non-airport-agent$")
    public void iMultipleFlightsAddedToBasketAsANonAirportAgent() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I change first departure airport to alternative with different currency$")
    public void iChangeFirstDepartureAirportToAlternativeWithDifferentCurrency() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^price is converted to new currency$")
    public void priceIsConvertedToNewCurrency() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^I have a flight in my basket added via agent channel$")
    public void iHaveAFlightInMyBasketAddedViaAgentChannel() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I change the airport agent to one with a different default currency$")
    public void iChangeTheAirportAgentToOneWithADifferentDefaultCurrency() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the basket price is shown in the new airport agent's currency$")
    public void theBasketPriceIsShownInTheNewAirportAgentSCurrency() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
