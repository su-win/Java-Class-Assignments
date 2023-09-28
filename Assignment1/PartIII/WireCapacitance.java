//Written by: Su Win
public class WireCapacitance {
	
	public static void main(String[] arguments) {
		double absolutePermittivity = 8.85E-12;
		double initialDistance = .01;
		double finalDistance = .005;
		double wireLength = 0.5;
		double wireRadius = .002053;
		
		
		//Numerator of Capacitance Pair Formula
		double numeratorOfCapacitance = Math.PI * absolutePermittivity * wireLength;
		
		
		//Denominator of Capacitance Pair Formula with Initial Distance
		double denominatorOfCapacitanceWithInitialDistance = Math.log( (initialDistance/ (2.0 * wireRadius) ) 
				+ Math.sqrt( (Math.pow(initialDistance, 2)/ (4.0 * Math.pow(wireRadius, 2))) - 1.0));

		//Calculate the Capacitance of a pair with initial distance: 0.01
		double cpairWithInitialDistance = numeratorOfCapacitance / denominatorOfCapacitanceWithInitialDistance;
		System.out.println("Cpair with intial distance: " + cpairWithInitialDistance); //9.037606135891814E-12
		
		
		//Denominator of Capacitance Pair Formula with Final Distance
		double denominatorOfCapacitanceWithFinalDistance = Math.log( (finalDistance/ (2.0 * wireRadius) ) 
				+ Math.sqrt( (Math.pow(finalDistance, 2)/ (4.0 * Math.pow(wireRadius, 2))) - 1.0));
		
		
		//Calculate the Capacitance of a pair with final distance: 0.005
		double cpairWithFinalDistance = numeratorOfCapacitance / denominatorOfCapacitanceWithFinalDistance;
		System.out.println("Cpair with final distance: " + cpairWithFinalDistance); //2.143738783
		
		
		//Calculate the capacitance difference between initial distance and final distance
		double capacitanceDifference =  cpairWithFinalDistance - cpairWithInitialDistance;
	
		
		System.out.println("The wires' change in capacity when moved from a distance of "
		 		+  + initialDistance + " m to " + finalDistance + " m is " + capacitanceDifference + " farads");
	
        
	}
}

