package com.zhangdong.stack;

public class ArrayStack {
	
	public static void main(String[] args) {
		
		ArrayStackDemo stack = new ArrayStackDemo(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		stack.showStack();
		
		int i = stack.pop();
		
		System.out.println("栈中取出的值为："+i);
		stack.showStack();
		
		i = stack.pop();
		
		System.out.println("栈中取出的值为："+i);
		stack.showStack();
		
	}
}


class ArrayStackDemo{
	private int maxSize;
	private int[] stack;
	private int top = -1;
	
	public ArrayStackDemo(int maxSize) {
		this.maxSize = maxSize;
		this.stack = new int[this.maxSize];
	}
	
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(int value) {
		if(isFull()) {
			System.out.println("栈已满！");
			return;
		}
		
		top++;
		stack[top] = value;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈已空！");
		}
		
		
		int value = stack[top];
		top--;
		return value;
	}
	
	public void showStack() {
		if(isEmpty()) {
			return;
		}
		System.out.println("开始读取栈：");
		for (int i = top; i >=0; i--) {
			int value= stack[i];
			System.out.println(value);
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int[] getStack() {
		return stack;
	}

	public void setStack(int[] stack) {
		this.stack = stack;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}
}