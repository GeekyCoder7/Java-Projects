/*Name: Nazareth H. Keshishian
 *Student ID: 201701143
 *Date Last Modified: 18/10/2018
 *Associated files: BSTree.java, BSTNode.java. 
 * Program Description: BST.
 */


public class Main {
	static BSTree bst3 = new BSTree(null);

	
	
	static BSTNode merge(BSTNode node1, BSTNode node2,int[]nums,int index){ 
	    if (node1 == null) {
	        return node2; 
	    }
	    if (node2 == null) {
	        return node1; 
	    }
	    nums[index++]=node1.number;
	    node1.left = merge(node1.left, node2.left,nums,index); 
	    node1.right = merge(node1.right, node2.right,nums,index); 
	    return node1; 
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTree bst1 = new BSTree(new BSTNode(10));
		bst1.add(bst1.getRoot(), new BSTNode(10));
		bst1.add(bst1.getRoot(), new BSTNode(9));
		bst1.add(bst1.getRoot(), new BSTNode(11));
		bst1.add(bst1.getRoot(), new BSTNode(13));
		
		BSTree bst2 = new BSTree(new BSTNode(15));
		bst2.add(bst2.getRoot(), new BSTNode(16));
		bst2.add(bst2.getRoot(), new BSTNode(7));
		bst2.add(bst2.getRoot(), new BSTNode(12));
		bst2.add(bst2.getRoot(), new BSTNode(11));
		int[] nums = new int[bst1.getCount()+bst2.getCount()+1];
		bst3.setRoot(merge(bst1.getRoot(),bst2.getRoot(),nums,0));
		
		System.out.println(bst3.printAll(bst3.getRoot()));
	}

}
