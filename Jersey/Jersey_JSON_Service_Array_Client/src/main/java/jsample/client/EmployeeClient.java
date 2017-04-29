package jsample.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
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
		System.out.println("\nRequesting employee list...");
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

	public static void updateEmployeesList(List<Employee> employeeList) {
		System.out.println("\nUpdating employee list...");
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path("addList");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(employeeList, MediaType.APPLICATION_JSON));

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

	public static void createEmployeesList(List<Employee> employeeList) {
		System.out.println("\nCreating employee list...");
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path("createList");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(employeeList, MediaType.APPLICATION_JSON));

		if (response.getStatusInfo().equals(Status.OK)) {
			String responseText = response.readEntity(String.class);
			System.out.println("Response Received-\n" + responseText);
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

	public static void updateEmployeesObject(Employees employees) {
		System.out.println("\nUpdating employees object...");
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path("updateObject");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(employees, MediaType.APPLICATION_JSON));

		if (response.getStatusInfo().equals(Status.OK)) {
			Employees responseEmployees = response.readEntity(Employees.class);
			System.out.println("Response Received-\n" + responseEmployees);
		} else {
			String responseText = response.readEntity(String.class);
			System.out.println("Response Received-\n" + responseText);
		}
	}

	public static void createEmployeesObject(Employees employees) {
		System.out.println("\nCreating employees object...");
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path("createObject");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(employees, MediaType.APPLICATION_JSON));

		if (response.getStatusInfo().equals(Status.OK)) {
			String responseText = response.readEntity(String.class);
			System.out.println("Response Received-\n" + responseText);
		} else {
			String responseText = response.readEntity(String.class);
			System.out.println("Response Received-\n" + responseText);
		}
	}
}