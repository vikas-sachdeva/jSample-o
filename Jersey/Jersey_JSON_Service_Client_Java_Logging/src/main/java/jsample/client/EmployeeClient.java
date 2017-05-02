package jsample.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.logging.LoggingFeature.Verbosity;

import jsample.model.Employee;

public class EmployeeClient {

	private static final Logger LOGGER = Logger.getLogger(EmployeeClient.class.getName());

	private static final String SERVER_URL = "http://localhost:8080/Jersey_JSON_Service/rest";

	private static final String API_PATH = "employee";

	public static void getEmployeeWithId(Integer id) {
		System.out.println("\n-------------------------------------------------");
		System.out.println("\nRequesting employee information...");

		Client client = getClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path(String.valueOf(id));

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		if (response.getStatusInfo().equals(Status.OK)) {
			Employee employee = response.readEntity(Employee.class);
			System.out.println("Response Received-\n" + employee);
		} else {
			String responseText = response.readEntity(String.class);
			System.out.println("Response Received-\n" + responseText);
		}

	}

	public static void deleteEmployeeWithId(Integer id) {
		System.out.println("\n-------------------------------------------------");
		System.out.println("\nRequesting employee deletion...");
		Client client = getClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path(String.valueOf(id));

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();

		String responseText = response.readEntity(String.class);
		System.out.println("Response Received-\n" + responseText);

	}

	public static void createEmployee(Employee emp) {
		System.out.println("\n-------------------------------------------------");
		System.out.println("\nRequesting employee addition...");
		Client client = getClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH);

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(emp, MediaType.APPLICATION_JSON));

		if (response.getStatusInfo().equals(Status.OK)) {
			Employee employee = response.readEntity(Employee.class);
			System.out.println("Response Received-\n" + employee);
		} else {
			String responseText = response.readEntity(String.class);
			System.out.println("Response Received-\n" + responseText);
		}
	}

	public static void updateEmployee(Integer id, Employee emp) {
		System.out.println("\n-------------------------------------------------");
		System.out.println("\nRequesting employee updation...");
		Client client = getClient();
		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path(String.valueOf(id));

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(emp, MediaType.APPLICATION_JSON));

		if (response.getStatusInfo().equals(Status.OK)) {
			Employee employee = response.readEntity(Employee.class);
			System.out.println("Response Received-\n" + employee);
		} else {
			String responseText = response.readEntity(String.class);
			System.out.println("Response Received-\n" + responseText);
		}
	}

	private static Client getClient() {

		Feature feature = new LoggingFeature(LOGGER, Level.FINE, Verbosity.PAYLOAD_ANY,
				LoggingFeature.DEFAULT_MAX_ENTITY_SIZE);

		Client client = ClientBuilder.newBuilder().register(feature).build();
		return client;
	}
}