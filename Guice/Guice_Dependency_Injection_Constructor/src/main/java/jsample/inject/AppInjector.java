package jsample.inject;

import com.google.inject.Inject;

import jsample.service.Operation;

public class AppInjector {

	private Operation operation;

	/*
	 * Inject the dependency while creating instance
	 */
	@Inject
	public AppInjector(Operation operation) {
		this.operation = operation;
	}

	public String doAction(String input) {
		return operation.perform(input);
	}
}
