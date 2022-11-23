package com.runners;

import org.junit.runner.RunWith;
//Created by Ali Faizi for demonstration and learning purposes only. 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		// We can specify which feature to run. We can also run all features
		features = "src/test/resources/features/", 
		
		// Shows where we can find the implementation scripts for feature file steps 
		glue = "com.steps.definition", 
		
		// Tag is similar to groups in TestNG. We can run specific scenario with adding tag
		
		tags = "@loginToTekRetailSite",

		// If true, it will not run the steps, It just check if every step in the feature file is defined 
		dryRun = false, 
		
		strict = true,
		
		monochrome = true, 
		plugin = {
				"pretty",  // Prints Gherkin steps in the console
				"html:target/cucumber-default-report", // Create a basic html report in target folder
				"json:target/cucumber.json",
				"rerun:target/failed.txt"
			} 
		)

public class TestRunner {
	
	}
