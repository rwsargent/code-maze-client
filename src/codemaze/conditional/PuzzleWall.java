package codemaze.conditional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import codemaze.Constants;
import codemaze.MazeException;
import codemaze.PasswordGenerator;
import codemaze.PropertyHandler;

public class PuzzleWall {
	public List<Tumbler> outerRing;
	public List<Tumbler> middleRing;
	public List<Tumbler> innerRing;

	public PuzzleWall() {
		outerRing = generateTumblers(23);
		middleRing = generateTumblers(23);
		innerRing = generateTumblers(23);
		Collections.shuffle(outerRing, new Random(1234));
		Collections.shuffle(middleRing, new Random(456));
		Collections.shuffle(innerRing, new Random(987));
		outerRing = Collections.unmodifiableList(outerRing);
		middleRing = Collections.unmodifiableList(middleRing);
		innerRing = Collections.unmodifiableList(innerRing);
	}
	
	private List<Tumbler> generateTumblers(int size) {
		List<Tumbler> tumblers = new ArrayList<>();
		for(int i = 0; i < size; i++){
			tumblers.add(new Tumbler(String.valueOf((char)('a' + i))));
		}
		
		return tumblers;
	}
	
	public class Tumbler {
		
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof Tumbler)) {
				return false;
			}
			return this.name.equals(((Tumbler)obj).name);
		}
		public String name;
		
		public Tumbler(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return String.valueOf(name);
		}
	}
	
	/**
	 * This really calculates the password, I just need to obfuscate the name 
	 * @param hitCount
	 */
	private String spinTumblers() {
		String passwordString = "";
		for(int midIdx = 0; midIdx < middleRing.size(); midIdx++) {
			for(int innerIdx = 0; innerIdx < innerRing.size(); innerIdx++) {
				if(outerRing.get(22).equals(middleRing.get(midIdx)) && middleRing.get(midIdx).equals(innerRing.get(innerIdx))) {
					passwordString = "22-" + midIdx + "-" + innerIdx;
				}
			}
		}
		return passwordString;
	}

	// expected password 22-15-9
	public void tryPassword(String calculatePuzzlePassword) {
		if(!spinTumblers().equals(calculatePuzzlePassword)) {
			throw new MazeException("Nope! " + calculatePuzzlePassword + " is not the Puzzle Wall Password!");
		}
		System.out.println("The puzzle wall slides open! You may procede. The next chunk is: ");
		String chunk = PasswordGenerator.getPasswordChunk(3);
		System.err.println(chunk);
		PropertyHandler.writeChunk(Constants.LabPropertyKeys.TUMBLERS, chunk);
	}
}
