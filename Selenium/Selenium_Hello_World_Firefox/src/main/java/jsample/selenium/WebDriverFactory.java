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
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		return webDriver;
	}
}