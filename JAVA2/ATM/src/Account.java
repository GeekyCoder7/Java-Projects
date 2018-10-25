/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 7/04/2018
 *Associated files:ATM.java, Accounts.java, Node.java, Person.java, Queue.java, Transaction.java. 
 *Program Description: ATM Machine program, that runs from 9am till 6pm and puts every transaction in the queue after 6pm.
 */





public class Account {
private int acc_number;
private String type;
private double balance;
private Account next;

public Account(int acc_number, String type, double balance) {	//A constructor for instantiation
	this.acc_number=acc_number;
	this.type=type;
	this.balance=balance;
}

//Getters and Setters 
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance=balance;
}

public int getacc_number() {
	return acc_number;
}


public void setNext(Account next) {
	this.next=next;
}

public Account getNext() {
	return next;
}

public String toString() {//method that returns the account infomation.
	return "Account Number: "+acc_number+", Account type: "+type+", Balance: "+balance+" \n";
}

}
