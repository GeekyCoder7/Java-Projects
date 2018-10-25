/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 7/04/2018
 *Associated files:Account.java, Accounts.java, Node.java, ATM.java, Queue.java, Transaction.java. 
 *Program Description: ATM Machine program, that runs from 9am till 6pm and puts every transaction in the queue after 6pm.
 */




public class Person {
private String name;
@SuppressWarnings("unused")
private int client_number;
private Accounts accounts;

public Person(String name,int client_number, Accounts accounts) {//A constructor for instantiation
	this.name=name;
	this.client_number=client_number;
	this.accounts=accounts;
}

//Getters and Setters
public String getName() {
	return name;
}

public Accounts getAccounts() {
	return accounts;
}
}
