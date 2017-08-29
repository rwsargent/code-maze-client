package codemaze.npe;

import codemaze.Constants;
import codemaze.MazeException;
import codemaze.PasswordGenerator;
import codemaze.PropertyHandler;

public class ChainFence {
	
	public static void allowThrough(Chain chain) {
		String password = chain.password.toString();
		if(!password.equals("aaaaaaa")){
			throw new MazeException("You removed the wrong method! Only pick one method to remove from the guard's method chain.");
		}
		System.out.println("You found the weakest link! The next chunk is: ");
		String chunk = PasswordGenerator.getPasswordChunk(4);
		System.err.println(chunk);
		PropertyHandler.writeChunk(Constants.LabPropertyKeys.CHAIN, chunk);
	}
}
