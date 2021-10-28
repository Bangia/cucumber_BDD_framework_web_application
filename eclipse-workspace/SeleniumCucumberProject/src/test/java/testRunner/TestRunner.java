package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		   features="/Users/hashstudioz/eclipse-workspace/SeleniumCucumberProject/Features/",
		   glue ="stepDefinitions",
		   dryRun= false, //true to check that code is fine, else make false as Live run
		   monochrome = true,  //to disable unwanted data
		   tags= "@smoke", //OR operator
		   // tags= "@sanity","@regression", //AND operator
		   plugin= {"pretty","html:test-output"}
		   
		   )

public class TestRunner {

	
}
