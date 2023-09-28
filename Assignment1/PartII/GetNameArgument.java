//Written by: Su Win

public class GetNameArgument {
	
	public static void main(String[] args) {
		System.out.println("args is " + java.util.Arrays.toString(args));
		// if there are command line arguments, then the first will be in
		// args[0], the second in arg[1], and so on. If there are no command
		// line arguments, then args[0] will give an error
		System.out.println("Hello " + args[0] + "!");
	}
}
