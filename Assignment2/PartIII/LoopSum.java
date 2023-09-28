//Written by: Su Win

public class LoopSum {
	
	public static int factorial(int num) {
		int fact=1;
		for(int i=1; i <= num; i++) {
			fact *= i;
		}
		return fact;
	}

	
	public static double[] estimateExponential(double z) {
		final int numOfTrials = 1000;
		int numberOfIterations = 0;
	    double calculation = 0, result = 0, estimateResult = 0;
	    double[] answer = new double[2];
	    
	    //iterate until less than number of trials 
	    for(int k=0; k < numOfTrials; k++) {
	    	calculation = Math.pow(z,k)/factorial(k);
	    	result += calculation;
	    	
	    	double differences =  result - (Math.pow(Math.E, z)); //calculate difference between actual and estimate result
	    	
	    	//save the estimate result and number of iterations if less than equal 0.001
	    	if (differences <= .001) {
	    		estimateResult = result;
	    		numberOfIterations++;
	    	}else {
	    		break;
	    	}
	    	 
	    }
	    
	    // number of iterations for estimate result
        answer[0] = numberOfIterations;
        answer[1] = estimateResult;
		
		return answer;
	}
	
	public static void main(String[] args) {	

		double actual = 0;
		double[] estimate = new double[2];

		//iterate z for 0 to 15
		for(int z = 0; z <=15; z++) {
			actual = Math.pow(Math.E, z);
			estimate = estimateExponential(z);
			
			System.out.println("e^"+ z + " is " + actual +
								"\nresult for " + estimate[0] + " iterations: " + estimate[1] +
								"\nit requires " + estimate[0] + " iterations to estimate e^" + z + " within .001\n");
		}
		
	}
	
}
