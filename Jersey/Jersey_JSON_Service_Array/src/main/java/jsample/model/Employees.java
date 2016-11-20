package jsample.model;

import java.util.ArrayList;
import java.util.List;

import jsample.model.Employee;

public class Employees {

	private List<Employee> employeeList = new ArrayList<Employee>() {
		private static final long serialVersionUID = 1L;
		{
			add(new Employee(101, "Bob"));
			add(new Employee(102, "Alice"));
		}
	};

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Employees [employeeList=" + employeeList + "]";
	}

}
