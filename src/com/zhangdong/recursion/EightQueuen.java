package com.zhangdong.recursion;

public class EightQueuen {
	int max = 8;
	int[] array = new int[max];
	static int count = 0;
	
	public static void main(String[] args) {
		EightQueuen queuen = new EightQueuen();
		queuen.check(0);
		System.out.printf("共有%d种解法", count);
	}
	
	public void check(int n) {
		if(n==max) {
			print();
			return;
		}
		
		for(int i = 0; i<max;i++) {
			array[n] = i;
			if(judge(n)) {
				check(n+1);
			}
		}
	}
	
	public boolean judge(int n) {
		for(int i=0; i<n; i++) {
			if(array[i]==array[n] || 
					Math.abs(n-i)==Math.abs(array[i]-array[n])) {
				return false;
			}
			
		}
		return true;
		
	}
	
	private void print() {
		for(int i = 0; i< array.length; i++) {
			System.out.print(array[i] + "");
		}
		count++;
		System.out.println();
	}
}
