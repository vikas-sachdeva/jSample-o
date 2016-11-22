package jsample.osgi.service.helloworld;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import jsample.osgi.service.HelloService;

public class Activator implements BundleActivator {

	private ServiceRegistration<HelloService> helloServiceRegistration;

	public void start(BundleContext context) throws Exception {
		HelloService helloService = new HelloServiceImpl();
		helloServiceRegistration = context.registerService(HelloService.class, helloService, null);

	}

	public void stop(BundleContext context) throws Exception {
		helloServiceRegistration.unregister();
	}
}
