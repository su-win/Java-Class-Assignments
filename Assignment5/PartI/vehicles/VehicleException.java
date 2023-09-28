//Written by: Su Win

/*	These are the rules that we define in different vehicles.
	car doors cannot be less than 2
	car doors must be 2 or 4
	car wheels must be 4
	Motorcycle have 2 wheels
	Motorcycle have 0 cargo space
	Cargo cycle have 2 /3/ 4 wheels	*/

package vehicles;

public class VehicleException extends Exception{

	/*	•	Cargo space can never be negative
		•	Cars cannot have fewer than 2 doors
		b.	Ensure that the constructor accepts a String argument which is passed up to the Exception superclass
		c.	Throw a VehicleException when any of the three “illegal” conditions are raised. 
		d.	The VehicleException should have a message explaining the error. (eg, “cargoSpace cannot be negative”)
	*/

	private static final long serialVersionUID = 1L;

	//construct exception
	public VehicleException(String message) {
		super(message);
	}
	
	
}


