package co.tushar.queue;

public class QueueDemo {

	private int ar[];
	private int end;
	private int count=0;
	private int Default_Size=10;
	
	
	public QueueDemo() {
		ar=new int[Default_Size];
		end=0;
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
		int temp=ar[0];
		for (int i = 1; i < end; i++) {
			ar[i-1]=ar[i];
		}
		end--;
		return temp;
		
	}
	private boolean isEmpty() {
		return end==0;
	}
	
	public void display() {
		for (int i = 0; i < end; i++) {
			System.out.println(ar[i]+" ");
		}
		System.out.println();
	}
	
	
	public int front() {
		return ar[0];
	}
	public int size() {
		for (int i = 0; i <end; i++) {
			count++;
		}
		return count;
	}

	public static void main(String[] args)throws Exception{
		
		QueueDemo qd=new QueueDemo();
		for (int i = 1; i <=8; i++) {
			qd.enqueue(i);
		}
		
		qd.display();
		System.out.println(qd.front());
		
		for (int i = 1; i <=4; i++) {
			qd.dequeue();
		}
		
		qd.display();
		
		System.out.println(qd.size());
		
		
		
	}

}
