package jsample;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import jsample.endpoint.HelloWorld;

public class App {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:9999/ws/hello?wsdl");
		
		/**
		 * Following method takes two arguments -
		 * 
		 * 1. Namespace URI - value of targetNamespace attribute of definitions element in above WSDL document 
		 * 2. Local part - value of name attribute of definitions element in above WSDL
		 * document.
		 * 
		 */

		QName qname = new QName("http://impl.endpoint.jsample/", "HelloWorldImplService");

		Service service = Service.create(url, qname);

		HelloWorld hello = service.getPort(HelloWorld.class);

		System.out.println(hello.getHelloWorldAsString("RPC Style Web Service"));
	}
}