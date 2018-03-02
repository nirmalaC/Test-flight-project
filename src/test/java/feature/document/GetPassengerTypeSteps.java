package feature.document;

import com.api.example.TestApplication;
import com.api.example.database.example.ExamplePassengerTypeDao;
import com.api.example.database.example.models.PassengerTypeDbModel;
import com.api.example.fixture.asserters.models.ExpectedLocalizedName;
import com.api.example.fixture.asserters.models.ExpectedPassenger;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.requests.refdata.PassengerTypesRequest;
import com.api.example.fixture.invoke.services.ServiceFactory;
import com.api.example.fixture.invoke.services.refdata.PassengerTypesService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * Created by daniel on 21/09/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class GetPassengerTypeSteps {

    private PassengerTypesService passengerTypesService;
    @Autowired
    private ServiceFactory serviceFactory;
    private List<PassengerTypeDbModel> paxTypes;

    @Autowired
    private ExamplePassengerTypeDao dbPaxTypes;

    @When("^I call the get passenger types service$")
    public void iCallTheGetPassengerTypesService() throws Throwable {
        passengerTypesService = serviceFactory.get(new PassengerTypesRequest(ExampleHeaders.getValid("Digital").build()));
        passengerTypesService.invoke();
    }

    @Then("^the following passenger types are returned:$")
    public void the_following_passenger_types_are_returned(List<ExpectedPassenger> expectedPassengers) throws Throwable {
        passengerTypesService.assertThat().thesePassengerTypesWereReturned(expectedPassengers);
    }

    @And("^the localized names for passenger code \"([^\"]*)\" are:$")
    public void theLocalizedNamesForPassengerCodeAre(String passengerCodeToCheck, List<ExpectedLocalizedName> expectedLocalizedNames) throws Throwable {
        passengerTypesService.assertThat().thisPassengerTypeHasTheseLocalizedNames(passengerCodeToCheck, expectedLocalizedNames);
    }

    @Given("^there are passsenger types$")
    public void thereArePasssengerTypes() throws Throwable {
        paxTypes = dbPaxTypes.getPassengerTypes();
    }

    @Then("^the passenger types are returned$")
    public void thePassengerTypesAreReturned() throws Throwable {
        passengerTypesService.assertThat().thePassengerTypesWereReturned(paxTypes);
    }
}