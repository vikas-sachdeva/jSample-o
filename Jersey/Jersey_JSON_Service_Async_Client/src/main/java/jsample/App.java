package jsample;

import java.util.concurrent.ExecutionException;

import jsample.client.EmployeeClient;
import jsample.model.Employee;

public class App {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		EmployeeClient.getEmployeeWithId(101);

		EmployeeClient.deleteEmployeeWithId(101);

		EmployeeClient.getEmployeeWithId(101);

		Employee emp = new Employee(103, "George");
		EmployeeClient.createEmployee(emp);

		EmployeeClient.getEmployeeWithId(103);

		emp.setName("Robert");
		EmployeeClient.updateEmployee(103, emp);

		EmployeeClient.getEmployeeWithId(103);

		emp = new Employee(101, "Bob");
		EmployeeClient.createEmployee(emp);

		EmployeeClient.getEmployeeWithId(101);
	}
}
