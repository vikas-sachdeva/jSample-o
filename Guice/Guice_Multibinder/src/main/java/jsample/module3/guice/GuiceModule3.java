package jsample.module3.guice;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

import jsample.module3.service.SearchOperation;
import jsample.service.Operation;

public class GuiceModule3 extends AbstractModule {

	@Override
	protected void configure() {

		Multibinder<Operation> multibinder = Multibinder.newSetBinder(binder(), Operation.class);

		// bind module or plugin dependencies
		multibinder.addBinding().to(SearchOperation.class);
	}
}
