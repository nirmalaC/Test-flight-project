package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.example.LanguagesDao;
import com.api.example.exceptions.ExampleCompromisedException;
import com.api.example.fixture.asserters.models.ExpectedLanguage;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.requests.refdata.LanguagesRequest;
import com.api.example.fixture.invoke.services.ServiceFactory;
import com.api.example.fixture.invoke.services.refdata.LanguagesService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.api.example.exceptions.ExampleCompromisedException.ExampleCompromisedExceptionMessages.INSUFFICIENT_DATA;

/**
 * Created by daniel on 21/09/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class GetLanguagesSteps {

    @Autowired
    private ServiceFactory serviceFactory;
    @Autowired
    private LanguagesDao languagesDao;
    private LanguagesService languagesService;
    private List<ExpectedLanguage> activeLanguages;
    private List<ExpectedLanguage> inactiveLanguages;

    public GetLanguagesSteps() {
    }

    @When("^I call the get languages service$")
    public void iCallTheGetLanguagesService() throws Throwable {
        languagesService = serviceFactory.get(new LanguagesRequest(ExampleHeaders.getValid("Digital").build()));
        languagesService.invoke();
    }

    @When("^I call the get languages service with \"([^\"]*)\"$")
    public void iCallTheGetLanguagesServiceWith(String channel) throws Throwable {
        ExampleHeaders headerWithChannel = ExampleHeaders.getValid(channel).build();
        headerWithChannel.setXPosId(channel);
        languagesService = serviceFactory.get(new LanguagesRequest(headerWithChannel));
        languagesService.invoke();
    }


    @Given("^there are active languages$")
    public void thereAreActiveLanguages() throws Throwable {
        activeLanguages = languagesDao.getLanguages(true);
        if (activeLanguages.size() < 1) {
            throw new ExampleCompromisedException(INSUFFICIENT_DATA);
        }
    }

    @Given("^there are inactive languages$")
    public void thereAreInactiveLanguages() throws Throwable {
        inactiveLanguages = languagesDao.getLanguages(false);
        if (inactiveLanguages.size() < 1) {
            throw new ExampleCompromisedException(INSUFFICIENT_DATA);
        }
    }

    @Then("^the active languages are returned$")
    public void theActiveLanguagesAreReturned() throws Throwable {
        languagesService.assertThat().onlyTheseLanguagesWereReturned(activeLanguages);
    }

    @Then("^the inactive languages are not returned$")
    public void theInactiveLanguagesAreNotReturned() throws Throwable {
        languagesService.assertThat().theseLanguagesWereNotReturned(inactiveLanguages);

    }
}
