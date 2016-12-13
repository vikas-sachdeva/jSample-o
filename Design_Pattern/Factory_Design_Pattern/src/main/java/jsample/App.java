package jsample;

import jsample.factory.PlatformFactory;
import jsample.platform.Platform;
import jsample.platform.PlatformType;

public class App {
	public static void main(String[] args) {
		Platform linux = PlatformFactory.getPlatform(PlatformType.LINUX);
		System.out.println(linux.getUserHomeDirectory());

		Platform windows = PlatformFactory.getPlatform(PlatformType.WINDOWS);
		System.out.println(windows.getUserHomeDirectory());

		Platform mac = PlatformFactory.getPlatform(PlatformType.MAC);
		System.out.println(mac.getUserHomeDirectory());
	}
}
