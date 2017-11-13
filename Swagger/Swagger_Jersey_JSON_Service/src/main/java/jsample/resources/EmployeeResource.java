package jsample.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jsample.model.Employee;
import jsample.service.EmployeeService;

@Path("/employee")
@Api
public class EmployeeResource {

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get Employee by Id", notes = "It will take Employee id as input and return Employee details.")
	@ApiResponses({ @ApiResponse(code = 404, message = "Employee with given id is not found"),
			@ApiResponse(code = 200, response = Employee.class, message = "Employee with input id") })
	public Response getEmployeeById(@PathParam("id") Integer id) {
		for (int i = 0; i < EmployeeService.getInstance().getEmployeeList().size(); i++) {
			if (EmployeeService.getInstance().getEmployeeList().get(i).getId().equals(id)) {
				return Response.ok().entity(EmployeeService.getInstance().getEmployeeList().get(i)).build();
			}
		}
		return Response.status(Status.NOT_FOUND).entity("Employee with id " + id + " is not found").build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "Delete Employee by Id", notes = "It will take Employee id as input and delete it.")
	@ApiResponses({ @ApiResponse(code = 404, message = "Employee with given id is not found"),
			@ApiResponse(code = 200, message = "Employee with input id is deleted.") })
	public Response deleteEmployeeById(@PathParam("id") Integer id) {
		for (int i = 0; i < EmployeeService.getInstance().getEmployeeList().size(); i++) {
			if (EmployeeService.getInstance().getEmployeeList().get(i).getId().equals(id)) {
				EmployeeService.getInstance().getEmployeeList().remove(i);
				return Response.status(Status.ACCEPTED).entity("Employee with id " + id + " is deleted.").build();
			}
		}
		return Response.status(Status.NOT_FOUND).entity("Employee with id " + id + " is not found").build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add Employee", notes = "It will add a new Employee")
	@ApiResponses({ @ApiResponse(code = 400, message = "Employee id is not found in input."),
			@ApiResponse(code = 200, response = Employee.class, message = "Employee with given details is added") })
	public Response addEmployee(Employee emp) {

		if (emp.getId() == null) {
			return Response.status(Status.BAD_REQUEST).entity("Employee id is not found").build();
		}
		EmployeeService.getInstance().getEmployeeList().add(emp);
		return Response.status(Status.OK).entity(emp).build();

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Update Employee", notes = "It will update Employee details")
	@ApiResponses({ @ApiResponse(code = 400, message = "Employee id is not found in input."),
			@ApiResponse(code = 200, response = Employee.class, message = "Employee with given details is updated.") })
	public Response updateEmployee(@PathParam("id") Integer id, Employee emp) {

		if (emp.getId() == null) {
			return Response.status(Status.BAD_REQUEST).entity("Employee id is not found").build();
		}
		for (int i = 0; i < EmployeeService.getInstance().getEmployeeList().size(); i++) {
			if (EmployeeService.getInstance().getEmployeeList().get(i).getId().equals(id)) {
				EmployeeService.getInstance().getEmployeeList().remove(i);
			}
		}
		EmployeeService.getInstance().getEmployeeList().add(emp);
		return Response.status(Status.OK).entity(emp).build();
	}
}