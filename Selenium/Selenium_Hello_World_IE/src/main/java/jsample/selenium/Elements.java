package jsample.selenium;

import org.openqa.selenium.By;

public class Elements {

	public static class GoogleSearchPage {

		private static final String NAME_INPUT_TEXT_SEARCH = "q";
		
		public static final By INPUT_TEXT_SEARCH_LOCATOR = By.name(NAME_INPUT_TEXT_SEARCH);

	}

	public static class GoogleResultPage {

		private static final String ID_DIV_RESULT_COUNT = "resultStats";

		private static final String LINK_TEXT_WIKIPEDIA = "Wikipedia";
		
		public static final By DIV_RESULT_COUNT_LOCATOR = By.id(ID_DIV_RESULT_COUNT);
		
		public static final By WIKIPEDIA_LOCATOR = By.partialLinkText(LINK_TEXT_WIKIPEDIA);

	}

	public static class WikipediaPage {

		private static final String CLASS_ANCHOR_WIKIPEDIA = "mw-wiki-logo";
		
		public static final By ANCHOR_WIKIPEDIA_LOCATOR = By.className(CLASS_ANCHOR_WIKIPEDIA);
	}
}