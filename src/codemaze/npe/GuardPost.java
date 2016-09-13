package codemaze.npe;

import codemaze.Constants;
import codemaze.MazeException;
import codemaze.PasswordGenerator;
import codemaze.PropertyHandler;

public class GuardPost {
	
	public static void allowThrough(Guard guard) {
		String password = guard.password.toString();
		if(!password.equals("aaaaaaa")){
			throw new MazeException("You removed the wrong methods! Only pick one method to remove from the guard's method chain.");
		}
		System.out.println("The guard allows you to pass! The next chunk is: ");
		String chunk = PasswordGenerator.getPasswordChunk(5);
		System.err.println(chunk);
		PropertyHandler.writeChunk(Constants.LabPropertyKeys.GUARD, chunk);
	}
}
