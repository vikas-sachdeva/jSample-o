package jsample.selenium.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class UiUtil {

	public static void switchToNewTab(WebDriver webDriver) {
		Set<String> windowSet = webDriver.getWindowHandles();
		List<String> windowList = new ArrayList<>(windowSet);

		String newTab = windowList.get(windowList.size() - 1);
		webDriver.switchTo().window(newTab); // switch to new tab
	}

	public static void closeCurrentTabAndSwitchToNewTab(WebDriver webDriver) {
		Set<String> windowSet = webDriver.getWindowHandles();
		List<String> windowList = new ArrayList<>(windowSet);
		String newTab = windowList.get(windowList.size() - 1);
		webDriver.close(); // close the original tab
		webDriver.switchTo().window(newTab); // switch to new tab
	}
}
