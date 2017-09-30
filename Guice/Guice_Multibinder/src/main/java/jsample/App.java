package jsample;

import com.google.inject.Guice;
import com.google.inject.Injector;

import jsample.inject.AppInjector;
import jsample.module1.guice.GuiceModule1;
import jsample.module2.guice.GuiceModule2;
import jsample.module3.guice.GuiceModule3;

public class App {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new GuiceModule1(), new GuiceModule3(), new GuiceModule2());
		AppInjector appInjector = injector.getInstance(AppInjector.class);

		appInjector.doAction("Hello");
	}
}
