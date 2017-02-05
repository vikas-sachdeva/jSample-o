package jsample.selenium.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import jsample.selenium.Constants;

public class WikipediaPage {

	private static final String CLASS_ANCHOR_WIKIPEDIA = "mw-wiki-logo";

	private static final By ANCHOR_WIKIPEDIA_LOCATOR = By.className(CLASS_ANCHOR_WIKIPEDIA);

	private WebDriver driver;

	private Wait<WebDriver> wait;

	public WikipediaPage(WebDriver driver) {
		this.driver = driver;
		wait = new FluentWait<>(this.driver).withTimeout(Constants.WAIT_TIME_SEC, TimeUnit.SECONDS);
	}

	public WikipediaPage loadWikipediaLogo() {
		// wait for wikipedia logo element to display
		wait.until(ExpectedConditions.visibilityOfElementLocated(ANCHOR_WIKIPEDIA_LOCATOR));
		return this;
	}
}
