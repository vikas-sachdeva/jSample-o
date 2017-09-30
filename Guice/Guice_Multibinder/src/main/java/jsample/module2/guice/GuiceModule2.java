package jsample.module2.guice;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

import jsample.module2.service.DeleteOperation;
import jsample.service.Operation;

public class GuiceModule2 extends AbstractModule {

	@Override
	protected void configure() {
		
		Multibinder<Operation> multibinder = Multibinder.newSetBinder(binder(), Operation.class);

		// bind module or plugin dependencies
		multibinder.addBinding().to(DeleteOperation.class);
	}
}
