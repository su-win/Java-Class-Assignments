//Written by: Su Win

package arraylists;

import java.util.ArrayList;

import vehicles.*;

public class VehicleArraylist {

	public static void main(String[] args) {
		// this ArrayList MUST be parameterized
		ArrayList<Vehicle> vehicleList = new ArrayList<>();

//1 one red motorcycle with accessories “grip warmers” and “usb charger”
		ArrayList<String> accesories = new ArrayList<>();
		accesories.add("grip warmers");
		accesories.add("usb charger");
		vehicleList.add(new Motorcycle(2, 0, "red", accesories));
				
//2 blue cars with 4 doors and 20 cubic feet of cargo space
		vehicleList.add(new Car(4, 20, "blue", 4));
		vehicleList.add(new Car(4, 20, "blue", 4));
		
//1 black bicycle
//we assume this bicycle is electric so build the object with electric type
		vehicleList.add(new Bicycle(2, 0, "Black", "electric"));
		
//2 green cargoCycle with 3 wheels and 10 cubic feet of cargo space
//we assume this CargoCycle is electric so build the object with electric type
		vehicleList.add(new CargoCycle(3, 10, "green","electric"));
		vehicleList.add(new CargoCycle(3, 10, "green","electric"));
		
//1 gray car with 2 doors and 10 cubic feet of cargo space
		vehicleList.add(new Car(4, 10, "gray", 2));
		
//1 white car with 4 doors and 25 cubic feet of cargo space
		vehicleList.add(new Car(4, 25, "white", 4));
		
		System.out.println(vehicleList);//print out all vehicles in ArrayList
		
/*b.Print out the average cargo space of all the Car objects in the ArrayList.*/
		double carTotalCargoSpace = 0.0;
		int count = 0;
		for (int i = 0; i < vehicleList.size(); i++) {
			if(vehicleList.get(i) instanceof Car) {
				carTotalCargoSpace = carTotalCargoSpace + ((Car)vehicleList.get(i)).getCargoSpace();
				count++;
			}
		}
		double avgCargoSpace = carTotalCargoSpace/count;
		System.out.println("\nAverage cargo space for all Car Objects: " + avgCargoSpace + "\n");
		
/*c.Remove the matching objects*/
		// this is the variable you should retain to compare
		// to the other objects in the ArrayList
		//Car blueCar;
		
		Car blueCar = (Car)vehicleList.get(1);
		//System.out.println("\nRetain test:" + blueCar);
		for (int i = 0; i < vehicleList.size(); i++) {//loop through vehicleList ArrayList
			if(vehicleList.get(i) instanceof Car) {
				//print out which object in the ArrayList is the same object as the one in your variable.
				if(vehicleList.get(i)==blueCar) {
					System.out.println("\nSame object: " + vehicleList.get(i).toString());
				}
				
	//print out object equal in value: same color, doors, wheels, cargo space. And remove it
				if((vehicleList.get(i)).equals(blueCar)) {
					System.out.println("\nEqual object: " + vehicleList.get(i).toString());
					vehicleList.remove(i);
					i--;
					System.out.println("Removed equal in value object.\n");
				}
			}
		}

/*d.Print out the remaining objects: Loop through again and use toString*/
		System.out.println("\nRemaining Objects: ");
		for (int i = 0; i < vehicleList.size(); i++) {
			System.out.println(vehicleList.get(i).toString());
		}
	}
}


