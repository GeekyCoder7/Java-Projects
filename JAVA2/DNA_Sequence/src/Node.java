/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 17/03/2018
 *Associated files:DNA_Sequence.java, Main.java. 
 *Program Description: Class Node.
 */

public class Node {
private String data;
private Node next;
public Node(String s) {	//A constructor for instantiation
	data=s;
	next=null;
}
public void setData(String data) {//set data
	this.data=data;
}
public String getData() {//returns the data
	return data;
}
public void setNext(Node next) {//sets the next node
	this.next=next;
}
public Node getNext() {//gets the next node
	return next;
}
}
