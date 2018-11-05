
/*Name: Nazareth H. Keshishian
 *Student ID: 201701143
 *Date Last Modified: 18/10/2018
 *Associated files: BSTree.java, Main.java. 
 * Program Description: BST.
 */

package Question2;

public class BSTNode {
private int number;
private BSTNode right, left;

	public BSTNode(int number) {//constructor
		this.setNumber(number);
		right=left=null;
	}
	public boolean isLeaf() {
		return (right==null&&left==null);
	}

	
	public BSTNode getRight() {
		return right;
	}
	public void setRight(BSTNode right) {
		this.right = right;
	}
	public BSTNode getLeft() {
		return left;
	}
	public BSTNode setLeft(BSTNode left) {
		this.left = left;
		return left;
	}
	
	public boolean equals(BSTNode n) {
		if(this.number==n.getNumber()) {
			return true;
		}
		return false;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	

}
