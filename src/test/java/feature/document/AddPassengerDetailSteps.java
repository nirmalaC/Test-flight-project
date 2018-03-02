package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.example.ExamplePassengerTypeDao;
import com.api.example.database.example.models.PassengerTypeDbModel;
import com.api.example.fixture.helpers.BasketHelper;
import com.api.example.fixture.helpers.FieldAndValue;
import com.api.example.fixture.helpers.TravellerHelper;
import com.api.example.fixture.invoke.response.basket.Basket;
import com.api.example.fixture.invoke.response.traveller.Travellers;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static com.api.example.fixture.asserters.models.UpdateTravellerExpectedErrors.UPDATE_TRAVELLER_VALID_ERRORS;

/**
 * Created by dwebb on 11/22/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class AddPassengerDetailSteps {

    protected static Logger LOG = LogManager.getLogger(AddPassengerDetailSteps.class);

    private String channelUsed;
    private Travellers sentUpdate;
    private String expectedPaxType;
    private Basket originalBasket;
    private Basket updatedBasket;
    @Autowired
    private ExamplePassengerTypeDao examplePassengerTypeDao;
    @Autowired
    private BasketHelper basketHelper;
    @Autowired
    private TravellerHelper travellerHelper;


    public AddPassengerDetailSteps() {
    }

    @Given("^I have set values for Adult, Child and Infant$")
    public void setAgeFor() {
        List<PassengerTypeDbModel> examplePassengers = examplePassengerTypeDao.getPassengersOfType("adult");
        travellerHelper.setAdultMax(99);
        travellerHelper.setAdultMin(examplePassengers.get(0).getMinAge());
        examplePassengers = examplePassengerTypeDao.getPassengersOfType("child");
        travellerHelper.setChildMax(examplePassengers.get(0).getMaxAge());
        travellerHelper.setChildMin(examplePassengers.get(0).getMinAge());
        examplePassengers = examplePassengerTypeDao.getPassengersOfType("infant");
        travellerHelper.setInfantMax(examplePassengers.get(0).getMaxAge());
    }


    @Given("^my basket contains \"([^\"]*)\"$")
    public void myBasketContains(String passengerMix) throws Throwable {
        basketHelper.myBasketContainsAFlightWithPassengerMix(passengerMix);
        channelUsed = "Digital";
    }

    @Given("^my basket contains \"([^\"]*)\" added via \"([^\"]*)\"$")
    public void myBasketContainsAddedVia(String passengerMix, String channel) throws Throwable {
        basketHelper.myBasketContainsAFlightWithPassengerMix(passengerMix, channel);
        channelUsed = channel;
    }

    @And("^all base prices are the same$")
    public void allBasePricesAreTheSame() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @When("^I change the passenger age of \"([^\"]*)\" to \"([^\"]*)\" via \"([^\"]*)\"$")
    public void iChangeThePassengerAgeOfToVia(String original, String changeTo, String channel) throws Throwable {
        expectedPaxType = changeTo;
        originalBasket = basketHelper.getBasketService().getResponse().getBasket();
        Travellers request = travellerHelper.CreateRequestToChangePassengerAge(original, changeTo, channel, basketHelper.getBasketService().getResponse());
        sentUpdate = request;
        basketHelper.updateTravellersForChannel(request, channel, basketHelper.getBasketService().getResponse().getBasket().getCode());
        //Basket updatedBasket = basketHelper.getBasketService().getResponse().getBasket();
    }

    @Then("^the basket is updated and fees calculated$")
    public void theBasketIsUpdatedAndFeesCalculated() throws Throwable {
        //get the basket and assert it has been updated
        basketHelper.getBasket(originalBasket.getCode());
        updatedBasket = basketHelper.getBasketService().getResponse().getBasket();
        //compare
        basketHelper.getBasketService().assertThat().theBasketContainsTheUpdatedTravellerDetails(updatedBasket, sentUpdate, expectedPaxType);
    }

    @When("^I provide basic passenger details$")
    public void iProvideBasicPassengerDetails() throws Throwable {
        originalBasket = basketHelper.getBasketService().getResponse().getBasket();
        Travellers request = travellerHelper.CreateValidRequestToAddAllTravellersForBasket(basketHelper.getBasketService().getResponse());
        sentUpdate = request;
        basketHelper.updateTravellersForChannel(request, "Digital", basketHelper.getBasketService().getResponse().getBasket().getCode());
    }

    @Then("^the basket is updated with the details$")
    public void theBasketIsUpdatedWithTheDetails() throws Throwable {
        basketHelper.getBasket(originalBasket.getCode());
        Basket updatedBasket = basketHelper.getBasketService().getResponse().getBasket();
        basketHelper.getBasketService().assertThat().theBasketContainsTheUpdatedTravellerDetails(updatedBasket, sentUpdate);
    }

    @When("^I fail to provide the traveller field \"([^\"]*)\"$")
    public void iFailToProvideTheTravellerField(String field) throws Throwable {
        Travellers request = travellerHelper.CreateRequestWithFieldSetAs(new FieldAndValue(field, null), basketHelper.getBasketService().getResponse());
        basketHelper.updateTravellersForChannel(request, "Digital", basketHelper.getBasketService().getResponse().getBasket().getCode());
    }

    @When("^I set the traveller type as \"([^\"]*)\" and the title as \"([^\"]*)\"$")
    public void iSetTheTravellerTypeAsAndTheTitleAs(String travellerType, String title) throws Throwable {
        ArrayList<FieldAndValue> list = new ArrayList<FieldAndValue>() {{
            add(FieldAndValue.builder().field("passengertype").value(travellerType).build());
            add(FieldAndValue.builder().field("title").value(title).build());
        }};
        Travellers request = travellerHelper.CreateRequestWithFieldsSetAs(list, basketHelper.getBasketService().getResponse());
        basketHelper.updateTravellersForChannel(request, "Digital", basketHelper.getBasketService().getResponse().getBasket().getCode());
    }

    @When("^I set the traveller type as \"([^\"]*)\" and the age as \"([^\"]*)\"$")
    public void iSetTheTravellerTypeAsAndTheAgeAs(String travellerType, String age) throws Throwable {
        ArrayList<FieldAndValue> list = new ArrayList<FieldAndValue>() {{
            add(FieldAndValue.builder().field("passengertype").value(travellerType).build());
            add(FieldAndValue.builder().field("age").value(Integer.toString(travellerHelper.GetValidAgeForPassengerType(age))).build());
        }};
        Travellers request = travellerHelper.CreateRequestWithFieldsSetAs(list, basketHelper.getBasketService().getResponse());
        basketHelper.updateTravellersForChannel(request, "Digital", basketHelper.getBasketService().getResponse().getBasket().getCode());
    }

    @Then("^I should see the \"([^\"]*)\" error message$")
    public void iShouldSeeTheErrorMessage(String err) throws Throwable {
        basketHelper.getBasketTravellerService().assertThatErrors().containedTheCorrectErrorMessageFor(err, UPDATE_TRAVELLER_VALID_ERRORS);
    }

    @When("^I update traveller details with \"([^\"]*)\" as \"([^\"]*)\"$")
    public void iUpdateTravellerDetailsWithAs(String field, String value) throws Throwable {
        Travellers request = travellerHelper.CreateRequestWithFieldSetAs(new FieldAndValue(field, value), basketHelper.getBasketService().getResponse());
        basketHelper.updateTravellersForChannel(request, "Digital", basketHelper.getBasketService().getResponse().getBasket().getCode());
    }

    @And("^the infant is now on lap of the first adult$")
    public void theInfantIsNowOnLapOfTheFirstAdult() throws Throwable {
        basketHelper.getBasketService().assertThat().infantIsNowOnLapOfFirstAdult();
    }

    @When("^I change the passenger age of \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iChangeThePassengerAgeOfTo(String original, String changeTo) throws Throwable {
        expectedPaxType = changeTo;
        originalBasket = basketHelper.getBasketService().getResponse().getBasket();
        Travellers request = travellerHelper.CreateRequestToChangePassengerAge(original, changeTo, channelUsed, basketHelper.getBasketService().getResponse());
        sentUpdate = request;
        basketHelper.updateTravellersForChannel(request, channelUsed, basketHelper.getBasketService().getResponse().getBasket().getCode());
    }

    @Then("^the Child seat is removed$")
    public void theChildSeatIsRemoved() throws Throwable {
        basketHelper.getBasket(originalBasket.getCode());
        basketHelper.getBasketService().assertThat().thereIsNoSeatOfType("child");
    }

    @And("^the infant is assigned to the second adult on their lap$")
    public void theInfantIsAssignedToTheSecondAdultOnTheirLap() throws Throwable {
        basketHelper.getBasketService().assertThat().theInfantIsOnTheLapOfTheSecondAdult(sentUpdate, originalBasket);
    }

    @And("^the \"([^\"]*)\" is now in their own seat$")
    public void theIsNowInTheirOwnSeat(String paxType) throws Throwable {
        basketHelper.getBasketService().assertThat().infantIsNowOnTheirOwnSeat(sentUpdate, originalBasket, updatedBasket);
    }

    @And("^all base prices are different$")
    public void allBasePricesAreDifferent() throws Throwable {
        //TODO
    }

    @And("^a price change event is raised$")
    public void aPriceChangeEventIsRaised() throws Throwable {
        //TODO
    }

    @Then("^the basket is marked as invalid$")
    public void theBasketIsMarkedAsInvalid() throws Throwable {
        //TODO
    }
}
