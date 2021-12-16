package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "@target/failed.txt",
        // features = "src/test/resources/features/EmployeeSearch.feature",
        glue = "steps",
       // dryRun = true,
        monochrome = true,
        // tags = "@RunJoe or @Fdf"
        //tags = "@runJoe and @10/27"
      //  tags = "@trojan",
        plugin = {"pretty"}


)

public class FailedRunner {
}
