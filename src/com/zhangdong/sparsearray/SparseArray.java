package com.zhangdong.sparsearray;

public class SparseArray {
	/**
	 * ����ԭʼ���� 11*11
	 * 0��ʶû������ 1��ʶ������2��ʶ������
	 * @param args
	 */
	public static void main(String[] args) {
		int chessArr[][] = new int[11][11];
		chessArr[1][2]=1;
		chessArr[2][3]=2;
		for (int[] row : chessArr) {
			for(int data: row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
			
		}
		
		//����ά����ת����ϡ������
		//1���ȱ������飬�õ��������ݵĸ���
		int sum = 0;
		for(int i=0; i<chessArr.length; i++) {
			for (int j = 0; j < chessArr[0].length; j++) {
				if(chessArr[i][j]!=0)
					sum++;
			}
		}
		
		//2������ϡ������
		int sparseArr[][] = new int [sum+1][3];
		
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		
		//3����ԭ����ķ�0ֵ���뵽ϡ��������
		int s= 1;
		for(int i=0; i<chessArr.length; i++) {
			for (int j = 0; j < chessArr[0].length; j++) {
				if(chessArr[i][j]!=0) {
					sparseArr[s][0] = i;
					sparseArr[s][1] = j;
					sparseArr[s][2] = chessArr[i][j];
					
					s++;
				}
			}
		}
		
		System.out.println();
		System.out.println("�õ���ϡ�����飺\n");
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr[0].length; j++) {
				System.out.printf("%d\t", sparseArr[i][j]);
			}
			
			System.out.println();
		}
		
		
		
		//��ϡ�����黹ԭ��ԭʼ����
		int newArr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		for(int i =1; i<sparseArr.length; i++) {
			newArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		System.out.println();
		System.out.println("�õ��Ļ�ԭ���飺\n");
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr[0].length; j++) {
				System.out.printf("%d\t", newArr[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	    *    ����ϡ������
	 * @param chessArr
	 * @return
	 */
	public int[][] makeSparseArr(int chessArr[][]){
		
		int sum = 0;
		for(int i=0; i<chessArr.length; i++) {
			for (int j = 0; j < chessArr[0].length; j++) {
				if(chessArr[i][j]!=0)
					sum++;
			}
		}
		
		int sparseArr[][] = new int [sum+1][3];
		
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		
		//3����ԭ����ķ�0ֵ���뵽ϡ��������
		int s= 1;
		for(int i=0; i<chessArr.length; i++) {
			for (int j = 0; j < chessArr[0].length; j++) {
				if(chessArr[i][j]!=0) {
					sparseArr[s][0] = i;
					sparseArr[s][1] = j;
					sparseArr[s][2] = chessArr[i][j];
					
					s++;
				}
			}
		}
		
		System.out.println();
		System.out.println("�õ���ϡ�����飺\n");
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr[0].length; j++) {
				System.out.printf("%d\t", sparseArr[i][j]);
			}
			
			System.out.println();
		}
		
		return null;
		
	}
	
	/**
	   *   ϡ�����黹ԭԭ����
	 * @param sparseArr
	 * @return
	 */
	public int[][] checkSparseArr(int sparseArr[][]){
		
		int newArr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		for(int i =1; i<sparseArr.length; i++) {
			newArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		System.out.println();
		System.out.println("�õ��Ļ�ԭ���飺\n");
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr[0].length; j++) {
				System.out.printf("%d\t", newArr[i][j]);
			}
			System.out.println();
		}
		
		return newArr;
		
	}
}
