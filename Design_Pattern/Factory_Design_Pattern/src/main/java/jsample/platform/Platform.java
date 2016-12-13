package jsample.platform;

/**
 * 
 * It is the parent class of all platform sub classes and it will also contain
 * the common logic applicable in all platforms.
 *
 */
public abstract class Platform {

	private PlatformType platformType;

	public Platform(PlatformType platformType) {
		this.platformType = platformType;
	}

	public PlatformType getPlatformType() {
		return platformType;
	}

	public void setPlatformType(PlatformType platformType) {
		this.platformType = platformType;
	}

	/**
	 * Each sub class will override this method and provide its own
	 * implementation.
	 * 
	 */
	public abstract String getUserHomeDirectory();
}
