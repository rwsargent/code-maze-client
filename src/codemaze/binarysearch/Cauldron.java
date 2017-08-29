package codemaze.binarysearch;

import java.util.Arrays;

import codemaze.Backpack;
import codemaze.Constants;
import codemaze.MazeException;
import codemaze.PasswordGenerator;
import codemaze.PropertyHandler;

public class Cauldron {

	private static Integer[] healthPotions = new Integer[] {1, 2, 3, 4, 5};
	private static Integer[] manaPotions = new Integer[] {5, 10, 15, 20, 25};
	
	private static Integer[] largeList = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
	
	public static void testBinarySearch(Backpack backpack) {
		
		if(backpack.testBinarySearch(largeList, 0)) {
			throw new MazeException("Wrong! The goal was 0 for: \n" + Arrays.toString(largeList) +
					".\nBinarySearch returned true, should be false.");
		}
		
		if(!backpack.testBinarySearch(healthPotions, 2)) {
			throw new MazeException("Wrong! The goal was 2 for: \n" + Arrays.toString(healthPotions) +
					".\nBinarySearch returned false, should be true.");
		}
		if(backpack.testBinarySearch(healthPotions, 0)) {
			throw new MazeException("Wrong! The goal was 0 for: \n" + Arrays.toString(healthPotions) +
					".\nBinarySearch returned true, should be false.");
		}
		if(!backpack.testBinarySearch(manaPotions, 20)) {
			throw new MazeException("Wrong! The goal was 20 for: \n" + Arrays.toString(manaPotions) + 
					".\nBinarySearch returned false, should be true.");
		}
		if(backpack.testBinarySearch(manaPotions, 18)) {
			throw new MazeException("Wrong! The goal was 18 for: \n" + Arrays.toString(manaPotions) +
					".\nBinarySearch returned true, should be false.");
		}
		
		String chunk = PasswordGenerator.getPasswordChunk(6);
		System.out.println("You got the right potions! Your next password chunk is:\n" + chunk);
		PropertyHandler.writeChunk(Constants.LabPropertyKeys.BINARY, chunk);
		
	}
}
