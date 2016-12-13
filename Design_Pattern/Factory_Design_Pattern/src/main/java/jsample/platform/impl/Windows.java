package jsample.platform.impl;

import jsample.platform.Platform;
import jsample.platform.PlatformType;

/**
 * Concrete implementation of platform type WINDOWS
 *
 */
public class Windows extends Platform {

	public Windows() {
		super(PlatformType.WINDOWS);
	}

	@Override
	public String getUserHomeDirectory() {
		return "User Home Directory in Windows OS";
	}
}