package feature.document;

import com.api.example.TestApplication;
import com.api.example.fixture.helpers.CustomerHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static com.api.example.fixture.asserters.models.LoginExpectedErrors.CUSTOMER_LOGIN_ERRORS;

/**
 * Created by dwebb on 12/16/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class CustomerLoginSteps {

    @Autowired
    private CustomerHelper customerHelper;
    private int maxAttempts = 6;

    public CustomerLoginSteps() {
    }

    @When("^I login with valid credentials$")
    public void iLoginWithValidCredentials() throws Throwable {
        customerHelper.loginWithValidCredentials();
    }

    @Given("^a customer account exists with a known password$")
    public void aCustomerAccountExistsWithAKnownPassword() throws Throwable {
        customerHelper.customerAccountExistsWithAKnownPassword();
    }

    @Then("^I should be successfully logged in$")
    public void iShouldBeSuccessfullyLoggedIn() throws Throwable {
        customerHelper.getLoginDetailsService().assertThat().theLoginWasSuccesful();
    }

    @When("^I login with valid credentials using the \"([^\"]*)\" channel$")
    public void iLoginWithValidCredentialsUsingTheChannel(String channel) throws Throwable {
        customerHelper.loginWithValidCredentials(channel);
    }

    @Then("^I should not be logged in$")
    public void iShouldNotBeLoggedIn() throws Throwable {
        customerHelper.getLoginDetailsService().assertThatErrors().containedTheCorrectErrorMessageFor("wrong credentials", CUSTOMER_LOGIN_ERRORS);
    }

    @When("^I login with invalid credentials$")
    public void iLoginWithInvalidCredentials() throws Throwable {
        customerHelper.loginWithInvalidCredentials();
    }

    @When("^I provide a different email address$")
    public void iProvideADifferentEmailAddress() throws Throwable {
        customerHelper.loginWithDifferentEmail("thisisnotthe@emailforpassword.com");
    }

    @And("^configuration is in place for maximum number of failed attempts to get lock$")
    public void configurationIsInPlaceForMaximumNumberOfFailedAttemptsToGetLock() throws Throwable {
        //assume it is six
        maxAttempts = 6;
    }

    @When("^I breach the maximum login attempts in a single session$")
    public void iBreachTheMaximumLoginAttemptsInASingleSession() throws Throwable {
        //attempt login 7 times
        for (int i = 0; i < maxAttempts -1; i++) {
            customerHelper.loginWithInvalidPassword("");
            customerHelper.getLoginDetailsService().assertThatErrors().containedTheCorrectErrorMessageFor("wrong credentials", CUSTOMER_LOGIN_ERRORS);
        }
        customerHelper.loginWithInvalidPassword("");
    }

    @Then("^the account is locked$")
    public void theAccountIsLocked() throws Throwable {
        customerHelper.getLoginDetailsService().assertThatErrors().containedTheCorrectErrorMessageFor("disabled", CUSTOMER_LOGIN_ERRORS);
    }

    @When("^I breach the maximum login attempts over multiple sessions$")
    public void iBreachTheMaximumLoginAttemptsOverMultipleSessions() throws Throwable {
        for (int i = 0; i < maxAttempts -1; i++) {
            customerHelper.loginWithInvalidPassword("");
            customerHelper.getLoginDetailsService().assertThatErrors().containedTheCorrectErrorMessageFor("wrong credentials", CUSTOMER_LOGIN_ERRORS);
        }
        customerHelper.loginWithInvalidPassword("");
    }

    @And("^the account has been disabled$")
    public void theAccountHasBeenDisabled() throws Throwable {
        for (int i = 0; i < maxAttempts; i++) {
            customerHelper.loginWithInvalidPassword("");
        }
    }

    @Then("^I am informed that the account is disabled$")
    public void iAmInformedThatTheAccountIsDisabled() throws Throwable {
        customerHelper.getLoginDetailsService().assertThatErrors().containedTheCorrectErrorMessageFor("disabled", CUSTOMER_LOGIN_ERRORS);
    }

    @Then("^I am informed that only Digital can access this channel$")
    public void iAmInformedThatOnlyDigitalCanAccessThisChannel() throws Throwable {
        customerHelper.getLoginDetailsService().assertThatErrors().containedTheCorrectErrorMessageFor("digital only", CUSTOMER_LOGIN_ERRORS);
    }
}
