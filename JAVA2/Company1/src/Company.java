/*Name: Nazareth H. Keshishian
 *Date Last Modified: 07/02/2018
 *Associated files: Employee.java, Manager.java 
 * Program Description: A company program that has employees who can be
 * either manager or a basic employee.
 */


import java.util.Scanner;

public class Company {
	
 private Employee[] employees;
 private Scanner scan;
 private int num_employees,count_exit;
 private final double BONUS;
 private boolean isEmpty;
 
 public Company() { 						//A constructor for instantiation
	 employees = new Employee[10];
	 scan  = new Scanner(System.in);
	 num_employees=0;
	 count_exit=0;
	 BONUS =1.02;
	 isEmpty =true;
 }
 
 
 public String changePi(String str) {
	  
	   if(str.length()==0){
	    return "";
	  }
	 else if(str.length()==1){
	    return str;
	  }
	  else if(str.substring(0,2).equals("pi")){
		 
	    return "3.14"+changePi(str.substring(2));
	  }
	  
	 
	  return str.charAt(0)+changePi(str.substring(1));
	}

 


 
 public void printMenu(){	
	 String str ="3.14pi";
	 String str1= changePi(str);
	
	//if( str.substring(0,1).equals("x"))
	 System.out.println(str.substring(4));
	//A default printMenu method which prints the menu(Used to simplify code in the main())
	 	System.out.println("1. Add employee");
		System.out.println("2. Delete employee");
		System.out.println("3. Raise salary");
		System.out.println("4. List all");
		System.out.println("5. Exit");
		System.out.println("---------------");
		System.out.println("Enter your choice:");
 }
 
 
 											//This method first of all prompts the user for the employee's name.
	 public void Add() {						
	 String name,hireDay,str,secretary;		 
	 double salary;
	 boolean sameName=false;
	 
	 if(num_employees==employees.length){
		 increaseSize();
	 }
	 
	 System.out.println("Enter Employee's name");
	 name=scan.next();
	 Employee e1 = new Employee(name,"0",0);
	 
	 if(num_employees>=1){
		for(int i=0; i<num_employees;i++){
			if(employees[i].equals(e1)){ 			// If the name exists in the array, the employee with the same name can't be added
				sameName=true;
				System.out.println("An employee with the same name exists."
						+ " Can't add this employee.\n");
		 	}
		 }
	 }

	 if(!sameName){											//If the name does not exist in the array, the user will choose if that employee is a manager or not.
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
		 employees[num_employees]=new Manager(name,hireDay,salary,secretary);
		 System.out.println("Employee (Manager) added successfully");			//Manager Added
		 num_employees++;
	
	 }
	 
	 	else{
			 employees[num_employees]=new Employee(name,hireDay,salary);
			 System.out.println("Employee added successfully");
			 num_employees++;														//Employee Added
			 System.out.println(num_employees);
	 	}
	 }
 }
 
 
 private void increaseSize() {							//If the initial size of the array which is 10 gets full, this method automatically creates a new array 2x bigger 
	 Employee[] temp = new Employee[employees.length*2+1];

	 for (int i=0;i<num_employees;i++){
		temp[i]=employees[i];
	}
	employees=temp;
}
 
public int Search(String name){				//This method search the Employee by its name in the Array.
	 for(int i=0;i<num_employees;i++){
			if(employees[i].getName().equals(name)){
				return i;							//Return the index if the employees name is found
			} 
	 }
			return -1;								//Else returns -1
	
	}
 
 public void Delete(String name){			//After searching the index of that employee, we remove that employee from the array.
	 int i = Search(name);
	 if(i<0){
		 System.out.println("Employee not found.");
	 }
	 else if(i>=0){	
	 num_employees--;								
	 employees[i]=employees[num_employees];
	 employees[num_employees]=null;
	 System.out.println("Employee deleted.");
 }
 }
 
 public void raiseSalary(){						//This method raises the salary of an employee. 
	 String str; int i; double percent,new_salary;
	 System.out.println("Enter name of the Employee: ");
	 str=scan.next();
	 i=Search(str);
	 if(i<0){
		 System.out.println("Employee not found.");
	 }
	 else if(i>=0){
		if(employees[i].getSecretary().equals("not available")) {//if not manager
			System.out.println("By how many percent do you want to raise this employee's salary?");
			
			 percent=scan.nextDouble();
			 while(percent<0){
				 System.out.println("Invalid percentage. Please re-enter");
				 percent=scan.nextDouble();
			 }
			 new_salary = employees[i].getSalary()*(1+(percent/100));
			 employees[i].setSalary(new_salary);
			}
			 
			 
		}
		else{ //if manager
			System.out.println("By how many percent do you want to raise this employee's salary?");
			 percent=scan.nextDouble();
			 new_salary = employees[i].getSalary()*(1+(percent/100))*BONUS;
			 employees[i].setSalary(new_salary);
		}
		 
	 }

 
 public void listAll(){			//This method lists all employees in the array 
	
	 for(int i=0;i<num_employees;i++){
		 System.out.println(employees[i]);
	 	
	 }
 }
 
 public static void main(String[] args) {
		int num=0;
		Company c1 = new Company();
		
	while(true){
		if(c1.count_exit>=5) {
			System.out.println("Application Closed.");
			System.exit(0);
		}
		if(c1.num_employees==0){				//if there is no employees in the array, we make the boolean isEmpty to true.
			c1.isEmpty=true;					//So every time the user tries to delete/raise salary/List all, the program will say that there is no employees.
		}
		else if (c1.num_employees>=1){
			c1.isEmpty=false;
		}
		c1.printMenu();
		num=c1.scan.nextInt();
		switch(num){
		case 1:
			c1.Add(); //Add
			break;
		case 2:
			if(c1.isEmpty){
				System.out.println("No employees to delete");
			}
		else if(!c1.isEmpty){
			System.out.println("Enter the name of the employee you wish to delete");
			String str1;
			str1=c1.scan.next();
			c1.Delete(str1); 
			}//Delete
			break;
		case 3:
			if(c1.isEmpty){
			System.out.println("No employees in the company");
			}
			else if(!c1.isEmpty){
				c1.raiseSalary(); //Raise salary
				}
			break;
		case 4: 
			if(c1.isEmpty){
			 System.out.println("No employees to list.");
			}
			 else if(!c1.isEmpty){
			c1.listAll(); //List all
			 }
			break;
		case 5:
			System.out.println("Application closed.");
			System.exit(0);
			break;
		default:										//Invalid number if different from 1,2,3,4,5.
			System.out.println("Invalid Number");
			c1.count_exit++;
			break;
		}
	}
	}
}

