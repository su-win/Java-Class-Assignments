//Written by: Su Win

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class DumbPasswords {
	
	//method printDumbPasswords takes two arguments: m and n
	public static void printDumbPasswords(int m, int n) {
		
		int count = 0;
		String appendCharacters = "", dumbPasswordsString = "";
		ArrayList<String> dumbPasswordsArray = new ArrayList<String>();
		
		while(count < 5) {
			
	    	//generate digit character from 1 to m for character 1 and character 2
			char character1 = (char)('1' + Math.random() * ((char)(m+'0') - '1' + 1));
			char character2 = (char)('1' + Math.random() * ((char)(m+'0') - '1' + 1));
			
			//generate random lower case letter from the first n letters for character 3 and character 4
			Random r = new Random();
			char character3 = (char) (97 + r.nextInt(n));
			char character4 = (char) (97 + r.nextInt(n));
			
			//generate digit character from 1 to m; greater than char1 and char2
			char character5 = (char)('1' + Math.random() * ((char)(m+'0') - '1' + 1));
			
			//if character5 is greater than first two digit characters
			//append all 5 characters. If not, append only 4 characters
			if (character5 > character1 && character5 > character2 ) {
				appendCharacters = new StringBuilder().append(character1).append(character2).append(character3).append(character4).append(character5).toString();
			}else {
				appendCharacters = new StringBuilder().append(character1).append(character2).append(character3).append(character4).toString();
			}
			
			//after appending four/five characters, add to array
			dumbPasswordsArray.add(appendCharacters);
			
			//increment the counter
			count++;
			
		}
		
		//use collection class to sort passwords in alphabetical order
		Collections.sort(dumbPasswordsArray);
	
		//loop through array and concatenate string objects; return a single object
		for (String s : dumbPasswordsArray)
		{
			dumbPasswordsString += s + " ";
		}
	
		System.out.println("\n" + dumbPasswordsString);
		
}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter value for m and n: ");
		
		int m = input.nextInt();
		int n = input.nextInt();
		
		printDumbPasswords(m, n);
		
		input.close();
	
	}
}

