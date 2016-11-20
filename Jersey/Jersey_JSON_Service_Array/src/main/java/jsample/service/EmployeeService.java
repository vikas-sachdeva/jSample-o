package jsample.service;

import jsample.model.Employees;

public class EmployeeService {

	private static final EmployeeService instance = new EmployeeService();

	private Employees employees;

	private EmployeeService() {

		employees = new Employees();
	}

	public static EmployeeService getInstance() {
		return instance;
	}

	public Employees getEmployees() {
		return employees;
	}

}
