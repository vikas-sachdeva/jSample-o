package jsample.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.glassfish.jersey.media.multipart.ContentDisposition;

@Path("/download")
public class FileDownloadResource {

	private static final String CONTENT_DISPOSITION_HEADER_NAME = "Content-Disposition";
	
	@GET
	@Path("/{param}")
	@Produces("application/pdf")
	public Response downloadFile(@PathParam("param") String fileId) {
		String fileName = fileId + ".pdf";
		StreamingOutput outputStream = new StreamingOutput() {

			@Override
			public void write(OutputStream output) throws IOException, WebApplicationException {
				byte[] fileData = Files.readAllBytes(Paths.get("G:/Itinerary.pdf"));
				output.write(fileData);
				output.flush();
				output.close();
			}
		};
		ContentDisposition contentDisposition = ContentDisposition.type("attachment").fileName(fileName).build();
		return Response.ok(outputStream, MediaType.APPLICATION_OCTET_STREAM)
				.header(CONTENT_DISPOSITION_HEADER_NAME, contentDisposition).build();
	}
}