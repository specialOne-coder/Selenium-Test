import driver.WebDriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/cucumber-reports/Cucumber.json"},
        features = {"src/test/res/AsignUp.feature","src/test/res/BsignIn.feature","src/test/res/Csearch.feature","src/test/res/Flogout.feature"}
)
public class CucumberTestRunner {
}
