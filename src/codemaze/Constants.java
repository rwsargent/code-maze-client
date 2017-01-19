package codemaze;

public class Constants {
	public static interface Entrance {
		public static final String startMessage = "Welcome to the Code Maze! It has many twists and turns, and only "
				+ "your wit and trusty debugger will see you through to the end.\n"
				+ "To start off, let's see if you know who you are...";
		public static final String firstPassword = "Congratulations! Gotta know who you are before you can go anywhere. Your first password is: ";
		public static final String tail = "Enter that at cs2420-lab.eng.utah.edu";
	}
	
	public static interface Cauldron {
		public static final String GREETING = "To make it further into the maze, you need to pick the right potion to carry with you.\nBefore you are"
				+ " several groups of potions, each sorted quite nicely. Since you don't have a lot of time, you decide to do a binary search.\n"
				+ "Please debug the binarySearch method.";
	}
	
	public static interface TeaCups {
		public static final String GREETING = "Next up is Tea Cups! If you start feel dizzy, remember that you can PAUSE anything at a moment's notice."
				+ "\nNow around and around and around we go!";
	}
	
	public static interface Sphinx {
		public static final String GREETING = "You're making good progress! But before you know you it you come up agains a Cyborb Sphnix. Every maze has a Sphinx.\n"
				+ "She asks for a password, but doesn't realize you've hooked up your handy-dandy debugger to her Main Frame.\nCan you discover the password she expects?";
	}
	
	public static interface PuzzleWall {
		public static final String GREETING = "Past the Sphnix, you think you're in the clear, but you come up against a Puzzle Wall with thousands "
				+ "and thousands of possible combinations. Only one is the right answer...if only you could stop it with some condition!";
		public static final String EXPLANATION = "These three tumblers are procedurally scrambled. The Puzzle Wall opens with the proper password."
				+ "\nThe password is the index of each tumbler when all three align FOR THE SECOND TIME.\n"
				+ "Right now, the tumblers align on the first index, so the password would be '000'. The order is Outer - Middle - Inner\n"
				+ "Once given to the puzzle wall, the tumblers are predictablly scrambled. Fortunately for you, your debugger can watch the Puzzle Wall figure out the password for itself.";
	}
	
	public static interface Password {
		public static final String GREETING = "You are nearing the end...the maze has blocked your way with a solid oak door.\n"
				+ "The door will open if you say the correct password. Etched onto the door are all the possible letters\n"
				+ " other weary travelers have tried. If you can pick the right ones, you'll be sure to figure out the password!";
	}
	public static interface Fence {
		public static final String GREETING = "The way is blocked by a seemingly impenaturable chain link fence.\n"
				+ "However, you know a chain is only as strong as it's weakest link. Can you find the right one to remove?";
				
	}
	
	public static interface LabPropertyKeys {
		public static String UID = "uid";
		public static String ENTRANCE = "entrance";
		public static String BINARY = "potions";
		public static String TEA_CUPS = "spinners";
		public static String SPHINX = "sphinx";
		public static String TUMBLERS = "tumblers";
		public static String CHAIN = "chain";
		public static String PASSWORD = "password";
	}
	
	public static String MAZE_PROPERTY_FILENAME = "maze.properties";
}
