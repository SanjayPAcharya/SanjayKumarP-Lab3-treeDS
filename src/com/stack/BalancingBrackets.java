package com.stack;

import java.util.*;

public class BalancingBrackets {

	static boolean isBalanced(String expr) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);

			if (x == '(' || x == '[' || x == '{' || x == '<') {
				stack.push(x);
			}

			if (stack.isEmpty()) {
				return false;
			}
			
			char check;
			
			switch (x) {
				case ')':
					check = stack.pop();
					if (check == '{' || check == '[' || check == '<')
						return false;
					break;

				case '}':
					check = stack.pop();
					if (check == '(' || check == '[' || check == '<')
						return false;
					break;

				case ']':
					check = stack.pop();
					if (check == '(' || check == '{' || check == '<')
						return false;
					break;
					
				case '>':
					check = stack.pop();
					if (check == '(' || check == '{' || check == '[')
						return false;
					break;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args)
	{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the brackets : ");
        String expr = scanner.nextLine();
        scanner.close();
		if (isBalanced(expr))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
	}
}
