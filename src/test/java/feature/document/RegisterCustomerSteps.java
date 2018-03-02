package feature.document;

import com.api.example.TestApplication;
import com.api.example.fixture.helpers.CustomerHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static com.api.example.fixture.asserters.models.CustomerMissingFieldErrors.*;
import static com.api.example.fixture.asserters.models.CustomerMissingFieldErrors.CustomerExpectedErrors.CUSTOMER_VALID_ERRORS;

/**
 * Created by dwebb on 12/15/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class RegisterCustomerSteps {

    @Autowired
    private CustomerHelper customerHelper;

    public RegisterCustomerSteps() {
    }

    @Given("^a valid request to create a customer profile$")
    public void aValidRequestToCreateACustomerProfile() throws Throwable {
        customerHelper.aValidRequestToCreateAProfileForCustomer();
    }

    @When("^I request creation of a customer profile$")
    public void iRequestCreationOfACustomerProfile() throws Throwable {
        customerHelper.requestCreationOfACustomerProfile();

    }

    @Then("^the customer profile is created$")
    public void theCustomerProfileIsCreated() throws Throwable {
        customerHelper.getRegisterCustomerService().assertThat().theCustomerProfileWasCreated(customerHelper.getRequest());
    }


    @Given("^I have provided valid mandatory fields for \"([^\"]*)\" with the missing field \"([^\"]*)\"$")
    public void iHaveProvidedValidMandatoryFieldsForWithTheMissingField(String channel, String field) throws Throwable {
        customerHelper.customerRequestWithMissingField(channel,field);
    }

    @Then("^I will get a Invalid character error for \"([^\"]*)\"$")
    public void iWillGetAInvalidCharacterErrorFor(String field) throws Throwable {
        customerHelper.getRegisterCustomerService().assertThatErrors().containedTheCorrectErrorMessageFor (field,  CUSTOMER_NAME_VALID_ERRORS);
    }

    @But("^the \"([^\"]*)\" is not valid because it contains \"(.*)\"$")
    public void theIsNotValidBecauseItContains(String field, String symbol) throws Throwable {
        customerHelper.setCustomerProfileFieldWithSymbol(field,symbol);
    }

    @Then("^I will get a customer creation error for the missing field \"([^\"]*)\"$")
    public void iWillGetACustomerCreationErrorForTheMissingField(String field) throws Throwable {
        customerHelper.getRegisterCustomerService().assertThatErrors().containedTheCorrectErrorMessageFor (field, CUSTOMER_MISSING_FIELD_VALID_ERRORS);
    }

    @Given("^an existing customer profile with known e-mail address$")
    public void anExistingCustomerProfileWithKnownEMailAddress() throws Throwable {
        customerHelper.customerAccountExistsWithAKnownEmail();
    }

    @When("^I request creation of a new customer profile with the same e-mail address$")
    public void iRequestCreationOfANewCustomerProfileWithTheSameEMailAddress() throws Throwable {
        customerHelper.creatNewCustomerProfielWithpPeviouslyUsedEmail();
    }

    @Then("^an email registered validation error is returned$")
    public void anEmailRegisteredValidationErrorIsReturned() throws Throwable {
        String field = "email";
        customerHelper.getRegisterCustomerService().assertThatErrors().containedTheCorrectErrorMessageFor (field,  CUSTOMER_VALID_ERRORS);
    }

    @But("^the \"([^\"]*)\" length is \"([^\"]*)\"$")
    public void theLengthIs(String field, int length) throws Throwable {
        customerHelper.customerRequestWithFieldAndFieldLength(field,length);
    }

    @And("^the optional field \"([^\"]*)\" is missing$")
    public void theOptionalFieldIsMissing(String arg0) throws Throwable {
      //nothing to do there is no need to unset any of the non madatory fields as they are simply not set at all.
    }

    @But("^the email field is in an invalid format \"([^\"]*)\"$")
    public void theEmailFieldIsInAnInvalidFormat(String invalidEmail) throws Throwable {
        customerHelper.creatNewCustomerProfielWithEmail(invalidEmail);
    }

    @Then("^an Invalid Email Format validation error is returned$")
    public void anInvalidEmailFormatValidationErrorIsReturned() throws Throwable {
        String field = "invalidEmailFormat";
        customerHelper.getRegisterCustomerService().assertThatErrors().containedTheCorrectErrorMessageFor (field,  CUSTOMER_VALID_ERRORS);
    }

    @Then("^I will get a customer creation error for field length \"([^\"]*)\"$")
    public void iWillGetACustomerCreationErrorForFieldLength(String field) throws Throwable {
        customerHelper.getRegisterCustomerService().assertThatErrors().containedTheCorrectErrorMessageFor (field, CUSTOMER_VALID_ERRORS);
    }

    @And("^the email address is availabel for recycling$")
    public void theEmailAddressIsAvailabelForRecycling() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^a valid request to create a customer profile for \"([^\"]*)\"$")
    public void aValidRequestToCreateACustomerProfileFor(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @But("^the \"([^\"]*)\" age is not valid$")
    public void theAgeIsNotValid(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^an age validation error is returned$")
    public void anAgeValidationErrorIsReturned() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
