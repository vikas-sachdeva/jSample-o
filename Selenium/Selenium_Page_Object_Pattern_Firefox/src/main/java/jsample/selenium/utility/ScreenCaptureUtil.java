package jsample.selenium.utility;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import com.google.common.io.Files;

public class ScreenCaptureUtil {

	public static void captureCompletePage(WebDriver webDriver, String filePath) throws IOException {

		WebDriver tmpDriver = null;
		if (webDriver instanceof TakesScreenshot) {
			tmpDriver = webDriver;
		} else {
			tmpDriver = new Augmenter().augment(webDriver);
		}
		File source = ((TakesScreenshot) tmpDriver).getScreenshotAs(OutputType.FILE);
		Files.copy(source, new File(filePath));
	}

	public static void captureCompleteScreen(String filePath) throws IOException, HeadlessException, AWTException {
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File(filePath));
	}
}