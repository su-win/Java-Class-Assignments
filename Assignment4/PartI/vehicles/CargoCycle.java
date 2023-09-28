//Written by: Su Win

package vehicles;

public class CargoCycle extends Bicycle{

	/*In the instruction, "Cargo cycles are a type of bicycle and can have 2, 3, or 4 wheels and 
	 * have cargo space. Bicycles and CargoCycles can be electric."
	 * so, set cargo space as 1. Since cargo cycle is type of bicycle, let it inherit 
	 * the number of wheels for 2 as default.
	 */
	public CargoCycle(){
		super.setCargoSpace(1);
	}
	
	public CargoCycle(int wheels, double cargoSpace, String color, String type){
		super(wheels,cargoSpace, color, type);
		if(wheels ==2 || wheels == 3 || wheels == 4) { //if num of wheels are not 2 or 3 or 4, throw exception. Otherwise assign value
			super.setWheels(wheels);
		}else {
			throw new IllegalArgumentException("CargoCycle can only have 2, 3 or 4 wheels.");
		}
		setCargoSpace(cargoSpace); //call the override setCargoSpace to check whether cargo space is valid or not
	}

	public String Pedal() {
		return "pedaling";
	}
	
	//Since instruction said "have cargo space", we assume cargo space must be greater than 0
	@Override
	public void setCargoSpace(double newcargoSpace) {
		if (newcargoSpace > 0) {//if no cargo space throw exception. If not assign it
			super.setCargoSpace(newcargoSpace);
		}else {
			throw new IllegalArgumentException("Cargo space must be greater than 0.");
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject)) return false;
		Bicycle other = (Bicycle) otherObject;
		return true;
	}
}
