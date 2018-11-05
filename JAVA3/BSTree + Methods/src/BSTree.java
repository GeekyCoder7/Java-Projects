/*Name: Nazareth H. Keshishian
 *Student ID: 201701143
 *Date Last Modified: 18/10/2018
 *Associated files: BSTNode.java, Main.java. 
 * Program Description: BST.
 */
package Question2;

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

 
 public BSTNode getMax(BSTNode root) { 
     BSTNode current = root;
     while (current.getRight() != null) { 
         current = current.getRight() ; 
     } 
     return current;
 } 
 
 
 public BSTNode getMin(BSTNode root) { 
     BSTNode current = root; 
     while (current.getLeft() != null) { 
         current = current.getLeft() ; 
     } 
     return current;
 } 
 
 public boolean search(BSTNode current, int number) {//searches, function 5
		if(current==null) {
			return false;
		}
		else {

			if(current.getNumber()==number) {
				return true;
			}
			else if(current.getNumber()>=number) {
				return search(current.getLeft(),number);//go to left
			}
			else if (current.getNumber()<number) {
				return search(current.getRight(),number);//go to right
			}
		}
		return false;
	}
 
 public boolean isBinaryTree(BSTNode current, int min, int max){ 
	 if (current == null) {
	 	return true; 
	 }
	 if (current.getNumber() < min || current.getNumber() > max) {
		return false; 
	 }
	 return (isBinaryTree(current.getLeft(), min, current.getNumber()-1)&&
			 isBinaryTree(current.getRight(), current.getNumber()+1, max)); 
	 }
 

 public boolean delete(BSTNode current,int i){
			 if(current==null) {
			 return false;
			 }
			 
			 if(i==current.getNumber()){
			 current=null;
			 return true;
			 }
			 
		 boolean flag=true;
		 while(flag){
			 if(current==null) {
			 return false;
			 }
			 if(i<=current.getNumber()){
				 	if(current.getLeft()!=null){
				 			if(i!=current.getLeft().getNumber()) {
				 					current=current.getLeft();
				 			}
					 else{
						 BSTNode n1=current.getLeft().getLeft();
						 BSTNode n2=current.getLeft().getRight();
						 current.setLeft(null);
						 if(n1!=null) {
						 add(current,n1);
						 }
						 if(n2!=null) {
						 add(current,n2);
						 }
					 return true;
					 }
				 	}
			 else {
			 return false;
			 }
		 }
		 else{
		 if(current.getRight()!=null){
			 if(i!=current.getRight().getNumber()) {
			 current=current.getRight();
			 }
			 else{
			 BSTNode n1=current.getRight().getLeft();
			 BSTNode n2=current.getRight().getRight();
			 current.setRight(null);
			 if(n1!=null) {
			 add(current,n1);
			 }
			 if(n2!=null) {
			 add(current,n2);
			 }
			 return true;
			 }
		 }
			 else
			 return false;
			 }
		 }
		 return false;
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
					return true;
				}
				else{
					current.setRight(n);
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
					}
				}
				else if(n.getNumber()>current.getNumber()) {
					if(current.getRight()!=null) {
					return add(current.getRight(),n);//go to right
					}
					else {
						current.setRight(n);//set to right
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
