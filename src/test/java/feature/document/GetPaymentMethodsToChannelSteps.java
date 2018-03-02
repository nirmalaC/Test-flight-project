package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.example.models.CustomerModel;
import com.api.example.fixture.asserters.models.ExpectedPaymentMethod;
import com.api.example.fixture.helpers.BasketHelper;
import com.api.example.fixture.helpers.CustomerProfileHelper;
import com.api.example.fixture.helpers.TravellerHelper;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.pathparams.CustomerProfilePathParams;
import com.api.example.fixture.invoke.queryparams.PaymentMethodsQueryParams;
import com.api.example.fixture.invoke.requests.PaymentMethodsRequest;
import com.api.example.fixture.invoke.requests.ProfileRequest;
import com.api.example.fixture.invoke.response.traveller.Travellers;
import com.api.example.fixture.invoke.services.CustomerProfileService;
import com.api.example.fixture.invoke.services.PaymentMethodsService;
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

import javax.ws.rs.HttpMethod;
import java.util.ArrayList;
import java.util.List;

import static com.api.example.fixture.asserters.models.PaymentMethodsExpectedErrors.PAYMENT_METHODS_VALID_ERRORS;

/**
 * Created by prite on 11/11/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class GetPaymentMethodsToChannelSteps {
    protected static Logger LOG = LogManager.getLogger(GetPaymentMethodsToChannelSteps.class);

    private PaymentMethodsService paymentMethodsService;
    @Autowired
    private ServiceFactory serviceFactory;
    @Autowired
    private CustomerProfileHelper customerProfileHelper;
    @Autowired
    private BasketHelper basketHelper;
    @Autowired
    private TravellerHelper travellerHelper;

    private CustomerProfileService customerProfileService;
    private CustomerModel dbCustomer;
    private List<ExpectedPaymentMethod> paymentModes;


    public GetPaymentMethodsToChannelSteps() {
    }

    /*@Given("^I have a basket complete with traveller details$")
    public void iHaveABasketCompleteWithTravellerDetails() throws Throwable {
        basketHelper.myBasketContainsAFlightWithPassengerMix("1 Adult");
        Travellers request = travellerHelper.CreateValidRequestToAddAllTravellersForBasket(basketHelper.getBasketService().getResponse());
        basketHelper.updateTravellersForChannel(request, "Digital", basketHelper.getBasketService().getResponse().getBasket().getCode());
    }

    @And("^I am a registered customer$")
    public void iAmARegisteredCustomer() throws Throwable {
        dbCustomer = customerProfileHelper.findAValidCustomerProfile();
    }*/

    @When("^I call the getPaymentMethods service with missing (.*)$")
    public void iCallTheGetPaymentMethodsServiceWithMissingParameter(String parameter) throws Throwable {
        PaymentMethodsQueryParams paymentMethodsQueryParams = PaymentMethodsQueryParams.builder().basketId(basketHelper.getBasketService().getResponse().getBasket().getCode())
                .bookingTypeCode("STANDARD_CUSTOMER").customerId(dbCustomer.getCustomerid()).build();
        if (parameter.equals("CustomerId")) {
            paymentMethodsQueryParams.setCustomerId(null);
        }
        if (parameter.equals("BasketId")) {
            paymentMethodsQueryParams.setBasketId(null);
        }
        paymentMethodsService = serviceFactory.get(new PaymentMethodsRequest(ExampleHeaders.getValid("Digital").acceptLanguage("en").build(), paymentMethodsQueryParams));
        paymentMethodsService.invoke();
    }

    @When("^I call the getPaymentMethods service with wrong value of (.*)$")
    public void iCallTheGetPaymentMethodsServiceWithWrongValueOfParameter(String parameter) throws Throwable {
        throw new PendingException();
    }

    @And("^the available active payment methods are$")
    public void theAvailableActivePaymentMethodsAre(List<ExpectedPaymentMethod> expectedPaymentModes) throws Throwable {
        paymentModes = expectedPaymentModes;
    }

    @When("^I call the service to choose the payment methods$")
    public void ICallTheServiceToChooseThePaymentMethods() throws Throwable {
        PaymentMethodsQueryParams paymentMethodsQueryParams = PaymentMethodsQueryParams.builder().basketId(basketHelper.getBasketService().getResponse().getBasket().getCode())
                .bookingTypeCode("STANDARD_CUSTOMER").customerId(dbCustomer.getCustomerid()).build();
        paymentMethodsService = serviceFactory.get(new PaymentMethodsRequest(ExampleHeaders.getValid("Digital").build(), paymentMethodsQueryParams));
        paymentMethodsService.invoke();
    }

    @Then("^the applicable payment methods are returned$")
    public void theApplicablePaymentMethodsAreReturned() throws Throwable {
        paymentMethodsService.assertThat().paymentMethodsWereReturned();

    }


    @When("^I call the service to retrieve payment methods for \"([^\"]*)\"$")
    public void iCallTheServiceToRetrievePaymentMethodsFor(String channel) throws Throwable {
        Thread.sleep(5000);
        PaymentMethodsQueryParams paymentMethodsQueryParams = PaymentMethodsQueryParams.builder().basketId(basketHelper.getBasketService().getResponse().getBasket().getCode())
                .bookingTypeCode("STANDARD_CUSTOMER").customerId(dbCustomer.getUid()).build();
        paymentMethodsService = serviceFactory.get(new PaymentMethodsRequest(ExampleHeaders.getValid(channel).acceptLanguage("en").build(), paymentMethodsQueryParams));
        paymentMethodsService.invoke();
    }

    @Then("^the applicable payment methods are returned for \"([^\"]*)\"$")
    public void theApplicablePaymentMethodsAreReturnedFor(String channel) throws Throwable {
        List<ExpectedPaymentMethod> paymentMethods = new ArrayList<>();
        paymentMethodsService.assertThat().paymentMethodsWereReturned();
    }

    /*@And("^there are payment methods available$")
    public void thereArePaymentMethodsAvailable() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //TODO add a check to see what payment methods are available in the reference data once the mock is removed
        LOG.info("this is currently using a mock service");
    }*/

    @Then("^I do not receive \"([^\"]*)\" as an available payment method$")
    public void iDoNotReceiveAsAnAvailablePaymentMethod(String paymentMethod) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        paymentMethodsService.assertThat().thisPaymentMethodWasNotReturned(paymentMethod);
    }

    @Then("^the (.*) validation error is returned$")
    public void theParameterValidationErrorIsReturned(String parameter) throws Throwable {
        paymentMethodsService.assertThatErrors().containedTheCorrectErrorMessageFor(parameter, PAYMENT_METHODS_VALID_ERRORS);
    }

    @Given("^I have a valid basket with passengers and associated customer$")
    public void iHaveAValidBasketWithPassengersAndAssociatedCustomer() throws Throwable {
        basketHelper.myBasketContainsAFlightWithPassengerMix("1 Adult");
        Travellers request = travellerHelper.CreateValidRequestToAddAllTravellersForBasket(basketHelper.getBasketService().getResponse());
        basketHelper.updateTravellersForChannel(request, "Digital", basketHelper.getBasketService().getResponse().getBasket().getCode());
        dbCustomer = customerProfileHelper.findAValidCustomerProfileWithShippingAddress();
        CustomerProfilePathParams profilePathParams = CustomerProfilePathParams.builder().profileId(dbCustomer.getUid()).build();
        customerProfileService = serviceFactory.get(new ProfileRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, profilePathParams));
        customerProfileService.invoke();
    }

    @Given("^I have a valid basket with passengers and associated customer created via \"([^\"]*)\"$")
    public void iHaveAValidBasketWithPassengersAndAssociatedCustomerCreatedVia(String channel) throws Throwable {
        basketHelper.myBasketContainsAFlightWithPassengerMix("1 Adult", channel);
        Travellers request = travellerHelper.CreateValidRequestToAddAllTravellersForBasket(basketHelper.getBasketService().getResponse());
        basketHelper.updateTravellersForChannel(request, channel, basketHelper.getBasketService().getResponse().getBasket().getCode());
        dbCustomer = customerProfileHelper.findAValidCustomerProfileWithShippingAddress();
        CustomerProfilePathParams profilePathParams = CustomerProfilePathParams.builder().profileId(dbCustomer.getUid()).build();
        customerProfileService = serviceFactory.get(new ProfileRequest(ExampleHeaders.getValid(channel).build(), HttpMethod.GET, profilePathParams));
        customerProfileService.invoke();
    }
}
