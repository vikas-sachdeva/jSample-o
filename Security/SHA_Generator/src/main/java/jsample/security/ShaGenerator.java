package jsample.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaGenerator {

	public static byte[] generateSha256Hash(String textToBeHashed)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		return md.digest(textToBeHashed.getBytes("UTF-8"));
	}

	public static String generateSha256HashString(String textToBeHashed)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] hashBytes = generateSha256Hash(textToBeHashed);
		return convertByteArrayToHexString(hashBytes);
	}

	private static String convertByteArrayToHexString(byte[] arrayBytes) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < arrayBytes.length; i++) {
			stringBuilder.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return stringBuilder.toString();
	}
}
