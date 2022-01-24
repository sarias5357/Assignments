package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {
	public static int countWords(String x) {
		String[] newX;
		newX = x.split("\\W+");
		
		return newX.length;
	}
	
	public static int countWords(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		String[] str;
		int sum = 0;
		
		while (input.hasNext()) {
			str = input.nextLine().split("\\W+");
			
			sum += str.length;
		}
		
		input.close();
		return sum;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\dirtt\\eclipse-workspace\\Assignments\\src\\words.txt");
				
		try {
			System.out.println(countWords(file));
		}
		catch (FileNotFoundException e) {
			System.out.println("Invalid file");
			System.exit(0);
		}
		finally {
			System.out.println(countWords("hello, my name is steven!"));
		}
	}
}
