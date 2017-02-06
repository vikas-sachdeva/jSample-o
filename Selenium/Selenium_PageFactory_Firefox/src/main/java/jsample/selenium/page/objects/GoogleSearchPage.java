package jsample.selenium.page.objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

	private static final String NAME_INPUT_TEXT_SEARCH = "q";

	private WebDriver driver;

	@FindBy(name = NAME_INPUT_TEXT_SEARCH)
	private WebElement inputTextSearch;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public GoogleSearchPage typeSearchText(String text) {
		inputTextSearch.sendKeys(text);

		return this;
	}

	public GoogleResultPage search() {
		inputTextSearch.sendKeys(Keys.RETURN);
		return PageFactory.initElements(driver, GoogleResultPage.class);
	}

}
