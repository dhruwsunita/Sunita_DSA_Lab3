/* Java program to check Balanced Brackets */

package com.glearning.dsa;

import java.util.Stack;

public class BalancedBracket {

	// Creating a function to check brackets are balanced
	public static boolean balanced(String str) {

		// Creating a stack of characters
		Stack<Character> st = new Stack<>();

		// Traversing the string
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// if current character is a opening bracket then push into the stack
			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
				continue;
			}

			// if current character is not opening bracket then it must be closing
			// so keep popping out characters until stack becomes empty
			if (st.isEmpty()) {
				return false;
			}
			char check;

			switch (ch) {

			case '}':
				check = st.pop();
				if (check == '(' || check == '[') {
					return false;
				}
				break;
			case ')':
				check = st.pop();
				if (check == '{' || check == '[') {
					return false;
				}
				break;

			case ']':
				check = st.pop();
				if (check == '(' || check == '{') {
					return false;
				}
				break;
			}
		}
		// Check for empty stack
		return (st.isEmpty());

	}

	// Driver code
	public static void main(String[] args) {

		String str = "([[{}]])";
		// String str = "([[{}]]))";

		if (balanced(str))
			System.out.println("The entered string has Balanced Brackets");
		else
			System.out.println("The entered strings do not contain Balanced Brackets");

	}

}
