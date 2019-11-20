package com.rocketmiles.test.core;

/**
 * @author dasha_daniyalian
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rocketmiles.test.pages.LoginPage;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Setup {

	public static WebDriver driver;
	private static String OS = System.getProperty("os.name").toLowerCase();

	@Before
	public void setWebDriver() throws Exception {

		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = "chrome";
		}
		switch (browser) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("start-maximized");
			if (isWindows()) {
				System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/win/chromedriver.exe");
			} else {
				System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/mac/chromedriver");
			}
			driver = new ChromeDriver(chromeOptions);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String url = "https://www.rocketmiles.com/";
		Setup.launchBrowser(url);
		new LoginPage(driver).acceptCookies();
	}

	@After
	public void quitDriver(Scenario scenario) {

		if (driver != null) {
			if (scenario.isFailed()) {
				saveScreenshotsForScenario(scenario);
			}
			driver.quit();
		}

	}

	private void saveScreenshotsForScenario(final Scenario scenario) {

		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
	}

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public static void launchBrowser(String url) {
		driver.get(url);
		;
	}
}
