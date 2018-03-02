package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.example.AdminFeeDao;
import com.api.example.database.example.models.AdminFeesModel;
import com.api.example.fixture.helpers.BasketHelper;
import com.api.example.fixture.invoke.services.FlightsService;
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

/**
 * Created by AndyGr on 12/20/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class ApportionAdminFeeSteps {

    private static Logger LOG = LogManager.getLogger(ApportionAdminFeeSteps.class);

    @Autowired
    private AdminFeeDao adminFeeDao;
    @Autowired
    private BasketHelper basketHelper;

    private List<AdminFeesModel> feesFromDB;

    private FlightsService flightsService;

    public ApportionAdminFeeSteps() {
    }

    @Given("^I know the admin fee$")
    public void iKnowTheAdminFee() throws Throwable {
        feesFromDB = adminFeeDao.getAdminFees();
        LOG.info("FeesRetrieved from Databse "+feesFromDB);
    }

    @Given("^my basket contains \"([^\"]*)\" flight for \"([^\"]*)\" passengers added via the \"([^\"]*)\" channel$")
    public void myBasketContainsFlightForPassengersAddedViaTheChannel(int noOfFlights, int noOfPassengers, String channel) throws Throwable {
        basketHelper.addTripTypeWithPasengersViaChannelToBasket(noOfFlights, noOfPassengers, channel);
    }


    @Given("^I have found a valid flight for multiple passengers for channel \"([^\"]*)\" and bundle \"([^\"]*)\"$")
    public void theCreditCardFeeForEachPassengerIsCorrectForChannel(String channel, String bundle) throws Throwable {
       // basketHelper.getBasketService().assertThat().theCreditCardFeeForEachPassengerIsCorrect(channel, feesFromDB);

    }

    @Then("^the admin fee should be apportioned per passenger and rounded to the nearest pence for the first two sectors only$")
    public void theAdminFeeShouldBeApportionedPerPassengerAndRoundedToTheNearestPenceForTheFirstTwoSectors () throws Throwable {
        basketHelper.getBasketService().assertThat().theAdminFeeShouldBeApportionedPerPassengerAndRoundedToTheNearestPenceForTheFirstTwoSectors (feesFromDB);
    }


    @When("^I add the <tripType(\\d+)> flight to my basket via the \"([^\"]*)\" channel$")
    public void iAddTheTripTypeFlightToMyBasketViaTheChannel(int arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^remove <tripType(\\d+)> flight from basket$")
    public void removeTripTypeFlightFromBasket(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Flight tax is apportioned per passenger$")
    public void flightTaxIsApportionedPerPassenger() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^credit card fee is added at order level based on language set$")
    public void creditCardFeeIsAddedAtOrderLevelBasedOnLanguageSet() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I have a <tripType(\\d+)> and <tripType(\\d+)> flight for <noOfPassengers> passengers in basket for \"([^\"]*)\" channel$")
    public void iHaveATripTypeAndTripTypeFlightForNoOfPassengersPassengersInBasketForChannel(int arg0, int arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I add the flight to my basket via \"([^\"]*)\" channel$")
    public void iAddTheFlightToMyBasketViaTheChannel(String channel) throws Throwable {
        basketHelper.addFlightToBasketAsChannel(flightsService.getOutboundFlight(), channel);
    }


    @Then("^the admin fee should be apportioned per passenger per sector and wrapped up in the flight fare of the first flight Only$")
    public void theAdminFeeShouldBeApportionedPerPassengerPerSectorAndWrappedUpInTheFlightFare() throws Throwable {
        basketHelper.getBasketService().assertThat().theAdministrationFeeDividedAcrossPassengersandOfTheFirstFlightOnly(feesFromDB);
    }

    @When("^I add another flight to the basket$")
    public void iAddAnotherFlightToTheBasket() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^my basket contains return flight for \"([^\"]*)\" passengers added via the \"([^\"]*)\" channel$")
    public void myBasketContainsReturnFlightForPassengersAddedViaTheChannel(int numberOfPassengers, String channel) throws Throwable {
        basketHelper.addReturnFlightToBasketAsChannel(numberOfPassengers, channel);
    }

    @When("^I add another \"([^\"]*)\" flight with \"([^\"]*)\" passengers to the basket via the \"([^\"]*)\" channel$")
    public void iAddAnotherFlightWithPassengersToTheBasketViaTheChannel(int numberOfFlights, int numberOfPassengers, String channel) throws Throwable {
        basketHelper.addFlightToBasketAsChannel(numberOfFlights, numberOfPassengers, channel);
    }

    @Given("^my basket contains an Outbound flight for for \"([^\"]*)\" passengers added via the \"([^\"]*)\" channel$")
    public void myBasketContainsAnOutboundFlightForForPassengersAddedViaTheChannel(int numberOfPassengers, String channel) throws Throwable {
        basketHelper.addFlightToBasketAsChannel(numberOfPassengers, channel);
    }

    @Given("^my basket contains \"([^\"]*)\" flights for \"([^\"]*)\" passengers added via the \"([^\"]*)\" channel$")
    public void myBasketContainsFlightsForPassengersAddedViaTheChannel(int numberOfFlights, int numberOfPassengers, String channel) throws Throwable {
        basketHelper.addFlightToBasketAsChannel(numberOfFlights, numberOfPassengers, channel);
    }

    @Then("^the admin fee should be apportioned per passenger and rounded to the nearest pence for the first (\\d+) sectors$")
    public void theAdminFeeShouldBeApportionedPerPassengerAndRoundedToTheNearestPenceForTheFirstSectors(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I add the \"([^\"]*)\" flights with \"([^\"]*)\" passengers to my basket via \"([^\"]*)\"$")
    public void iAddTheFlightsWithPassengersToMyBasketVia(int numberOfFlights, int numberOfPassengers, String channel) throws Throwable {
        basketHelper.addFlightToBasketAsChannel(numberOfFlights, numberOfPassengers, channel);
    }

    @Then("^the credit card fee for each passenger is correct for the \"([^\"]*)\"$")
    public void theCreditCardFeeForEachPassengerIsCorrectForChannel(String channel) throws Throwable {
        basketHelper.getBasketService().assertThat().theCreditCardFeeForEachPassengerIsCorrect(channel, feesFromDB);
    }

    @And("^the administration tax is at booking level$")
    public void theAdministrationTaxIsAtBookingLevel() throws Throwable {
        basketHelper.getBasketService().assertThat().theAdministrationTaxIsAtBookingLevel(feesFromDB);
    }

    @And("^the total fare with credit card is at booking level$")
    public void theTotalFareWithCreditCardIsAtBookingLevel() throws Throwable {
        basketHelper.getBasketService().assertThat().theTotalFareWithCreditCardIsAtBookingLevel(feesFromDB);
    }

}
