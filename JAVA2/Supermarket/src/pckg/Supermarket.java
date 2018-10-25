package pckg;

import java.util.Scanner;
import java.util.Vector;

public class Supermarket {
	static Scanner scan =new Scanner(System.in);
	static Vector<Goods> ledger = new Vector<Goods>();
	static int count=0;
	public static void printMenu(){
		System.out.println("1. Import vegetables or fruit");
		System.out.println("2. Get number of vegetables");
		System.out.println("3. Get number of fruits");
		System.out.println("4. Remove Fruit or Vegetable with ID");
		System.out.println("5. Remove Fruit or Vegetable at position");
		System.out.println("6. Print Ledger");
	}
	
	 public static void Add(){
		 String type,supplier,importDate,str;
		 int quantity;
		
		 System.out.println("Import vegetable or fruit? ");
		 type=scan.next();
		 if(type.equalsIgnoreCase("vegetable")){
			 System.out.println("Enter the name of the supplier");
			 supplier=scan.next();
			 System.out.println("Enter the import date");
			 importDate=scan.next();
			 System.out.println("Enter the quantity you want to add");
			 quantity=scan.nextInt();
			 System.out.println("Carrot or Cucumber?");
			 str=scan.next();
			 if(str.equalsIgnoreCase("Carrot")){
				Carrot ca1 = new Carrot(supplier,importDate,quantity); 
				ledger.add(ca1);
			 }
			 else if (str.equalsIgnoreCase("Cucumber")){
				 Cucumber cu1 = new Cucumber(supplier,importDate,quantity); 
				 ledger.add(cu1);
			 }
		 }
		 else if(type.equalsIgnoreCase("fruit")){
			 System.out.println("Enter the name of the supplier");
			 supplier=scan.next();
			 System.out.println("Enter the import date");
			 importDate=scan.next();
			 System.out.println("Enter the quantity you want to add");
			 quantity=scan.nextInt();
			 System.out.println("Strawberry or Banana?");
			 str=scan.next();
			 if(str.equalsIgnoreCase("Strawberry")){
				 Strawberry stra1 = new Strawberry(supplier,importDate,quantity); 
					ledger.add(stra1);
			 }
			 else if (str.equalsIgnoreCase("Banana")){
				 Banana ban1 = new Banana(supplier,importDate,quantity); 
					ledger.add(ban1); 
			 }
		 }
		
		 
	 }
	
	public static void main(String[] args) {
		String str;
		int i;
		int num=0;

while(num>=0){
	
	printMenu();
	num=scan.nextInt();
	switch(num){
	case 1:
		Add();
		break;
	case 2:
		getNumberVeg();
		break;
	case 3:
		getNumberFrt();
		break;
	case 4: 
		System.out.println("Enter ID to remove item.");
		str=scan.next();
		DeleteID(str);
		break;
	case 5:
		System.out.println("Enter position to remove item.");
		i=scan.nextInt();
		DeletePOS(i);
		break;
	case 6:
		listAll();
		break;
	default:
		System.out.println("Invalid Number");
		break;
			}
		}
	}
	
	public static int Search(String ID){
		 for(int i=0;i<ledger.size();i++){
				if(ledger.elementAt(i).toString().equals(ID)){
					return i;
				} 
		 }
				return -1;
		
		}
	 
	 public static void DeleteID(String ID){
		 int i = Search(ID);
		 if(i<0){
			 System.out.println("Fruit/Vegetable not found.");
		 }
		 else if(i>=0){
			 ledger.removeElementAt(i);
		 System.out.println("Fruit/Vegetable removed.");
	 }
}

	 public static void DeletePOS(int index){
			 ledger.removeElementAt(index);
		 System.out.println("Fruit/Vegetable removed.");
	 }

	 public static void listAll(){
			
		 for(int i=0;i<ledger.size();i++){
			 System.out.println("Quantity:"+ledger.elementAt(i).Quantity+" ,"+ledger.elementAt(i));
		 	
		 }
	 }
	 

	private static void getNumberVeg() {
		// TODO Auto-generated method stub
		int count=0;
		for(int i =0; i<ledger.size();i++){
		if(ledger.elementAt(i).getName().equals("Cucumber") 
				|| ledger.elementAt(i).getName().equals("Carrot")
				){
			count+=ledger.elementAt(i).Quantity;
			System.out.println("We have "+count+" vegetable(s).");
			}
		}
		if(count==0){
			System.out.println("No vegetables.");
		}
	}
	private static void getNumberFrt() {
		// TODO Auto-generated method stub
		int count=0;
		for(int i =0; i<ledger.size();i++){
		if( ledger.elementAt(i).getName().equals("Strawberry")|| ledger.elementAt(i).getName().equals("Banana")){
			count+=ledger.elementAt(i).Quantity;
			System.out.println("We have "+count+" fruit(s).");
			}
		}
		if(count==0){
			System.out.println("No fruits.");
		}
	}
}
