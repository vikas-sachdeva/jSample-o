package jsample;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "helloWorld")
@RequestScoped
public class HelloWorldBean implements Serializable {

	private static final long serialVersionUID = -5093790367912748741L;

	private String name = "JSF";

	public String getName() {
		return name;
	}

	public String simpleName() {
		return "Simple " + name;
	}

	public String completeName() {
		return "Complete " + name;
	}
}