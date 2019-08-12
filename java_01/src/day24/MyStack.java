package day24;

public class MyStack {
	int[] stack;
	int top = 0;
	int size;
	
	public MyStack() {
		stack = new int[10];
	}

	public MyStack(int size) {
		if(size<0) {
			stack = new int[10];
		} else {
			stack = new int[size];
		}
	}
	
	public synchronized boolean isEmpty() {
		return top == 0 ? true : false;
	}
	public synchronized boolean isFull() {
		return top == stack.length ? true : false;
	}
	
	public synchronized void push(int data) {
		if(isFull()) {  // 꽉차면 안들어가니까 wait();해줌 
			//System.out.println("stack is full ...");
			//return;
			try { 
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stack[top] = data;
		top++;
		System.out.println("push => "+data);
		
		notifyAll(); // wait()에 빠져있는게 다 나온다 // 상호 보완적인 설계
	}
	
	public synchronized int top() {
		if(isEmpty()) return -1;
		return stack[top-1];
	}

	public synchronized int pop() {
		if(isEmpty()) {
			//return -1;
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int data = stack[--top];
		System.out.println("                pop ==> "+data);
		notifyAll();   // wait()에 빠져있는게 다 나온다 // 상호 보완적인 설계
		return data;
		
	}
	
}
