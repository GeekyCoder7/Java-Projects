package pckg;

import java.util.Scanner;

public class ZOO {
	 private static Animal[] Animals = new Animal[10];
	 static Scanner scan = new Scanner(System.in);
	 static int count=0,age;
	 
	 public static void Add(){
		 
		 String str;
		 System.out.println("What type of animal is it?");
		 str=scan.next();
		 if(str.equalsIgnoreCase("dog")){
			 System.out.println("How old is the dog?");
			 age=scan.nextInt();
			 Animals[count]=new Mamal(age,"Dog "+(count+1));
			 count++;
		 }
		 else if(str.equalsIgnoreCase("cat")){
			 System.out.println("How old is the cat?");
			 age=scan.nextInt();
			 Animals[count]=new Mamal(age,"Cat "+(count+1));
			 count++;
		 }
		 
		else if(str.equalsIgnoreCase("tiger")){
			 System.out.println("How old is the tiger?");
			 age=scan.nextInt();
			Animals[count]=new Mamal(age,"Tiger "+(count+1));
			 count++; 
				 }
		else if(str.equalsIgnoreCase("lion")){
			System.out.println("How old is the lion?");
			 age=scan.nextInt();
			Animals[count]=new Mamal(age,"Lion "+(count+1));
			 count++; 
		}
		else if(str.equalsIgnoreCase("chicken")){
			System.out.println("How old is the chicken?");
			 age=scan.nextInt();
			Animals[count]=new Chicken(age);
			 count++; 
		}
		else if(str.equalsIgnoreCase("hawk")){
			System.out.println("How old is the hawk?");
			 age=scan.nextInt();
			Animals[count]=new Hawk(age);
			count++; 
		}
	
	 }
	 
	 public static void IncreaseCapacity(){
		 if(count==Animals.length){
			 Animal[] temp = new Animal[Animals.length*2+1];
			 for(int j = 0; j<Animals.length;j++){
				 temp[j]=Animals[j];
			 }
			 Animals=temp;
		 }
	 }

	public static int Search(int age1){
		 for(int i=0;i<count;i++){
				if(Animals[i].getAge()==(age1)){
					return i;
				} 
		 }
				return -1;
		
		}
	 
	 public static void Delete(int age){
		 int i = Search(age);
		 if(i<0){
			 System.out.println("Animal not found.");
		 }
		 if(i>=0){
		 count--;
		 Animals[i]=Animals[count];
		 Animals[count]=null;
		 System.out.println("Animal deleted.");
	 }
	 }
	 
	public static void main(String[] args) {
		int num=0;
		int age;
		
		while(num>=0){
			System.out.println("1. Add");
			System.out.println("2. Delete");
			System.out.println("3. List dangerous");
			System.out.println("4. List not-dangerous");
			num=scan.nextInt();
			switch(num){
			case 1:
				 Add();
				break;
			case 2:
				System.out.println("Age you want to remove?");
				age=scan.nextInt();
				Delete(age);
				break;
			case 3:
				 for(int i=0;i<count;i++){
					 if(Animals[i].isDangerous()){
						 System.out.println(Animals[i].toString());
					 }
	
				 }
				break;
			case 4:
				for(int i=0;i<count;i++){
					 if(!(Animals[i].isDangerous())){
						System.out.println(Animals[i].toString());
					 }
				
				}
				break;
			default:
				System.out.println("Invalid Number");
				break;
			
		
	
	}
	}
}
}
