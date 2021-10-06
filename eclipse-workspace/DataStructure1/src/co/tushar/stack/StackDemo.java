package co.tushar.stack;

public class StackDemo {

	private int ar[];
	private int top;
	private int Default_Size = 10;

	StackDemo() {
		this.ar = new int[Default_Size];
		this.top = -1;
	}

	public boolean push(int ele) {
		if (isFull()) {
			return false;
		}
		ar[++top] = ele;
		return true;
	}

	private boolean isFull() {
		return top == ar.length - 1;
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty");
		}

		return ar[top--];

	}

	private boolean isEmpty() {
		return top == -1;
	}

	public int peak() throws Exception {
		if (top == -1) {
			throw new Exception("Empty");
		}
		return ar[top];
	}

	public void display() {
		for (int i = 0; i <= top; i++) {
			System.out.println(ar[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		StackDemo st = new StackDemo();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);

		st.display();
		System.out.println(st.peak());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.peak());

	}

}
