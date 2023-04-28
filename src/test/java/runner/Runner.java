package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/cucumber-reports.html"},
        features = "src/test/resources/Api",
        glue = "stepDefinitions",
        tags = "@PutAccountRegistration", // iki tag'ı aynı anda çalıştırmak isterseniz "@gp1 or @gp2"
        dryRun = false

)



        public class Runner {
}
