package assignments;

import java.util.Scanner;

public class WordCount {
	public static int countWords(String x) {
		String[] newX;
		newX = x.split("[^a-zA-Z\\d\\s:]");
		
		return newX.length;
	}
	
	public static int countWords(File file) {
		Scanner input = new Scanner(file);
		
		while (input.hasNext()) {
			
		}
	}
}
