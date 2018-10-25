package pckg;

public class Employee {
	protected String Name,hireDay;
	protected static final int lebConv = 1500;
	protected double salary;
public Employee(String Name, String hireDay, double salary){
	this.Name=Name;
	this.hireDay=hireDay;
	this.salary=salary;
}
public String getName() {
	return Name;
}
public void setName(String Name) {
	this.Name = Name;
}
public String toString(){
	return "Employee's name: "+Name+", Employee's Hire day: "+hireDay+", Employee's salary in $: "+salary+"(in L.L.: "+salary*lebConv+").";
	
}
public String getSecretary() {
	return "not available";
}
/*public boolean equals(Employee x){
	if(x.getName()==Name){
		return true;
	}
	else
	return false;
}*/
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary=salary;
}
}
