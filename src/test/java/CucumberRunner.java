import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        glue = {"baseSettings","pageSteps"},
        features = {"src/test/resources/"},
		strict = true,
		tags = {"@checkDeposit"}
)
public class CucumberRunner {}
