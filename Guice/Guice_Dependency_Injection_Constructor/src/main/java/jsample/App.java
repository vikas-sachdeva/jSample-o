package jsample;

import com.google.inject.Guice;
import com.google.inject.Injector;

import jsample.guice.AppGuiceModule;
import jsample.inject.AppInjector;

public class App {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new AppGuiceModule());
		AppInjector appInjector = injector.getInstance(AppInjector.class);

		String output = appInjector.doAction("Hello");
		System.out.println("Output of operation - " + output);
	}
}
