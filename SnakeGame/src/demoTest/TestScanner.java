package demoTest;

import java.util.Scanner;


public class TestScanner {
	
	public static void main(String[] args){

	Scanner input = new Scanner(System.in);
	String command = input.nextLine();
	
	switch(command){
		case "n":
			System.out.println("north");
			break;
		case "1":
			System.out.println("one");
			break;
		default:
			System.out.println("enter N or 1");
	
	}
	input.close();
}
	
}
