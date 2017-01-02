package jsample;

import jsample.endpoint.impl.HelloWorld;
import jsample.endpoint.impl.HelloWorldImplService;

/**
 * 
 * <pre>
 * 
 * Use following command for generating web service client source code using wsimport tool -
 * 
 * wsimport -keep http://localhost:9999/ws/hello?wsdl -Xnocompile
 * 
 * wsimport tool is bundle with the JDK.
 * 
 * In this case, it will generate jsample.endpoint.impl package which contains two files -
 * 
 * 1. HelloWorld.java
 * 2. HelloWorldServiceImplService.java
 * 
 * 
 */
public class App {
	public static void main(String[] args) {
		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld hello = helloService.getHelloWorldImplPort();

		System.out.println(hello.getHelloWorldAsString("PRC Client wsimport tool"));
	}
}
