package jsample.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jsample.service.EmployeeService;

@Path("/employees")
public class EmployeeResource {

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeesList() {

		return Response.ok().entity(EmployeeService.getInstance().getEmployees().getEmployeeList()).build();

	}

	@GET
	@Path("/object")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeesObject() {

		return Response.ok().entity(EmployeeService.getInstance().getEmployees()).build();

	}
}
