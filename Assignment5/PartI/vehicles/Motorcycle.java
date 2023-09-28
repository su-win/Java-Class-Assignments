//Written by: Su Win

package vehicles;

import java.util.ArrayList;

public class Motorcycle extends Vehicle {
		private ArrayList<String> accessories = new ArrayList<String>();
		
		public Motorcycle() {
			this.accessories = null;
		}

		public Motorcycle(ArrayList<String> accessories) {
			this();
			this.accessories = accessories;
		}
		
		public Motorcycle(int wheels, double cargoSpace, String color, ArrayList<String> accessories) throws VehicleException{
			super(wheels, cargoSpace, color);
			if(wheels != 2) {
				throw new VehicleException("Motrocycle can only have 2 wheels");
			}else{
				this.setWheels(wheels);
			}
			if (cargoSpace != 0) {
				throw new VehicleException("Motrocycle have no cargo space. It must be zero.");
			}else {
				this.setCargoSpace(cargoSpace);
			}
			this.accessories = accessories;
		}
		
		//getter & setter methods
		public ArrayList<String> getAccessories(){
			return accessories;
		}

		public void addAccessories(ArrayList<String> accessories) {
			if (accessories != null)
			this.accessories = accessories;
		}

		public String TwistThrottle() {
			return "accelerating";
		}
		
		
		@Override
		public String toString() {
			return "\n"+ super.toString() + 
					", Accessories: " + this.accessories;
		}

		@Override
		public boolean equals(Object otherObject) {
			if(!super.equals(otherObject)) return false;
			Motorcycle other = (Motorcycle) otherObject;
			return accessories == other.accessories;
		}
}
