package assignments;

public class Vowels {
	public static int countVowels(String str) {
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char character = Character.toUpperCase(str.charAt(i));
			
			if (character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U') {
				// Increment sum and print out vowel
				sum++;
				System.out.println(character);
			}
		}
		
		return sum;
	}
	

	public static void main(String[] args) {
		// Test word
		String word = "Test";
		int result;
		
		// Intro message
		System.out.println("Counting the vowels in the word: " + word);
		System.out.println();
		
		result = countVowels(word);
		
		// Horizontal rule
		System.out.println("------");
		
		System.out.println("Total: " + result);
	}
}
