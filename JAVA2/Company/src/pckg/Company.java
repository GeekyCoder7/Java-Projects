package pckg;

import java.util.Scanner;

public class Company {
 private static Employee[] Emp1= new Employee[10];
 private static Scanner scan = new Scanner(System.in);
 private static int numEmployee=0;
 private final static double bonus=1.02;
 private static boolean isEmpty =true;
 
 public static void printMenu(){
	 	System.out.println("1. Add employee");
		System.out.println("2. Delete employee");
		System.out.println("3. Raise salary");
		System.out.println("4. List all");
		System.out.println("5. Exit");
		System.out.println("---------------");
		System.out.println("Enter your choice:");
 }
 public static void Add(){
	 String name,hireDay,str,secretary;
	 double salary;
	 boolean sameName=false;
	 if(numEmployee==Emp1.length){
		 increaseSize();
	 }
	 System.out.println("Enter Employee's name");
	 name=scan.next();
	 if(numEmployee>=1){
		 for(int i=0; i<numEmployee;i++){
		 if(Emp1[i].getName().equalsIgnoreCase(name)){
			 sameName=true;
			 System.out.println("An employee with the same name exists."
			 		+ " Can't add this employee.\n");
		 	}
		 }
	 }
	 if(!sameName){
	 System.out.println("Enter Employee's salary in $");
	 salary=scan.nextDouble();
	 System.out.println("Enter Employee's hire day(MM/DD/YYYY)");
	 hireDay=scan.next();
	 while(hireDay.charAt(2)!='/'||hireDay.charAt(5)!='/'){
		 System.out.println("Invalid Date Format. Please Re-Enter Employee's hire day(MM/DD/YYYY)");
		 hireDay=scan.next();
	 }
	 System.out.println("Is this employee a manager?(yes/no)");
	 str=scan.next();
	 
	
	 if(str.equalsIgnoreCase("yes")){
		 System.out.println("Enter the secretary name: ");
		 secretary=scan.next();
		 Emp1[numEmployee]=new Manager(name,hireDay,salary,secretary);
		 System.out.println("Employee (Manager) added successfully");
		 numEmployee++;
		 //AddManger
	 }
	 else{
		 Emp1[numEmployee]=new Employee(name,hireDay,salary);
		 System.out.println("Employee added successfully");
		 numEmployee++;
		//AddEmployee
	 }
	 }
 }
 
 
 private static void increaseSize() {
	 Employee[] temp = new Employee[Emp1.length*2+1];
	for (int i=0;i<numEmployee;i++){
		temp[i]=Emp1[i];
	}
	Emp1=temp;
	 
	
}
public static int Search(String name){
	 for(int i=0;i<numEmployee;i++){
			if(Emp1[i].getName().equals(name)){
				return i;
			} 
	 }
			return -1;
	
	}
 
 public static void Delete(String name){
	 int i = Search(name);
	 if(i<0){
		 System.out.println("Employee not found.");
	 }
	 else if(i>=0){
	 numEmployee--;
	 Emp1[i]=Emp1[numEmployee];
	 Emp1[numEmployee]=null;
	 System.out.println("Employee deleted.");
 }
 }
 
 public static void raiseSalary(){
	 String str; int i; double percent,new_salary;
	 System.out.println("Enter name of the Employee: ");
	 str=scan.next();
	 i=Search(str);
	 if(i<0){
		 System.out.println("Employee not found.");
	 }
	 else if(i>=0){
		if(Emp1[i].getSecretary().equals("not available")) {//if not manager
			System.out.println("By how many percent do you want to raise this employee's salary?");
			
			 percent=scan.nextDouble();
			 while(percent<0){
				 System.out.println("Invalid percentage. Please re-enter");
				 percent=scan.nextDouble();
			 }
			 new_salary = Emp1[i].getSalary()*(1+(percent/100));
			 Emp1[i].setSalary(new_salary);
			}
			 
			 
		}
		else{ //if manager
			System.out.println("By how many percent do you want to raise this employee's salary?");
			 percent=scan.nextDouble();
			 new_salary = Emp1[i].getSalary()*(1+(percent/100))*bonus;
			 Emp1[i].setSalary(new_salary);
		}
		 
	 }

 
 public static void listAll(){
	
	 for(int i=0;i<numEmployee;i++){
		 System.out.println(Emp1[i]);
	 	
	 }
 }
 
 public static void main(String[] args) {
		int num=0;
		
	while(num>=0){
		if(numEmployee==0){
			isEmpty=true;
		}
		else if (numEmployee>=1){
			isEmpty=false;
		}
		printMenu();
		num=scan.nextInt();
		switch(num){
		case 1:
			Add(); //Add
			break;
		case 2:
			if(isEmpty){
				System.out.println("No employees to delete");
			}
		else if(!isEmpty){
			System.out.println("Enter the name of the employee you wish to delete");
			String str1;
			str1=scan.next();
			Delete(str1); 
			}//Delete
			break;
		case 3:
			if(isEmpty){
			System.out.println("No employees in the company");
			}
			else if(!isEmpty){
				raiseSalary(); //Raise salary
				}
			break;
		case 4: 
			if(isEmpty){
			 System.out.println("No employees to list.");
			}
			 else if(!isEmpty){
			listAll(); //List all
			 }
			break;
		case 5:
			System.out.println("Application closed.");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Number");
			break;
		}
	}
	}
}

