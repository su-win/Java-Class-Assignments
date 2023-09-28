//Written by: Su Win

public class SquarePyramid {
	
	//use static variable because we want to increment the id
	//whenever we create new object SquarePyramid
	private static int nextId = 0; //count the number of square pyramid we created
	private int id = 0;
	private double side = 0, height = 0;
	
	
	public static void main(String[] args) {
		

		System.out.println("Number of Square Pyramid before creating objects: " + 
							SquarePyramid.nextId);
	
		System.out.println("\n\nWe created two objects and then set the new side and height values for object 1.");
		
		//create an object
		SquarePyramid  pyramid1 = new SquarePyramid();
		
		System.out.println("\nSquare pyramid1 with side: " + pyramid1.side + " and height: " + pyramid1.height + 
							"\nVolume is " + pyramid1.getVolume() + 
							"\nSurface area is " + pyramid1.getSurfaceArea() +
							"\nCreated first object and the current number of SquarePyramid objects: " + pyramid1.getID());
		
		
		SquarePyramid  pyramid2 = new SquarePyramid(3, 4);
		
		System.out.println("\nSquare pyramid2 with side: " + pyramid2.getSide() + " and height: " + pyramid2.getHeight() + 
							"\nVolume is " + pyramid2.getVolume() + 
							"\nSurface area is " + pyramid2.getSurfaceArea() +
							"\nCreated second object and the number of SquarePyramid objects becomes " + pyramid2.getID());
		
		//modify pyramid1 with new side and height value
		pyramid1.setSide(5);
		pyramid1.setHeight(7);
		
		System.out.println("\nSquare pyramid1 with NEW side: " + pyramid1.getSide() + " and NEW height: " + pyramid1.getHeight() + 
							"\nVolume is " + pyramid1.getVolume() + 
							"\nSurface area is " + pyramid1.getSurfaceArea() +
							"\nThe current number of SquarePyramid objects is still " + pyramid2.getID());
		
	}
	

	//Constructors
	public SquarePyramid(){
		SquarePyramid.nextId++;
		this.id = SquarePyramid.nextId;
	}
	
	public SquarePyramid(double side, double height){
		this();
		this.side = side;
		this.height = height;
	}
	
	//declare instance getter methods
	public double getSide() {
		return this.side;
	}
	
	public void setSide(double side) {
		this.side = side;
	}	
	
	public double getHeight() {
		return this.height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	

	public double getVolume() {	
		return (Math.pow(side, 2) *height)/3; //return calculated volume
	}
	
	
	public double getSurfaceArea() {	//calculate surface area
		return Math.pow(side, 2) + (2*side*(Math.sqrt((Math.pow(side, 2)/4)+ Math.pow(height, 2))));
	}
	
	
	public int getID() {
		return this.id;
	}
	
	
	
}
