package jsample.osgi.servicefactory.helloworld;

import jsample.osgi.service.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String hello(String name) {
		System.out.println("name = " + name);
		return "Hello " + name;
	}

}
