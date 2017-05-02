package jsample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.LogManager;

import jsample.client.EmployeeClient;
import jsample.model.Employee;

public class App {
	public static void main(String[] args) throws SecurityException, FileNotFoundException, IOException {

		readLogConfigurationFile();

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

	private static void readLogConfigurationFile() throws SecurityException, FileNotFoundException, IOException {
		LogManager.getLogManager().readConfiguration(new FileInputStream("./config/log_config.properties"));
	}
}
