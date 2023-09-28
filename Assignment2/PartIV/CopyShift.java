//Written by: Su Win

import java.util.Arrays;

public class CopyShift {

	public static void copyShift(int[] sourceArray, int[] destArray, int shift) {
		
		//copy element from source array to destination array using for loop
		for(int i = 0; i < sourceArray.length; i++) {
			
			//for new position, adding counter i with shift and divide length of source array
			int newPosition = (shift+i)%sourceArray.length; 
			destArray[newPosition]=sourceArray[i];
			
		}
		
		System.out.println("Destination Array: " + Arrays.toString(destArray));
	}
	
	public static void main(String[] args) {
		
		int[] sourceArray = new int[50];
		int[] destArray = new int[50];
		
		/* initialize the source Array */
		for (int i = 0;i < sourceArray.length; i++) {
			sourceArray[i] = (int)(Math.random()*100);
		}
		
		System.out.println("Source Array: " + Arrays.toString(sourceArray));
		
		int shiftValue = 3;
		copyShift(sourceArray, destArray, shiftValue);
		
	}
}
