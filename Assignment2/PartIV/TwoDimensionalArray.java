//Written by: Su Win

import java.util.Arrays;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		
		int[][] twoDimArray = new int[2][5]; //creating empty 2D array with 2 rows and 5 columns
		int[] arrayOne = {5, 9, 55, 23, 89};
		int[] arrayTwo = {15, 3, 23, 19, 64};
		
		//use deepToString method to print array with more than one dimension
		System.out.println("Initial value of 2D array: " + Arrays.deepToString(twoDimArray));
		
		/* copy arrayOne and arrayTwo into twoDimArray */
		/* print out the first list of 5 numbers in twoDimArray
		 * on one line, and the second list of 5 numbers in twoDimArray
		 * on the next line
		 */
		
		//copy two arrays to 2D array using nested loop
		for (int i = 0; i < twoDimArray.length; i++) {
		    for (int j = 0; j < twoDimArray[0].length; j++) {
		    	if(i==0) { //if row is one, insert arrayOne into first row of 2D array
					twoDimArray[i][j] = arrayOne[j];
				}
				else if(i==1){ //if second row, insert arrayTwo into second row of 2D array
					twoDimArray[i][j] = arrayTwo[j];
				}
		    }
		}
		
		//using toString() method
		System.out.println("\nFirst list of 5 numbers in two dimensional array: " + Arrays.toString(twoDimArray[0]));
		System.out.println("Second list of 5 numbers in two dimensional array: " + Arrays.toString(twoDimArray[1])+"\n");


		//print out 2D array
		for (int i = 0; i < twoDimArray.length; i++) { 	//loop to loop over row in 2D array
            for (int j = 0; j < twoDimArray[i].length; j++) { //loop to loop over each element inside that row
                System.out.print(twoDimArray[i][j] + " ");
            }
            System.out.println();
        }
	
		System.out.println("\ntwoDimArray is " + Arrays.deepToString(twoDimArray));
	}
}