package jsample.inject;

import com.google.inject.Inject;

import jsample.service.Operation;

public class AppInjector {

	/*
	 * Inject the dependency on field
	 */
	@Inject
	private Operation operation;

	public String doAction(String input) {
		return operation.perform(input);
	}
}
