package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.example.ExampleTitleDao;
import com.api.example.database.example.LocalisedLanguagesDao;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.requests.refdata.PassengerTitlesRequest;
import com.api.example.fixture.invoke.services.ServiceFactory;
import com.api.example.fixture.invoke.services.refdata.PassengerTitlesService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;


/**
 * Created by bhalasaravananthiruvarangamrajalakshmi on 10/11/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class GetPassengerTitlesSteps {


    private List<String> expectedTitlesFromDatabase;
    @Autowired
    private ExampleTitleDao _exampleTitleDao;
    @Autowired
    private LocalisedLanguagesDao localisedLanguagesDao;
    private PassengerTitlesService passengerTitlesService;
    @Autowired
    private ServiceFactory serviceFactory;

    @Given("^there are active passenger titles available$")
    public void thereArePassengerTitlesAvailable() {
        // Check in the DB for passenger titles
        expectedTitlesFromDatabase = _exampleTitleDao.findTitlesWhichAreActive(true);
    }

    @When("^I request passenger title reference data$")
    public void iRequestPassengerTitleReferenceData() throws Throwable {
        passengerTitlesService = serviceFactory.get(new PassengerTitlesRequest(ExampleHeaders.getValid("Digital").build()));
        passengerTitlesService.invoke();
    }

    @Then("^all applicable passenger titles are returned$")
    public void allApplicablePassengerTitlesAreReturned() throws Throwable {
        passengerTitlesService.assertThat().theNumberOfPassengerTitlesReturnedWas(expectedTitlesFromDatabase.size())
                .titlesAreAsExpected(expectedTitlesFromDatabase);
    }

    @Given("^there are active passenger titles available with localisations$")
    public void thereAreActivePassengerTitlesAvailableWithLocalisation() throws Throwable {
        //TODO: Check the DB has data
    }

    @Then("^all localisation data is present$")
    public void allLocalisationDataIsPresent() throws Throwable {
        List<String> expectedLocales = localisedLanguagesDao.getLocales(null);
        passengerTitlesService.assertThat().allLocalisationDataIsPresent(expectedLocales);
    }

    @When("^I request passenger title reference data for a language$")
    public void iRequestPassengerTitleReferenceDataForALanguage() throws Throwable {
        ExampleHeaders header = ExampleHeaders.getValid("Digital").build();
        header.setAcceptLanguage("en");
        passengerTitlesService = serviceFactory.get(new PassengerTitlesRequest(header));
        passengerTitlesService.invoke();
    }

    @Then("^only language specific reference data is returned$")
    public void onlyLanguageSpecificReferenceDataIsReturned() throws Throwable {
        List<String> expectedLocales = localisedLanguagesDao.getLocales("en");
        passengerTitlesService.assertThat().allLocalisationDataIsPresentForLanguage("en", expectedLocales);
    }
}