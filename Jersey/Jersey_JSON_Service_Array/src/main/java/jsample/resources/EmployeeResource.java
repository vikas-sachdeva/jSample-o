package jsample.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jsample.model.Employee;
import jsample.model.Employees;
import jsample.service.EmployeeService;

@Path("/employees")
public class EmployeeResource {

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeesList() {

		return Response.ok().entity(EmployeeService.getInstance().getEmployees().getEmployeeList()).build();

	}

	@PUT
	@Path("/addList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployeesList(List<Employee> employeeList) {

		EmployeeService.getInstance().getEmployees().getEmployeeList().addAll(employeeList);

		return Response.ok().entity(EmployeeService.getInstance().getEmployees().getEmployeeList()).build();

	}

	@POST
	@Path("/createList")
	public Response createEmployeesList(List<Employee> employeeList) {

		Employees employees = new Employees();

		employees.setEmployeeList(employeeList);

		EmployeeService.getInstance().setEmployees(employees);

		return Response.ok().entity("Employee List created.").build();

	}

	@GET
	@Path("/object")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeesObject() {

		return Response.ok().entity(EmployeeService.getInstance().getEmployees()).build();

	}

	@PUT
	@Path("/updateObject")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployeesObject(Employees employees) {
		EmployeeService.getInstance().getEmployees().getEmployeeList().addAll(employees.getEmployeeList());

		return Response.ok().entity(EmployeeService.getInstance().getEmployees()).build();
	}

	@POST
	@Path("/createObject")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEmployeesObject(Employees employees) {

		EmployeeService.getInstance().setEmployees(employees);

		return Response.ok().entity("Employees object created.").build();
	}
}
