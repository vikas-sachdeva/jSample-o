package jsample.service.impl;

import jsample.service.Operation;

public class CreateOperation implements Operation {

	@Override
	public String perform(String input) {
		System.out.println("Performing create operation using input - " + input);

		return "creation result";
	}
}
