package co.tushar.stack;

import java.util.Stack;

public class ValidParenthesis {

	public static boolean checkParenthesis(String str) {
//		if(str.length()%2!=0) {
//			return false;
//		}
		
		Stack<Character> st=new Stack<>();
		for(char c:str.toCharArray()) {
			if(c=='{' || c=='[' || c=='(') {
				st.push(c);
			}else if(c==')' && !st.isEmpty() && st.peek()=='(') {
				st.pop();
			}else if(c==']' && !st.isEmpty() && st.peek()=='[') {
				st.pop();
			}else if(c=='}' && !st.isEmpty() && st.peek()=='{') {
				st.pop();
			}
		}
		
		return st.isEmpty();
	}
	
	public static void main(String[] args) {
		
		System.out.println(checkParenthesis("{a*(b+c)/(k*l)}"));

	}

}
