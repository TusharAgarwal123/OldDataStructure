package co.tushar.queue;

public class OptimizeQueueDemo {

	private int ar[];
	private int end;
	private int front;
	private int count=0;
	private int Default_Size=10;
	
	
	public OptimizeQueueDemo() {
		ar=new int[Default_Size];
		end=0;
		front=0;
	}
	
	public boolean enqueue(int ele)throws Exception {
		if(isFull()) {
			throw new Exception("Queue is full");
		}
		ar[end++]=ele;
		return true;
	}
	private boolean isFull() {
		return end==ar.length;
	}
	
	

	public int dequeue()throws Exception {
		if(isEmpty()) {
			throw new Exception("Empty");
		}
		return ar[front++];
		
	}
	private boolean isEmpty() {
		return front==end;
	}
	
	public void display() {
		for (int i = front; i < end; i++) {
			System.out.println(ar[i]+" ");
		}
		System.out.println();
	}
	
	
	public int front() {
		return ar[front];
	}
	public int size() {
		for (int i = front; i <end; i++) {
			count++;
		}
		return count;
	}
	public static void main(String[] args) throws Exception {
		OptimizeQueueDemo qd=new OptimizeQueueDemo();
		for (int i = 1; i <= 7; i++) {
			qd.enqueue(i);
		}
		
		System.out.println(qd.front());
		qd.display();
		System.out.println(qd.size());
		
		for (int i = 1; i <= 4; i++) {
			qd.dequeue();
		}
		System.out.println(qd.size());
		qd.display();

	}

}
