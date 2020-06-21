package com.zhangdong.stack;

public class LinkedListStack {
	public static void main(String[] args) {
		
		LinkedListStackDemo stack = new LinkedListStackDemo();
		Node n1 = new Node(1, "一");
		Node n2 = new Node(2, "二");
		Node n3 = new Node(3, "三");
		Node n4 = new Node(4, "四");
		
		stack.push(n1);
		stack.push(n2);
		stack.push(n3);
		//stack.showStack();
		
		stack.push(n4);
		//stack.showStack();
		
		Node node = stack.pop();
		node = stack.pop();
		node = stack.pop();
		node = stack.pop();
		System.out.println("取出的值为："+node);
		stack.showStack();
		node = stack.pop();
		System.out.println("取出的值为："+node);
		stack.showStack();
		
	}
}


class LinkedListStackDemo{
	
	private Node stack;
	
	public Node getStack() {
		return stack;
	}

	public void setStack(Node stack) {
		this.stack = stack;
	}

	public boolean isEmpty() {
		return stack==null;
	}
	
	public void push(Node node) {
		if(isEmpty()) {
			setStack(node);
			return;
		}
		
		Node temp = getStack();
		node.setNext(temp);
		
		setStack(node);
	}
	
	public Node pop() {
		if(isEmpty()) {
			
			System.out.println("栈已空");
			return null;
		}
		
		Node temp = getStack();
		setStack(temp.getNext());
		
		return temp;
	}
	
	public void showStack() {
		
		if(isEmpty()) {
			System.out.println("栈已空");
			return;
		}
		
		Node node = getStack();
		
		while(true) {
			
			System.out.println(node);
			if(node.getNext()==null) {
				break;
			}
			
			node = node.getNext();
		}
	}
	
}

class Node{
	
	private int no;
	private String name;
	private Node next;
	
	public Node(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}
	
	
	
	
}