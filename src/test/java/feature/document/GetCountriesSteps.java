package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.example.CountriesDao;
import com.api.example.exceptions.ExampleCompromisedException;
import com.api.example.fixture.asserters.models.ExpectedCountry;
import com.api.example.fixture.asserters.models.ExpectedLocalizedName;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.requests.refdata.CountriesRequest;
import com.api.example.fixture.invoke.services.ServiceFactory;
import com.api.example.fixture.invoke.services.refdata.CountriesService;
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

import static com.api.example.exceptions.ExampleCompromisedException.ExampleCompromisedExceptionMessages.INSUFFICIENT_DATA;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by daniel on 21/09/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class GetCountriesSteps {

    private static Logger LOG = LogManager.getLogger(GetCountriesSteps.class);
    @Autowired
    private CountriesDao countriesDao;
    @Autowired
    private ServiceFactory serviceFactory;

    private List<String> activeCountriesInExampleDatabase;
    private List<String> inactiveCountriesInTheExampleDatabase;
    private CountriesService countriesService;

    @When("^I call the get countries service$")
    public void iCallTheGetCountriesService() throws Throwable {
        countriesService = serviceFactory.get(new CountriesRequest(ExampleHeaders.getValid("Digital").build()));
        countriesService.invoke();
    }

    @Then("^the following countries are returned$")
    public void theFollowingCountriesAreReturned(List<ExpectedCountry> expectedCountries) throws Throwable {
        countriesService.assertThat().theseCountriesWereReturned(expectedCountries);
    }

    @And("^the localized names for country \"([^\"]*)\" are\"$")
    public void theLocalizedNamesForCountryAre(String countryToCheck, List<ExpectedLocalizedName> expectedLocalizedNames) throws Throwable {
        countriesService.assertThat().thisCountryHasTheseLocalizedNames(countryToCheck, expectedLocalizedNames);
    }

    @Then("^I can see if a country is active or not$")
    public void iCanSeeIfACountryIsActiveOrNot() throws Throwable {
        countriesService.assertThat().allCountriesAreIdentifiedAsBeingActiveOrInactive();
    }

    @Given("^there are active countries in the database$")
    public void thereAreCountriesInTheDatabase() throws Throwable {
        activeCountriesInExampleDatabase = countriesDao.getCountries(true);
        assertThat(activeCountriesInExampleDatabase).size().isGreaterThan(0);

    }

    @Then("^there are countries returned$")
    public void thereAreCountriesReturned() throws Throwable {
        countriesService.assertThat().thereWereCountriesReturned();
    }

    @Then("^all active countries are returned$")
    public void allCountriesAreReturned() throws Throwable {
        countriesService.assertThat().theseCountriesWereAllReturned(activeCountriesInExampleDatabase);
    }

    @Given("^there are inactive countries in the database$")
    public void thereAreInactiveCountriesInTheDatabase() throws Throwable {
        inactiveCountriesInTheExampleDatabase = countriesDao.getCountries(false);
        if (inactiveCountriesInTheExampleDatabase.size() < 1) {
            throw new ExampleCompromisedException(INSUFFICIENT_DATA);
        }
        assertThat(inactiveCountriesInTheExampleDatabase).size().isGreaterThan(0);
    }

    @Then("^the inactive countries are not returned$")
    public void theInactiveCountriesAreNotReturned() throws Throwable {
        countriesService.assertThat().theseCountriesWereNotReturned(inactiveCountriesInTheExampleDatabase);
    }
}
