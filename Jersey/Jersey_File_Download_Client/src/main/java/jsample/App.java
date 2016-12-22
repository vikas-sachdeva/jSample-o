package jsample;

import java.io.IOException;

import jsample.client.FileDownloadClient;

public class App {
	public static void main(String[] args) throws IOException {
		new FileDownloadClient().download("travel");
	}
}
