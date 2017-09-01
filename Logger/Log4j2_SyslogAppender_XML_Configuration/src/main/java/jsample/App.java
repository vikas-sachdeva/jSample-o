package jsample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Name of the log configuration file must be log4j2.xml or log4j2.properties
 * and It should be present in the classpath of the program.
 * 
 * 
 * For integration with rsyslog, make following modifications in
 * /etc/rsyslog.conf file -
 * 
 * 
 * 1) Uncomment below 2 lines -
 * 
 * <pre>
 * $ModLoad imudp 
 * $UDPServerRun 514
 * </pre>
 * 
 * 
 * 2) Add below line -
 * 
 * <pre>
 * local3.*                                                /tmp/app.log
 * </pre>
 * 
 * After these modifications, restart rsyslog service using below command -
 * 
 * <pre>
 * systemctl restart rsyslog
 * </pre>
 * 
 * This program with above configuration is tested on Centos 7.
 * 
 * 
 * ※ If generated log file is deleted manually, rsyslog will not generate
 * further logs until rsyslog service is restarted.
 * 
 */
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
	}
}