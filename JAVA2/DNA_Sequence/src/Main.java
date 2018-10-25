/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 19/03/2018
 *Associated files:DNA_Sequence.java, Node.java. 
 *Program Description: Main program class.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	private static Scanner scan;
	public static void printMenu() {
		for(int i =0; i<20;i++) {//Prints the main menu every time called.
		System.out.println((int)Math.random()*2);
		}
		System.out.println("");
		System.out.println("1. Enter a DNA Sequence");
		System.out.println("2. Validate a DNA Sequence");
		System.out.println("3. Mutate DNA Sequence");
		System.out.println("4. Insert or Delete a base");
		System.out.println("5. Quit");
		System.out.println("-----------------------------");
		System.out.println("Input your choice:");
	} 
	
	public void createDictionary() {
		System.out.println();
	}
	
	
	
	
	public static void main(String[] args) {	//Main method
		int num=0,count=0;
		String str="",comp_str="";
		boolean isInt=false;
		double probability=0;
		scan = new Scanner(System.in);
		DNA_Sequence dna = new DNA_Sequence();
		DNA_Sequence comp_dna = new DNA_Sequence();
	
	while(dna.count<=3){
		if(count==4) {
			System.out.println("Application Closed.");
			System.exit(0);
		}
		printMenu();
		 while(!isInt){
				try {
					 num=scan.nextInt();
				isInt = true;
			}
			catch(InputMismatchException e) {
				System.out.print("Error. Re-enter value: ");
			}
				scan.nextLine();
				
			}
			isInt=false; 
		
			
		switch(num){
		case 1:
			//Used this for testing: TACCGATACGATAACATT
			if(dna.isValidated) {
				System.out.println("Application already contains a DNA Strand.");
			}
			while(dna.count<=3&&!dna.isValidated) {
			System.out.println("Enter the sequence:");
			 str =  scan.next();
			dna.addSequence(str);
			if(dna.isValidated) {
			comp_str = dna.complementarySTR(str);
			comp_dna.addCompSequence(comp_str);
			}
			}
			
			if(dna.count<=4&&!dna.isValidated) {
				System.out.println("Application Closed.");
				System.exit(0);
			}
			dna.count=0;
			
			break;
			
		case 2:
			if(dna.isValidated) {
				System.out.println("DNA Strand is already valid");
			}
			else {
				while(dna.count<=3&&!dna.isValidated) {
					System.out.println("Enter the sequence:");
					 str =  scan.next();
					dna.addSequence(str);
					if(dna.isValidated) {
					comp_str = dna.complementarySTR(str);
					comp_dna.addCompSequence(comp_str);
					}
					}
					
					if(dna.count<=4&&!dna.isValidated) {
						System.out.println("Application Closed.");
						System.exit(0);
					}
					dna.count=0;
			}
			
			break;
			
		case 3:

			if(dna.isValidated) {
				
				
				while(!isInt){
					try {
						System.out.println("Enter probability:");
						 probability=scan.nextDouble();
					isInt = true;
				}
				catch(InputMismatchException e) {
					System.out.print("Error. ");
				}
					scan.nextLine();
					
				}
				isInt=false; 
				
				dna.mutateDNA(dna,probability,comp_dna);
				
			}
			else {
				while(dna.count<=3&&!dna.isValidated) {
					System.out.println("Enter the sequence:");
					 str =  scan.next();
					dna.addSequence(str);
					if(dna.isValidated) {
					comp_str = dna.complementarySTR(str);
					comp_dna.addCompSequence(comp_str);
					}
					}
					
					if(dna.count<=4&&!dna.isValidated) {
						System.out.println("Application Closed.");
						System.exit(0);
					}
					dna.count=0;
					
					while(!isInt){
						try {
							System.out.println("Enter probability:");
							 probability=scan.nextDouble();
						isInt = true;
					}
					catch(InputMismatchException e) {
						System.out.print("Error. ");
					}
						scan.nextLine();
						
					}
					isInt=false; 
					dna.mutateDNA(dna,probability,comp_dna);
			}
			
			break;
		case 4:
			System.out.println("Do you want to delete or insert a base? (i/d)");
			str=scan.next();
			while(!(str.equalsIgnoreCase("d")||str.equalsIgnoreCase("i"))) {
				System.out.println("Enter again: ");
				str=scan.next();
			}
			if(str.equalsIgnoreCase("d")) {
			if(dna.isValidated) {
				while(!isInt){
					try {
						System.out.println("Enter probability:");
						 probability=scan.nextDouble();
					isInt = true;
				}
				catch(InputMismatchException e) {
					System.out.print("Error. ");
				}
					scan.nextLine();
					
				}
				isInt=false; 
				dna.deleteBase(dna,probability,comp_dna);
				
			}
			else {
				while(dna.count<=3&&!dna.isValidated) {
					System.out.println("Enter the sequence:");
					 str =  scan.next();
					dna.addSequence(str);
					if(dna.isValidated) {
					comp_str = dna.complementarySTR(str);
					comp_dna.addCompSequence(comp_str);
					}
					}
					
					if(dna.count<=4&&!dna.isValidated) {
						System.out.println("Application Closed.");
						System.exit(0);
					}
					dna.count=0;
					while(!isInt){
						try {
							System.out.println("Enter probability:");
							 probability=scan.nextDouble();
						isInt = true;
					}
					catch(InputMismatchException e) {
						System.out.print("Error. ");
					}
						scan.nextLine();
						
					}
					isInt=false; 
					dna.deleteBase(dna,probability,comp_dna);
			}
			}
			else if(str.equalsIgnoreCase("i")) {
				
				if(dna.isValidated) {
					while(!isInt){
						try {
							System.out.println("Enter probability:");
							 probability=scan.nextDouble();
						isInt = true;
					}
					catch(InputMismatchException e) {
						System.out.print("Error. ");
					}
						scan.nextLine();
						
					}
					isInt=false; 
					dna.insertBase(dna,probability,comp_dna);
					
				}
				else {
					while(dna.count<=3&&!dna.isValidated) {
						System.out.println("Enter the sequence:");
						 str =  scan.next();
					
						dna.addSequence(str);
						if(dna.isValidated) {
						comp_str = dna.complementarySTR(str);
						comp_dna.addCompSequence(comp_str);
						}
						}
						
						if(dna.count<=4&&!dna.isValidated) {
							System.out.println("Application Closed.");
							System.exit(0);
						}
						dna.count=0;
						while(!isInt){
							try {
								System.out.println("Enter probability:");
								 probability=scan.nextDouble();
							isInt = true;
						}
						catch(InputMismatchException e) {
							System.out.print("Error. ");
						}
							scan.nextLine();
							
						}
						isInt=false; 
						dna.insertBase(dna,probability,comp_dna);
				
				
				}
				
			}
			
			
			break;
		case 5:
			System.out.println("Application Closed.");
			System.exit(0);
			break;
		 default:
			System.out.println("Invalid Number.");
			count++;
			break;
}
	}
	}
}
