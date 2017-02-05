package jsample;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import jsample.selenium.Elements;
import jsample.selenium.WebDriverFactory;
import jsample.selenium.utility.ScreenCaptureUtil;
import jsample.selenium.utility.UiUtil;

public class App {

	private static final String BASE_URL = "http://www.google.co.in/";

	private static final int WAIT_TIME_SEC = 5;

	public static void main(String[] args) throws HeadlessException, IOException, AWTException, InterruptedException {
		WebDriver driver = WebDriverFactory.getWebDriver();
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(WAIT_TIME_SEC, TimeUnit.SECONDS);

		driver.get(BASE_URL);

		WebElement textInput = driver.findElement(By.id(Elements.GoogleSearchPage.ID_INPUT_TEXT_SEARCH));

		textInput.sendKeys("selenium");
		// Press Enter key
		textInput.sendKeys(Keys.RETURN);

		if (driver.findElements(By.id(Elements.GoogleResultPage.ID_DIV_RESULT_COUNT)).isEmpty()) {
			System.out.println("No result is found");
			ScreenCaptureUtil.captureCompleteScreen("./screenshots/google.png");
			driver.quit();
			return;
		}

		WebElement resultsDiv = driver.findElement(By.id(Elements.GoogleResultPage.ID_DIV_RESULT_COUNT));

		System.out.println("Results Found - " + resultsDiv.getText());

		ScreenCaptureUtil.captureCompleteScreen("./screenshots/google.png");
		// Find Wikipedia Link
		List<WebElement> wikiPediaAnchors = driver
				.findElements(By.partialLinkText(Elements.GoogleResultPage.LINK_TEXT_WIKIPEDIA));

		if (wikiPediaAnchors.size() == 0) {
			System.out.println("There is no wikipedia page found in the search");
			driver.quit();
			return;
		}
		WebElement wikiPediaAnchor = wikiPediaAnchors.get(0);

		// Open link in a new tab
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		wikiPediaAnchor.sendKeys(selectLinkOpeninNewTab);

		// Wait for the new tab to open

		wait.until(new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver webDriver) {

				return webDriver.getWindowHandles().size() > 1;

			}
		});
		// switch to new tab
		UiUtil.switchToNewTab(driver);

		// wait for wikipedia logo element to display
		wait.until(new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver webDriver) {
				return webDriver.findElement(By.className(Elements.WikipediaPage.CLASS_ANCHOR_WIKIPEDIA)).isDisplayed();
			}
		});
		ScreenCaptureUtil.captureCompletePage(driver, "./screenshots/wiki.png");
		/**
		 * Quitting driver will result in error in Firefox browser with current
		 * version of selenium, it is a known bug.
		 */
		driver.quit();
	}
}