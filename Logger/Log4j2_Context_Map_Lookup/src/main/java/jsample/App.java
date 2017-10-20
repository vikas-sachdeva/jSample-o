package jsample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

/**
 * Name of the log configuration file must be log4j2.xml or log4j2.properties
 * and It should be present in the classpath of the program.
 */
public class App {

	public static void main(String[] args) {
		// Set log file name through context map (ThreadContext)
		ThreadContext.put("logFileName", "app.log");
		/**
		 * Logger should be initialized after setting file name through
		 */
		final Logger LOGGER = LogManager.getLogger(App.class);
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				LOGGER.info("It is info log -  {}", i);
			else
				LOGGER.warn("It is warn log - {} ", i);
		}
		LOGGER.error("It is error log");

	}
}