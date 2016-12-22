package jsample.client;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class FileDownloadClient {

	private static final String SERVER_URL = "http://localhost:8080/Jersey_File_Download_Service/rest";

	private static final String API_PATH = "download";

	private static final String DOWNLOAD_FILE_PATH = "H:/";

	private static final String CONTENT_DISPOSITION_HEADER_NAME = "Content-Disposition";

	private static final String FILENAME_STR = "filename=";

	public void download(String fileId) throws IOException {
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path(fileId);

		Invocation.Builder invocationBuilder = webTarget.request();
		Response response = invocationBuilder.get();

		String contentDispositionHeader = response.getHeaderString(CONTENT_DISPOSITION_HEADER_NAME);
		String fileName = contentDispositionHeader
				.substring(contentDispositionHeader.indexOf(FILENAME_STR) + FILENAME_STR.length()).replace("\"", "");

		InputStream responseStream = response.readEntity(InputStream.class);

		Files.copy(responseStream, Paths.get(DOWNLOAD_FILE_PATH + fileName), StandardCopyOption.REPLACE_EXISTING);

		System.out.println("File is downloaded");

	}
}