package jsample;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import jsample.selenium.Constants;
import jsample.selenium.Elements;
import jsample.selenium.WebDriverFactory;
import jsample.selenium.utility.ScreenCaptureUtil;

public class App {

	public static void main(String[] args) throws HeadlessException, IOException, AWTException, InterruptedException {
		WebDriver driver = WebDriverFactory.getWebDriver();
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Constants.WAIT_TIME_SEC, TimeUnit.SECONDS);

		driver.get(Constants.BASE_URL);

		WebElement textInput = driver.findElement(Elements.GoogleSearchPage.INPUT_TEXT_SEARCH_LOCATOR);

		textInput.sendKeys("selenium");

		// Press Enter key
		textInput.sendKeys(Keys.RETURN);

		if (driver.findElements(Elements.GoogleResultPage.DIV_RESULT_COUNT_LOCATOR).isEmpty()) {
			System.out.println("No result is found");
			ScreenCaptureUtil.captureCompleteScreen("./screenshots/google.png");
			driver.quit();
			return;
		}

		WebElement resultsDiv = driver.findElement(Elements.GoogleResultPage.DIV_RESULT_COUNT_LOCATOR);

		System.out.println("Results Found - " + resultsDiv.getText());

		ScreenCaptureUtil.captureCompleteScreen("./screenshots/google.png");

		// Find Wikipedia Link
		List<WebElement> wikiPediaAnchors = driver.findElements(Elements.GoogleResultPage.WIKIPEDIA_LOCATOR);

		if (wikiPediaAnchors.size() == 0) {
			System.out.println("There is no wikipedia page found in the search");
			driver.quit();
			return;
		}
		WebElement wikiPediaAnchor = wikiPediaAnchors.get(0);

		// Open link
		wikiPediaAnchor.sendKeys(Keys.RETURN);

		// wait for wikipedia logo element to display
		wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.WikipediaPage.ANCHOR_WIKIPEDIA_LOCATOR));

		ScreenCaptureUtil.captureCompletePage(driver, "./screenshots/wiki.png");
		/**
		 * Quitting driver will result in error in Firefox browser with current
		 * version of selenium, it is a known bug.
		 */
		driver.quit();
	}
}