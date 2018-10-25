/*Name: Nazareth H. Keshishian
 *Date Last Modified: 07/02/2018
 *Associated files:  Company.java, Employee.java 
 * Program Description: A company program that has employees who can be
 * either manager or a basic employee.
 */

public class Manager extends Employee {
	
	private String secretary;
	
	
	public Manager(String name, String hire_day, double salary,String secretary) {
			super(name, hire_day, salary);
			this.setSecretary(secretary);
		}
	public String getSecretary() {	//This method returns the manager's secretary name.
		return secretary;
	}
	public void setSecretary(String secretary) {		//By calling this method, we can set the manager's secretary's name.
		this.secretary = secretary;
	}
	public String toString(){		//This method returns the information of the manager, including his/her secretary's name.
		return "M "+ super.toString() +", Employee's Seceretary: "+ secretary;
	}

}
