//Written by: Su Win

package vehicles;

public class CargoCycle extends Bicycle {

	public CargoCycle(){
	}
	
	public CargoCycle(int wheels, double cargoSpace, String color, String type) throws VehicleException{
		super(wheels,cargoSpace, color, type);
		
		//if num of wheels are 2 or 3 or 4 assign value. Otherwise, throw vehicle exception
		if(wheels ==2 || wheels == 3 || wheels == 4) { 
			this.setWheels(wheels);
		}else {
			throw new VehicleException("CargoCycle can only have 2, 3 or 4 wheels.");
		}
		
	}

	public String Pedal() {
		return "pedaling";
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
