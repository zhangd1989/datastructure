package com.zhangdong.linkedlist;

public class CircleSingleLinkedList {
	public static void main(String[] args) {
		CircleSingleLinkedListDemo demo = new CircleSingleLinkedListDemo();
		
//		NumNode n1 = new NumNode(1, "一");
//		NumNode n3 = new NumNode(3, "三");
//		NumNode n2 = new NumNode(2, "二");
//		NumNode n5 = new NumNode(5, "五");
//		NumNode n4 = new NumNode(4, "四");
//		
//		demo.addByNo(n1);
//		demo.addByNo(n3);
//		demo.addByNo(n2);
//		demo.addByNo(n5);
//		demo.addByNo(n4);
		
		
		int num = 5;
		demo.addNo(num);
		
		demo.showList();
		
		demo.outCircle(1, 2, 5);
		
		
		
	}
}

class CircleSingleLinkedListDemo {
	
	private NumNode first;
	
	public void setFirst(NumNode first) {
		this.first = first;
	}
	
	public void addNo(int num) {
		if(num < 1) {
			System.out.println("数据太少，不能创建链表");
		}
		NumNode currNo = null;
		for (int i = 1; i <= num; i++) {
			NumNode numNode = new NumNode(i, "NO."+i);
			
			if(i==1) {
				first = numNode;
				first.setNext(first); 
				currNo = first;
			}else {
				currNo.setNext(numNode);
				numNode.setNext(first); 
				currNo = numNode;
			}
		}
	}
	
	public void addByNo(NumNode node) {
		
		if(first==null) {
			this.setFirst(node);
			first.next = first;
			return;
		}
		
		
		
		if(first!=null) {
			
			NumNode temp = first.next;
			NumNode currNode = first;
			
			while(true) {
				if(temp == temp.next) {
					currNode.next = node;
					node.next = first;
					break;
				}
				
				if(temp.next == first) {
					currNode.next = node;
					node.next = temp;
					
					break;
				}
				
				if(temp.no == node.no) {
					System.out.println("当前值已存在，不能重复添加！");
					break;
				}
				
				if(temp.no > node.no) {
					
					node.next = temp;
					currNode.next = node;
					break;
				}
				
				currNode = temp;
				temp = temp.next;
			}
		}
		
		
	}
	
	public void showList() {
		if(first==null) {
			System.out.println("空链表！");
			return;
		}
		
		NumNode temp = first;
		while(true) {
			
			System.out.println(temp);
			if(first==temp.next) {
				break;
			}
			
			
			temp = temp.next;
		}
	}
	
	public void outCircle(int arr[], int step) {
		int i = 0;
		int j = 1;
		
		NumNode temp = first;
		NumNode currNode = first;
		if(first==null) {
			System.out.println("空链表！");
			return;
		}
		
		while(true) {
			if(temp.next == temp) {
				arr[i] = temp.no;
				break;
			}
			
			if(j==step) {
				
				currNode.next = temp.next;
				System.out.println(temp.no + "----------------" + i);
				arr[i] = temp.no;
				
				i++;
				j=1;
			}
			
			currNode = temp;
			
			temp = temp.next;
			j++;
		}
	}
	
	/**
	 * 
	 * @param start 环中第一报数的人
	 * @param step 报数的个数
	 * @param maxSize 环中人数
	 */
	public void outCircle(int start, int step, int maxSize) {
		if(start < 0 || step < 0 || start > maxSize) {
			System.out.println("输入数据不争取");
		}
		
		NumNode helper = first;
		while(true) {
			if(helper.getNext()==first)
				break;
			helper = helper.getNext();
		}
		
		for(int i = 0; i< start-1; i++) {
			first = first.getNext();
			helper = first.getNext();
		}
		
		while(true) {
			if(helper == first) {
				break;
			}
			
			for(int i = 0; i< step-1; i++) {
				first = first.next;
				helper = helper.next;
			}
			
			System.out.println("取出的人员编号是："+first.no);
			first = first.getNext();
			helper.setNext(first); 
			
		}
		
		System.out.println("队列中最后一个人的编号是："+first.no);
	}
	
	

}


class NumNode {
	
	public int no;
	public String name;
	public NumNode next;
	
	public NumNode getNext() {
		return next;
	}

	public void setNext(NumNode next) {
		this.next = next;
	}

	public NumNode() {
		
	}
	
	public NumNode(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "NumNode [no=" + no + ", name=" + name + "]";
	}
	
	
}