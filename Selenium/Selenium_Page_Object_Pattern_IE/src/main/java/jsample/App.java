package jsample;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import jsample.selenium.Constants;
import jsample.selenium.WebDriverFactory;
import jsample.selenium.page.objects.GoogleResultPage;
import jsample.selenium.page.objects.GoogleSearchPage;
import jsample.selenium.page.objects.WikipediaPage;
import jsample.selenium.utility.ScreenCaptureUtil;

public class App {

	public static void main(String[] args) throws HeadlessException, IOException, AWTException, InterruptedException {
		WebDriver driver = WebDriverFactory.getWebDriver();

		driver.get(Constants.BASE_URL);

		GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
		GoogleResultPage googleResultPage = googleSearchPage.typeSearchText("selenium").search();

		if (!googleResultPage.isResultFound()) {
			System.out.println("No result is found");
			ScreenCaptureUtil.captureCompleteScreen("./screenshots/google.png");
			driver.quit();
			return;
		}

		System.out.println("Results Found - " + googleResultPage.getResultFound());

		ScreenCaptureUtil.captureCompleteScreen("./screenshots/google.png");

		if (!googleResultPage.isWikipediaLinkExist()) {
			System.out.println("There is no wikipedia page found in the search");
			driver.quit();
			return;
		}

		WikipediaPage wikipediaPage = googleResultPage.openWikipediaLink();

		wikipediaPage.loadWikipediaLogo();

		ScreenCaptureUtil.captureCompletePage(driver, "./screenshots/wiki.png");
		/**
		 * Quitting driver will result in error in Firefox browser with current
		 * version of selenium, it is a known bug.
		 */
		driver.quit();
	}
}