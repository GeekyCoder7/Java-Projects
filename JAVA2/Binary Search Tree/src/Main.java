/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 04/05/2018
 *Associated files:BSTNode.java,BSTree.java. 
 *Program Description: Program to create a dictionary in a BinarySearch Tree.
 */

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static String file_name,str,str1;
	@SuppressWarnings("unused")
	private boolean b, isValid;
	private static Scanner scan;
	private Scanner sc2,s2;
	private BSTree BST;
	private int count_exit,item_count;
	
	
	public Main() {//constructor
		file_name="";str="";str1="";
		b=false;
		isValid=false;
		scan= new Scanner(System.in);
		BST= new BSTree();
		count_exit=0;item_count=0;
	}
	
	
public static void printMenu() {	//Prints the main menu every time called.
		
		System.out.println("1. Create the dictionary");
		System.out.println("2. Add a definition");
		System.out.println("3. Remove a definition");
		System.out.println("4. Search for a definition");
		System.out.println("5. Print Dictionary");
		System.out.println("6. Exit");
		System.out.println("-----------------------------");
		System.out.println("Input your choice:");
	} 
	
	
public BSTree createDictionary() throws FileNotFoundException{
	//method that checks for the file and extracts data from it: Words and their definitions.(Recursive)
	
	try {
		 s2 = new Scanner(sc2.nextLine());
		if(!s2.hasNext()) {
			return BST;
		}
	}
	catch(Exception e){
		
	}
	
	if(file_name.equals("")) {
	@SuppressWarnings("unused")
	Scanner sc2 = null;
	}
	count_exit=0;
	
	while(!isValid&&count_exit<3) {
	System.out.println("Enter the name of the text file: ");
	
	if(file_name.equals("")||!isValid) {
	file_name=scan.next();//re-attempt to try to find the file.
	}
	
	try {
		sc2 = new Scanner(new File("//Users//nazarethkeshishian//Desktop//eclipse-workspace//HW6 CP2//"+file_name));
		
	   isValid=true;
	} catch (FileNotFoundException e) {
		 count_exit++;
		System.out.println("File not found");
	  
		}
	}
	if(count_exit==3&&!isValid) {//if tried more than 3 times and the file is invalid, exit.
		return null;
	}
	sc2 = new Scanner(new File("//Users//nazarethkeshishian//Desktop//eclipse-workspace//HW6 CP2//"+file_name));
	  
	for(int i=0;i<=item_count;i++) {
		if (sc2.hasNextLine()) {
	         s2 = new Scanner(sc2.nextLine());
		}
	}
	
	if (s2.hasNext()) {
	        String s = s2.nextLine();
	    		
		        	for(int i =0;i<s.length();i++) {
			        	if(s.charAt(i)!=':') {
			        		str+=s.charAt(i);
			        	}
			        	else {//if s.charAt(i)==':'
			        		str1=s.substring(i+1, s.length());
			        		i=s.length()+1;
			        		
			        	}
		        	}

		System.out.println("Info to be added : "+str +", description:"+str1);
		BSTNode n = new BSTNode(str,str1.substring(1));
	   	BST.add(BST.getRoot(),n);
	      str="";
	      str1="";
	      item_count++;
	      if(!sc2.hasNextLine()) {
			return BST;
		}
   	}
	    
	    return createDictionary();
	
	}


public void writeToFile() {
	 BufferedWriter writer = null;
     try {
         //create a temp file
         File logFile = new File("definitions");

         // This will output the full path where the file will be written to
         System.out.println(logFile.getCanonicalPath());

         writer = new BufferedWriter(new FileWriter(logFile));
         
         // Create a stream to hold the output
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
        
         PrintStream old = System.out;
         // Use special stream
         System.setOut(ps);
         // Printed output will go to the special stream
         System.out.println(BST.listAll(BST.getRoot()));
         // Put things back
         System.out.flush();
         System.setOut(old);

      writer.write(baos.toString()); //write everything in the file again before exiting the program
     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         try {
             // Close the writer regardless of what happens
             writer.close();
         } catch (Exception e) {
         }
     }
}

public static String toTitleCase(String givenString) { //to capitalize every character after space.
    String[] arr = givenString.split(" ");
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < arr.length; i++) {
        sb.append(Character.toUpperCase(arr[i].charAt(0)))
            .append(arr[i].substring(1)).append(" ");
    }          
    return sb.toString().trim();
}  


	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Main m = new Main();
		int num = 0;
		boolean isInt=false;
		while(true) {
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
			switch(num) {
			
			case 1:
				m.BST= m.createDictionary();
				//create dictionary
				break;
			case 2:
				if(m.isValid) {
				System.out.println("Enter a word you want to add:");
				String word=scan.nextLine();
				word=toTitleCase(word);
				System.out.println("Enter its description:");
				String description=scan.nextLine();
				BSTNode n = new BSTNode(word, description);
				m.BST.add(m.BST.getRoot(), n);//add definition
				}
				else {
					System.out.println("You need to create a dictionary first");
				}
				break;
			case 3:
				if(m.isValid) {
				System.out.println("Enter a word you want to delete:");
				str=scan.nextLine();
				str=toTitleCase(str);
				
				m.BST.remove(str);//remove
				}
				else {
					System.out.println("You need to create a dictionary first");
				}
				break;
			case 4:
				if(m.isValid) {
				System.out.println("Enter the word you want to search: ");
				str=scan.nextLine();
				System.out.println(m.BST.search(m.BST.getRoot(), str));
				//Search definition
				}
				else {
					System.out.println("You need to create a dictionary first");
				}
				break;
			case 5:
				//print dictionary
				if(m.isValid) {
				String str= m.BST.printAll(m.BST.getRoot());
				System.out.println(str);
				}
				else {
					System.out.println("You need to create a dictionary first");
				}
				break;
			case 6:
				if(m.isValid) {
				//need to save all info to file
				m.writeToFile();
				}
				System.out.println("Application Stopped.");
				System.exit(0);
				break;
			
		
				default:
					System.out.println("Invalid Number.");
					break;
			}
		}
	}




}
