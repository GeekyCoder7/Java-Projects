/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 7/04/2018
 *Associated files:Account.java, Accounts.java, Node.java, Person.java, Queue.java, Transaction.java. 
 *Program Description: ATM Machine program, that runs from 9am till 6pm and puts every transaction in the queue after 6pm.
 */




import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
	
	private static Scanner scan = new Scanner(System.in);
	private final double amountPerDay;
	private double amountWithdrawed;
	String id="",password="";
	private int client_number;
	private Transaction transaction;
	private Queue queue=new Queue();
	
	public ATM() {	//A constructor for instantiation
		amountPerDay = 5000.0;
		amountWithdrawed=0;
		client_number = 1;
	}
	

	public void printMenu() {//method that prints menu 
		System.out.println("1. Withdraw money");
		System.out.println("2. Deposit money");
		System.out.println("3. Transfer of Money");
		System.out.println("4. Display account info");
		System.out.println("5. Exit");
		System.out.println("----------------------");
	}
	
	public String getDate() { //method that returns the date
		Date today = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dateFormat.format(today);
	}
	
	public int getHour() { //method that returns the hour of the day
		Calendar C = new GregorianCalendar();
        int hour = C.get( Calendar.HOUR_OF_DAY );
		return hour;
	}
	
	public String getTime() {//method that returns the time including the hour, minute, and seconds.
		Date today = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(today);
	}
	
	public void printTime() { //method that prints the time
		System.out.println("Welcome!");
		Date today = new Date();
		LocalDate currentDate = LocalDate.now();
        DayOfWeek dow = currentDate.getDayOfWeek();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//Date date = new Date();
		System.out.println(dow+ ", "+dateFormat.format(today));
	}
	
	
	
	
	public boolean validateUser() { //method that searches from the id-s and pass-s text file for a valid user.
		
		String[] ids_pass = new String[10];
		int count =0;
		boolean valid_user=false,b;
	
		
		System.out.println("Enter your ID number:");
		id=scan.next();
		System.out.println("Enter your password");
		password=scan.next();
		Scanner sc2 = null;
		try {
		    sc2 = new Scanner(new File("//Users//nazarethkeshishian//Desktop//IDSANDPASS.txt"));
		} catch (FileNotFoundException e) {
		    e.printStackTrace();  
		}
		while (sc2.hasNextLine()) {
		        Scanner s2 = new Scanner(sc2.nextLine());
		    
		    while (b = s2.hasNext()) {
		        String s = s2.next();
		        ids_pass[count]=s;
		        count++;
		    }
		}
		
		for(int j = 0 ;j<count;j+=2) {
			if(id.equalsIgnoreCase(ids_pass[j])&&password.equalsIgnoreCase(ids_pass[j+1])) {
					valid_user=true;
			}	
		}
			
		
		if(valid_user) {//if the user creds are correct
			
			return true;
		}
		else {//if the user creds are wrong
			System.out.println("User Not Found.");
			return false;
		}
	}
	
	
	public void withdraw(Person p,int num) { //method to withdraw money from a pre-existing account
		double amount = 0;
		Account current = p.getAccounts().getHeader();
		while(num!=current.getacc_number()) {
			current=current.getNext();
		}
		System.out.println("Enter the amount you want to withdraw:");
		amount=scan.nextDouble();
		while(amount>current.getBalance()) {
			System.out.println("Re-Enter the amount you want to transfer:");
			amount=scan.nextDouble();
		}
		 if(current.getBalance()>0&&current.getBalance()>=amount&&amountWithdrawed<amountPerDay) {
			
			
			while(amount+amountWithdrawed>amountPerDay) {
				System.out.println("Daily Limit Exceeded, Enter the amount you want to withdraw:");
				amount=scan.nextDouble();
			}
			if(getHour()<18&&getHour()>6) {
			transaction = new Transaction(p,current,getDate(),getTime(),"Withdrawal",amount);
			current.setBalance(current.getBalance()-amount);
			amountWithdrawed+=amount;
			}
			
			
			else {//if the time is after 6pm the transaction will be in the queue.
				transaction = new Transaction(p,current,getDate(),getTime(),"Withdrawal",amount);
				queue.enqueue(transaction);
				
			}
			
			
			
		}
		
		
	}
	
	
	public void deposit(Person p,int num) { //method that deposits money from a pre-existing account
		double amount = 0;
		Account current = p.getAccounts().getHeader();
		while(num!=current.getacc_number()) {
			current=current.getNext();
		}
		System.out.println("Enter the amount you want to deposit:");
		amount=scan.nextDouble();
		
		 
			if(getHour()<18&&getHour()>6) {
			transaction = new Transaction(p,current,getDate(),getTime(),"Deposit",amount);
			current.setBalance(current.getBalance()+amount);
			
			}
			
			
			else{//if the time is after 6pm the transaction will be in the queue.
				transaction = new Transaction(p,current,getDate(),getTime(),"Deposit",amount);
				queue.enqueue(transaction);
				
				
			}
			
			
		
		
	}
	public void transfer(Person p, int num,int num1) {//method to transfer money from 2 pre-existing accounts belonging to the same user
		double amount = 0;
		Account current = p.getAccounts().getHeader();
		Account current1 = p.getAccounts().getHeader();
		while(num!=current.getacc_number()) {
			current=current.getNext();
		}
		while(num1!=current1.getacc_number()) {
			current1=current1.getNext();
		}
		System.out.println("Enter the amount you want to transfer:");
		amount=scan.nextDouble();
		while(amount>current.getBalance()) {
			System.out.println("Re-Enter the amount you want to transfer:");
			amount=scan.nextDouble();
		}
		
			if(getHour()<18&&getHour()>6) {
			transaction = new Transaction(p,current,current1,getDate(),getTime(),"Transfer",amount);
			current.setBalance(current.getBalance()-amount);
			current1.setBalance(current1.getBalance()+amount);
			amountWithdrawed+=amount;
			}
			
			
			else {//if the time is after 6pm the transaction will be in the queue.
				transaction = new Transaction(p,current,current1,getDate(),getTime(),"Transfer",amount);
				queue.enqueue(transaction);
				
			}
			
			
			
		}
		
	
	
	


public static void main(String[] args) {
	int num=0;
	boolean isInt=false,emptyQueue=false;
	ATM atm1 = new ATM();

	boolean valid = atm1.validateUser();
	
	
	//creating accounts
	//person1 
	Account acc1 = new Account(1,"Checking",1205.18);
	Account acc2 = new Account(2,"Savings",103.7);
	Account acc3 = new Account(3,"Savings",203.7);
	Accounts accounts = new Accounts(acc1);
	accounts.add(acc2);
	accounts.add(acc3);
	Person p1 = new Person("201801523",atm1.client_number,accounts);
	
	atm1.client_number++;
	//person2
	Account acc4 = new Account(1,"Checking",521.18);
	Account acc5 = new Account(2,"Savings",752.7);
	Account acc6 = new Account(3,"Savings",952.57);
	Accounts accounts1 = new Accounts(acc4);
	accounts1.add(acc5);
	accounts1.add(acc6);
	Person p2 = new Person("20185236",atm1.client_number,accounts1);
	
	while(!valid) {
		valid = atm1.validateUser();
	}
	new java.util.Timer().schedule( 			//refreshes every 2s
	        new java.util.TimerTask() {
	            @Override
	            public void run() {
	            	if(atm1.getHour()<18&&atm1.getHour()>=6) {
	            	try{
	            		
	        			atm1.queue.Dequeue();	
	        		}
	        		catch(NullPointerException e) {
	        			System.out.println("Queue is empty");
	        		}
	            	System.out.println("All transactions are done");
	            	}
	            }
	        }, 
	        2000 //2000ms = 2s
	);
	
	while(valid) {
	
		atm1.printTime();
		atm1.printMenu();
		while(!isInt){
			try {
				 num=scan.nextInt();
			isInt = true;
		}
		catch(InputMismatchException e) {
			System.out.print("Error. Re-enter value: ");
		}
			scan.nextLine();
			
		}
		isInt=false; 
	
		switch(num) {
		case 1:
			
			System.out.println("From which account you want to withdraw? ");
			System.out.println(accounts);
			while(!isInt){
				try {
					 num=scan.nextInt();
				isInt = true;
			}
			catch(InputMismatchException e) {
				System.out.print("Error. Re-enter value: ");
			}
				scan.nextLine();
				
			}
			isInt=false; 
			
			
			atm1.withdraw(p1,num);
			break;
		case 2:
			System.out.println("Into which account you want to deposit? ");
			System.out.println(accounts);
			while(!isInt){
				try {
					 num=scan.nextInt();
				isInt = true;
			}
			catch(InputMismatchException e) {
				System.out.print("Error. Re-enter value: ");
			}
				scan.nextLine();
				
			}
			isInt=false; 
			atm1.deposit(p1,num);
			
			break;
		case 3:
			int num1=num;
			while(num==num1) {
			
			System.out.println("From which account you want to transfer money?(Can't tranfer to the same account)");
			System.out.println(accounts);
			while(!isInt){
				try {
					 num=scan.nextInt();
									isInt = true;
			}
			catch(InputMismatchException e) {
				System.out.print("Error. Re-enter value: ");
			}
				scan.nextLine();
				
			}
			isInt=false; 
			System.out.println("To which account you want to transfer money?");
			System.out.println(accounts);
			while(!isInt){
				try {
		
					 num1=scan.nextInt();
				isInt = true;
			}
			catch(InputMismatchException e) {
				System.out.print("Error. Re-enter value: ");
			}
				scan.nextLine();
				
			}
			isInt=false;
			}
			atm1.transfer(p1,num,num1);
			break;
		case 4:
			if(atm1.id.equalsIgnoreCase(p1.getName())) {
			System.out.println(accounts);
			}
			else if(atm1.id.equalsIgnoreCase(p2.getName())) {
				System.out.println(accounts1);
				}
			break;
		case 5:
			if(!atm1.queue.isEmpty()) {
			System.out.println("Do you want to see which of your transaction are in the queue?(Y/N)");
			String str =scan.next();
			if(str.equalsIgnoreCase("y")) {
				atm1.queue.print(atm1.id);
			}
			
			}
			
			valid=false;
				while(!valid) {
				valid = atm1.validateUser();
				}
			
			break;
	
			default:
				System.out.println("Invalid Number");
				break;
			}
		}
	}
}