package com.zhangdong.recursion;

public class RecursionTest {

	public static void main(String[] args) {
		int i = factoria(4);
		
		System.out.println(i);

	}
	//��ӡ����
	public static void test(int n) {
		if(n>2) {
			test(n-1);
		}
		
		System.out.println(n);
	}
	//�׳�����
	public static int factoria(int n) {
		if(n==1) {
			return 1;
		}else {
			return factoria(n-1)*n;
		}
	}

}
