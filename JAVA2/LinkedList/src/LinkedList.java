

public class LinkedList {
	public Node header;
	public int count = 0;

	public LinkedList(Node n) {
		header = null;
	}

	public int length(Node current) {
		if (current == null) {
			return 0;
		} 
		return 1 + length(current.getNext());
	}

	public Node getHeader() {
		return header;
	}

	public boolean insert(int index, Node n, Node current) {
		if (index == 0) {
			n.setNext(header);
			header = n;
			return true;
		}
		if (index == 1) {
			n.setNext(current.getNext());
			current.setNext(n);
			return true;
		}

		return insert(index - 1, n, current.getNext());

	}

	public String print(Node current, String ans) {
		if (current == null) {
			return null;
		} else {
			if (current.getNext() == null) {
				ans += current.getData();
				return ans;
			} else {
				return print(current.getNext(), ans += current.getData());
			}
		}
	}

	public void Print(Node current) {
		if (current == null) {
			return;
		} else {
			System.out.println(current.getData());
			Print(current.getNext());
		}
	}

	public void reversePrint(Node current) {
		if (current == null) {
			return;
		} else {
			reversePrint(current.getNext());
			System.out.println(current.getData());
		}
	}

	public int search(int data, int count, Node current) {
		if (header == null || current == null) {
			return -1;
		} else if (data == current.getData()) {
			return count;
		}

		return search(data, count + 1, current.getNext());
	}

	public int sum(Node current) {
		if (current == null) {
			return 0;
		} else
			return current.getData() + sum(current.getNext());
	}

}
