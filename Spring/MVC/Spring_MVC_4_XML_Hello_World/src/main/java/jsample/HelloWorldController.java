package jsample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	/**
	 * Following controller will map with these URLs -
	 * 
	 * http://localhost:8080/Spring_MVC_4_XML_Hello_World/
	 * http://localhost:8080/Spring_MVC_4_XML_Hello_World/hello
	 * http://localhost:8080/Spring_MVC_4_XML_Hello_World/?param=Spring
	 * http://localhost:8080/Spring_MVC_4_XML_Hello_World/hello?param=Spring
	 * 
	 * URLs are case sensitive.
	 */
	@RequestMapping(value = { "/", "/hello" })
	/**
	 * It can accept one optional parameter with name - "param".
	 * 
	 * If other parameters are also passed, they will be ignored.
	 * 
	 * If multiple parameters with name "param" are passed, value of each
	 * parameter will be appended and separated by "," in variable "paramValue"
	 * 
	 * E.g. URL
	 * http://localhost:8080/Spring_MVC_4_XML_Hello_World/hello?param=Spring&param=MVC
	 * 
	 * will result in "Spring,MVC"
	 * 
	 */
	public String hello(@RequestParam(value = "param", required = false, defaultValue = "Spring MVC") String paramValue,
			Model model) {
		model.addAttribute("name", paramValue);
		return "helloworld";
		/**
		 * It will look for the jsp file with name helloworld.jsp inside folder
		 * /WEB-INF/views/
		 */
	}
}