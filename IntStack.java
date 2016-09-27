import java.util.EmptyStackException;

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
 * Filename : IntStack.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 
 


public class IntStack {
	
	// private fields for IntStack 
	private int S[];
	private int t;
	
	// the maximum capacity of the stack is set to 1000
	public static final int CAPACITY = 1000;
	
	
	// default contructor
	public IntStack(){
		S = new int[CAPACITY];
		t = -1;		// -1 indicates the stack is empty
	}
	
	
	// Methods for IntStack class
	
	// pushing to top of stack
	public void push(int x){
		
		// if Stack is full return message 'Stack is Full!'
		if(t == CAPACITY-1){
			System.out.println("Stack is Full!");		
		}
		else{
			t++;		// increment the top of stack
			S[t] = x;		// put the value x into the array
		}
	}
	
	// peak at the top of the stack
	public int top(){
		
		// make sure that the stack is not empty
		if(isEmpty()){
			System.out.println("Stack is Empty!");
			return -1;
		}
		else{
			return S[t];
		}
	}
	
	// pop out the value top of the stack without returning the value
	public void pop(){
		
		// make sure that the stack is not empty
		if(isEmpty()){
			System.out.println("Stack is Empty!");
		}
		else{
			t--;	// decrement the value top of stack
		}
	}
	
	// checking if the stack is empty
	public boolean isEmpty(){
		if(t == -1){		// t == -1 indicates the stack is empty
			return true;
		}
		else{
			return false;
		}
	}

}
