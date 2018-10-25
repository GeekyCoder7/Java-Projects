/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 03/05/2018
 *Associated files:Main.java,BSTNode.java. 
 */
import java.util.Scanner;

public class BSTree {
	private BSTNode root;
	private String str1;
	private int count,count_words;
	private String[] words,definitions;
	private static Scanner scan;
	public BSTree() {//constructor
		root=null;
		str1="";
		count=0;
		words=new String[2];
		definitions=new String[2];
		scan = new Scanner(System.in);
	}
	
	public BSTNode getRoot() {//returns the root of the tree
		return root;
	}
	


	public String listAll(BSTNode current) {//list all items one over the other, in order to save it later in the text file
		if(current==null) {
			return "";
		}
		else {
			
				System.out.println(current.getWord()+": "+current.getDescription());
				return listAll(current.getLeft())+listAll(current.getRight());
			}
			
	}
	
	public String fillArrayForRemoveAll(BSTNode current, String word) {//used to remove all elements with the same word from the tree.
		if(current==null) {
			return "";
		}
		else {
		
			if(current.getWord().equalsIgnoreCase(word)) { //if same word, go to left and right
				return fillArrayForRemoveAll(current.getLeft(),word)+fillArrayForRemoveAll(current.getRight(),word);
			}
			else {//if not equal, fill in the array, and go to left and right
				if(words.length==count_words) {
					increaseSize();
				}
				words[count_words]=current.getWord();
				definitions[count_words]=current.getDescription();
				count_words++;
				return fillArrayForRemoveAll(current.getLeft(),word)+fillArrayForRemoveAll(current.getRight(),word);
				
			}
		}
	}
	
	
	public String fillArrayForRemoveElement(BSTNode current, String word,String description) {//used to remove a specific element specified with its word and its description from the tree.
		if(current==null) {
			return "";
		}
		else if(!(current.getWord().equalsIgnoreCase(word))||!(current.getDescription().equalsIgnoreCase(description))) { 
			//if not equal, fill in the array, and go to left and right
			if(words.length==count_words) {
				increaseSize();
			}
			words[count_words]=current.getWord();
			definitions[count_words]=current.getDescription();
			count_words++;
			return fillArrayForRemoveElement(current.getLeft(),word,description)+fillArrayForRemoveElement(current.getRight(),word,description);
			
			
			
			}
			
			else {//if same word, go to left and right
				return fillArrayForRemoveElement(current.getLeft(),word,description)+fillArrayForRemoveElement(current.getRight(),word,description);
				
			}
		}
	

	
private void increaseSize() {//used to increase size of the arrays.
		String[] temp = new String[words.length*2+1];
		String[] temp1 = new String[words.length*2+1];
		for(int i =0; i<count_words;i++) {
			temp[i]=words[i];
			temp1[i]=definitions[i];
		}
		words=temp;
		definitions=temp1;
	}


public String search(BSTNode current, String str) {//searches for every element that matches with the word that the user entered, and displays all appearances.
		if(current==null) {
			count=0;
			return str1;
		}
		else {
			if(count==0) {
				str1="";
			}
			if(current.getWord().equalsIgnoreCase(str)) {
				count++;
				str1+=count +". Word: "+current.getWord()+", Description: "+current.getDescription()+"\n";
				return search(current.getLeft(),str);//go to left
			}
			else if(current.getWord().charAt(0)>=str.charAt(0)) {
				return search(current.getLeft(),str);//go to left
			}
			else if (current.getWord().charAt(0)<str.charAt(0)) {
				return search(current.getRight(),str);//go to right
			}
		}
		return "";
	}



	public boolean add(BSTNode current,BSTNode n) {//Adds an element in the tree
		
		if(current!=null&&current.equals(n)) {
			return false;
		}
		else {
		if(root==null) {
		root=n;
		current=root;
		return true;
		}
		
		else if(!current.equals(n)){//if same word does not exist
	
			if(current.isLeaf()) {//if leaf
				if(n.getWord().charAt(0)<=current.getWord().charAt(0)) {
					current.setLeft(n);
					return true;
				}
				else{
					current.setRight(n);
					return true;
				}	
			}
			else{//if not leaf
				if(n.getWord().charAt(0)<=current.getWord().charAt(0)) {
					if(current.getLeft()!=null) {
					return add(current.getLeft(),n);//go to left
					}
					else {
						current.setLeft(n);//set to left
					}
				}
				else if(n.getWord().charAt(0)>current.getWord().charAt(0)) {
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

	public String printAll(BSTNode root) {//prints all the words in the tree in infix order
		if(root==null) {
			return "";
		}
		
		 return printAll(root.getLeft())+" "+root.getWord()+" "+printAll(root.getRight());
	}
	
	
	
	
	public void remove(String word) {//removes element(s)
	String str2="";
	String str1 = search(root,word);
	System.out.println(str1);
	if(str1=="") {
		System.out.println("No such word found in the dictionary.");
		return;
	}
	System.out.println("Do you want to remove them all?(y/n)");
	str2=scan.next();
	if(str2.equalsIgnoreCase("y")){//yes
		fillArrayForRemoveAll(root,word);//removes all occurrences of the word.
			
		System.out.println();
		root=null;
		for(int j = 0 ;j<count_words;j++) {//recreate a new tree
			
			BSTNode n = new BSTNode(words[j],definitions[j]);
			words[j]="";//empty the array after creating a new tree.
			definitions[j]="";
			add(root,n);
		}
		count_words=0;
	}
	else {//no
	System.out.println("Which item you want to delete? Enter its description:");
	scan.nextLine();
	str2=scan.nextLine();
	fillArrayForRemoveElement(root,word,str2);//removes only the one with the exact word and description
	root=null;
	for(int i =0;i<count_words;i++) {
		BSTNode n = new BSTNode(words[i],definitions[i]);
		words[i]="";//empty the array after creating a new tree.
		definitions[i]="";
		add(root,n);
	}
	count_words=0;
	
	}
	
	}
	
	

}
