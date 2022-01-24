package assignments;

import javax.swing.JOptionPane;

/**
 * Determines whether or not a 2D array is a Lo Shu Magic Square
 */

public class LoShu {

	public static void main(String[] args) {
		// Store values, create array
		final int ROWS = 3, COLUMNS = 3;
		String input;
		int[][] square = new int[ROWS][COLUMNS];
		boolean rowEquality, columnEquality, diagonalEquality;

		// Get numbers 
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				input = JOptionPane.showInputDialog("Row " + (i + 1) + "\n"
						+ "Enter a number");
				square[i][j] = Integer.parseInt(input);
			}
		}
		
		// Find equality across rows, columns, and diagonals 
		rowEquality = evaluateRows(square, ROWS, COLUMNS);
		columnEquality = evaluateColumns(square, ROWS, COLUMNS);
		diagonalEquality = evaluateDiagonals(square, ROWS, COLUMNS);
		
		
		// Display results
		if (rowEquality == true)
			if (columnEquality == true)
				if (diagonalEquality == true) {
					JOptionPane.showMessageDialog(null, "Array is a Lo Shu Magic Square");
					System.exit(0);
				}

		JOptionPane.showMessageDialog(null, "Array is not a Lo Shu Magic Square");
		System.exit(0);
	}
	
	/**
	 * This method returns whether or not the sum of each row is equal to each other
	 * @param arr 3x3 square of values
	 * @param ROWS 3 rows
	 * @param COLUMNS 3 columns
	 * @return Whether or not the sum of each row is equal to each other
	 */
	
	public static boolean evaluateRows(int[][] arr, int ROWS, int COLUMNS) {
		boolean flag = false;
		int[] rowSum = new int[3]; // Create array of sums for rows
		int sum, j = 0;
		
		// Loop across rows and add each column value to the sum variable
		for (int i = 0; i < ROWS; i++) {
			sum = 0; // Reset to 0 
			
			for (j = 0; j < COLUMNS; j++) {
				sum += arr[i][j];
			}
			
			// Store sum in array of row sums
			rowSum[i] = sum;
		}
		
		// If the sums of each row are equal to each other, flag is switched to true
		if (rowSum[0] == rowSum[1] && rowSum[0] == rowSum[2]) 
			flag = true;
		
		return flag;
	}
	
	/**
	 * This method returns whether or not the sum of each column is equal to each other
	 * @param arr 3x3 square of values
	 * @param ROWS 3 rows
	 * @param COLUMNS 3 columns
	 * @return Whether or not the sum of each column is equal to each other
	 */
	
	public static boolean evaluateColumns(int[][] arr, int ROWS, int COLUMNS) {
		boolean flag = false;
		int[] columnSum = new int[3]; // Create array of sums for columns
		int sum, j = 0;
		
		// Loop through each column and add values to sum
		for (int i = 0; i < COLUMNS; i++) {
			sum = 0; // Reset sum to 0
			
			for (j = 0; j < ROWS; j++) {
				sum += arr[j][i];
			}
		
			// Store sum in array
			columnSum[i] = sum;
		}

		// Compare 3 sums
		if (columnSum[0] == columnSum[1] && columnSum[0] == columnSum[2]) 
			flag = true;
		
		return flag;
	}
	
	/**
	 * This method returns whether or not the sum of each diagonal is equal to each other
	 * @param arr 3x3 square of values
	 * @param ROWS 3 rows
	 * @param COLUMNS 3 columns
	 * @return Whether or not the sum of each diagonal is equal to each other
	 */
	
	public static boolean evaluateDiagonals(int[][] arr, int ROWS, int COLUMNS) {
		boolean flag = false;
		int[] diagonalSum = new int[2]; // Create array of sums for diagonals
		int sum = 0, i = 0, j = 2;
		
		// Find sum of first diagonal
		for (i = 0; i < 3; i++) {
				sum += arr[i][i];
			}
		
		// Store sum
		diagonalSum[0] = sum;
		
		sum = 0; // Reset
		
		// Find sum of second diagonal
		for (i = 0; i < 3; i++) {
			sum += arr[i][j];
			j--;
		}
		
		// Store sum
		diagonalSum[1] = sum;
		
		// Compare
		if (diagonalSum[1] == diagonalSum[0])
			flag = true;
		
		return flag;
	}

}