package jsample.service.impl;

import jsample.service.Operation;

public class DeleteOperation implements Operation {

	@Override
	public String perform(String input) {
		System.out.println("Performing delete operation using input - " + input);

		return "deletion result";
	}
}
