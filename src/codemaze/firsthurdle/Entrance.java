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
		File propFile = new File(uidPropertyFileName);
		try {
			uidProp.load(new FileInputStream(propFile));
		} catch (FileNotFoundException e) {
			throw new MazeException("I couldn't find your maze.properties file! I looked for it at " + propFile.getAbsolutePath() + "\nIs that where you put it?");
		} catch (IOException e) {
			throw new MazeException("Woah, somethine really bad happened. " + e.getMessage());
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
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Constants.Entrance.tail);
	}
}
