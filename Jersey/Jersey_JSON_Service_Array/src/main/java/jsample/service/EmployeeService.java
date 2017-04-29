package jsample.service;

import jsample.model.Employees;

public class EmployeeService {

	private Employees employees;

	private static class ClassLazyHolder {
		private static final EmployeeService INSTANCE = new EmployeeService();
	}

	public static EmployeeService getInstance() {
		return ClassLazyHolder.INSTANCE;
	}

	private EmployeeService() {
		employees = new Employees();
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
}