package pretoPost;



public class Node {
	
	private String data;
	private Node next;
	public Node(String data) {
		this.setData(data);
		next=null;
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
	
	
	public Node getNext(){
		return next;
	}
	


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
}
