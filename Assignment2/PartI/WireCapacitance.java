//Written by: Su Win

public class WireCapacitance {

	public static double calculateWireCapacitance(double l, double a, double d0, double d1) {
		
		double absolutePermittivity = 8.85E-12;
		
		double numeratorOfCapacitance = Math.PI * absolutePermittivity * l;
		double denominatorOfCapacitanceWithInitialDistance = Math.abs(Math.log( (d0/ (2.0 * a) ) 
				+ Math.sqrt( (Math.pow(d0, 2)/ (4.0 * Math.pow(a, 2))) - 1.0)));
		double cpairWithInitialDistance = numeratorOfCapacitance / denominatorOfCapacitanceWithInitialDistance;
		
		double denominatorOfCapacitanceWithFinalDistance = Math.abs(Math.log( (d1/ (2.0 * a) ) 
				+ Math.sqrt( (Math.pow(d1, 2)/ (4.0 * Math.pow(a, 2))) - 1.0)));
		double cpairWithFinalDistance = numeratorOfCapacitance / denominatorOfCapacitanceWithFinalDistance;
		
		double result =  cpairWithFinalDistance - cpairWithInitialDistance;
		
		
		return result;
	}
	
	public static void main(String[] args) {

		double l = 0.5; //wireLength
		double a = 0.002053 ; //wireRadius
		double d0 = .01; //initial distance
		double d1 = .005; //final distance
		
		System.out.println("Change in capactiance: " +  calculateWireCapacitance(l, a, d0, d1));
		
	}
}
