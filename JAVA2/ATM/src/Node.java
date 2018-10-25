/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 7/04/2018
 *Associated files:Account.java, Accounts.java, ATM.java, Person.java, Queue.java, Transaction.java. 
 *Program Description: ATM Machine program, that runs from 9am till 6pm and puts every transaction in the queue after 6pm.
 */



public class Node {
private Transaction data;
private Node next;
	public Node(Transaction a) {//A constructor for instantiation
		data=a;
		next=null;
	}

	
	//Getters and Setters
	public Transaction getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next=next;
		
	}

}
