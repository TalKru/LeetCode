package strings;
/*
	Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
	determine if the input string is valid.
	
	An input string is valid if:
	- Open brackets must be closed by the same type of brackets.
	- Open brackets must be closed in the correct order.
	
	Example 1:
	Input: s = "()"
	Output: true
	
	Example 2:
	Input: s = "()[]{}"
	Output: true
	
	Example 3:
	Input: s = "(]"
	Output: false
 */
import java.util.Stack;

public class _20_Valid_Parentheses {

	public static void main(String[] args) {

		String str = "{([])[()()]}";
		//String str = "()[]{}";

		boolean ans = isValid(str);

		System.out.println(str + "-> " + ans);
	}

	public static boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); ++i) { // i = 1 to avoid empty stack

			if(stack.isEmpty()) {
				stack.push(s.charAt(i));
			}
			else {
				//                              '{'           ']' 
				boolean isMirror = isMirrBrk(stack.peek(), s.charAt(i));

				if(isMirror) { // match
					stack.pop();
				}
				else { // miss-match
					stack.push(s.charAt(i) ); // insert the i char into the stack
				}
			}
		} // loop

		if(stack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	} 
	
	
	public static boolean isMirrBrk(char brkOne, char brkTwo) {

		if(brkOne == '{' && brkTwo == '}') {
			return true;
		}
		else if(brkOne == '[' && brkTwo == ']') {
			return true;
		}
		else if(brkOne == '(' && brkTwo == ')') {
			return true;
		}
		else {
			return false;
		}
	}
}













