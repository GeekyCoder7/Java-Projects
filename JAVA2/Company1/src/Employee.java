/*Name: Nazareth H. Keshishian
 *Date Last Modified: 07/02/2018
 *Associated files:  Company.java, Manager.java 
 * Program Description: A company program that has employees who can be
 * either manager or a basic employee.
 */

public class Employee {
	
	protected String name,hire_day;				//Initializing variables
	protected final int LEB_CONVERT = 1500;
	protected double salary;
	
	public Employee(String name, String hire_day, double salary){	//Constructor
		this.name=name;
		this.hire_day=hire_day;
		this.salary=salary;
	}
	public String getName() {			//This method returns the name of an employee.
		return name;
	}
	public void setName(String Name) {	//By calling this method, we can set the name of an employee.
		this.name = Name;
	}
	public String toString(){		//Return the information of an employee
		return "Employee's name: "+name+", Employee's Hire day: "+hire_day+", Employee's salary in $: "+salary+"(in L.L.: "+salary*LEB_CONVERT+").";
		
	}
	public String getSecretary() {	//We set this to compare a manager and a regular employee.
		return "not available";
	}
	public boolean equals(Employee x){			//This method checks if the employee1 and employee2 have the same name or not.
		if(x.getName().equalsIgnoreCase(name)){
			return true;
		}
		return false;
	}
	public double getSalary() {					//This method returns the salary of an employee.
		return salary;
	}
	public void setSalary(double salary) {		//By calling this method, we can set the salary of an employee.
		this.salary=salary;
	}
}
