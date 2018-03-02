package feature.document;

import com.api.example.TestApplication;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.IgnoredStepException;
import net.serenitybdd.core.exceptions.SerenityManagedException;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.junit.AssumptionViolatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import javax.ws.rs.client.Client;

/**
 * Created by dwebb on 12/5/2016.
 */
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class GlobalHooks {

    @Autowired
    private Client client;

    @Before("@defect")
    public void beforeDefectsScenario() throws Throwable {
        try {
            if (!System.getProperty("runall").equals("true")) {
                throw new SerenityManagedException(new IgnoredStepException("ignored - defect"));
            }
        }
        catch (Exception e)
        {
            throw new SerenityManagedException(new IgnoredStepException("ignored - defect"));
        }
    }

    @Before("@manual")
    public void ignoreManualTests() throws Throwable {
        throw new AssumptionViolatedException("Ignored - manual");
    }

    @After
    public void clearCookiesInClient() throws Throwable {
        ApacheConnectorProvider.getCookieStore(client).clear();
    }

}
