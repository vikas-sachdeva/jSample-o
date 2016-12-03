package jsample.client;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

public class FileUploadClient {

	private static final String SERVER_URL = "http://localhost:8080/Jersey_File_Upload_Service/rest";

	private static final String API_PATH = "upload/file";

	public static final String UPLOAD_FILE_PATH = "G:/temp/bookmarks_7_1_15.html";

	public void upload() throws IOException {
		Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();

		FileDataBodyPart filePart = new FileDataBodyPart("file", new File(UPLOAD_FILE_PATH));
		FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
		FormDataMultiPart multipart = (FormDataMultiPart) formDataMultiPart.bodyPart(filePart);
		multipart.field("fileDescription", "Test file");

		WebTarget target = client.target(SERVER_URL).path(API_PATH);
		Response response = target.request().post(Entity.entity(multipart, multipart.getMediaType()));

		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			System.out.println(response.readEntity(String.class));
		} else {
			System.out.println(
					"There is an error while uploading file. Received HTTP Status code= " + response.getStatus());
		}
		formDataMultiPart.close();
		multipart.close();
	}
}