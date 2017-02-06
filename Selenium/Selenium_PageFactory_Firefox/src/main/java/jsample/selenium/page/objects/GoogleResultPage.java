package jsample.selenium.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import jsample.selenium.Constants;
import jsample.selenium.utility.UiUtil;

public class GoogleResultPage {

	private static final String ID_DIV_RESULT_COUNT = "resultStats";

	private static final String LINK_TEXT_WIKIPEDIA = "Wikipedia";

	private Wait<WebDriver> wait;

	private WebDriver driver;

	@FindBy(id = ID_DIV_RESULT_COUNT)
	private WebElement divResultCount;

	@FindBy(partialLinkText = LINK_TEXT_WIKIPEDIA)
	private WebElement linkTextWikipedia;

	public GoogleResultPage(WebDriver driver) {
		this.driver = driver;
		wait = new FluentWait<>(this.driver).withTimeout(Constants.WAIT_TIME_SEC, TimeUnit.SECONDS);
	}

	public boolean isResultFound() {
		// return !driver.findElements(divResultCount).isEmpty();
		return !(divResultCount == null);
	}

	public String getResultFound() {
		return divResultCount.getText();
	}

	public boolean isWikipediaLinkExist() {
		// return !driver.findElements(LINK_TEXT_WIKIPEDIA_LOCATOR).isEmpty();
		return !(linkTextWikipedia == null);
	}

	public WikipediaPage openWikipediaLinkInNewTab() {

		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		linkTextWikipedia.sendKeys(selectLinkOpeninNewTab);

		// Wait for the new tab to open
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// switch to new tab
		UiUtil.switchToNewTab(driver);
		return PageFactory.initElements(driver, WikipediaPage.class);
	}
}