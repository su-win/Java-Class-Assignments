//Written by: Su Win

package PartII;

import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {
	
	private static final long serialVersionUID = 1L;


	public Set<E> intersection(Set<E> s2) {
		Set<E> set = new MathSet<E>();
		for(E e2: s2) {
			for(E e1: this) {
				if(e1 == e2)
					set.add(e2);
			}
		}
		return set;
    }
    
    public Set<E> union(Set<E> s2) {
    	Set<E> set = new MathSet<E>();
    	set.addAll(this);
    	set.addAll(s2);
    	return set;
    }
    
    public <T> Set<Pair<E,T>> cartesianProduct(Set<T> s2) {
        Set<Pair<E,T>> set = new MathSet<Pair<E,T>>();    
    	for(E e1: this) {
    		for(T e2: s2) {
    			set.add(new Pair<E,T>(e1, e2));
    		}
    	}
    	return set;
    }


	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		MathSet<Integer> s1 = new MathSet<Integer>();
		s1.add(5);
		s1.add(7);
		s1.add(9);
		MathSet<Integer> s2 = new MathSet<Integer>();
		s2.add(5);
		s2.add(7);
		s2.add(4);
		s2.add(6);
		s2.add(8);
		System.out.println(s1.intersection(s2));
		System.out.println(s1.union(s2));
		System.out.println(s1.cartesianProduct(s2));
		
		
		// create another MathSet object of a different type
		// calculate the Cartesian product of this set with one of the
		// above sets
		MathSet<String> s3 = new MathSet<String>();
		s3.add("NYU");
		s3.add("CS");
		s3.add("NYC");
		
		System.out.println(s3.cartesianProduct(s1));

	}
}
