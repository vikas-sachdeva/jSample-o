package jsample;

import java.util.Calendar;

import jsample.model.Employee;

public class App {
	public static void main(String[] args) {

		Calendar dateofbirth = Calendar.getInstance();
		dateofbirth.clear();
		dateofbirth.set(1980, 10, 2);

		Employee emp = new Employee(101, "Bob", "Teacher", "Male", "English", dateofbirth.getTime());
		System.out.println("Employee Details -");
		System.out.println(emp);
	}
}
