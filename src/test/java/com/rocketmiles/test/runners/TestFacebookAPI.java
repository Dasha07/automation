package com.rocketmiles.test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "src/test/resources/features/facebook_api.feature", 
		tags = {"@Login"}, 
		plugin = { "pretty","html:target/cucumber-report/" }, 
		glue = { "com.rocketmiles.test" })

public class TestFacebookAPI extends AbstractTestNGCucumberTests{
	
}
