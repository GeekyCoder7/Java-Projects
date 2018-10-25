

public class Node {
	
	private String data;
	private Node next,previous;
	public Node(String data) {
		this.setData(data);
		next=null;
		previous=null;
	}
	
	public void setNext(Node next){		
		this.next=next;
	}
	public boolean hasNext(){
		if(getNext()!=null){
			return true;
		}
		return false;
	}
	
	public boolean hasPrevious(){
		if(getPrevious()!=null){
			return true;
		}
		return false;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setPrevious(Node previous){		
		this.previous=previous;
	}
	
	public Node getPrevious(){
		return previous;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
}
