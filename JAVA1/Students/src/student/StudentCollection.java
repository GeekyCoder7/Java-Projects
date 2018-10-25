package student;

import java.util.Scanner;


public class StudentCollection {
private  Student[] s;
private   int ID;
private   String name;
private   int Credits;
private static  int count;

 Scanner scan = new Scanner(System.in);

public StudentCollection(int size){
	s = new Student[size];
	count=0;
	
}

 void Add(){
	 IncreaseCapacity();
	System.out.println("Enter ID:");
	ID=scan.nextInt();
	
	System.out.println("Enter Name:");
	name  = scan.next();
	
	System.out.println("Enter Credits:");
	Credits = scan.nextInt();
	Student student = new Student(ID, name, Credits);
	student.calculatefees(1000);
	s[count]=student;
	count++;
	//String n = toString();
	//System.out.println(n);
	print();
	}
public void print(){
	for(int i =0;i<count;i++){
		System.out.println(s[i].toString()+", fees: " +s[i].calculatefees(500)+"$");
	}
}
 
 public void IncreaseCapacity(){
	 if(count==s.length){
		 Student[] temp = new Student[s.length*2+1];
		 for(int j = 0; j<s.length;j++){
			 temp[j]=s[j];
		 }
		 s=temp;
	 }
 }
 

 public int Search(int ID){
	 for(int w=0;w<count;w++){
			if(s[w].getID()==ID){
				return w;
			} 
	 }
			return -1;
	
	}
 
 public boolean Delete(int ID){
	 int L = Search(ID);
	 if(L<0){
		 return false;
	 }
	 count--;
	 s[L]=s[count];
	 s[count]=null;
	 return true;
 }
 
public static void main(String[] args) {
	// TODO Auto-generated method stub
	StudentCollection y = new StudentCollection(1);
	for(int q=0;q<=count;q++)
		y.Add();
		
	
}
}
//asks the user for student info
//create a new student
//Add it to the array

