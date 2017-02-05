package jsample.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	public static WebDriver getWebDriver() {

		System.setProperty("webdriver.gecko.driver", "./firefox_driver/geckodriver.exe");

		WebDriver webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();

		// Wait for finding elements
		webDriver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_SEC, TimeUnit.SECONDS);

		webDriver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return webDriver;
	}
}