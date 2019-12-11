package com.tour.mercury.runner;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tour.logger.CustomLogger;
import com.tour.report.listener.Reporter;
import com.tour.test.utils.ConfigurationUtil;
import com.tour.ui.utils.browser.Browsers;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

/*import net.serenitybdd.cucumber.CucumberWithSerenity;*/
/*
 * Helper class to provide Cucumber JVM configuration:
 * -how to run feature with TestNG
 */
@CucumberOptions(plugin = { "pretty", "com.tour.report.listener.ExtentCucumberFormatter:ExtendedReport/myreport.html",
		"html:target/cucumber-html-report", "json:target/cucumber-report.json",
		"rerun:rerun.txt" }, features = "src/test/resources/features",
		/* features = {"@rerun/target/rerun.txt"}, */
		glue = "com.tour.step.definitions") 
		//tags = { "@SMOKE" })
public class CucumberRunner {

	private TestNGCucumberRunner testNGCucumberRunner;
	Browsers browser = new Browsers();
	private static final CustomLogger LOGGER = new CustomLogger(CucumberRunner.class);

	@BeforeClass()
	@Parameters({ "CONFIG", "SL4J", "BROWSER" })
	public void setup(String configProperty, String logProperties, String browserType) throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		CustomLogger.initializeLogger(logProperties);
		ConfigurationUtil.setFileName(configProperty);
		browser.setDriver(browserType);
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Features", dataProvider = "features")
	@Parameters({ "CONFIG", "BROWSER" })
	public void run_cukes(CucumberFeatureWrapper cucumberFeature) throws InterruptedException {
		LOGGER.info("Start Test Suite ---> " + cucumberFeature.getCucumberFeature().getGherkinFeature().getName());
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		LOGGER.info("End Test Suite ---> " + cucumberFeature.getCucumberFeature().getGherkinFeature().getName());
	}

	@DataProvider(name = "features")
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		Reporter.loadXMLConfig(new File("report-config/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "WINDOWS 10");
		Reporter.setTestRunnerOutput("Sample test runner output message");
		testNGCucumberRunner.finish();
		browser.closeDriver();
	}

}
