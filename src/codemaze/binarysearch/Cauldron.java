package codemaze.binarysearch;

import codemaze.Backpack;
import codemaze.Constants;
import codemaze.MazeException;
import codemaze.PasswordGenerator;
import codemaze.PropertyHandler;

public class Cauldron {

	private static Integer[] healthPotions = new Integer[] {1, 2, 3, 4, 5};
	private static Integer[] manaPotions = new Integer[] {5, 10, 15, 20, 25};
	
	public static void testBinarySearch(Backpack backpack) {
		if(!backpack.testBinarySearch(healthPotions, 2)) {
			throw new MazeException("You picked the wrong health potion! The goal was 2.");
		}
		if(backpack.testBinarySearch(healthPotions, 0)) {
			throw new MazeException("You picked the wrong health potion! The goal was 0");
		}
		if(!backpack.testBinarySearch(manaPotions, 20)) {
			throw new MazeException("You picked the wrong mana potion! The goal was 20");
		}
		if(backpack.testBinarySearch(manaPotions, 18)) {
			throw new MazeException("You picked the wrong mana potion! The goal was 18");
		}
		String chunk = PasswordGenerator.getPasswordChunk(1);
		System.out.println("You got the right potions! Your next password chunk is:\n" + chunk);
		PropertyHandler.writeChunk(Constants.LabPropertyKeys.BINARY, chunk);
		
	}
}
