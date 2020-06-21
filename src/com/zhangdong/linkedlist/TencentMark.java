package com.zhangdong.linkedlist;

import java.util.Stack;

public class TencentMark {
	
	public static void main(String[] args) {
		
		HeroNode nod1 = new HeroNode(1, "1", "一");
		HeroNode nod2 = new HeroNode(2, "2", "二");
		HeroNode nod3 = new HeroNode(3, "3", "三");
		HeroNode nod4 = new HeroNode(4, "4", "四");
		HeroNode nod5 = new HeroNode(5, "5", "五");
		HeroNode nod6 = new HeroNode(6, "6", "六");
		
		
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
	
	
	//方式2：
	//可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			return;//空链表，不能打印
		}
		//创建要给一个栈，将各个节点压入栈
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		//将链表的所有节点压入栈
		while(cur != null) {
			stack.push(cur);
			cur = cur.next; //cur后移，这样就可以压入下一个节点
		}
		//将栈中的节点进行打印,pop 出栈
		while (stack.size() > 0) {
			System.out.println(stack.pop()); //stack的特点是先进后出
		}
	}
	
	//将单链表反转
	public static void reversetList(HeroNode head) {
		//如果当前链表为空，或者只有一个节点，无需反转，直接返回
		if(head.next == null || head.next.next == null) {
			return ;
		}
		
		//定义一个辅助的指针(变量)，帮助我们遍历原来的链表
		HeroNode cur = head.next;
		HeroNode next = null;// 指向当前节点[cur]的下一个节点
		HeroNode reverseHead = new HeroNode(0, "", "");
		//遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
		//动脑筋
		while(cur != null) { 
			next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
			cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
			reverseHead.next = cur; //将cur 连接到新的链表上
			cur = next;//让cur后移
		}
		//将head.next 指向 reverseHead.next , 实现单链表的反转
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
