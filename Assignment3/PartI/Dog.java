//Written by: Su Win

public class Dog {
        private int age;
        private String owner;
        private String breed;

        //No-argument Constructor
        public Dog(){
        	this.age=0;
        	this.owner="not known";
        	this.breed="not known";
        }
        
        
        public Dog(int age, String owner, String breed){
        	this.age = age;
        	this.owner = owner;
        	this.breed = breed;
        }

        
        //Methods
        
        //compares two instances of the class Dog,
        //returns boolean value true if they have same owner;
        //false if they do not have same owner
        public static boolean hasSameOwner(Dog d1, Dog d2) {
        	return (d1.owner == d2.owner);
        }
      
        
        public static double avgAge(Dog[] dogs) {
        	double sum = 0;
        	for (int i = 0; i < dogs.length; i++) {
        		sum = dogs[i].age + sum;
        	}
        	double result = sum/dogs.length;
        	return result;
        }
       
        
        public int getAge() {
        	return this.age;
        }
  
        public void setAge(int age) {
        	this.age = age;
        }

        
        public String getOwner() {
        	return this.owner;
        }
        
        public void setOwner(String owner) {
        	this.owner = owner;
        }
        
        
        public String getBreed() {
        	return this.breed;
        }
     
        public void setBreed(String breed) {
        	this.breed =  breed;
        }
        
        public String toString() {	//return a String with breed, owner and age
        	return this.breed+
        			": Owner: " + this.owner +
        			", Age: " + this.age;
        }
        
        public static void main(String[] args) {
                
                Dog[] dogs = new Dog[5];
                dogs[0] = new Dog(4, "Stephen Colbert", "Boxer"); // age, owner, breed
                dogs[1] = new Dog(5, "Su Win", "Husky");
                dogs[2] = new Dog(3, "Thet Wai", "Pomeranian");
                dogs[3] = new Dog(6, "Taylor Swift", "Chihuahua");
                dogs[4] = new Dog(8, "Trevor Noah", "Dalmatians");
                
                System.out.println("dogs[1] owns by " + dogs[1].getOwner() + 
                					"\ndogs[4] owns by " + dogs[4].getOwner());
                System.out.println("So, hasSameOwner method returns " + Dog.hasSameOwner(dogs[1], dogs[4]));
                
                System.out.println("\ndogs[4] owner: " + dogs[4].getOwner() +
                					" gave his dog to his friend.");
                
                dogs[4].setOwner("Su Win");
                
                System.out.println("After giving his dog, dogs[4]'s new owner name is : " + dogs[4].getOwner());
                
                System.out.println("\nNow, dogs[1] and dogs[4] have same owner." +
                					"\nSo, hasSameOwner method returns " + Dog.hasSameOwner(dogs[1], dogs[4]));
                
               
                System.out.println("\nAverage age: " + Dog.avgAge(dogs) + "\n");

               
                //(e) return a string with format
                System.out.println(dogs[2].toString());
                
                //(f) for this question, we could either create object with
                //no-argument constructor or argument constructor
                
                //create with no argument constructor and the set the age, owner and breed
                Dog newDog = new Dog();
                newDog.setAge(8);
                newDog.setOwner("Dexter Morgan");
                newDog.setBreed("Corgi");
                
                //create with argument constructor 
                //Dog newDog = new Dog(8,"Dexter Morgan","Corgi");
                
                System.out.println("\n" + newDog.toString());
                
               
        }
}