package codemaze.classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import codemaze.Constants;
import codemaze.MazeException;
import codemaze.PasswordGenerator;
import codemaze.PropertyHandler;

public class Password {
	public static void main(String[] args) {
		List<String> passLetters = getPassletters();
		String password = "BeLoud";
		List<Integer> ind = new ArrayList<>();
		password.chars().forEach(c -> {
			for(int i = 0; i < passLetters.size(); i++) {
				if(passLetters.get(i).equals(String.valueOf((char)c))) {
					System.out.println(i);
					ind.add(i);
					continue;
				}
			}
		});
		System.out.println(ind);
		System.out.println(passLetters);
	}
	
	public static List<String> getPassletters() {
		List<String> letters = new ArrayList<>();
		for(int i = 0; i < 26; i++) {
			letters.add(String.valueOf((char)('a' + i)));
		}
		for(int i = 0; i< 26; i++) {
			letters.add(String.valueOf((char)('A' + i)));
		}
		Collections.shuffle(letters, new Random(1));
		return letters;
	}
	
	public static String getPassword() { 
		return "BeLoud";
	}

	public static void checkPassword(int[] passwordIndecies) {
		int[] solution = new int[] {36, 45, 39, 47, 35, 30};
		if(!Arrays.equals(solution, passwordIndecies)) {
			throw new MazeException("Those aren't the right indecies!");
		}
		
		System.out.println("The password was accepted! Proceed...\nYour password is: " );
		String chunk = PasswordGenerator.getPasswordChunk(5);
		System.err.println(chunk + "\n");
		PropertyHandler.writeChunk(Constants.LabPropertyKeys.PASSWORD, chunk);
	}
}
