package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.example.models.CustomerModel;
import com.api.example.fixture.helpers.CustomerProfileHelper;
import com.api.example.fixture.helpers.IdentifyCustomerHelper;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.queryparams.IdentifyCustomerQueryParams;
import com.api.example.fixture.invoke.requests.IdentifyCustomerRequest;
import com.api.example.fixture.invoke.services.CustomerProfileService;
import com.api.example.fixture.invoke.services.IdentifyCustomerService;
import com.api.example.fixture.invoke.services.ServiceFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import javax.ws.rs.HttpMethod;

/**
 * Created by dwebb on 12/5/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class IdentifyCustomerSteps {

    private IdentifyCustomerService identifyCustomerService;
    private CustomerProfileService customerProfileService;
    private CustomerModel dbCustomer;

    @Autowired
    private CustomerProfileHelper customerProfileHelper;

    @Autowired
    private IdentifyCustomerHelper identifyCustomerHelper;

    @Autowired
    private ServiceFactory serviceFactory;

    @Given("^a customer with valid data exists$")
    public void aCustomerWithValidDataExists() throws Throwable {
        dbCustomer = customerProfileHelper.findAValidCustomerProfile();
    }

    @When("^I search using \"([^\"]*)\" only$")
    public void iSearchUsingOnly(String field) throws Throwable {
        IdentifyCustomerQueryParams identifyQueryParams = identifyCustomerHelper.getParamsFor(field, dbCustomer);
        identifyCustomerService = serviceFactory.get(new IdentifyCustomerRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, null, identifyQueryParams));
        identifyCustomerService.invoke();
    }

    @Then("^I am informed that I cannot search using only lastname$")
    public void iAmInformedThatICannotSearchUsingOnlyLastname() throws Throwable {
        identifyCustomerService.assertThatErrors().containsText("Please enter either a title or First Name of the customer");
    }

    @Then("^I am informed that I cannot search using only firstname$")
    public void iAmInformedThatICannotSearchUsingOnlyFirstname() throws Throwable {
        identifyCustomerService.assertThatErrors().containsText("Atleast one more parameter needed along with firstname parameter");
    }

    @Then("^I am informed that I cannot search using only title$")
    public void iAmInformedThatICannotSearchUsingOnlyTitle() throws Throwable {
        identifyCustomerService.assertThatErrors().containsText("Please enter additional search criteria");
    }

    @When("^I search using lastname and firstname is empty$")
    public void iSearchUsingLastnameAndFirstnameIsEmpty() throws Throwable {
        IdentifyCustomerQueryParams identifyQueryParams = IdentifyCustomerQueryParams.builder().lastname(dbCustomer.getLastname()).firstname("{EMPTY}").build();
        identifyCustomerService = serviceFactory.get(new IdentifyCustomerRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, null, identifyQueryParams));
        identifyCustomerService.invoke();
    }

    @Then("^I am informed that lastname needs a firstname value$")
    public void iAmInformedThatLastnameNeedsAFirstnameValue() throws Throwable {
        identifyCustomerService.assertThatErrors().containsText("Please enter either a title or First Name of the customer");
    }

    @When("^I search using lastname and firstname is (\\d+) character$")
    public void iSearchUsingLastnameAndFirstnameIsCharacter(int chars) throws Throwable {
        IdentifyCustomerQueryParams identifyQueryParams = IdentifyCustomerQueryParams.builder().lastname(dbCustomer.getLastname()).firstname(dbCustomer.getFirstname().substring(0, 1)).build();
        identifyCustomerService = serviceFactory.get(new IdentifyCustomerRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, null, identifyQueryParams));
        identifyCustomerService.invoke();
    }

    @When("^I search using lastname and title$")
    public void iSearchUsingLastnameAndTitle() throws Throwable {
        IdentifyCustomerQueryParams identifyQueryParams = IdentifyCustomerQueryParams.builder().lastname(dbCustomer.getLastname()).title(dbCustomer.getTitle()).build();
        identifyCustomerService = serviceFactory.get(new IdentifyCustomerRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, null, identifyQueryParams));
        identifyCustomerService.invoke();
    }

    @When("^I search for the profile using \"([^\"]*)\"$")
    public void iSearchForTheProfileUsing(String casing) throws Throwable {
        IdentifyCustomerQueryParams identifyQueryParams = identifyCustomerHelper.queryParamsFromCustomer(dbCustomer, casing);
        identifyCustomerService = serviceFactory.get(new IdentifyCustomerRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, null, identifyQueryParams));
        identifyCustomerService.invoke();
    }

    @When("^I search using the email address \"([^\"]*)\"$")
    public void iSearchUsingTheEmailAddress(String email) throws Throwable {
        IdentifyCustomerQueryParams identifyQueryParams = IdentifyCustomerQueryParams.builder().email(email).build();
        identifyCustomerService = serviceFactory.get(new IdentifyCustomerRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, null, identifyQueryParams));
        identifyCustomerService.invoke();
    }

    @Then("^I am informed that the email address is not valid$")
    public void iAmInformedThatTheEmailAddressIsNotValid() throws Throwable {
        identifyCustomerService.assertThatErrors().containsText("Email address is invalid");
    }

    @Then("^the customer profile is returned$")
    public void theCustomerProfileIsReturned() throws Throwable {
        identifyCustomerService.assertThat().thatCorrectCustomerDetailsWereReturned(dbCustomer);
    }

    @When("^I search for multiple matching profiles$")
    public void i_search_for_multiple_matching_profiles() throws Throwable {
        IdentifyCustomerQueryParams identifyQueryParams = IdentifyCustomerQueryParams.builder().title(dbCustomer.getTitle()).firstname(dbCustomer.getFirstname()).lastname(dbCustomer.getLastname()).build();
        identifyCustomerService = serviceFactory.get(new IdentifyCustomerRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, null, identifyQueryParams));
        identifyCustomerService.invoke();
    }

    @Then("^the list is returned by default in lastname ascending order$")
    public void the_list_is_returned_by_default_in_lastname_ascending_order() throws Throwable {
        identifyCustomerService.assertThat().theListIsSortedByLastNameByDefault();
    }

    @When("^I search for a customer with no matching data$")
    public void i_search_for_a_customer_with_no_matching_data() throws Throwable {
        IdentifyCustomerQueryParams identifyQueryParams = IdentifyCustomerQueryParams.builder().title(dbCustomer.getTitle()).firstname(RandomStringUtils.randomAlphabetic(6).toLowerCase()).lastname(RandomStringUtils.randomAlphabetic(7).toLowerCase()).build();
        identifyCustomerService = serviceFactory.get(new IdentifyCustomerRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, null, identifyQueryParams));
        identifyCustomerService.invoke();
    }

    @Then("^I should see \"([^\"]*)\" error message$")
    public void i_should_see_error_message(String rtnMessage) throws Throwable {
        identifyCustomerService.assertThat();
        identifyCustomerService.assertThat().thatVerifyTheReponseMessage(rtnMessage);
    }


    @Given("^there are more than (\\d+) customers from \"([^\"]*)\"$")
    public void thereAreMoreThanCustomersFrom(int numberOfCustomers, String country) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I search for multiple matching profiles and choose to sort the results by \"([^\"]*)\"$")
    public void iSearchForMultipleMatchingProfilesAndChooseToSortTheResultsBy(String sortField) throws Throwable {
        IdentifyCustomerQueryParams identifyQueryParams = IdentifyCustomerQueryParams.builder()
                .title(dbCustomer.getTitle())
                .firstname(dbCustomer.getFirstname())
                .lastname(dbCustomer.getLastname())
                .sortfield(sortField)
                .order("ascending")
                .build();
        identifyCustomerService = serviceFactory.get(new IdentifyCustomerRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, null, identifyQueryParams));
        identifyCustomerService.invoke();
    }

    @Then("^the results are sorted by \"([^\"]*)\"$")
    public void theResultsAreSortedBy(String sortField) throws Throwable {
        identifyCustomerService.assertThat().thenDataReturnedIsSortedBy(sortField);
    }

    @When("^I search for the profile using partial \"([^\"]*)\"$")
    public void iSearchForTheProfileUsingPartial(String fields) throws Throwable {
        IdentifyCustomerQueryParams identifyQueryParams = IdentifyCustomerQueryParams.builder().lastname(dbCustomer.getLastname().substring(0, 3)).firstname(dbCustomer.getFirstname().substring(0, 3)).build();
        identifyCustomerService = serviceFactory.get(new IdentifyCustomerRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, null, identifyQueryParams));
        identifyCustomerService.invoke();
    }
}
