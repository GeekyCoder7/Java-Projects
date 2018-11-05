/*Name: Nazareth H. Keshishian
 *Student ID: 201701143
 *Date Last Modified: 18/10/2018
 *Associated files: BSTNode.java, Main.java. 
 * Program Description: BST.
 */

import java.util.Scanner;

public class BSTree {
	private BSTNode root;
	private int count;
	//private int[] numbers;
	private static Scanner scan;
	public BSTree(BSTNode root) {//constructor
		this.root=root;
		count=0;
		//numbers=new int[2];
		scan = new Scanner(System.in);
	}
	
	public BSTNode getRoot() {//returns the root of the tree
		return root;
	}
	public void setRoot(BSTNode root) {
		this.root=root;
	}
	
	public int getCount() {
		return count;
	}

public boolean add(BSTNode current,BSTNode n) {//Adds an element in the tree, 3
		
		if(n==null) {
			return false;
		}
		else {
			if(root==null) {
			root=n;
			return true;
			}
		
		else if(current!=null){
			
			
			if(current.isLeaf()) {//if leaf
				if(n.getNumber()<=current.getNumber()) {
					current.setLeft(n);
					count++;
					return true;
				}
				else{
					current.setRight(n);
					count++;
					return true;
				}	
			}
			else{//if not leaf
				if(n.getNumber()<=current.getNumber()) {
					if(current.getLeft()!=null) {
					return add(current.getLeft(),n);//go to left
					}
					else {
						current.setLeft(n);//set to left
						count++;
					}
				}
				else if(n.getNumber()>current.getNumber()) {
					if(current.getRight()!=null) {
					return add(current.getRight(),n);//go to right
					}
					else {
						current.setRight(n);//set to right
						count++;
						}
					}	
				}
			}
		}
			return false;
	}

public String printAll(BSTNode root) {//prints all the numbers in the tree in infix order
	if(root==null) {
		return "";
	}
	
	 return printAll(root.getLeft())+" "+root.getNumber()+" "+printAll(root.getRight());
}
}
	