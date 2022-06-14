package page;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features",
        glue = {"steps"},
        plugin = {"pretty","html:out"})


public class TestSupportTest {
}
