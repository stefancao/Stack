import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Stefan
 * Last Name: Cao
 * Lab Section: 1A
 * email address: stefanc1@uci.edu
 *
 *
 * Assignment: lab3
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 
 


public class Main {

	public static void main(String[] args) {
		
		
		
		GenericStack<Integer> intStack = new GenericStack<Integer>();
		
		if (args.length != 1) {
			System.out.println("No input file provided. Expected Usage: java <executable> input.txt");
			System.exit(1);
		} 
		else {
			
			if (args[0].equals("numbers.txt")){
				File intfile = new File(args[0]);
				
				try {
					Scanner inNums = new Scanner(intfile).useDelimiter("\n");
					while(inNums.hasNextInt()) {
						intStack.push(inNums.nextInt());
			
					}
					inNums.close();
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
			
			
				System.out.println("*** Testing Stack with integers ***");
				System.out.println("Loaded numbers.txt which contains 1000 numbers");
					
				System.out.println("Trying to push a 3 to Stack....");
				intStack.push(3);
				
				
				System.out.println("Top of Stack is: " + intStack.top());
				
				System.out.println("Pop out of the Stack...");
				intStack.pop();
				
				System.out.println("Top of Stack is: " + intStack.top());
				
				System.out.println("Pop out of the Stack...");
				intStack.pop();
				
				System.out.println("Top of Stack is: " + intStack.top());
				
				System.out.println("Pop out of the Stack...");
				intStack.pop();
				
				System.out.println("Top of Stack is: " + intStack.top());
				
				System.out.println("Push 3 onto the Stack...");
				intStack.push(3);
				
				System.out.println("Top of Stack is: " + intStack.top());
				
				System.out.println("Push 4 onto the Stack...");
				intStack.push(4);
				
				System.out.println("Top of Stack is: " + intStack.top());
				
				System.out.println("Push 5 onto the Stack...");
				intStack.push(5);
				
				System.out.println("Top of Stack is: " + intStack.top());
				
				System.out.println("Push 6 onto the Stack...");
				intStack.push(6);
				
				System.out.println("Top of Stack is: " + intStack.top());
				
				System.out.println("Removing all element from the stack....");
				for(int i = 0; i < 1000; i++){
					intStack.pop();
				}
				System.out.println("Top of Stack is: " + intStack.top() +"\n");
			
			
			}
			else if(args[0].equals("strings.txt")){
				
				GenericStack<String> stringStack = new GenericStack<String>();
				
				File stringfile = new File(args[0]);
				try {
					Scanner inStrings = new Scanner(stringfile).useDelimiter("\n");
					while(inStrings.hasNext()) {
						stringStack.push(inStrings.next());
			
					}
					inStrings.close();
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				System.out.println("*** Testing Stack with Strings ***");
				System.out.println("Loaded strings.txt which contains 1000 numbers");
					
				System.out.println("Trying to push a 'trien' to Stack....");
				stringStack.push("trien");
				
				
				System.out.println("Top of Stack is: " + stringStack.top());
				
				System.out.println("Pop out of the Stack...");
				stringStack.pop();
				
				System.out.println("Top of Stack is: " + stringStack.top());
				
				System.out.println("Pop out of the Stack...");
				stringStack.pop();
				
				System.out.println("Top of Stack is: " + stringStack.top());
				
				System.out.println("Pop out of the Stack...");
				stringStack.pop();
				
				System.out.println("Top of Stack is: " + stringStack.top());
				
				System.out.println("Push 'open' onto the Stack...");
				stringStack.push("open");
				
				System.out.println("Top of Stack is: " + stringStack.top());
				
				System.out.println("Push 'hello' onto the Stack...");
				stringStack.push("hello");
				
				System.out.println("Top of Stack is: " + stringStack.top());
				
				System.out.println("Push 'bye' onto the Stack...");
				stringStack.push("bye");
				
				System.out.println("Top of Stack is: " + stringStack.top());
				
				System.out.println("Push 'random' onto the Stack...");
				stringStack.push("random");
				
				System.out.println("Top of Stack is: " + stringStack.top());
				
				System.out.println("Removing all element from the stack....");
				for(int i = 0; i < 1000; i++){
					stringStack.pop();
				}
				System.out.println("Top of Stack is: " + stringStack.top() + "\n");
			
			}
			
			else if(args[0].equals("postfix.txt")){
				RPNEval();
			}
			

		}
		

	}
	
	
	public static void RPNEval(){
		
		System.out.println("*** Testing Reverse Polish Notation Evaluation ***");
		
		File postfixfile = new File("postfix.txt");
		try {
			Scanner inPostfix = new Scanner(postfixfile).useDelimiter("\n");
			while(inPostfix.hasNext()) {
				
				String temp = inPostfix.next();
				
				System.out.println("The Expression is: " + temp);
				
				String[] st = temp.split("\\s");
			     
				String operators = "+-*/";
				
				
				GenericStack<String> postfixStack = new GenericStack<String>();
				
				for(String s : st){
					if(!operators.contains(s)){
						postfixStack.push(s);
					}
					
					else{
						if(postfixStack.isEmpty()){
							System.out.println("Stack is Empty!");
						}
						else{
							int b = Integer.valueOf(postfixStack.top());
							postfixStack.pop();
							
							if(postfixStack.isEmpty()){
								System.out.println("Stack is Empty!");
							}
							else{
								int a = Integer.valueOf(postfixStack.top());
								postfixStack.pop();
								
								if(s.equals("+")){
									postfixStack.push(String.valueOf(a+b));
								}
								else if(s.equals("-")){
									postfixStack.push(String.valueOf(a-b));
								}
								else if(s.equals("*")){
									postfixStack.push(String.valueOf(a*b));
								}
								else if(s.equals("/")){
									postfixStack.push(String.valueOf(a/b));
								}
								
							}
						}
					}
				}
				
				int value = Integer.valueOf(postfixStack.top());
				postfixStack.pop();
				if(!(postfixStack.isEmpty())){
					System.out.println("Stack is NOT empty");
				}
				else{
					System.out.println("value = " + value);
				}
					
			}
			inPostfix.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}	
	
}
