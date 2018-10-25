package lab9;

public class Queue {
	private int size, front, rear;
	private int[] Ax;

	public Queue(int size) {
		Ax = new int[size];
		front = -1;
		rear = -1;

	}

	public void Enqueue(int item) {
		if (rear == -1) {
			rear = 0;
			front = 0;
			Ax[rear] = item;
		} else {
			if (rear == Ax.length - 1 && front != 0)
				rear = 0;
			else if (front == rear + 1 || (rear == Ax.length - 1 && front == 0))
				IncreaseSize();
			rear++;
			Ax[rear] = item;
		}
	}

	public void Dequeue() {
		Ax[front] = 0;
		if (rear == -1)
			System.out.println("The queue is empty");
		else if (front < rear)
			front++;
		else if (front == Ax.length - 1)
			front = 0;
		else
			front++;

	}

	private void IncreaseSize() {
		int[] temp = new int[Ax.length * 2 + 1];
		if (rear <= front) {
			for (int i = front; i < Ax.length; i++)
				temp[i - front] = Ax[i];
			for (int i = 0; i < rear; i++)
				temp[i] = Ax[i];

		} else {
			for (int i = front; i <= rear; i++)
				temp[i - front] = Ax[i];
		}
		front = 0;
		rear = Ax.length - 1;
		Ax = temp;
	}

	public String toString() {
		String str = "";
		if (rear <= front) {
			for (int i = front; i < Ax.length; i++)
				str += Ax[i] + "\t";
			for (int i = 0; i < rear; i++)
				str += Ax[i] + "\t";
		} else {
			for (int i = front; i <= rear; i++)
				str += Ax[i] + "\t";
		}
		return str;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue(4);
		q.Enqueue(3);
		q.Enqueue(5);
		System.out.println(q);
		q.Dequeue();

		q.Enqueue(9);
		System.out.println(q);
		q.Enqueue(10);
		System.out.println(q);
		q.Dequeue();
		System.out.println(q);
	}

}
