package base;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(strict = true, monochrome = true, features = "src/test/resources/Features", glue = "stepDefinition", plugin = {"pretty"})

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
