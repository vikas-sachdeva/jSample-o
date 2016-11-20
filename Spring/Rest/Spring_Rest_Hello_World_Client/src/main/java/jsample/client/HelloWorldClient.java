package jsample.client;

import org.springframework.web.client.RestTemplate;

public class HelloWorldClient {

	private static final String SERVER_URL = "http://localhost:8080/Jersey_Hello_World/rest";

	private static final String API_PATH = "helloworld";

	public static void callRestApi(String param) {

		String url = SERVER_URL + '/' + API_PATH + '/' + param;

		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(url, String.class);

		System.out.println("Response Received -\n" + response);

	}
}
