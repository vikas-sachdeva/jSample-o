package jsample.selenium.page.objects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {

	private static final String ID_DIV_RESULT_COUNT = "resultStats";

	private static final String LINK_TEXT_WIKIPEDIA = "Wikipedia";

	private WebDriver driver;

	@FindBy(id = ID_DIV_RESULT_COUNT)
	private List<WebElement> divResultCount;

	@FindBy(partialLinkText = LINK_TEXT_WIKIPEDIA)
	private List<WebElement> linkTextWikipedia;

	public GoogleResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isResultFound() {
		return !divResultCount.isEmpty();
	}

	public String getResultFound() {
		return divResultCount.get(0).getText();
	}

	public boolean isWikipediaLinkExist() {
		return !linkTextWikipedia.isEmpty();
	}

	public WikipediaPage openWikipediaLinkInNewTab() {

		linkTextWikipedia.get(0).sendKeys(Keys.RETURN);

		return PageFactory.initElements(driver, WikipediaPage.class);
	}
}