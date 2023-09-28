//Written by: Su Win

import java.util.Arrays;

class FindMinimumLength {
    public static int minSubArrayLen(int goal, int[] nums) {
        
    	int sum = 0;
    	int minimumLength = Integer.MAX_VALUE; //initialize Integer.Max_Value as minimum length
    	int start = 0;
    	int arrayLength = nums.length; //initialize array length

    	//loop the array
    	for(int i = 0; i < arrayLength; i++) {
    		
    		sum += nums[i];
    		
    		//when sum is greater than or equal to goal
    		while(sum >= goal) {
    			
    			//calculate and update minimumLength
    			minimumLength = Math.min(minimumLength, i - start + 1);
    			
    			//decrease sum from starting of an array until sum is equal or greater than goal
    			//and increase start pointer
    			sum -= nums[start];
    			start++;
    		}
    	}
    	
    	
    	//if minimum length is equal to initialize value
    	//it means minimum length is not found. So, return 0
    	//otherwise return minimum length
    	if(minimumLength == Integer.MAX_VALUE) {
    		return 0;
    	}else {
    		return minimumLength;
    	}
        
    }
    
    public static void main(String[] args) {
    	int[] array1 = {10,2,3,11};
    	System.out.println("Array1 is " + Arrays.toString(array1) +
    						". Goal is 11 and minimum length subarray is " + 
    						minSubArrayLen(11, array1));
    	
    	int[] array2 = {5, 6, 8, 2};
    	System.out.println("\nArray2 is " + Arrays.toString(array2) +
							". Goal is 7 and minimum length subarray is " + 
							minSubArrayLen(7, array2));
    	
    	int[] array3 = {1, 0, 1, 1};
    	System.out.println("\nArray3 is " + Arrays.toString(array3) +
    						". Goal is 5 and minimum length subarray is " + 
    						minSubArrayLen(5, array3));
    	
    	int[] array4 = {1, 3, 4, 2, 1};
    	System.out.println("\nArray4 is " + Arrays.toString(array4) +
							". Goal is 9 and minimum length subarray is " + 
							minSubArrayLen(9, array4));
    }
}
