package jsample.selenium.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleResultPage {

	private static final String ID_DIV_RESULT_COUNT = "resultStats";

	private static final String LINK_TEXT_WIKIPEDIA = "Wikipedia";

	private static final By DIV_RESULT_COUNT_LOCATOR = By.id(ID_DIV_RESULT_COUNT);

	private static final By LINK_TEXT_WIKIPEDIA_LOCATOR = By.partialLinkText(LINK_TEXT_WIKIPEDIA);

	private WebDriver driver;

	public GoogleResultPage(WebDriver driver) {
		this.driver = driver;
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

	public WikipediaPage openWikipediaLink() {
		WebElement wikipediaLink = driver.findElement(LINK_TEXT_WIKIPEDIA_LOCATOR);
		wikipediaLink.sendKeys(Keys.RETURN);

		return new WikipediaPage(driver);
	}
}