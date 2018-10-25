/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 04/05/2018
 *Associated files:Main.java,BSTree.java. 
 */

public class BSTNode {
private String word,description;
private BSTNode right, left;

	public BSTNode(String word, String description) {//constructor
		this.setWord(word);
		this.setDescription(description);
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
		if(word.equalsIgnoreCase(n.getWord())&&description.equalsIgnoreCase(n.getDescription())) {//if same word and same description
			
			System.out.println("Two equal definitions cannot be in the tree at the same time");
			return true;
			
		}
		
		return false;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	

}
