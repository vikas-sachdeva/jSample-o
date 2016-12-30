package jsample;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import jsample.security.ShaGenerator;

public class App {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		System.out.println("Enter the text to be hashed -");
		Scanner scanner = new Scanner(System.in);
		String textToBeHashed = scanner.next();
		scanner.close();

		byte[] hashBytes = ShaGenerator.generateSha256Hash(textToBeHashed);
		System.out.println("Length of hashed byte array " + hashBytes.length);

		String hashString = ShaGenerator.generateSha256HashString(textToBeHashed);
		System.out.println("Hashed Hex String \'" + hashString + "\' with length " + hashString.length());
	}
}
