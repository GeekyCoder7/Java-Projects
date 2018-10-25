package Bank;

public class Account {

	private double balance;
	private String name;
	private long acctNum;
	final int FEE=10;
	
	public Account(double initBal,String owner,long number){
		balance=initBal;
		name=owner;
		acctNum=number;
	}
	
	public void withdraw(double amount){
		if(balance>=amount){
		balance -= amount;
		}
		else {
			System.out.println("Insufficient funds");
		}
	}
	
	
	public void deposit(double amount){
		balance+=amount;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public String toString(){
		
		return ("Name: "+name +", Account Number: "+ acctNum + ", Current Balance: " + balance);
	}
	
	public double chargeFee(){
		balance-=FEE;
		return balance;
	}
	
	
	public void changeName(String newName){
		name = newName;
	}

}
