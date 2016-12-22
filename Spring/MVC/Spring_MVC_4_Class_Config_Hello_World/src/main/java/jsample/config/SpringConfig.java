package jsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 
 * @Configuration annotation will let spring knows that this class contains bean
 *                definitions.
 */
@Configuration
/**
 * 
 * @EnableWebMvc annotation is the same as <mvc:annotation-driven/>
 *
 */
@EnableWebMvc
/**
 * 
 * @ComponentScan annotation is same is
 *                <context:component-scan base-package="jsample" /> line in XML
 *                configuration.
 */
@ComponentScan("jsample")
public class SpringConfig {

	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
}