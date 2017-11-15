package jsample;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jsample.conf.Configuration;

public class App {

	private static final String CONF_FILE_PATH = "./json/config.json";

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		Configuration configuration = deserialize();
		serialize(configuration);
	}

	private static void serialize(Configuration configuration)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(System.out, configuration);
	}

	private static Configuration deserialize() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		Configuration configuration = objectMapper.readValue(new File(CONF_FILE_PATH), Configuration.class);
		System.out.println("Configuration File is -");
		System.out.println(configuration);
		return configuration;
	}
}