package pckg;

public class Manager extends Employee {
	
	private String secretary;
public Manager(String Name, String hireDay, double salary,String secretary) {
		super(Name, hireDay, salary);
		this.setSecretary(secretary);
	}
public String getSecretary() {
	return secretary;
}
public void setSecretary(String secretary) {
	this.secretary = secretary;
}
public String toString(){
	return "M "+ super.toString() +", Employee's Seceretary: "+ secretary;
}

}
