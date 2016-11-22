package jsample.osgi.service.consumer.helloworld;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import jsample.osgi.service.HelloService;

public class Activator implements BundleActivator {

	private ServiceReference<HelloService> helloServiceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Hello World!!");
		helloServiceReference = context.getServiceReference(HelloService.class);
		HelloService helloService = context.getService(helloServiceReference);
		System.out.println(helloService.hello("OSGI !!!"));
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
		context.ungetService(helloServiceReference);
	}

}
