package api.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/User.feature",
 glue= {"api.stepdefinitions"},
 plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			"pretty","html:target/CucumberReports.html","json:target/cucumber.json",
			"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
		)
public class TestRunner {

}
