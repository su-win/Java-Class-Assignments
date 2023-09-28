//Written by: Su Win

import java.util.Scanner;

public class BoxingWeightClass {

	public static String findWeightClass(float weight) {
		
		String weightClass_Name = "";
		
		// this is really only valid for weights greater than 0.
		if(weight <= 108){
			weightClass_Name = "light flyweight"; //weight that is less than and equal 108
		}else if (weight <= 115){
			weightClass_Name = "flyweight"; //weight that is less than and equal 115
		}else if (weight <= 123){
			weightClass_Name = "bantamweight"; //weight that is less than and equal 123
		}else if (weight <= 132){
			weightClass_Name = "lightweight"; //weight that is less than and equal 132
		}else if (weight <= 141){
			weightClass_Name = "light welterweight"; //weight that is less than and equal 141
		}else if (weight <= 152){
			weightClass_Name = "welterweight"; //weight that is less than and equal 152
		}else if (weight <= 165){
			weightClass_Name = "middleweight"; //weight that is less than and equal 165
		}else if (weight <= 178){
			weightClass_Name = "Light heavyweight"; //weight that is less than and equal 178
		}else if (weight <= 201){
			weightClass_Name = "Heavyweight"; //weight that is less than and equal 201
		}else {
			weightClass_Name = "Super heavyweight"; //weight that is greater than 201
		}
		
		return weightClass_Name;
		
	}
	
	public static void main(String[] args) {
		
		System.out.print("Enter your weight: ");
		Scanner input = new Scanner(System.in);
		
		//read float value from user
		float weight = input.nextFloat();	
		
		if (weight < 1) {
			//if weight is less than 0, print input error
			System.out.println("Input invalid. Weight value must be greater than Zero.");
		}else {
			// if the digits are greater than zero print this out:
			String weightClass = findWeightClass(weight);
			System.out.println("The weight class for the weight " + weight + " is " 
					+ weightClass + ".");
		}
		
		//closing the scanner
		input.close();
	}
}



