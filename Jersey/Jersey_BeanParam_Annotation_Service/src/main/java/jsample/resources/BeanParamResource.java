package jsample.resources;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jsample.model.Data;

@Path("/beanParam")
public class BeanParamResource {

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg(@BeanParam Data data) {

		String name = data.getName();

		String role = data.getRole();

		data.setDisplayName(name + " , " + role);

		return Response.status(200).entity(data).build();
	}
}
