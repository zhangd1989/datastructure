package com.zhangdong.queue;

import java.util.Scanner;

public class ArrayQueue {
	public static void main(String[] args) {
		ArrayQueueDemo queue = new ArrayQueueDemo(3);
		
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


class ArrayQueueDemo{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	
	//�������еĹ�����
	ArrayQueueDemo(int maxSize) {
		this.maxSize = maxSize;
		this.arr = new int[this.maxSize];
		this.front = -1;//ָ����е�ͷ����������front��ָ�����ͷ��ǰһ��λ��
		this.rear = -1;//ָ�����Ϊ��ָ���β������
	}
	
	public boolean isFull() {
		return rear == maxSize-1;
	}
	
	public boolean isEmpty() {
		
		return front == rear;
	}
	
	public void addQueue(int i) {
		if(isFull()) {
			System.out.println("�����������޷��������");
			return;
		}
		
		rear++;
		arr[rear] = i;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("����Ϊ�գ��޷���ȡ����");
		}
		front++;
		int i = arr[front];
		return i;
	}
	
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("����Ϊ�գ���չʾ����");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}
	
	public int headQueue() {
		if(isEmpty()) {
			System.out.println();
			throw new RuntimeException("����Ϊ�գ�û��ͷ������");
		}
		
		int i = arr[front+1];
		return i;
	}
}