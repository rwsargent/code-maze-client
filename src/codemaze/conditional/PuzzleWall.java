package codemaze.conditional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;

import codemaze.Constants;
import codemaze.MazeException;
import codemaze.PasswordGenerator;
import codemaze.PropertyHandler;

public class PuzzleWall {
	private String passwordString; 
	
	public PuzzleWall() {
		
	}
	
	public List<Tumbler> generateTumblers(int size) {
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

	public void tumble(List<Tumbler> outerRing, List<Tumbler> middleRing, List<Tumbler> innerRing, BiFunction<List<Tumbler>[], String, Boolean> object) {
		
	}

	public void scrambleTumblers(List<Tumbler> outerRing, List<Tumbler> middleRing, List<Tumbler> innerRing) {
		int hitCount = 0;
		Collections.shuffle(outerRing, new Random(1234));
		Collections.shuffle(middleRing, new Random(456));
		Collections.shuffle(innerRing, new Random(987));
		
		loop:
		for(int outIdx = 0; outIdx < outerRing.size(); outIdx++) {
			for(int midIdx = 0; midIdx < middleRing.size(); midIdx++) {
				for(int innerIdx = 0; innerIdx < innerRing.size(); innerIdx++) {
					if(outerRing.get(outIdx).equals(middleRing.get(midIdx)) && middleRing.get(midIdx).equals(innerRing.get(innerIdx))) {
						passwordString = "" + outIdx + midIdx + innerIdx;
						hitCount++;
						if(hitCount >= 2) {
							break loop;
						}
					}
				}
			}
		}
	}

	public void tryPassword(String calculatePuzzlePassword) {
		if(!passwordString.equals(calculatePuzzlePassword)) {
			throw new MazeException("Nope! " + calculatePuzzlePassword + " is not the Puzzle Wall Password!");
		}
		System.out.println("The puzzle wall slides open! You may procede. The next chunk is: ");
		String chunk = PasswordGenerator.getPasswordChunk(3);
		System.err.println(chunk);
		PropertyHandler.writeChunk(Constants.LabPropertyKeys.TUMBLERS, chunk);
	}
}
