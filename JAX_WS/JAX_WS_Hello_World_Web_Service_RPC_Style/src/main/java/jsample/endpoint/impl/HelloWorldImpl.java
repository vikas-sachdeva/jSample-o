package jsample.endpoint.impl;

import javax.jws.WebService;

import jsample.endpoint.HelloWorld;

//Service Implementation
@WebService(endpointInterface = "jsample.endpoint.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World - " + name.toLowerCase();
	}

}
