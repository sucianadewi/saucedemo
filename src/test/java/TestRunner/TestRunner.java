package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features/login.feature", "src/test/resources/Features/product.feature"},
        glue = {"StepDef"},
        plugin = {"pretty", "json:target/cucumber.json"}
//        plugin = {"pretty", "html:target/HTML_report.html"}
)
public class TestRunner {
}
