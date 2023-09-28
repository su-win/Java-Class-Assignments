//Written by: Su Win

import java.io.*;
import java.util.ArrayList;
 
public class ListOfNumbers {
	
	//private List<RDFTriple<Integer, Integer, Integer>> rdfTripleList;
	private ArrayList<RDFTriple<Integer, Integer, Integer>> rdfTripleList;
    private String inFile;
    
    public ListOfNumbers () {
    	rdfTripleList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
    }
    
    public ListOfNumbers (String inFile) {
    	this();
    	this.inFile = inFile;	
    }

    public ArrayList<RDFTriple<Integer, Integer, Integer>> getRdfTripleList() {
    	return this.rdfTripleList;
    }
    
    public void createList() {
    	for (int i = 0 ; i< 100 ; i++) {
    		Integer number1 = (int) (Math.random()*10000);
    		Integer number2 = (int) (Math.random()*10000);
    		Integer number3 = (int) (Math.random()*10000);
    		// fill the existing list with RDFTriple objects of three numbers.

/*Instruction: "take each triple of integers and put them in an RDFTriple object, 
 * and then add that RDFTriple object to the ArrayList called rdfTripleList"*/
//RDFTriple<Subject,Predicate,Object>
    		RDFTriple<Integer, Integer, Integer> t = new RDFTriple<Integer, Integer, Integer>(number1,number2,number3);
    		rdfTripleList.add(t);
    	}
    	System.out.println("Created List:\n\t" + rdfTripleList);
    }
    
//b) Add a readList method to ListOfNumbers.java. 
    public void readList() {
    	/*Instruction: "re-initialize the rdfTripleList field with a new, 
    	 * empty ArrayList, read in int values from a file, print each value,
    	 * put the triple of numbers in each line in a RDFTriple object, 
    	 * and append them to the end of rdfTripleList.
    	 * Catch all appropriate errors.
    	 * You will read from the text file numberfile.txt."
    	 */
    	rdfTripleList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
    	FileReader f = null;
    	String line = null;
    	
    	try {
    		f = new FileReader(this.inFile);
    		BufferedReader reader = new BufferedReader(f);
    		while((line = reader.readLine())!=null) {
    			String[] nums = line.split(" ");
    			RDFTriple<Integer, Integer, Integer> newTripleList = new RDFTriple<Integer, Integer, Integer>(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]),Integer.parseInt(nums[2]));
    			rdfTripleList.add(newTripleList);
    			line = reader.readLine();
    		}
    		reader.close();
    	}catch (FileNotFoundException e) {
			System.err.println("File Not Found: " + e.getMessage());
			System.exit(1); //terminates program
    	}catch(IOException ioe) {
    		System.err.println("Input Output Errors" + ioe.getMessage());
    	}catch(ArrayIndexOutOfBoundsException inOut) {
    		System.err.println(inOut);
    	}finally {
    		try {
    			f.close();
    		}catch(IOException ioe) {
    			System.err.println("Error closing file" + ioe.getMessage());
    		}
    	}
    	
    	System.out.println("Read:\n\t" + rdfTripleList.toString());
    }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("outFile.txt"));
            for (int i = 0; i < rdfTripleList.size(); i++)
                out.println(rdfTripleList.get(i).getSubj() + " " + rdfTripleList.get(i).getPred() + " " + rdfTripleList.get(i).getObj());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        }catch(IOException ioe){
        	System.out.println("Error! reading file." + ioe.getMessage());
        }finally {
        	try {
        		if (input != null) {
        			input.close();
        		}
        	}catch(IOException ioe){
            	System.out.println("Error! Cannot close file." + ioe.getMessage());
        	}
        }
    }
    
    public static void main(String[] args) {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	ListOfNumbers.cat("numberfile.txt");
    	listOfNumbers.readList();
    	listOfNumbers.createList();
    	listOfNumbers.writeList();
    }
}
