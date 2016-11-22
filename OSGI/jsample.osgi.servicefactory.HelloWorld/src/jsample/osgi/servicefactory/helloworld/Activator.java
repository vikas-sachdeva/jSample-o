package jsample.osgi.servicefactory.helloworld;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import jsample.osgi.service.HelloService;
import jsample.osgi.service.HelloServiceFactory;

public class Activator implements BundleActivator {

	private ServiceRegistration<HelloService> helloServiceRegistration;

	public void start(BundleContext context) throws Exception {
		HelloServiceFactory helloServiceFactory = new HelloServiceFactory();
		helloServiceRegistration = context.registerService(HelloService.class, helloServiceFactory, null);
	}

	public void stop(BundleContext context) throws Exception {
		helloServiceRegistration.unregister();
	}
}