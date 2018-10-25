/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 9/04/2018
 *Associated files:Main.java. 
 *Program Description: program that evaluates a postfix arithmetic expression.
 */
 


public class Stack {
	private int[] data;
	private int count=0;
	
	public Stack() {//A constructor for instantiation
		data= new int [1];
	}
	
	public void push(int i) { //method that pushes the last element
		if(count==data.length) {
			increaseSize();
		}
		data[count]=i;
		count++;
	}
	
	private void increaseSize() {//method that automatically increases the size of the stack
		// TODO Auto-generated method stub
		int[] temp = new int[data.length*2+1];
		for(int i = 0;i<count;i++) {
			temp[i]=data[i];
		}
		data=temp;
	}

	public int size() { //returns the number of elements in the stack
		return count;
	}
	
	public int pop() { //method that pops the element inside the stack
		if(count==0) {
			return -99;
		}
		count--;
		int num=data[count];
		data[count]=0;
		return num;
	}
	
	public int print() { //method that calculates the sum and returns
		int i =0;
		for(int j =0;j<count;j++) {
			i+=data[j];
		}
		return i;
	}
	
}
