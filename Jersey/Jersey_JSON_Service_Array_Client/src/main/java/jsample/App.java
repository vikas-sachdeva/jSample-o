package jsample;

import java.util.ArrayList;
import java.util.List;

import jsample.client.EmployeeClient;
import jsample.model.Employee;
import jsample.model.Employees;

public class App {

	private static List<Employee> employeeList1 = new ArrayList<Employee>() {
		private static final long serialVersionUID = 1L;
		{
			add(new Employee(101, "Bob"));
			add(new Employee(102, "Alice"));
		}
	};

	private static List<Employee> employeeList2 = new ArrayList<Employee>() {
		private static final long serialVersionUID = 1L;
		{
			add(new Employee(111, "Charlie"));
			add(new Employee(112, "Wayne"));
		}
	};

	private static Employees employees1 = new Employees();

	private static Employees employees2 = new Employees();

	public static void main(String[] args) {

		EmployeeClient.createEmployeesList(employeeList1);

		EmployeeClient.getEmployeesList();

		EmployeeClient.updateEmployeesList(employeeList2);

		employees1.setEmployeeList(employeeList2);
		employees2.setEmployeeList(employeeList1);

		EmployeeClient.createEmployeesObject(employees1);

		EmployeeClient.getEmployeesObject();

		EmployeeClient.updateEmployeesObject(employees2);

	}
}
