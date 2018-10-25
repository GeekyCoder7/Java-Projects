

public class DoublyLinkedList {
	public Node header, tail;

	public DoublyLinkedList() {
		header = null;
		tail = null;
	}

	public boolean isEmpty() {
		if (header == null) {
			return false;
		} else if (header != null) {
			return true;
		}
		return false;
	}

	public int size() {
		int count = 1;
		Node current = header;
		if (header == null) {
			return 0;
		} else {
			while (current.getNext() != null) {
				count++;
				current = current.getNext();
			}
		}
		return count;
	}

	public void Remove(int index) {
		if (index >= 0 && header != null) {
			Node current = header;
			for (int i = 1; i < index; i++) {
				current = current.getNext();
			}
			current.getPrevious().setNext(current.getNext());
			current.getNext().setPrevious(current.getPrevious());
		}
	}

	public int Search(String str) {
		if (header != null) {
			Node current = header;
			for (int i = 1; i <= size(); i++) {
				current = current.getNext();
				if (current.getData().equals(str)) {
					return i;
				}
			}
		}
		return -1;
	}

	/*
	 * public boolean Remove(Node n){ if(header!=null){ Node current = header;
	 * for(int i=1;i<=size();i++){ current=current.getNext(); if(current==n){
	 * current.getPrevious().setNext(current.getNext());
	 * current.getNext().setPrevious(current.getPrevious()); return true; } } }
	 * return false; }
	 */

	public void addNext(int index, Node n) {
		if (index >= 0 && header != null) {
			Node current = header;
			for (int i = 1; i < index; i++) {
				current = current.getNext();
			}
			n.setNext(current.getNext());
			n.setPrevious(current);
			current.setNext(n);
			current.getNext().getNext().setPrevious(n);
		}
	}

	public void addPrevious(int index, Node n) {
		if (index > 0 && header != null) {
			Node current = header;
			for (int i = 1; i < index; i++) {
				current = current.getNext();
			}
			n.setNext(current);
			n.setPrevious(current.getPrevious().getPrevious());
			current.getPrevious().getPrevious().setNext(n);
			current.setPrevious(n);
		}
	}

	public void prepend(Node n) {// first
		Node current = header;
		while (current.getPrevious() != null) {
			current = current.getPrevious();
		}
		if (header == null) {
			current.setPrevious(n);
			current = n;
		}

	}

	public void append(Node n) {// last
		if (header != null) {
			tail = header;
			while (tail.getNext() != null) {
				tail = tail.getNext();
			}
			if (tail == null) {
				header = n;
				tail = n;
			}
		}
	}

}