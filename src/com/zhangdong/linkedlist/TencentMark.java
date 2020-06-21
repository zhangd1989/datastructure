package com.zhangdong.linkedlist;

import java.util.Stack;

public class TencentMark {
	
	public static void main(String[] args) {
		
		HeroNode nod1 = new HeroNode(1, "1", "һ");
		HeroNode nod2 = new HeroNode(2, "2", "��");
		HeroNode nod3 = new HeroNode(3, "3", "��");
		HeroNode nod4 = new HeroNode(4, "4", "��");
		HeroNode nod5 = new HeroNode(5, "5", "��");
		HeroNode nod6 = new HeroNode(6, "6", "��");
		
		
		SingleLinkedListDemo demo = new SingleLinkedListDemo();
		demo.addByNo(nod1);
		demo.addByNo(nod3);
		demo.addByNo(nod5);
		
		SingleLinkedListDemo demo2 = new SingleLinkedListDemo();
		demo2.addByNo(nod2);
		demo2.addByNo(nod4);
		demo2.addByNo(nod6);
		
		HeroNode node =  checkList(demo.getHead(), demo2.getHead());
		
		showList(node);
		
	}
	
	public static HeroNode tunroverLinkedList(HeroNode head) {
		
		HeroNode newHeroNode = new HeroNode(head.no, head.name, head.nickname);
		if(head.next==null) {
			return newHeroNode;
		}
		
		HeroNode temp = head;
		while(true) {
			if(temp.next==null) {
				break;
			}
			
			HeroNode next = new HeroNode(temp.next.no, temp.next.name, temp.next.nickname);
			if(newHeroNode.next==null) {
				newHeroNode.next = next;
			}else {
				next.next = newHeroNode.next;
				newHeroNode.next = next;
			}
			
			temp = temp.next;
		}
		
		return newHeroNode;
	}
	
	private static void showList(HeroNode overList) {
		
		HeroNode temp = overList;
		while (true) {
			
			System.out.println(temp);
			if(temp.next==null) {
				break;
			}
			temp = temp.next;
		}

	}
	
	
	//��ʽ2��
	//��������ջ������ݽṹ���������ڵ�ѹ�뵽ջ�У�Ȼ������ջ���Ƚ�������ص㣬��ʵ���������ӡ��Ч��
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			return;//���������ܴ�ӡ
		}
		//����Ҫ��һ��ջ���������ڵ�ѹ��ջ
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		//����������нڵ�ѹ��ջ
		while(cur != null) {
			stack.push(cur);
			cur = cur.next; //cur���ƣ������Ϳ���ѹ����һ���ڵ�
		}
		//��ջ�еĽڵ���д�ӡ,pop ��ջ
		while (stack.size() > 0) {
			System.out.println(stack.pop()); //stack���ص����Ƚ����
		}
	}
	
	//��������ת
	public static void reversetList(HeroNode head) {
		//�����ǰ����Ϊ�գ�����ֻ��һ���ڵ㣬���跴ת��ֱ�ӷ���
		if(head.next == null || head.next.next == null) {
			return ;
		}
		
		//����һ��������ָ��(����)���������Ǳ���ԭ��������
		HeroNode cur = head.next;
		HeroNode next = null;// ָ��ǰ�ڵ�[cur]����һ���ڵ�
		HeroNode reverseHead = new HeroNode(0, "", "");
		//����ԭ��������ÿ����һ���ڵ㣬�ͽ���ȡ�����������µ�����reverseHead ����ǰ��
		//���Խ�
		while(cur != null) { 
			next = cur.next;//����ʱ���浱ǰ�ڵ����һ���ڵ㣬��Ϊ������Ҫʹ��
			cur.next = reverseHead.next;//��cur����һ���ڵ�ָ���µ��������ǰ��
			reverseHead.next = cur; //��cur ���ӵ��µ�������
			cur = next;//��cur����
		}
		//��head.next ָ�� reverseHead.next , ʵ�ֵ�����ķ�ת
		head.next = reverseHead.next;
	}
	
	public static HeroNode checkList(HeroNode head1, HeroNode head2) {
		
		HeroNode heroNode = new HeroNode();
		HeroNode next = null;
		
		HeroNode node = head1.next;
		
		while(node!=null) {
			next = new HeroNode();
			next.no = node.no;
			next.name = node.name;
			next.nickname = node.nickname;
			
			addNode(heroNode, next);
			
			node = node.next;
		}
		
		
		node = head2.next;
		
		while(node!=null) {
			next = new HeroNode();
			
			next.no = node.no;
			next.name = node.name;
			next.nickname = node.nickname;
			
			addNode(heroNode, next);
			
			node = node.next;
		}
		
		
		return heroNode;
	}
	
	public static void addNode(HeroNode heroNode, HeroNode node) {
		if(heroNode.next==null) {
			heroNode.next = node;
		}else {
			
			HeroNode temp = heroNode;
			while(true) {
				if(temp.next==null) {
					temp.next = node;
					break;
				}
				
				if(temp.next.no == node.no) {
					break;
				}
				
				if(temp.next.no > node.no) {
					node.next = temp.next;
					temp.next = node;
					break;
				}
				temp = temp.next;
			}
		}
	}
}
