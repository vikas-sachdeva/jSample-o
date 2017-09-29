package jsample.guice;

import com.google.inject.AbstractModule;

import jsample.service.Operation;
import jsample.service.impl.SearchOperation;

public class AppGuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		/*
		 * This tells Guice that whenever it sees a dependency on a Operation
		 * class, it should satisfy the dependency using a SearchOperation
		 * class.
		 */
		bind(Operation.class).to(SearchOperation.class);
	}
}
