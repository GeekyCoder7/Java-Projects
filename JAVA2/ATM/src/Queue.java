
/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 7/04/2018
 *Associated files:Account.java, Accounts.java, Node.java, Person.java, ATM.java, Transaction.java. 
 *Program Description: ATM Machine program, that runs from 9am till 6pm and puts every transaction in the queue after 6pm.
 */



public class Queue {
	public Node header;
	
	public Queue() {//A constructor for instantiation
		header=null;
	}
	
	public void enqueue(Transaction t) {//method that set a transaction and puts it in the queue
		if(header==null) {
			header = new Node(t);
		}
		else {
			Node n =new Node(t);
			Node current = header;
			
			while(current.getNext()!=null) {
				current=current.getNext();
			}
			if(current.getNext()==null) {
				current.setNext(n);
			}
		}
	}
	public void print(String n) {//method that prints every element in the queue 
		
		if(!isEmpty()) {
			Node current = header;
			while(current.getNext()!=null) {
				if(current.getData().getPerson().getName().equalsIgnoreCase(n)) {
					System.out.println(current.getData().toString());
					current=current.getNext();
				}
			}
			if(current.getNext()==null) {
				System.out.println(current.getData().toString());
			}
			
		}
		else {
			System.out.println("Queue is empty.");
		}
	}
	
	public void Dequeue() {//method that removes a transaction from the queue
		if(!isEmpty()) {
			Node current = header;
			header=header.getNext();
			if(current.getData().getType().equalsIgnoreCase("Deposit")) { //type deposit
			current.getData().getAccount().setBalance(current.getData()
					.getAmount()+current.getData().getAccount().getBalance());
			current.setNext(null);
			}
			
			else if(current.getData().getType().equalsIgnoreCase("Withdrawal")) { //type withdrawal
				current.getData().getAccount().setBalance(current.getData().getAccount().getBalance()
						-current.getData().getAmount());
				current.setNext(null);
			}
			
			else if(current.getData().getType().equalsIgnoreCase("Transfer")){ //type transfer
				current.getData().getAccount().setBalance(current.getData().getAccount().getBalance()
						-current.getData().getAmount());
				current.getData().getAccount1().setBalance(current.getData().getAccount1().getBalance()
						+current.getData().getAmount());
				current.setNext(null);
			}
		}
		else { //if empty
			return;
		}
	}

	public boolean isEmpty() {//method that checks if the queue is emoty or not
		return (header==null);
	}
}
