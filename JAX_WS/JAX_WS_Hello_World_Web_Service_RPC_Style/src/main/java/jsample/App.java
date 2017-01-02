package jsample;

import javax.xml.ws.Endpoint;

import jsample.endpoint.impl.HelloWorldImpl;

public class App {

	public static void main(String[] args) {
		/**
		 * 
		 * Following line will deploy Hello World Web Service at "http://localhost:9999/ws/hello" URL.
		 * 
		 * WSDL file can be accessed at http://localhost:9999/ws/hello?wsdl URL.
		 */
		Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
		System.out.println("Web Service is published.");
	}
}
