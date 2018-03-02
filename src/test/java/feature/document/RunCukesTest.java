package feature.document;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(features = {"src/test/resources/feature/document"}, tags = "@me")
@CucumberOptions(features = {"src/test/resources/feature/document"})
public class RunCukesTest {
    @Rule
    public SpringIntegrationMethodRule springIntegration = new SpringIntegrationMethodRule();
}

