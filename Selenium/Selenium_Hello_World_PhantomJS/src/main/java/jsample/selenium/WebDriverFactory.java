package jsample.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {

	public static WebDriver getWebDriver() {

		System.setProperty("phantomjs.binary.path", "./phantomjs_driver/phantomjs.exe");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability("takesScreenshot", true);

		WebDriver webDriver = new PhantomJSDriver();
		webDriver.manage().window().maximize();

		// Wait for finding elements
		webDriver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_SEC, TimeUnit.SECONDS);

		webDriver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return webDriver;
	}
}