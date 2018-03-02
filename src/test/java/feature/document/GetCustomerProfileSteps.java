package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.example.models.CustomerModel;
import com.api.example.fixture.helpers.CustomerProfileHelper;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.pathparams.CustomerProfilePathParams;
import com.api.example.fixture.invoke.requests.ProfileRequest;
import com.api.example.fixture.invoke.services.CustomerProfileService;
import com.api.example.fixture.invoke.services.ServiceFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import javax.ws.rs.HttpMethod;

/**
 * Created by dwebb on 12/2/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class GetCustomerProfileSteps {

    @Autowired
    private CustomerProfileHelper customerProfileHelper;
    @Autowired
    private ServiceFactory servicefactory;
    private CustomerProfileService customerProfileService;
    private CustomerModel dbCustomer;

    public GetCustomerProfileSteps() {
    }

    @Given("^a customer profile exists$")
    public void aCustomerProfileExists() throws Throwable {
        dbCustomer = customerProfileHelper.findAValidCustomerProfile();
    }

    @When("^I search for the profile$")
    public void iSearchForTheProfile() throws Throwable {
        CustomerProfilePathParams profilePathParams = CustomerProfilePathParams.builder().profileId(dbCustomer.getUid()).build();
        customerProfileService = servicefactory.get(new ProfileRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, profilePathParams));
        customerProfileService.invoke();
    }

    @Then("^a profile is returned$")
    public void aProfileIsReturned() throws Throwable {
        customerProfileService.assertThat().theProfileContainsBasicData(dbCustomer);
    }

    @Given("^a customer profile does not exist$")
    public void aCustomerProfileDoesNotExist() throws Throwable {
        dbCustomer = new CustomerModel("YUT2367776", "YUT2367776","", "", "", "", "", "", "","","","");
    }

    @Then("^a profile error is returned$")
    public void aProfileErrorIsReturned() throws Throwable {
        customerProfileService.assertThatErrors().containsText("Customer is not found");
    }
}
