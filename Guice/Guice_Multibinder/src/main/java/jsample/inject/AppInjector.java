package jsample.inject;

import java.util.Set;

import com.google.inject.Inject;

import jsample.service.Operation;

public class AppInjector {

	/*
	 * Inject the dependency on field
	 */
	@Inject
	private Set<Operation> operations;

	public void doAction(String input) {
		for (Operation operation : operations) {
			System.out.println("Output of operation - " + operation.perform(input));
		}
	}
}
