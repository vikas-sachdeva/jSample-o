package jsample.osgi.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import jsample.osgi.service.HelloService;
import jsample.osgi.servicefactory.helloworld.HelloServiceImpl;

public class HelloServiceFactory implements ServiceFactory<HelloService> {

	private int usageCounter = 0;

	@Override
	public HelloService getService(Bundle bundle, ServiceRegistration<HelloService> registration) {
		System.out.println("Create object of HelloService for " + bundle.getSymbolicName());
		usageCounter++;
		System.out.println("Number of bundles using service " + usageCounter);
		HelloService helloService = new HelloServiceImpl();
		return helloService;
	}

	@Override
	public void ungetService(Bundle bundle, ServiceRegistration<HelloService> registration, HelloService helloService) {
		System.out.println("Release object of HelloService for " + bundle.getSymbolicName());
		usageCounter--;
		System.out.println("Number of bundles using service " + usageCounter);
	}
}