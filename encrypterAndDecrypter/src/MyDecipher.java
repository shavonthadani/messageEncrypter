

import java.util.Scanner;

public class MyDecipher {
	public static String decipheredMessage = "";
	public static String encryptedMessage = "";
	private static Scanner input = new Scanner(System.in);

	/**
	 * This method asks the user for their message that they want to be deciphered.
	 *
	 * Example:
	 * 
	 * if user enters "23434 234 543 758" then userInput = "23434 234 543 758".
	 * 
	 * @return returns the variable encryptedMessage which stores the user's input
	 */
	private static String encryptedMessage() {
		System.out.println("enter your encrytped message");
		encryptedMessage = input.nextLine();
		if (encryptedMessage.equals("")) {
			System.out.println("Did not enter anything. Please enter your message");
			encryptedMessage();
		}
		return encryptedMessage;
	}

	/**
	 * method roots all the ASSCII code using the key and converts it all back to
	 * chars and a string accumulates those chars to form the deciphered message
	 * 
	 * @param key an integer that roots the encrypted message
	 * @return returns deciphered variable which is the final deciphered variable
	 */
	private static String unkey(int key) {
		String letter = "";
		int uniCode = 0;
		String deciphered = "";
		double fraction = 0;
		double fractionValue = 0;
		double decimal = 0;
		double value = 0;
		fraction = (double) 1 / key;
		fractionValue = (double) (fraction * 10);
		decimal = fractionValue % 10;
		value = decimal * 0.1;
		for (int i = 0; i < encryptedMessage.length(); i++) {
			char ch = encryptedMessage.charAt(i);
			if (ch != ' ') {
				letter = letter + ch;
				try {
					uniCode = Integer.parseInt(letter);
				} catch (Exception e) {
					System.out.println("invalid characters, only numbers");
					System.exit(0);
				}
				uniCode = (int) Math.pow(uniCode, value);
				char cha = (char) uniCode;
				deciphered = deciphered + cha;
				deciphered = deciphered.replaceAll("\\W+", "");
			} else {
				letter = "";
			}
		}
		return deciphered;
	}

	public static void main(String[] args) {
		encryptedMessage();
		System.out.println(unkey(2));
	}
}