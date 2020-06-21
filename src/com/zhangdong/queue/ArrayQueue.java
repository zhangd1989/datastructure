package com.zhangdong.queue;

import java.util.Scanner;

public class ArrayQueue {
	public static void main(String[] args) {
		ArrayQueueDemo queue = new ArrayQueueDemo(3);
		
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出队列");
			System.out.println("a(add):添加队列");
			System.out.println("g(get):获取队列");
			System.out.println("h(head):显示头部");
			key= scanner.next().charAt(0);
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'e':
				scanner.close();
				loop = false;
				System.out.println("队列结束");
				break;
			case 'a':
				System.out.println("请输入一个数字！");
				int i = scanner.nextInt();
				queue.addQueue(i);
				break;
			case 'g':
				int j = queue.getQueue();
				System.out.printf("获取队列值为:%d\n",j);
				break;
			case 'h':
				int k = queue.headQueue();
				System.out.printf("队列头部值为:%d\n",k);
				break;

			default:
				break;
			}
		}
		
	}
}


class ArrayQueueDemo{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	
	//创建队列的构造器
	ArrayQueueDemo(int maxSize) {
		this.maxSize = maxSize;
		this.arr = new int[this.maxSize];
		this.front = -1;//指向队列的头部，分析出front是指向队列头的前一个位置
		this.rear = -1;//指向队列为，指向队尾的数据
	}
	
	public boolean isFull() {
		return rear == maxSize-1;
	}
	
	public boolean isEmpty() {
		
		return front == rear;
	}
	
	public void addQueue(int i) {
		if(isFull()) {
			System.out.println("队列已满，无法添加数据");
			return;
		}
		
		rear++;
		arr[rear] = i;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列为空，无法获取数据");
		}
		front++;
		int i = arr[front];
		return i;
	}
	
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("队列为空，无展示数据");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}
	
	public int headQueue() {
		if(isEmpty()) {
			System.out.println();
			throw new RuntimeException("队列为空，没有头部数据");
		}
		
		int i = arr[front+1];
		return i;
	}
}