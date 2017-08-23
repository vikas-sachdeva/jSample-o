package jsample;

import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * While using log4j2 external configuration file, below message will get
 * printed on console -
 * 
 * ERROR StatusLogger No log4j2 configuration file found. Using default
 * configuration: logging only errors to the console.
 * 
 * This message will get printed initially because no log4j2 configuration file
 * is present in classpath of the application.
 * 
 */
public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		initialiseLogger();
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				LOGGER.info("It is info log -  {}", i);
			else
				LOGGER.warn("It is warn log - {} ", i);
		}
		LOGGER.error("It is error log");
	}

	private static void initialiseLogger() {
		Configurator.initialize(null, "./config/log_config.xml");
	}
}