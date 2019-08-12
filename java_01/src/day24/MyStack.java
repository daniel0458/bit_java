package day24;

import java.util.Arrays;

public class MyStack<E> {
	E[] stack;
	int top = 0;
	
	public MyStack() {
		this(10);
	}
	public MyStack(int n) {
		super();
		if(n < 0) {
			stack = (E[])new Object[10];
			return;
		}
		stack = (E[])new Object[n];
	}
	public synchronized void push(E number) {
		if (!isFull()) {
			stack[top++] = number;
			System.out.println("push => " + number);
			
			notifyAll();
			return;
		}
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized boolean isEmpty() {
		if(top == 0) {
			return true;
		}
		return false;
	}
	public synchronized boolean isFull() {
		if(top == stack.length) {
			return true;
		}
		return false;
	}
	public synchronized E top() {
		if (isEmpty()) {
			return null;
		}
		return stack[top-1];
	}
	public synchronized E pop() {
		if (isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		E data = stack[--top];
		System.out.println("                  pop => " + data);
		notifyAll();
		return data;
	}
	@Override
	public String toString() {
		return "MyStack [stack=" + Arrays.toString(stack) + ", top=" + top + "]";
	}
	
	
}
