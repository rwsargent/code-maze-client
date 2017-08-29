package codemaze;

import java.util.function.BiFunction;

import codemaze.conditional.PuzzleWall.Tumbler;
import codemaze.sphinx.Sphinx;
import codemaze.spin.TeaCupCode;

public class Backpack {
	private BiFunction<Integer[], Integer, Boolean> binarySearch;

	public void setBinarySearch(BiFunction<Integer[], Integer, Boolean> binarySearch) {
		this.binarySearch = binarySearch;
	}
	
	public boolean testBinarySearch(Integer[] potions, Integer goal) {
		return this.binarySearch.apply(potions, goal);
	}

	public void checkCode(TeaCupCode code) {
		if(!code.isValid()) {
			throw new MazeException("Looks like you didn't make it through the tea cups in the right order!");
		}
		System.out.println("Once the room stops spinning, continue you on! Your next password chunk is:");
		String chunk = PasswordGenerator.getPasswordChunk(1);
		System.err.println(chunk);
		PropertyHandler.writeChunk(Constants.LabPropertyKeys.TEA_CUPS, chunk);
	}
	
	public void debugSphinx(Sphinx sphinx, String password) {
		if(!sphinx.tryPassword(password)) {
			throw new MazeException("Close! But you were taking too long and she gobbled you up whole.");
		}
		System.out.println("Nice one. Once she got the password, she hopped to the side and let you pass!\nYour next password chunk is:");
		String chunk = PasswordGenerator.getPasswordChunk(2);
		System.err.println(chunk);
		PropertyHandler.writeChunk(Constants.LabPropertyKeys.SPHINX, chunk);
	}

	public void calculateTumblers(Tumbler... tumblers) {
		
	}
}
