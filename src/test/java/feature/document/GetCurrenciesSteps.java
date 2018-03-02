package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.example.CurrenciesDao;
import com.api.example.exceptions.ExampleCompromisedException;
import com.api.example.fixture.asserters.models.ExpectedCurrency;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.requests.refdata.CurrenciesRequest;
import com.api.example.fixture.invoke.services.ServiceFactory;
import com.api.example.fixture.invoke.services.refdata.CurrenciesService;
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
public class GetCurrenciesSteps {

    private CurrenciesService currenciesService;
    @Autowired
    private ServiceFactory serviceFactory;
    @Autowired
    private CurrenciesDao currenciesDao;
    private List<ExpectedCurrency> activeCurrencies;
    private List<ExpectedCurrency> inactiveCurrencies;

    @Given("^there are active currencies$")
    public void thereAreActiveCurrencies() throws Throwable {
        activeCurrencies = currenciesDao.getCurrencies(true);
        if (activeCurrencies.size() < 1) {
            throw new ExampleCompromisedException(INSUFFICIENT_DATA);
        }
    }

    @When("^I call the get currencies service$")
    public void iCallTheGetCurrenciesService() throws Throwable {
        currenciesService = serviceFactory.get(new CurrenciesRequest(ExampleHeaders.getValid("Digital").build()));
        currenciesService.invoke();
    }

    @When("^I call the get currencies service with \"([^\"]*)\"$")
    public void i_call_the_get_currencies_service_with(String channel) throws Throwable {
        ExampleHeaders headerWithChannel = ExampleHeaders.getValid("Digital").build();
        headerWithChannel.setXPosId(channel);
        currenciesService = serviceFactory.get(new CurrenciesRequest(headerWithChannel));
        currenciesService.invoke();
    }

    @Then("^the active currencies are returned$")
    public void theActiveCurrenciesAreReturned() throws Throwable {
        currenciesService.assertThat().onlyTheseCurrenciesWereReturned(activeCurrencies);
    }

    @Given("^there are inactive currencies$")
    public void thereAreInactiveCurrencies() throws Throwable {
        inactiveCurrencies = currenciesDao.getCurrencies(false);
        if (inactiveCurrencies.size() < 1) {
            throw new ExampleCompromisedException(INSUFFICIENT_DATA);
        }
    }

    @Then("^the inactive currencies are not returned$")
    public void theInactiveCurrenciesAreNotReturned() throws Throwable {
        currenciesService.assertThat().theseCurrenciesWereNotReturned(inactiveCurrencies);
    }
}