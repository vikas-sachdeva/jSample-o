package jsample.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import jsample.model.Data;

public class BeanParamClient {

	private static final String SERVER_URL = "http://localhost:8080/Jersey_BeanParam_Annotation_Service/rest";

	private static final String API_PATH = "beanParam";

	public static void callBeanParamApi(String name) {
		System.out.println("\nCalling REST API...");
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path(name);
		webTarget = webTarget.queryParam("role", "Teacher");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

		invocationBuilder.header("Content-Type", "application/xml");

		Response response = invocationBuilder.get();

		if (response.getStatusInfo().equals(Status.OK)) {
			Data data = response.readEntity(Data.class);
			System.out.println("Response Received-\n" + data);
		} else {
			String responseText = response.readEntity(String.class);
			System.out.println("Response Received-\n" + responseText);
		}

	}
}
