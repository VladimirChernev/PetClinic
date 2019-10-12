package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        tags = {"@P1, @P2, @P3"},
        glue = {"core", "steps"},
        plugin = {"pretty", "json:target/cucumber/Cucumber.json", "html:target/cucumber"},
        monochrome = true
)

public class RunTest {

}