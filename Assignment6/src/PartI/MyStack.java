//Written by: Su Win

package PartI;

import java.util.ArrayList;

public class MyStack<E> {

	private ArrayList<E> ar;
	
	public MyStack() {
		ar = new ArrayList<E>();
	}
	
	//tests if the stack is empty
	boolean empty() { 
		return ar.isEmpty();
	}
	
	//Looks at the object at the top of the stack without removing it from the stack
	E peek() {
		return ar.get(ar.size()-1);
	}
	
	//Removes the object at the top of the stack and returns that object as the value of this function
	E pop() {
		E o = ar.get(ar.size()-1);
		ar.remove(ar.size()-1);
		return o;
	}
	
	//Pushes an item onto the top of this stack
	E push(E o) {
		ar.add(o);
		return o;
	}
	
	//Returns the 1-based position where an object is on this stack. 
	//If it is not there, then it returns -1
	int search(E o) {
		int i = ar.lastIndexOf(o);
		if(i>0) {
			return ar.size()-i;
		}
		return -1;
	}
	
	@Override
	public String toString() {
		return "Stack: " + ar.toString();
	}

	public static void main(String[] args) {
		MyStack<Integer> testStack = new MyStack<>();
		
		System.out.println("Empty Stack? " + testStack.empty());
		
		System.out.println("\nNow push items to the stack... ");
		testStack.push(5);
		testStack.push(14);
		testStack.push(25);
		testStack.push(10);
		
		
		System.out.println(testStack);

		System.out.println("\nPop from stack.");
		testStack.pop();
		
		System.out.println("After pop, "+ testStack);
		
		System.out.println("Empty Stack? " + testStack.empty());
		
		System.out.println("\nCurrent Stack: " + testStack);
		
		//If 14 is not in the stack, return -1.
		//If 14 is in the stack, return the position of 14 in the stack.
		System.out.println("Search 14 in the stack. " + testStack.search(14));
		System.out.println("Search 1 in the stack. " + testStack.search(1));
		
	}

}
