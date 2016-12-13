package jsample;

import jsample.builder.Person;

public class App {
	public static void main(String[] args) {
		Person person1 = new Person.PersonBuilder("Taiyo", "New York").build();
		System.out.println(person1);

		Person person2 = new Person.PersonBuilder("Alice", "New York").setFemale(true).setLastName("Cooper").build();
		System.out.println(person2);
	}
}