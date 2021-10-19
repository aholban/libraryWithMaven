package cucumber.runners;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/", glue = {"cucumber.stepdefinitions"})
public class CucumberRunner {
}
