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
}
