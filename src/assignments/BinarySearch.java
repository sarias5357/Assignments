package assignments;

import java.util.Scanner;

/**
 * Implementing a binary search using recursion
 */

public class BinarySearch {

	public static void main(String[] args) {
		// Store values
		int value;
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 
				13, 14,15, 16, 17, 18, 19, 20, 21, 22, 23, 
				24, 25, 26, 27, 28, 29, 30 };
		
		Scanner scan = new Scanner(System.in);
		
		// Get value to search for
		System.out.print("Enter the number you would like to search for: ");
		value = scan.nextInt();
		
		// Call isMember method and display results
		if (isMember(value, arr, 0, arr.length - 1) == true) 
			System.out.println(value + " is a member");
		else
			System.out.println(value + " is not a member");

		scan.close();
		System.exit(0);
	}
	
	/**
	 * Binary search
	 * @param n Value to look for
	 * @param arr Integer array
	 * @param start Starting value of array
	 * @param end Ending value of array
	 * @return Whether or not the value is in the array
	 */
	
	public static boolean isMember(int n, int[] arr, int start, int end) {
		// Middle number is the first number added by the last number divided by 2
		int middle = (start + end) / 2;
		
		// If the first number is greater than the end number, return false
		if (start > end)
			return false;
		
		// If the middle value IS the value, return true
		if (arr[middle] == n) 
			return true;
		// Otherwise if the middle is less than the value you are searching for, 
		// call the method again using middle + 1 as the start 
		else if (arr[middle] < n) {
			return isMember(n, arr, middle + 1, end);
		}
		// If the middle is greater than the value searching for, call the method again
		// using middle - 1 as the end
		else
			return isMember(n, arr, start, middle - 1);
	}

}
