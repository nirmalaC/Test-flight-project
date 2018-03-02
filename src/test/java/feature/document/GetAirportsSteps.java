package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.example.AirportsDao;
import com.api.example.exceptions.ExampleCompromisedException;
import com.api.example.fixture.asserters.models.ExpectedAirport;
import com.api.example.fixture.asserters.models.ExpectedLocalizedName;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.requests.refdata.AirportsRequest;
import com.api.example.fixture.invoke.services.ServiceFactory;
import com.api.example.fixture.invoke.services.refdata.AirportsService;
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


/**
 * Created by daniel on 21/09/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class GetAirportsSteps {

    protected static Logger LOG = LogManager.getLogger(GetAirportsSteps.class);
    @Autowired
    private AirportsDao airportsDao;
    @Autowired
    private ServiceFactory serviceFactory;
    private List<String> inactiveAirportsFromDatabase;
    private List<String> activeAirportsFromDatabase;
    private AirportsService airportsService;

    public GetAirportsSteps() {
    }

    @When("^I call the get airports service$")
    public void iCallTheGetAirportsService() throws Throwable {
        airportsService = serviceFactory.get(new AirportsRequest(ExampleHeaders.getValid("Digital").build()));
        airportsService.invoke();
    }

    @Then("^there are (\\d+) airports returned$")
    public void thereAreAirportsReturned(int expectedNumberOfAirports) throws Throwable {
        airportsService.assertThat().theNumberOfAirportsReturnedWas(expectedNumberOfAirports);
    }

    @Then("^the following airports are returned in the response:$")
    public void theFollowingAirportsAreReturnedInTheResponse(List<ExpectedAirport> expectedAirports) throws Throwable {
        airportsService.assertThat().theseAirportsWereReturnedWithTheCorrectInformation(expectedAirports);
    }

    @Then("^the airport \"([^\"]*)\" has the following localized names:$")
    public void theAirportHasTheFollowingLocalizedNames(String airportToCheck, List<ExpectedLocalizedName> expectedLocalizedNames) throws Throwable {
        airportsService.assertThat().theAirportHasTheseLocalizedNames(airportToCheck, expectedLocalizedNames);
    }

    @Given("^there are inactive airports$")
    public void thereAreInactiveAirports() throws Throwable {
        inactiveAirportsFromDatabase = airportsDao.getAirportsThatAreActive(false);
        if (inactiveAirportsFromDatabase.size() < 1) {
            throw new ExampleCompromisedException(INSUFFICIENT_DATA);
        }
    }

    @Then("^the inactive airports are not returned$")
    public void theInactiveAirportsAreNotReturned() throws Throwable {
        airportsService.assertThat().theseAirportsWereNotReturned(inactiveAirportsFromDatabase);

    }

    @Given("^there are active airports$")
    public void thereAreActiveAirports() throws Throwable {
        activeAirportsFromDatabase = airportsDao.getAirportsThatAreActive(true);
        if (activeAirportsFromDatabase.size() < 1) {
            throw new ExampleCompromisedException(INSUFFICIENT_DATA);
        }
    }

    @Then("^all the active airports are returned$")
    public void allTheActiveAirportsAreReturned() throws Throwable {
        airportsService.assertThat().theseAirportsWereReturned(activeAirportsFromDatabase);
    }

    @Then("^all of the airports have localized names$")
    public void allOfTheAirportsHaveLocalizedNames() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        airportsService.assertThat().allAirportsHaveLocalizedNames();
    }
}
