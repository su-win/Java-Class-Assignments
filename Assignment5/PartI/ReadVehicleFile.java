//Written by: Su Win

import java.io.*;
import java.util.ArrayList;
import vehicles.*;

/* created a class called VehicleException
 * createVehicle should throw a VehicleException
 * catch the VehicleException in main
 */

public class ReadVehicleFile {
	
	//Implement createVehicle to return the appropriate employee depending on the input string
	public static Vehicle createVehicle(String vehicleName)throws VehicleException{
		
		/* if vehicleName is "Motorcycle" return Motorcycle();
		 * if vehicleName is "Car" return Car();
		 * if vehicleName is "Bicycle" return Bicycle();
		 * if vehicleName is "CargoCycle" return CargoCycle();
		 * if it is not any one of these, it should throw a VehicleException
		 */
		if (vehicleName.equals("Motorcycle")) {
			return new Motorcycle();
		}else if (vehicleName.equals("Car")) {
			return new Car();
		}else if (vehicleName.equals("Bicycle")) {
			return new Bicycle();
		}else if (vehicleName.equals("CargoCycle")) {
			return new CargoCycle();
		}else {
			throw new VehicleException(". This vehicle type is not known.");
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		String inString = null;

		/* create a loop to read the file line-by-line */
		try{
			FileReader f = new FileReader("vehicles.txt");
			BufferedReader reader = new BufferedReader(f); 
			
			inString = reader.readLine();
			
			while(inString!=null) {
				try {
					Vehicle v = createVehicle(inString);
					vehicleList.add(v);
				}catch(VehicleException ve) {
					System.err.println("Cannot create Vehicle: " + inString + ve.getMessage());
				}
				inString = reader.readLine();
			}
			reader.close();
		}catch(IOException ioe) {
    		System.err.println(ioe.getMessage());
		}
		
		for(int i=0; i<vehicleList.size(); i++) {
			System.out.println(vehicleList.get(i));
		}
		
		System.out.println("\nVehicle list size: " + vehicleList.size());

	}
}