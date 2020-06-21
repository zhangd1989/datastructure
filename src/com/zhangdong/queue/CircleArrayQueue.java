package com.zhangdong.queue;

import java.util.Scanner;

public class CircleArrayQueue {
	public static void main(String[] args) {
		CircleArrayQueueDemo queue = new CircleArrayQueueDemo(3);
		System.out.println("���Ի������飺");
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):��Ӷ���");
			System.out.println("g(get):��ȡ����");
			System.out.println("h(head):��ʾͷ��");
			key= scanner.next().charAt(0);
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'e':
				scanner.close();
				loop = false;
				System.out.println("���н���");
				break;
			case 'a':
				System.out.println("������һ�����֣�");
				int i = scanner.nextInt();
				queue.addQueue(i);
				break;
			case 'g':
				int j = queue.getQueue();
				System.out.printf("��ȡ����ֵΪ:%d\n",j);
				break;
			case 'h':
				int k = queue.headQueue();
				System.out.printf("����ͷ��ֵΪ:%d\n",k);
				break;

			default:
				break;
			}
		}
		
	}
}


class CircleArrayQueueDemo{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	
	//�������еĹ�����
	CircleArrayQueueDemo(int maxSize) {
		this.maxSize = maxSize;
		this.arr = new int[this.maxSize];
		this.front = 0;//ָ����е�ͷ��
		this.rear = 0;//ָ�����β��
	}
	
	public boolean isFull() {
		return (rear+1)%maxSize == front;
	}
	
	public boolean isEmpty() {
		
		return front == rear;
	}
	
	public void addQueue(int i) {
		if(isFull()) {
			System.out.println("�����������޷��������");
			return;
		}
		
		
		arr[rear] = i;
		//��rear����
		rear = (rear+1) % maxSize;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("����Ϊ�գ��޷���ȡ����");
		}
		
		int i = arr[front];
		front = (front+1) % maxSize;
		return i;
	}
	
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("����Ϊ�գ���չʾ����");
			return;
		}
		
		int dataSize = dataSize();
		
		for (int i = front; i < front+dataSize; i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}
	
	public int dataSize() {
		
		
		return (rear+maxSize-front) % maxSize;
	}
	
	public int headQueue() {
		if(isEmpty()) {
			System.out.println();
			throw new RuntimeException("����Ϊ�գ�û��ͷ������");
		}
		
		int i = arr[front];
		return i;
	}
}