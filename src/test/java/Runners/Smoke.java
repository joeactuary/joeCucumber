package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

       features = "src/test/resources/features",
       // features = "src/test/resources/features/EmployeeSearch.feature",
        //glue = "steps",
        glue = "APISteps",
      //dryRun = true,
      //  monochrome = true,
       // tags = "@RunJoe or @Fdf"
        //tags = "@runJoe and @10/27"
       // tags = "@tryThis",
       // tags = "@dbQuery",
        tags = "@apijoe",
        plugin = {"pretty", "html:target/cucumber.html","json:target/cucumber.json", "rerun:target/failed.txt"}


)

public class Smoke {
}
