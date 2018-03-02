package feature.document;

import com.api.example.TestApplication;
import com.api.example.fixture.asserters.models.ExpectedLocalizedDescription;
import com.api.example.fixture.asserters.models.ExpectedMarketGroup;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.requests.refdata.MarketGroupsRequest;
import com.api.example.fixture.invoke.services.ServiceFactory;
import com.api.example.fixture.invoke.services.refdata.MarketGroupsService;
import cucumber.api.java.en.And;
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
public class GetMarketGroupReferenceDataSteps {

    private MarketGroupsService marketGroupsService;
    @Autowired
    private ServiceFactory serviceFactory;

    public GetMarketGroupReferenceDataSteps() {
    }

    @When("^I call the get market data service$")
    public void iCallTheGetMarketDataService() throws Throwable {
        marketGroupsService = serviceFactory.get(new MarketGroupsRequest(ExampleHeaders.getValid("Digital").build()));
        marketGroupsService.invoke();
    }

    @Then("^the following market data is returned:$")
    public void theFollowingMarketDataIsReturned(List<ExpectedMarketGroup> expectedMarketGroups) throws Throwable {
        marketGroupsService.assertThat().theseMarketGroupsWereReturned(expectedMarketGroups);
    }

    @And("^the market group \"([^\"]*)\" has the localized descriptions:$")
    public void theMarketGroupHasTheLocalizedDescriptions(String marketGroupToCheck,
                                                          List<ExpectedLocalizedDescription> expectedLocalizedDescriptions) throws Throwable {
        marketGroupsService.assertThat().thisMarketGroupHasTheseLocalizedDescriptions(marketGroupToCheck, expectedLocalizedDescriptions);
    }


}