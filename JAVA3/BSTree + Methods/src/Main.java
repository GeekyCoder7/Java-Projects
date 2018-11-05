/*Name: Nazareth H. Keshishian
 *Student ID: 201701143
 *Date Last Modified: 18/10/2018
 *Associated files: BSTree.java, BSTNode.java. 
 * Program Description: BST.
 */
package Question2;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTree bst1 = new BSTree(new BSTNode(10));
		bst1.add(bst1.getRoot(), new BSTNode(8));
		bst1.add(bst1.getRoot(), new BSTNode(9));
		bst1.add(bst1.getRoot(), new BSTNode(11));
		bst1.add(bst1.getRoot(), new BSTNode(13));
		System.out.println(bst1.getMax(bst1.getRoot()).getNumber());
		System.out.println(bst1.getMin(bst1.getRoot()).getNumber());
		System.out.println(bst1.search(bst1.getRoot(), 11));
		bst1.delete(bst1.getRoot(),11);
		System.out.println(bst1.printAll(bst1.getRoot()));
		System.out.println(bst1.isBinaryTree(bst1.getRoot(), bst1.getMin(bst1.getRoot()).getNumber(),
										bst1.getMax(bst1.getRoot()).getNumber()));
	}

}
