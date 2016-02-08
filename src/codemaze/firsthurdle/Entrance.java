package codemaze.firsthurdle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import codemaze.Constants;
import codemaze.MazeException;
import codemaze.PasswordGenerator;
import codemaze.PropertyHandler;

public class Entrance {
	public static String getEntranceMessage() {
		return Constants.Entrance.startMessage;
	}

	public static Properties readPropertyFile(String uidPropertyFileName) {
		Properties uidProp = new Properties();
		try {
			uidProp.load(new FileInputStream(new File(uidPropertyFileName)));
		} catch (FileNotFoundException e) {
			throw new MazeException("Woops! Looks like you don't know what your UID is!");
		} catch (IOException e) {
		}
		return uidProp;
	}

	public static void declareUID(String uid) {
		if(uid == null) {
			throw new NullPointerException("How can your UID be null?");
		}
		String passwordChunk = PasswordGenerator.getPasswordChunk(uid, 0);
		PropertyHandler.writeChunk(Constants.LabPropertyKeys.UID, uid);
		PropertyHandler.writeChunk(Constants.LabPropertyKeys.ENTRANCE, passwordChunk);
		System.out.println(Constants.Entrance.firstPassword);
		System.err.println(passwordChunk);
		System.out.println(Constants.Entrance.tail);
	}
}
