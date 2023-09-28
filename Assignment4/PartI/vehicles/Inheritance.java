//Written by: Su Win

package vehicles;
import java.util.ArrayList;

public class Inheritance {

	public static void main(String[] args) {
	
		Vehicle defaultCar = new Car();
		System.out.println(defaultCar.toString());

		Vehicle blueCar = new Car(4,20.0,"blue",4); //if not 2 or 4 doors, show IllegalArgumentException
		System.out.println(blueCar.toString());

		System.out.println();
		Vehicle defaultBicycle = new Bicycle();
		System.out.println(defaultBicycle.toString());
		
		Vehicle testbicycle = new Bicycle(2, 3, "blue", null);
		System.out.println(testbicycle.toString());

		System.out.println();
		Vehicle dafaultMotorcycle = new Motorcycle();
		System.out.println(dafaultMotorcycle.toString());
				
		ArrayList <String> accessories = new ArrayList<String>();
		accessories.add("helmet");
		accessories.add("mirror");
		Vehicle testMotorcycle = new Motorcycle(2, 0, "blue", null);
		System.out.println(testMotorcycle.toString());
		
		System.out.println();
		Vehicle cargoDefault = new CargoCycle();
		System.out.println(cargoDefault.toString());
		
		Vehicle testCargoCycle = new CargoCycle(2,1,"blue","electric");
		System.out.println(testCargoCycle.toString());

	}

}
