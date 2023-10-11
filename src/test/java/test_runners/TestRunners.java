package test_runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/login.feature",
        glue = "stepdefinitions",
        dryRun = false,
        publish = true,
        plugin = {"pretty",
                 "rerun:failed_scenario.txt",
                "html:reports/cucumber-report.html"
          },


        snippets = CucumberOptions.SnippetType.CAMELCASE
       // tags = "@login and not @negative"
       // tags = "@login"
//        tags = "not @negative"
//        tags = "@negative and @ganesh"
//        tags = "@positive or @negative"



)
public class TestRunners {
}
