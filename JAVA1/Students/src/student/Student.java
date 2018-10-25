package student;

public class Student {
private int ID;
private String name;
private int numberofCredits;

public Student(int ID, String name, int numberofCredits){
	this.ID=ID;
	this.name=name;
	this.numberofCredits=numberofCredits;
	
	
}

public void setID(int ID){
	this.ID=ID;
}

public void setName(String name){
	this.name=name;
}

public void setCredits(int numberofCredits){
	this.numberofCredits=numberofCredits;
}

public int calculatefees(int fees){
	return fees*numberofCredits;
}

public int getID(){
	return ID;
}


public String getName(){
	return name;
}



public int getCredits(){
	return numberofCredits;
}

public String toString(){
	return  "ID: " + ID +", Name: "+name+" , Credits: "+numberofCredits;
	 
}


}
