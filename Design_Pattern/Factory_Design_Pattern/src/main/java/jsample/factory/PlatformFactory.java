package jsample.factory;

import jsample.platform.Platform;
import jsample.platform.PlatformType;
import jsample.platform.impl.Linux;
import jsample.platform.impl.Mac;
import jsample.platform.impl.Windows;

/**
 * 
 * This is the class implemented using Factory Pattern. It instantiates a
 * platform instance based on its type.
 *
 */
public class PlatformFactory {

	public static Platform getPlatform(PlatformType platformType) {
		switch (platformType) {
		case LINUX:
			return new Linux();
		case MAC:
			return new Mac();

		case WINDOWS:
			return new Windows();
		default:
			return null;
		}
	}

}