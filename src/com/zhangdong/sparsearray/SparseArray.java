package com.zhangdong.sparsearray;

public class SparseArray {
	/**
	 * 创建原始数组 11*11
	 * 0标识没有妻子 1标识黑棋子2标识兰棋子
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
		
		//将二维数组转换成稀疏数组
		//1、先遍历数组，得到非零数据的个数
		int sum = 0;
		for(int i=0; i<chessArr.length; i++) {
			for (int j = 0; j < chessArr[0].length; j++) {
				if(chessArr[i][j]!=0)
					sum++;
			}
		}
		
		//2、创建稀疏数组
		int sparseArr[][] = new int [sum+1][3];
		
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		
		//3、把原数组的非0值存入到稀疏数组中
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
		System.out.println("得到的稀疏数组：\n");
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr[0].length; j++) {
				System.out.printf("%d\t", sparseArr[i][j]);
			}
			
			System.out.println();
		}
		
		
		
		//将稀疏数组还原成原始数组
		int newArr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		for(int i =1; i<sparseArr.length; i++) {
			newArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		System.out.println();
		System.out.println("得到的还原数组：\n");
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr[0].length; j++) {
				System.out.printf("%d\t", newArr[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	    *    生成稀疏数组
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
		
		//3、把原数组的非0值存入到稀疏数组中
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
		System.out.println("得到的稀疏数组：\n");
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr[0].length; j++) {
				System.out.printf("%d\t", sparseArr[i][j]);
			}
			
			System.out.println();
		}
		
		return null;
		
	}
	
	/**
	   *   稀疏数组还原原数组
	 * @param sparseArr
	 * @return
	 */
	public int[][] checkSparseArr(int sparseArr[][]){
		
		int newArr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		for(int i =1; i<sparseArr.length; i++) {
			newArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		System.out.println();
		System.out.println("得到的还原数组：\n");
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr[0].length; j++) {
				System.out.printf("%d\t", newArr[i][j]);
			}
			System.out.println();
		}
		
		return newArr;
		
	}
}
