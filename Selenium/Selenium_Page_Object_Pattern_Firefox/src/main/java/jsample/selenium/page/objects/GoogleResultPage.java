package jsample.selenium.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import jsample.selenium.Constants;
import jsample.selenium.utility.UiUtil;

public class GoogleResultPage {

	private static final String ID_DIV_RESULT_COUNT = "resultStats";

	private static final String LINK_TEXT_WIKIPEDIA = "Wikipedia";

	private static final By DIV_RESULT_COUNT_LOCATOR = By.id(ID_DIV_RESULT_COUNT);

	private static final By LINK_TEXT_WIKIPEDIA_LOCATOR = By.partialLinkText(LINK_TEXT_WIKIPEDIA);

	private Wait<WebDriver> wait;

	private WebDriver driver;

	public GoogleResultPage(WebDriver driver) {
		this.driver = driver;
		wait = new FluentWait<>(this.driver).withTimeout(Constants.WAIT_TIME_SEC, TimeUnit.SECONDS);
	}

	public boolean isResultFound() {
		return !driver.findElements(DIV_RESULT_COUNT_LOCATOR).isEmpty();
	}

	public String getResultFound() {
		return driver.findElement(DIV_RESULT_COUNT_LOCATOR).getText();
	}

	public boolean isWikipediaLinkExist() {
		return !driver.findElements(LINK_TEXT_WIKIPEDIA_LOCATOR).isEmpty();
	}

	public WikipediaPage openWikipediaLinkInNewTab() {
		WebElement wikipediaLink = driver.findElement(LINK_TEXT_WIKIPEDIA_LOCATOR);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		wikipediaLink.sendKeys(selectLinkOpeninNewTab);

		// Wait for the new tab to open
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// switch to new tab
		UiUtil.switchToNewTab(driver);
		return new WikipediaPage(driver);
	}
}