package jsample.module1.guice;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

import jsample.module1.service.CreateOperation;
import jsample.service.Operation;

public class GuiceModule1 extends AbstractModule {

	@Override
	protected void configure() {

		Multibinder<Operation> multibinder = Multibinder.newSetBinder(binder(), Operation.class);

		// bind module or plugin dependencies
		multibinder.addBinding().to(CreateOperation.class);

	}
}
