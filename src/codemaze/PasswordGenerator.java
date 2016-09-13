package codemaze;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordGenerator {

	public static String getPasswordChunk(int chunkZeroBased) {
		String uid = PropertyHandler.getProperties().getProperty(Constants.LabPropertyKeys.UID);
		return getPasswordChunk(uid, chunkZeroBased);
	}
	public static String getPasswordChunk(String uid, int chunkZeroBased) {
		String hash = generatePassword(uid);
		int offset = chunkZeroBased * 4;
		return hash.substring(offset, offset + 4);
	}
	
	private static String generatePassword(String uid) {
		StringBuilder sb = new StringBuilder(uid).append('i').append('n').append('w').append('a').append('n');
		MessageDigest md = null;
		try {
			 md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// MD5 should always work.
		}
		String seed = sb.toString();
		md.update(seed.getBytes());
		byte byteData[] = md.digest();
       //convert the byte to hex format method 1
		sb = new StringBuilder();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
