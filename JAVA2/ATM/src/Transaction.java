
/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 7/04/2018
 *Associated files:Account.java, Accounts.java, Node.java, Person.java, Queue.java, ATM.java. 
 *Program Description: ATM Machine program, that runs from 9am till 6pm and puts every transaction in the queue after 6pm.
 */



public class Transaction {
private String date,time,type;
private double amount;
private Person person;
private Account account,account1;
//type deposit ,whitdrawal or transfer of money

public Transaction(Person person,Account account ,String date,String time,String type,double amount) {
	//A constructor for instantiation
	this.person=person;
	this.account=account;
	this.date=date;
	this.time=time;
	this.type=type;
	this.amount=amount;
}

public Transaction(Person person, Account account, Account account1, String date, String time, String type,
		double amount) {
	//Another constructor used for transfering money from acc to acc1.
	this.person=person;
	this.account=account;
	this.account1=account1;
	this.date=date;
	this.time=time;
	this.type=type;
	this.amount=amount;
}


//Getters and Setters
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Person getPerson() {
	return person;
}

public Account getAccount() {
	return account;
}
public void setAccount(Account account) {
	this.account = account;
}

public Account getAccount1() {//getAccount1 gets the account in which the money is going to be transfered.
	return account1;
}
public void setAccount1(Account account1) {//setAccount1 sets the account in which the money is going to be transfered.
	this.account1 = account1;
}

public String toString() { //returns a transaction's info.
	return "Transaction: Person: "+person.getName()+", date: "+date+", time: "+time
						+", type: "+type+", amount: "+amount;
}
}
