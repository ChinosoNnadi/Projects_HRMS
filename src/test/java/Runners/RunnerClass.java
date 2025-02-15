package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "src/test/resources/features/",
        //glue is where we find implementation of gherkin steps
        //we provide the path of package where we defined all the step definition
        glue = "Steps",
        dryRun = false,
        //tags will identify the scenarios in a group and will execute all the scenarios having these tags
        tags = "@Nnadi",
        //for generating the report
        //pretty is responsible for printing the step and step definition in the console
        //in your framework, all reports should be generated under target folder
        //we will generate html report in target folder
        plugin = {"pretty", "html:target/cucumber.html",
        "json:target/cucumber.json", "rerun:target/failed.txt"}
        //rerun plugin will create failed.txt under target for all failed tc
)


public class RunnerClass { }
