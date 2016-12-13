package jsample.platform.impl;

import jsample.platform.Platform;
import jsample.platform.PlatformType;

/**
 * Concrete implementation of platform type MAC
 *
 */
public class Mac extends Platform {

	public Mac() {
		super(PlatformType.MAC);
	}

	@Override
	public String getUserHomeDirectory() {
		return "User Home Directory in Mac OS";
	}
}