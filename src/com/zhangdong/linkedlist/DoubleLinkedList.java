package com.zhangdong.linkedlist;

public class DoubleLinkedList {
	public static void main(String[] args) {
		DoubleNode nod1 = new DoubleNode(1, "1", "һ");
		DoubleNode nod4 = new DoubleNode(4, "4", "��");
		DoubleNode nod2 = new DoubleNode(2, "2", "��");
		DoubleNode nod6 = new DoubleNode(6, "6", "��");
		DoubleNode nod3 = new DoubleNode(3, "3", "��");
		DoubleNode nod5 = new DoubleNode(5, "5", "��");
		
		
		DoubleNode nod7 = new DoubleNode(7, "7", "��");
		DoubleNode nod10 = new DoubleNode(10, "10", "ʮ");
		DoubleNode nod18 = new DoubleNode(18, "18", "ʮ��");
		
		DoubleLinkedListDemo demo = new DoubleLinkedListDemo();
		demo.addNodeByNo(nod1);
		demo.addNodeByNo(nod4);
		demo.addNodeByNo(nod2);
		demo.addNodeByNo(nod6);
		demo.addNodeByNo(nod3);
		demo.addNodeByNo(nod5);
		
		demo.showList();
		
		demo.addNodeByNo(nod7);
		demo.addNodeByNo(nod10);
		demo.addNodeByNo(nod18);
		demo.showList();
		
		DoubleNode nod9 = new DoubleNode(9, "9", "��");
		demo.addNodeByNo(nod9);
		demo.showList();
	}
}


class DoubleLinkedListDemo{
	
	private DoubleNode head = new DoubleNode(0, "", "");

	public DoubleNode getHead() {
		return head;
	}

	public void setHead(DoubleNode head) {
		this.head = head;
	}
	
	public void addNodeByNo(DoubleNode node) {
		
		DoubleNode temp = head;
		
		while(temp!=null) {
			if(temp.next==null) {
				
				temp.next = node;
				node.pre = temp.next;
				
				break;
			}
			
			if(temp.next.no==node.no) {
				System.out.printf("��ǰֵ�Ѵ���%d\n", node);
				break;
			}
			
			if(temp.next.no > node.no && temp.no < node.no) {
				
				temp.next.pre = node;
				node.pre = temp;
				node.next = temp.next;
				temp.next = node;
				
				break;
			}
			
			temp = temp.next;
		}
	}
	
	public void updateByNo(DoubleNode node) {
		if(head.next==null) {
			System.out.println("������update��");
			return;
		}
		
		DoubleNode temp = head.next;
		boolean b = true;
		
		while(true) {
			if(temp==null) {
				break;
			}
			
			if(temp.no == node.no) {
				temp.name = node.name;
				temp.nickname = node.nickname;
				b = false;
				break;
			}
			
			temp = temp.next;
		}
		
		if(b) {
			System.out.printf("�������� %d ����������", node.no);
		}
	}
	
	public void deleteByNo(DoubleNode node) {
		if(head.next==null) {
			System.out.println("������delete��");
			return;
		}
		
		DoubleNode temp = head.next;
		boolean b = true;
		
		while(true) {
			if(temp==null) {
				break;
			}
			
			if(temp.no == node.no) {
				
				temp.pre.next = temp.next;
				if(temp.next!=null)
					temp.next.pre = temp.pre;
				
				b = false;
				break;
			}
			
			temp = temp.next;
		}
		
		if(b) {
			System.out.printf("�������� %d ����������", node.no);
		}
	}
	
	public void showList() {
		if(head.next==null) {
			System.out.println("������show��");
			return;
		}
		
		DoubleNode node = head;
		
		while(node!=null) {
			System.out.println(node);
			node = node.next;
		}
		
		System.out.println();
		System.out.println();
	}
	
}

class DoubleNode{
	
	public int no;
	public String name;
	public String nickname;
	public DoubleNode pre;
	public DoubleNode next;
	
	public DoubleNode(){
		
	}
	
	public DoubleNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name; 
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "DoubleNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
	
}
