package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vowels {
	public static int countVowels(String str) {
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char character = Character.toUpperCase(str.charAt(i));
			
			if (character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U') {
				// Increment sum 
				sum++;
			}
		}
		
		return sum;
	}
	
	public static int countVowels(File file) throws FileNotFoundException {
		// Open file to read input
		Scanner input = new Scanner(file);
		int sum = 0;
		
		// Go through file and count vowels
		while (input.hasNext()) {
			String line = input.nextLine();
			
			sum += countVowels(line);
		}
		
		input.close();
		return sum;
	}
	

	public static void main(String[] args) throws FileNotFoundException {
		// Test word
		String word = "Test";
		int result;
		
		File file = new File("C:\\\\Users\\\\dirtt\\\\eclipse-workspace\\\\Assignments\\\\src\\\\words.txt");
		
		// Intro message
		System.out.println("Counting the vowels in the word: " + word);
		
		result = countVowels(word);
		System.out.println("Total: " + result);
		System.out.println();
		
		System.out.println("Counting the vowels in the file: words.txt");
		System.out.println("Total: " + countVowels(file));
	}
}
