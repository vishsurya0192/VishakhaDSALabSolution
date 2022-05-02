package com.greatlearning.lab3;
import java.util.Stack;

public class BalancingBrackets {
	
	//method to check brackets sequence is balanced
	static boolean isBracketsBalanced(String bracketSequence) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i< bracketSequence.length(); i++){
			char character = bracketSequence.charAt(i);
		 
		  if(character == '(' || character == '[' || character == '{'){
		  stack.push(character);
		  continue;
		  }
		  
		  if(stack.isEmpty())
		  return false;
		  
		  char c;
		  switch(character) {
		  case '}':
			  c = stack.pop();
			  if(c == '(' || c == '[')
				  return false;
			  break;
			  
		  case ')':
			  c = stack.pop();
			  if(c == '{' || c == '[')
				  return false;
			  break;
			  
		  case ']':
			  c = stack.pop();
			  if(c == '(' || c == '{')
				  return false;
			  break;
		  }
		  }
		
		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		String bracketSequence = "([[{}]])"; //given bracket input
		Boolean result;
		result = isBracketsBalanced(bracketSequence);
		if(result)
			System.out.println("The entered brackets sequence is balanced!");
		else
			System.out.println("Brackets sequence is not balanced!");
		
		
	}
	

}
