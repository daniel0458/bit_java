package day24;

import java.util.ArrayList;
import java.util.List;

public class StackTest{
	public static void main(String[] args) {
//		MyStack2 stack = new MyStack2(10);
		MyStack stack = new MyStack(10);
		if(stack.isEmpty()){
			System.out.println("스택이 비어있습니다.");
		}
		
		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		
		if(stack.isFull()){
			System.out.println("스택이 가득 찼습니다.");
		}
		
		System.out.println("최상위 숫자 : " + stack.top());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("");
		System.out.println("== 스택 리스트 ==");
//		for (int i = 1; i <= 10; i++) {
//			int num = stack.pop();
//			if(num != -1)
//				System.out.println(num);
//		}
		for (int i = 1; i <= 10; i++) {
		Object num = stack.pop();
		if(num != null)
			System.out.println(num);
		} 
	}
}

class MyStack2{
	int size;
	int[] stack;
	int top = 0;
	public MyStack2() {
		this(10);
	}
	public MyStack2(int n) {
		super();
		if(n < 0) {
			this.size = 10;
			stack = new int[10];
			return;
		}
		this.size = n;
		stack = new int[n];
	}
	void push(int number) {
		if (!isFull()) {
			stack[top++] = number;
		}
	}
	boolean isEmpty() {
		if(top == 0) {
			return true;
		}
		return false;
	}
	boolean isFull() {
		if(top == size) {
			return true;
		}
		return false;
	}
	int top() {
		if (isEmpty()) {
			return -1;
		}
		return stack[top-1];
	}
	int pop() {
		if (isEmpty()) {
			return -1;
		}
		return stack[--top];
	}
}

//class MyStack{
//	int n;
//	List<Integer> st;
//	public MyStack() {
//		this(10);
//	}
//
//	public MyStack(int n) {
//		super();
//		if (n < 0) {
//			this.n = 10;
//			st = new ArrayList<Integer>(10);
//			return;
//		}
//		this.n = n;
//		st = new ArrayList<Integer>(n);
//	}
//	
//	void push(int number) {
//		if(!isFull()) {
//			st.add(number);
//		}
//	}
//	
//	boolean isEmpty() {
//		return (st.size() == 0) ? true : false;
//	}
//	boolean isFull() {
//		return (st.size() == n) ? true : false;
//	}
//	int top() {
//		if (isEmpty()) {
//			return -1;
//		}
//		return st.get(st.size()-1);		
//	}
//	int pop() {
//		int re = -1;
//		if (isEmpty()) {
//			return -1;
//		}
//		re = st.get(st.size()-1);
//		st.remove(st.size()-1);
//		return re;	
//	}
//
//
//}

