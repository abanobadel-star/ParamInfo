package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = {"StepDef"}, tags = "@Run"
        , plugin = {"pretty","html:target/report/cucumber-html-report.html"})
public class runner {

}