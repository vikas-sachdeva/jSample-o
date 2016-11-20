package jsample.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import jsample.model.Employee;
import jsample.model.Employees;

public class EmployeeClient {

	private static final String SERVER_URL = "http://localhost:8080/Jersey_JSON_Service_Array/rest";

	private static final String API_PATH = "employees";

	public static void getEmployeesList() {
		System.out.println("\nRequesting employees list...");
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path("list");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		if (response.getStatusInfo().equals(Status.OK)) {
			Employee[] employeeArray = response.readEntity(Employee[].class);
			System.out.println("Response Received-");
			for (Employee emp : employeeArray) {
				System.out.println(emp);
			}
		} else {
			String responseText = response.readEntity(String.class);
			System.out.println("Response Received-\n" + responseText);
		}

	}

	public static void getEmployeesObject() {
		System.out.println("\nRequesting employees object...");
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path("object");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		if (response.getStatusInfo().equals(Status.OK)) {
			Employees employees = response.readEntity(Employees.class);
			System.out.println("Response Received-\n" + employees);
		} else {
			String responseText = response.readEntity(String.class);
			System.out.println("Response Received-\n" + responseText);
		}

	}

}