package jsample;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.StringMapMessage;

/**
 * Name of the log configuration file must be log4j2.xml or log4j2.properties
 * and It should be present in the classpath of the program.
 */
public class App {

	private static final Logger LOGGER = LogManager.getLogger(App.class);

	public static void main(String[] args) throws UnknownHostException {

		Map<String, String> map = new HashMap<>();
		map.put("ip", InetAddress.getLocalHost().getHostAddress().toString());
		map.put("text", "this in log message");
		/**
		 * A StringMapMessage typed to String-only values. This is like the
		 * MapMessage class before log4j2 2.9 version
		 */
		LOGGER.info(new StringMapMessage(map));
	}
}