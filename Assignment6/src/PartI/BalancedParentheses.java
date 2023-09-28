//Written by: Su Win

package PartI;

public class BalancedParentheses {

	public static boolean isBalanced(String inString) {
		MyStack<Object> stack = new MyStack<>();
		for (int i = 0; i < inString.length(); i++) {
			char p = inString.charAt(i);
			
			if(p == '(') {
				stack.push(p);
				continue;
			}
			
			if(stack.empty()) {
				return false;
			}
			
			if(p == ')') {
				stack.pop();
				
			}
		}
		return stack.empty();
	}
	
	public static void main(String[] args) {
		boolean result = isBalanced("(()()()())");
		System.out.println(result);
		
		result = isBalanced("(((())))");
		System.out.println(result);
		
		result = isBalanced(")()())");
		System.out.println(result);
		
		result = isBalanced("((((((())");
		System.out.println(result);
		
		
	}
}
