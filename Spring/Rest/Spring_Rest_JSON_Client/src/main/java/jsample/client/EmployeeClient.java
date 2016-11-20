package jsample.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import jsample.model.Employee;

public class EmployeeClient {

	private static final String SERVER_URL = "http://localhost:8080/Jersey_JSON_Service/rest";

	private static final String API_PATH = "employee";

	private static final char PATH_SEPARATOR = '/';

	public static void getEmployeeWithId(Integer id) {
		System.out.println("\nRequesting employee information...");

		String url = SERVER_URL + PATH_SEPARATOR + API_PATH + PATH_SEPARATOR + "{id}";

		RestTemplate restTemplate = new RestTemplate();

		Employee employee = restTemplate.getForObject(url, Employee.class, id);

		System.out.println("Response Received-\n" + employee);

	}

	public static void deleteEmployeeWithId(Integer id) {
		System.out.println("\nRequesting employee deletion...");

		String url = SERVER_URL + PATH_SEPARATOR + API_PATH + PATH_SEPARATOR + "{id}";

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.delete(url, id);

		System.out.println("Employee with id = " + id + " is deleted");

	}

	public static void createEmployee(Employee emp) {
		System.out.println("\nRequesting employee addition...");

		String url = SERVER_URL + PATH_SEPARATOR + API_PATH;

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Employee> employeeEntity = new HttpEntity<Employee>(emp, httpHeaders);

		RestTemplate restTemplate = new RestTemplate();

		Employee employee = restTemplate.postForObject(url, employeeEntity, Employee.class);

		System.out.println("Response Received-\n" + employee);

	}

	public static void updateEmployee(Integer id, Employee emp) {
		System.out.println("\nRequesting employee updation...");

		String url = SERVER_URL + PATH_SEPARATOR + API_PATH + PATH_SEPARATOR + "{id}";

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Employee> employeeEntity = new HttpEntity<Employee>(emp, httpHeaders);

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.put(url, employeeEntity, id);

		System.out.println("Employee with id = " + id + " is updated");

	}
}