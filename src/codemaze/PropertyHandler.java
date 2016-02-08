package codemaze;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandler {

	public static void writeChunk(String key, String chunk) {
		Properties props = getProperties();
		File f = new File(Constants.MAZE_PROPERTY_FILENAME);
		try {
			props.load(new FileInputStream(f));
			props.put(key, chunk);
			props.store(new FileOutputStream(f), "Saved a chunk of password");
		} catch (FileNotFoundException e) {
			throw new MazeException("Couldn't save password chunk");
		} catch (IOException e) {
			throw new MazeException("Couldn't save password chunk");
		}
	}
	
	public static Properties getProperties() {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(new File(Constants.MAZE_PROPERTY_FILENAME)));
		} catch (IOException e) {
			throw new MazeException("Couldn't read property file");
		}
		return props;
	}
}
