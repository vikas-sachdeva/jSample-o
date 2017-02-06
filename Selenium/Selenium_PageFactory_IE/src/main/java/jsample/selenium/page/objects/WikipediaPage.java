package jsample.selenium.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import jsample.selenium.Constants;

public class WikipediaPage {

	private static final String CLASS_ANCHOR_WIKIPEDIA = "mw-wiki-logo";

	private WebDriver driver;

	private Wait<WebDriver> wait;

	@FindBy(className = CLASS_ANCHOR_WIKIPEDIA)
	private WebElement anchorWikipedia;

	public WikipediaPage(WebDriver driver) {
		this.driver = driver;
		wait = new FluentWait<>(this.driver).withTimeout(Constants.WAIT_TIME_SEC, TimeUnit.SECONDS);
	}

	public WikipediaPage loadWikipediaLogo() {
		// wait for wikipedia logo element to display
		wait.until(ExpectedConditions.visibilityOf(anchorWikipedia));
		return this;
	}
}
