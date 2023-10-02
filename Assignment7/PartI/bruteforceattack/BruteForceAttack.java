package bruteforceattack;
//Written by: Su Win

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

public class BruteForceAttack {

	static final char startLower = 'a';
	static final char startUpper = 'A';
	static final char startNumber = '0';
	static final char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k','l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v','w','x', 'y', 'z', 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
	static int numfound;
	static Object locking = new Object();
	
	public static char getChar(int i) {
		return letters[i];
		
	}

	public static String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	public static int getInt(char c) {
		if ((c >= 'a') && (c <= 'z')) {
			return c - 'a';
		} else if ((c >= 'A') && (c <= 'Z')) {
			return 26 + (c - 'A');
		} else if ((c >= '0') && (c <= '9')) {
			return 52 + (c - '0');
		} else {
			return 0;
		}
	}
	
	public static Set<String> hashedpasswords(String filename) {
		Set<String> hashSet = new HashSet<String>();
		try {
			FileReader fr = new FileReader("hashedpassword.txt");
			BufferedReader br = new BufferedReader(fr);
			String inline = br.readLine();
			while (inline != null) {
				hashSet.add(inline);
				inline = br.readLine();
			}
		} catch (Exception e) {
			
		}
		return hashSet;
		
	}
	
	//getFound method for getting number of passwords found
	public static int getFound() {
		return numfound;
	}
	
	//method to perform password searching
	public static void multiThread(double first, double last, Set<String> passwordSet, int len) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] pass = new byte[len];
		
		for (int k = 0;k<pass.length ;k++) {
//				pass[k] = startLower;	//with this only found 5781
			pass[k] = (byte)letters[(int) ((first/(Math.pow(26, k))))%26];
		}
		
		for (long j=(long)first ; j < last ;j++) { 
			int v = (int)(j % 26L);
			if ((v == 0) && (j!=0)) {
				
				pass[0] = startLower;
				for (int k = 1;k<pass.length ;k++) {
					if (pass[k] == 'z') {
						if (k != pass.length-1) {
							pass[k] = startLower;
							continue;
						} else {
							break;
						}
					} else {
						int val = getInt((char)pass[k]);
						val++;
						pass[k] = (byte)letters[val];
						break;
					}
				}
			} else {
				pass[0] = (byte)letters[v];
			}
			
			byte[] encodedhash = digest.digest(pass);
					
			String hashpass = BruteForceAttack.bytesToHex(encodedhash);
			if (passwordSet.contains(hashpass)) {
				String passString = new String(pass);
					System.out.println("found password " + passString);
					//Since numfound is shared resources between threads, it can lead to data inconsistency
					//To prevent this happening, we use synchronized to lock on numfound.
					//So, only one thread can access numfound at a time.
				synchronized(locking) { //without synchronized, it's not thread safe
					numfound++;
				}
				
			}
			//System.out.println(new String(pass));
		}
//			return numfound;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Set<String> passwordSet = hashedpasswords("hashedpassword.txt");
		int len = 5;
		
		double max = Math.pow(26, len);
		
		int numOfThreads = 4;
		Thread[] threads = new Thread[numOfThreads];		
		
		long startTime = System.currentTimeMillis();
		for (int i=0; i < numOfThreads; i++) {
				double range =(double)( max/numOfThreads);
				double first = i * range;
				double last =(i+1) * range;
				
				Runnable runnable = null;
				
					if( i == numOfThreads -1) {
						runnable= () -> {
							try {
								multiThread(first, max, passwordSet, len);
							} catch (NoSuchAlgorithmException e) {
								e.printStackTrace();
							}	
						};
					}else {
						runnable= () -> {
							try {
								multiThread(first,last, passwordSet, len);
							} catch (NoSuchAlgorithmException e) {
								e.printStackTrace();
							}
						};
					}
//					threadSet.add(new Thread(runnable));
				
				threads[i] = new Thread(runnable);
//					System.out.println(threads[i]);
		 		threads[i].start();
		}
			
			for (Thread tread: threads) {
				try {
					tread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		System.out.println("found " + BruteForceAttack.getFound() + " out of " + passwordSet.size());
		System.out.println("Number of Threads: " + numOfThreads +
				" Total time: " + totalTime/1000.0 + " seconds");
	}
}

	

