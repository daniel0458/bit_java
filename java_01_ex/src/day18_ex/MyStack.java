package day18_ex;

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
	public void push(E number) {
		if (!isFull()) {
			stack[top++] = number;
		}
	}
	public boolean isEmpty() {
		if(top == 0) {
			return true;
		}
		return false;
	}
	public boolean isFull() {
		if(top == stack.length) {
			return true;
		}
		return false;
	}
	public E top() {
		if (isEmpty()) {
			return null;
		}
		return stack[top-1];
	}
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		return stack[--top];
	}
	
	
}
