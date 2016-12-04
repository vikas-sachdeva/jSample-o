package jsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jsample.beans.HelloWorld;

/*
 * @Configuration annotation makes this class spring class configuration file. 
 */
@Configuration
public class ApplicationConfig {

	/*
	 * Specify id of the bean in name attribute of @Bean annotation. This id is
	 * used for getting class instance in code.
	 */
	@Bean(name = "helloBean")
	public HelloWorld helloWorld() {
		HelloWorld helloWorld = new HelloWorld();
		/* set name variable value of the bean class */
		helloWorld.setName("Spring Class");
		return helloWorld;
	}
}