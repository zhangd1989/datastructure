package com.zhangdong.linkedlist;

public class SingleLinkedList {
	public static void main(String[] args) {
		
		HeroNode nod1 = new HeroNode(1, "1", "一");
		HeroNode nod2 = new HeroNode(2, "2", "二");
		HeroNode nod3 = new HeroNode(3, "3", "三");
		HeroNode nod4 = new HeroNode(4, "4", "四");
		HeroNode nod5 = new HeroNode(5, "5", "五");
		HeroNode nod6 = new HeroNode(6, "6", "六");
		
		HeroNode nod8 = new HeroNode(8, "8", "八");
		HeroNode nod12 = new HeroNode(12, "12", "十二");
		HeroNode nod17 = new HeroNode(17, "17", "十七");
		
		SingleLinkedListDemo demo = new SingleLinkedListDemo();
		demo.add(nod1);
		demo.add(nod2);
		demo.add(nod3);
		demo.add(nod4);
		demo.add(nod5);
		demo.add(nod6);
		demo.addByNo(nod17);
		demo.addByNo(nod12);
		demo.addByNo(nod8);
		demo.showList();
		
		System.out.println();
		System.out.println();
		
		System.out.println(demo.getHead().next);
		
	}
	
	public static void tunroverLinkedList(HeroNode head) {
		HeroNode newHeroNode = head;
		System.out.println(head.toString());
		newHeroNode.next=null;
		
		HeroNode temp = head;
		if(head.next==null) {
			return;
		}
		
		while(true) {
			if(head.next==null) {
				break;
			}
			
			HeroNode next = head.next;
			next.next = null;
			
			if(newHeroNode.next==null) {
				newHeroNode.next = next;
			}else {
				next.next = newHeroNode.next;
				newHeroNode.next = next;
			}
			
			temp = temp.next;
		}
		
		head = newHeroNode;
	}
	
	
}

class SingleLinkedListDemo{
	
	private HeroNode head = new HeroNode(0, "", "");
	
	public HeroNode getHead() {
		return head;
	}
	
	public void setHead(HeroNode head) {
		this.head = head;
	}



	public void add(HeroNode heroNode) {
		HeroNode temp = head;
		while (true) {
			if(temp.next==null) {
				break;
			}
			temp = temp.next;
		}
		
		temp.next = heroNode;
	}
	
	public void addByNo(HeroNode heroNode) {
		
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if(temp.next==null) {
				break;
			}
			
			if(temp.next.no > heroNode.no) {
				break;
			}
			
			if(temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		
		if(flag) {
			System.out.println("已存在改数据，请不要重复添加！");
			return;
		}
		heroNode.next = temp.next;
		temp.next = heroNode;
		
	}
	
	public void update(HeroNode heroNode) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			
			if(temp.next==null) {
				break;
			}
			
			if(temp.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
			
		}
		
		if(flag) {
			temp.name = heroNode.name;
			temp.nickname = heroNode.nickname;
		}else {
			addByNo(heroNode);
		}
		
	}
	
	public void delete(HeroNode heroNode) {
		HeroNode temp = head;
		HeroNode parent = null;
		
		boolean flag = false;
		while (true) {
			
			if(temp.next==null) {
				break;
			}
			
			if(temp.next.no == heroNode.no) {
				parent = temp;
			}
			
			if(temp.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
			
			System.out.println("------1111111-----");
		}
		
		if(flag) {
			parent.next = temp.next;
		}else {
			System.out.println("要删除的数据不存在，请确认数据是否正确！");
		}
	}
	
	public void showList() {
		HeroNode temp = head;
		
		if(temp.next==null) {
			System.out.println("链表为空，无需打印！");
			return;
		}
		
		while (true) {
			
			if(temp.no!=0)
				System.out.println(temp);
			
			if(temp.next==null) {
				break;
			}
			
			temp = temp.next;
		}
		
		
	}
}

class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;
	
	public HeroNode() {
		
	}
	
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name; 
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname +"]";
	}
}