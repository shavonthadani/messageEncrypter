

import java.util.Scanner;

public class MyEncrypterVersion {
	private static Scanner input = new Scanner(System.in);
	public static String usersInput;
	public static String alphaShifter = "";

	/**
	 * method asks user for their message and stores it in a variable Example:
	 * 
	 * if user enters "hello world" then userInput = "hello world".
	 * 
	 * @return returns the variable usersInput which stores the user's input
	 */
	private static String usersInput() {
		System.out.println("please enter your message");
		usersInput = input.nextLine();
		usersInput = usersInput.replaceAll("\\W+", "");
		if (usersInput.equals("")) {
			System.out.println("Did not enter anything or entered special characters.");
			usersInput();
		}
		return usersInput;
	}

	/**
	 * this method converts characters into a ASCII code and puts it to the power of
	 * the key Example: user enters "A" ASCII code is 65
	 * 
	 * @param key is an integer that will be the exponent to the ASCII code
	 * @return returns alphaShifter which is the variable containing the final
	 *         encrypted message
	 */
	private static String toUnicode(int key) {
		int unicode = 0;
		for (int i = 0; i < usersInput.length(); i++) {
			char ch = usersInput.charAt(i);
			unicode = ((int) (ch));
			unicode = (int) Math.pow(unicode, Math.abs(key));
			alphaShifter = alphaShifter + unicode + " ";
		}
		return alphaShifter;
	}

	public static void main(String[] args) {
		usersInput();
		toUnicode(2);
		// test cases
		// hello world
		// enter a number
		// enter nothing
		System.out.println("your encrypted message is: " + alphaShifter);
	}
}
