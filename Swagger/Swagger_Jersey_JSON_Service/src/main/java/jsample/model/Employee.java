package jsample.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Employee Details")
public class Employee {

	@ApiModelProperty(value = "Employee Id", required = true, example = "201")
	private Integer id;

	@ApiModelProperty(value = "Employee Name", example = "Albert")
	private String name;

	public Employee() {

	}

	public Employee(Integer id, String name) {

		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
