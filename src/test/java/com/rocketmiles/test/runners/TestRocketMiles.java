package com.rocketmiles.test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/rocketmiles.feature", 
		plugin = { "pretty",
		"html:target/cucumber-report/" }, 
		glue = { "com.rocketmiles.test" })

public class TestRocketMiles extends AbstractTestNGCucumberTests {

}
