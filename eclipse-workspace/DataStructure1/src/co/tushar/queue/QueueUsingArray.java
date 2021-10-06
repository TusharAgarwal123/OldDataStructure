package co.tushar.queue;

public class QueueUsingArray {

	static int front = 0;
	static int rear = -1;
	static int size = 0;
	static int MAX = 5;
	static int ar[] = new int[MAX];
	
	
	public static int remove() {
		if(isEmpty()) {
			return -1;
		}
		size--;
		front=front%MAX;
		return ar[front++];
	}
	
	public static int getFront() {
		if(isEmpty()) {
			return -1;
		}
		return ar[front];
	}
	
	public static int getRear() {
		if(isEmpty()) {
			return -1;
		}
		return ar[rear];
	}
	
	private static boolean isEmpty() {
		return size==0;
	}

	public static void insert(int val) {
		
		if(isFull()) {
			System.out.println("Not Possible!!");
			return;
		}
		
		rear=(rear+1)%MAX;
		size++;
		ar[rear]=val;
		
	}

	private static boolean isFull() {
		
		return size==MAX;
		
	}

	public static void main(String[] args) {

	}

}
