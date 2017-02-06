package jsample.selenium.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {

	private static final String NAME_INPUT_TEXT_SEARCH = "q";

	private static final By INPUT_TEXT_SEARCH_LOCATOR = By.name(NAME_INPUT_TEXT_SEARCH);

	private WebDriver driver;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public GoogleSearchPage typeSearchText(String text) {
		driver.findElement(INPUT_TEXT_SEARCH_LOCATOR).sendKeys(text);

		return this;
	}

	public GoogleResultPage search() {
		driver.findElement(INPUT_TEXT_SEARCH_LOCATOR).sendKeys(Keys.RETURN);
		return new GoogleResultPage(driver);
	}

}
