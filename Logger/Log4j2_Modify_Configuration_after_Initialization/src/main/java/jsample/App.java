package jsample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jsample.dynamic.logs.DynamicLoggerApp;
import jsample.log4j2.DynamicLoggerManager;

public class App {

	private static final Logger LOGGER = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				LOGGER.info("It is info log -  {}", i);
			else
				LOGGER.warn("It is warn log - {} ", i);
		}
		LOGGER.error("It is error log");
		DynamicLoggerManager.configureLogger("./dynamic_logs/");
		DynamicLoggerApp.execute();

	}
}