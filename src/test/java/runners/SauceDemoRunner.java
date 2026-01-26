package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/InicioDeSesion.feature",
        glue = {"stepdefinitions","hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber-report.json"},
        tags = "@regression and @e2e"
)
public class SauceDemoRunner {
}
