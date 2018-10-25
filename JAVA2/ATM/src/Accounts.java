
/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 7/04/2018
 *Associated files:Account.java, ATM.java, Node.java, Person.java, Queue.java, Transaction.java. 
 *Program Description: ATM Machine program, that runs from 9am till 6pm and puts every transaction in the queue after 6pm.
 */



public class Accounts {
	private Account header;

	public Accounts(Account account) {	//A constructor for instantiation
		header=account;
	}
	
	public void add(Account data) { //method that adds and account in the Accounts LinkedList
		if(header==null) {
			header=data;
		}
		else {
			Account n = data;
			Account current = header;
		
			while(current.getNext()!=null) {
				current=current.getNext();
			}
			if(current.getNext()==null) {
				current.setNext(n);
			}
		}
	}
	
	public Account getHeader() {	
		return header;
	}
	
	public String toString() {//method that prints all the accounts and its information.
		Account current=header;
		String str="";
		while(current.getNext()!=null) {
			str+=current.toString();
			current=current.getNext();	
		}
		if(current.getNext()==null) {
			str+=current.toString();
		}
		return str;
	}
}