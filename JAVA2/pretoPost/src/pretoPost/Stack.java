package pretoPost;



public class Stack {
private Node top;
private int count =1;
	public Stack() {
		top=null;
	}
	
	public void push(String data){
		if(isEmpty()){
			top= new Node(data);
		}
		else{
			Node n = new Node(data);
			n.setNext(top);
			top=n;
		}
	}

	public String pop(){
		if(isEmpty()){
			return "";
		}
		else{
			Node current = top;
			top=top.getNext();
			current.setNext(null);
			return current.getData();
		}
	}
	
	
	public void printAll(){
		String str="";
		if(isEmpty())
		{
			System.out.println("empty");
		}
		else
		{
			Node current=top;
			while(current.getNext()!=null)
				str+=current.getData();
		}
		
		System.out.println("All "+str);
		}
	
	
	
	public int size(){
		if(isEmpty()){
			return 0;
		}
		else{
			Node current= top;
			while(current.getNext()!=null){
				current=current.getNext();
				count++;
			}
			return count;
		}
	}	
	
	
	private boolean isEmpty() {
		return (top==null);
	}

}
