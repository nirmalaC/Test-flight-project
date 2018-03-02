package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.FlightFinder;
import com.api.example.fixture.helpers.BasketHelper;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.queryparams.FlightQueryParams;
import com.api.example.fixture.invoke.queryparams.FlightQueryParamsFactory;
import com.api.example.fixture.invoke.requestbody.AddFlightRequestBodyFactory;
import com.api.example.fixture.invoke.requests.FlightsRequest;
import com.api.example.fixture.invoke.response.basket.BasketsResponse;
import com.api.example.fixture.invoke.response.flights.Flight;
import com.api.example.fixture.invoke.services.FlightsService;
import com.api.example.fixture.invoke.services.ServiceFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * Created by dwebb on 12/2/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class ClearBasketSteps {

    @Autowired
    private BasketHelper basketHelper;
    private String basketCode;
    private Integer availableSeatsBeforeAddToBasket;
    private FlightQueryParams params;
    private FlightsService flightsService;
    private BasketsResponse emptyBasketResponse;
    private List<AddFlightRequestBodyFactory.multiFlightData> multiFlightParams;
    @Autowired
    private
    FlightFinder flightFinder;
    private Flight flight;
    @Autowired
    private ServiceFactory serviceFactory;

    public ClearBasketSteps() {
    }

    @Given("^I have a basket with a valid flight$")
    public void iHaveABasketWithAValidFlight() throws Throwable {
        basketHelper.myBasketContainsAFlightWithPassengerMix("1 Adult");
    }

    @When("^I clear the basket$")
    public void iClearTheBasket() throws Throwable {
        basketCode = basketHelper.getBasketService().getResponse().getBasket().getCode();
        emptyBasketResponse = basketHelper.emptyBasket(basketCode, "Digital");
    }

    @Then("^the basket is emptied$")
    public void theBasketIsEmptied() throws Throwable {
        basketHelper.getBasketService().assertThat().isEmptied(basketCode);
    }

    @Given("^I have a basket with a valid flight that has had inventory allocated$")
    public void iHaveABasketWithAValidFlightThatHasHadInventoryAllocated() throws Throwable {
        params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight()).adult("1").build();
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("ADAirport").build(), params));
        flightsService.invoke();
        flight = flightsService.getOutboundFlight();
        availableSeatsBeforeAddToBasket = flight.getInventory().getAvailable();
        basketHelper.addFlightToBasketAsChannel(flight, "ADAirport");
    }

    @Then("^the flights are deallocated$")
    public void theFlightsAreDeallocated() throws Throwable {
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("ADAirport").build(), params));
        flightsService.invoke();
        flightsService.assertThat().hasNumberOfSeatsAvailableEqualTo(availableSeatsBeforeAddToBasket);
    }

    @Given("^I have a basket with a valid flight added via \"([^\"]*)\"$")
    public void iHaveABasketWithAValidFlightAddedVia(String channel) throws Throwable {
        params = FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight()).adult("1").build();
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channel).build(), params));
        flightsService.invoke();
        flight = flightsService.getOutboundFlight();
        availableSeatsBeforeAddToBasket = flight.getInventory().getAvailable();
        basketHelper.addFlightToBasketAsChannel(flight, channel);
        flightsService.invoke();
        int a = flightsService.getOutboundFlight().getInventory().getAvailable();
        int b = a;
    }

    @Then("^the flights are not further deallocated$")
    public void theFlightsAreNotFurtherDeallocated() throws Throwable {
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), params));
        flightsService.invoke();
        flightsService.assertThat().hasNumberOfSeatsAvailableEqualTo(availableSeatsBeforeAddToBasket);
    }

    @Given("^I have a basket with valid multiple flights$")
    public void iHaveABasketWithValidMultipleFlights() throws Throwable {
        basketHelper.addNumberOfFlightsToBasket(2);
    }

    @When("^I clear the basket via \"([^\"]*)\"$")
    public void iClearTheBasketVia(String channel) throws Throwable {
        basketCode = basketHelper.getBasketService().getResponse().getBasket().getCode();
        emptyBasketResponse = basketHelper.emptyBasket(basketCode, channel);
    }

    @Given("^I have a basket with valid multiple flights added via \"([^\"]*)\"$")
    public void iHaveABasketWithValidMultipleFlightsAddedVia(String channel) throws Throwable {
        multiFlightParams = basketHelper.addNumberOfFlightsToBasket(2, channel);
    }

    @Then("^all the flights are deallocated$")
    public void allTheFlightsAreDeallocated() throws Throwable {
        for (AddFlightRequestBodyFactory.multiFlightData mfParams : multiFlightParams) {
            flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("ADAirport").build(), mfParams.getFlightQueryParams()));
            flightsService.invoke();
            flightsService.assertThat().hasNumberOfSeatsAvailableEqualTo(mfParams.getAvailableSeats());
        }

    }

}
