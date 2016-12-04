package jsample;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jsample.beans.HelloWorld;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		/*
		 * Parameter value passed to context.getBean() method should be same as
		 * the id attribute value in <bean> element defined in spring xml
		 * configuration file.
		 */
		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();
		context.close();
	}
}
