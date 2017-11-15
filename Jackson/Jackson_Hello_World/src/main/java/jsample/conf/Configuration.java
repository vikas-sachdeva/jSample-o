package jsample.conf;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "configuration")
public class Configuration {

	private DatabaseConfiguration databaseConfiguration;

	private String logConfigurationFilePath;

	private Configuration() {

	}

	public DatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}

	public String getLogConfigurationFilePath() {
		return logConfigurationFilePath;
	}

	@Override
	public String toString() {
		return "Configuration [databaseConfiguration=" + databaseConfiguration + ", logConfigurationFilePath="
				+ logConfigurationFilePath + "]";
	}

}
