package co.tushar.stack;

import java.util.Scanner;

public class BalanceParenthesis {

	public static void main(String[] args) {
		
		System.out.println("--");
		Scanner sc=new Scanner(System.in);
		Stack st=new Stack();
		
		String input=sc.next();
        //Complete the code

        for(int i=0;i<input.length();i++){

            char c=input.charAt(i);

            if(c=='{' || c=='[' || c=='('){
                st.push(c);
            }else{
                char c1=st.pop();
                 if(c1=='r'){
                     System.out.println("false");
                     break;
                 }
            }
        
        }
        if(st.isEmpty()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

	}

}
class Stack{
	   public int top=-1;
	   char[] ch=new char[100];

	   public void push(char ch){
	       this.ch[++top]=ch;
	   }
	   public char pop(){
	       if(top==-1){
	           return 'r';
	       }
	       return ch[top--];
	   }
	   public boolean isEmpty(){
	    return top==-1;
	   }
	   
	 }

