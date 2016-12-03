package jsample;

import java.io.IOException;

import jsample.client.FileUploadClient;

public class App {
	public static void main(String[] args) throws IOException {
		new FileUploadClient().upload();
	}
}