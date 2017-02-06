package jsample.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

	public static WebDriver getWebDriver() {

		System.setProperty("webdriver.ie.driver", "./ie_driver/IEDriverServer.exe");

		WebDriver webDriver = new InternetExplorerDriver();
		webDriver.manage().window().maximize();

		// Wait for finding elements
		webDriver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_SEC, TimeUnit.SECONDS);

		webDriver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return webDriver;
	}
}