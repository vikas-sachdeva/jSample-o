package jsample.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import jsample.model.Employee;

public class EmployeeClient {

	private static final String SERVER_URL = "http://localhost:8080/Jersey_JSON_Service/rest";

	private static final String API_PATH = "employee";

	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	public static void getEmployeeWithId(Integer id) throws InterruptedException, ExecutionException {
		String transactionId = "[" + atomicInteger.getAndIncrement() + "] ";
		System.out.println("\n" + transactionId + "Requesting employee information...");
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path(String.valueOf(id));

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

		AsyncInvoker asyncInvoker = invocationBuilder.async();

		asyncInvoker.get(new InvocationCallback<Response>() {

			@Override
			public void completed(Response response) {
				if (response.getStatusInfo().equals(Status.OK)) {
					Employee employee = response.readEntity(Employee.class);
					System.out.println(transactionId + "Response Received-\n" + employee);
				} else {
					String responseText = response.readEntity(String.class);
					System.out.println(transactionId + "Response Received-\n" + responseText);
				}
				client.close();
			}

			@Override
			public void failed(Throwable throwable) {
				System.out.println(transactionId + "An error occurred while calling API");
				throwable.printStackTrace();
				client.close();
			}
		});
	}

	public static void deleteEmployeeWithId(Integer id) {
		String transactionId = "[" + atomicInteger.getAndIncrement() + "] ";
		System.out.println("\n" + transactionId + "Requesting employee deletion...");
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path(String.valueOf(id));

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

		AsyncInvoker asyncInvoker = invocationBuilder.async();
		asyncInvoker.delete(new InvocationCallback<Response>() {

			@Override
			public void completed(Response response) {
				String responseText = response.readEntity(String.class);
				System.out.println(transactionId + "Response Received-\n" + responseText);
				client.close();
			}

			@Override
			public void failed(Throwable throwable) {
				System.out.println(transactionId + "An error occurred while calling API");
				throwable.printStackTrace();
				client.close();
			}
		});
	}

	public static void createEmployee(Employee emp) {
		String transactionId = "[" + atomicInteger.getAndIncrement() + "] ";
		System.out.println("\n" + transactionId + "Requesting employee addition...");
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

		AsyncInvoker asyncInvoker = invocationBuilder.async();
		asyncInvoker.post(Entity.entity(emp, MediaType.APPLICATION_JSON), new InvocationCallback<Response>() {

			@Override
			public void completed(Response response) {
				if (response.getStatusInfo().equals(Status.OK)) {
					Employee employee = response.readEntity(Employee.class);
					System.out.println(transactionId + "Response Received-\n" + employee);
				} else {
					String responseText = response.readEntity(String.class);
					System.out.println(transactionId + "Response Received-\n" + responseText);
				}
				client.close();
			}

			@Override
			public void failed(Throwable throwable) {
				System.out.println(transactionId + "An error occurred while calling API");
				throwable.printStackTrace();
				client.close();
			}
		});
	}

	public static void updateEmployee(Integer id, Employee emp) {
		String transactionId = "[" + atomicInteger.getAndIncrement() + "] ";
		System.out.println("\n" + transactionId + "Requesting employee updation...");
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path(String.valueOf(id));

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

		AsyncInvoker asyncInvoker = invocationBuilder.async();
		asyncInvoker.put(Entity.entity(emp, MediaType.APPLICATION_JSON), new InvocationCallback<Response>() {

			@Override
			public void completed(Response response) {
				if (response.getStatusInfo().equals(Status.OK)) {
					Employee employee = response.readEntity(Employee.class);
					System.out.println(transactionId + "Response Received-\n" + employee);
				} else {
					String responseText = response.readEntity(String.class);
					System.out.println(transactionId + "Response Received-\n" + responseText);
				}
				client.close();
			}

			@Override
			public void failed(Throwable throwable) {
				System.out.println(transactionId + "An error occurred while calling API");
				throwable.printStackTrace();
				client.close();
			}
		});
	}
}