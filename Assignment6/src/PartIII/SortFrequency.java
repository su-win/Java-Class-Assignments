//Written by: Su Win

package PartIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

public class SortFrequency {

    public static void sortByFrequency(ArrayList<Integer> ar) {
    	Map<Integer, Integer> map = new HashMap<>();

		//add each element in the array to the map and increment count
    	for(Integer key : ar) {
    		map.put(key, map.getOrDefault(key, 0) +1);
    	}
    	System.out.println("Map: " + map);
    	
    	Collections.sort(ar, new Comparator < Integer > () {
            @Override 
            public int compare(Integer num1, Integer num2) {
            	//comparing values
            	int compareValues = map.get(num1).compareTo(map.get(num2));
            	
            	//comparing keys
            	int compareKeys = num1.compareTo(num2);
            	
                if (compareValues == 0) {
                	return compareKeys;
                }else{
                	return compareValues;
                }
            }
	    });
    }
    
    public static void main(String[] args) {
            ArrayList<Integer> ar = new ArrayList<Integer>();
            for (int i=0;i<100;i++) {
                    ar.add((int)(Math.random()*10));                        
            }
            System.out.println(ar.toString());
            sortByFrequency(ar);
            System.out.println(ar.toString());
    }
}


//Test
//ArrayList<Integer> ar = new ArrayList<Integer>(Arrays.asList(1, 5, 9, 7, 5, 9,20, 1, 4, 8, 8, 5, 4, 8, 1, 9, 1, 1, 6, 1, 8, 7, 8, 5, 4, 3, 9, 3, 1, 6, 1, 20, 8, 6));


