package com.zhangdong.sort;

import java.util.Arrays;

public class BulleSort {
	public static void main(String[] args) {
		
		int[] array = new int[] {3,9,-1,10,-2};
		int temp = 0;
		
		boolean flag = true;
		for (int i = array.length-1; i >0; i--) {
			
			for (int j = 0; j < i; j++) {
				if(array[j]>array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = false;
				}
			}
			
			
			System.out.println("µÚ"+(array.length-i)+"´ÎÅÅĞò");
			System.out.println(Arrays.toString(array));
			
			while (flag) {
				break;
			}
			
			flag = true;
		}
		
	}
}
