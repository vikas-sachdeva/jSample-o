package jsample.client;

import org.springframework.web.client.RestTemplate;

import jsample.model.Employee;
import jsample.model.Employees;

public class EmployeeClient {

	private static final String SERVER_URL = "http://localhost:8080/Jersey_JSON_Service_Array/rest";

	private static final String API_PATH = "employees";

	private static final char PATH_SEPARATOR = '/';

	private static final String URL = SERVER_URL + PATH_SEPARATOR + API_PATH + PATH_SEPARATOR + "{path}";

	public static void getEmployeesList() {
		System.out.println("\nRequesting employees list...");

		RestTemplate restTemplate = new RestTemplate();

		Employee[] employeeArray = restTemplate.getForObject(URL, Employee[].class, "list");

		System.out.println("Response Received-");
		for (Employee emp : employeeArray) {
			System.out.println(emp);
		}
	}

	public static void getEmployeesObject() {
		System.out.println("\nRequesting employees object...");

		RestTemplate restTemplate = new RestTemplate();

		Employees employees = restTemplate.getForObject(URL, Employees.class, "object");

		System.out.println("Response Received-\n" + employees);
	}
}