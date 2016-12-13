package jsample.platform.impl;

import jsample.platform.Platform;
import jsample.platform.PlatformType;

/**
 * Concrete implementation of platform type LINUX
 *
 */
public class Linux extends Platform {

	public Linux() {
		super(PlatformType.LINUX);
	}

	@Override
	public String getUserHomeDirectory() {
		return "User Home Directory in Linux OS";
	}

}