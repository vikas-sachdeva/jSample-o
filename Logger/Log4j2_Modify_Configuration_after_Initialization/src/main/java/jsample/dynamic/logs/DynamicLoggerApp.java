package jsample.dynamic.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DynamicLoggerApp {

	private static final Logger LOGGER = LogManager.getLogger(DynamicLoggerApp.class);

	public static void execute() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				LOGGER.info("It is info log -  {}", i);
			else
				LOGGER.warn("It is warn log - {} ", i);
		}
		LOGGER.error("It is error log");
	}

}