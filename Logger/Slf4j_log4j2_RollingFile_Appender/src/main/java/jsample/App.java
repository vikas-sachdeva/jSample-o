package jsample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Name of the log configuration file must be log4j2.xml or log4j2.properties
 * and It should be present in the classpath of the program.
 */
public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				LOGGER.info("It is info log -  {}", i);
			else
				LOGGER.warn("It is warn log - {} ", i);
		}
		LOGGER.error("It is error log");
	}
}