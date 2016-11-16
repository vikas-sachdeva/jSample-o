package jsample.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jsample.logic.IUserLogic;

@Component
@RequestScoped
@ManagedBean
public class UserOperation {

	@Autowired
	IUserLogic userLogic;

	public List<User> getUserDetails() {
		return userLogic.getUserDetails();
	}
}
