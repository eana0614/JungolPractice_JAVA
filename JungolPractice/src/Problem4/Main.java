package Problem4;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * Problem 4. Browser
 * 
 *  Print page use Stack.
 *  
 *  Input : Command
 *  Output : Current page.
 *  
 */

public class Main {

	static Stacks forwardStack = new Stacks();
	static Stacks backwardStack = new Stacks();
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		String command = scanner.nextLine();
		
		String init = "http://www.acm.org/";
		
		while(!command.equals("QUIT")) {
		
			StringTokenizer stringTokenizer = new StringTokenizer(command, " ");
			
			String comd = stringTokenizer.nextToken();
			
			switch (comd) {
			case "BACK":
				init = runBack(init);
				break;
			case "FORWARD":
				init = runForward(init);
				break;
			case "VISIT":
				String pages = stringTokenizer.nextToken();
				init = runVisit(pages, init);
				break;
			}
			command = scanner.nextLine();
		}
	}
	
	private static String runForward(String init) {
		
		if(forwardStack.isEmpty()) {
			System.out.println("Ignored");
			return null;
		}else {
			backwardStack.push(init);
			String current = forwardStack.pop();
			System.out.println(current);
			return current;
		}
	}

	private static String runBack(String init) {
		
		if(backwardStack.isEmpty()) {
			System.out.println("Ignored");
			return init;
		}else {
			forwardStack.push(init);
			String current = backwardStack.pop();
			System.out.println(current);
			return current;
		}
	}

	private static String runVisit(String pages, String init) {
		
		backwardStack.push(init);
		forwardStack.emptyStack();
		
		System.out.println(pages);
		return pages;
	}

	static class Stacks {
		int top;
		int size = 100;
		String[] stack;
		
		public Stacks() {
			this.top = -1;
			this.stack = new String[size];
		}
		
		boolean isEmpty() {
			return top == -1;
		}
		
		boolean isFully( ) {
			return top == size-1;
		}
		
		void push(String string) {
			if(!isFully()) {
				stack[++top] = string;
			}
		}
		
		String pop() {
			String result = peek();
			top--;
			
			return result;
		}

		String peek() {
			
			if(!isEmpty()) {
				return stack[top];
			}else {
				return "http://www.acm.org/";
			}
		}
		
		void emptyStack() {
			top = -1;
		}
		
		int getTop() {
			return top;
		}
		
	}

}
