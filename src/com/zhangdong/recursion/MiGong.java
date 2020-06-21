package com.zhangdong.recursion;

public class MiGong {
	
	public static void main(String[] args) {
		
		int[][] map = new int[8][7];
		//使用1标识墙
		//先把上下置为1
		
		for(int i = 0; i<7; i++) {
			map[0][i]=1;
			map[7][i]=1;
		}
		
		for(int j= 0; j<8; j++) {
			map[j][0]=1;
			map[j][6]=1;
		}
		System.out.println("地图");
		for(int i = 0; i<8; i++) {
			for(int j= 0; j<7; j++) {
				System.out.print(map[i][j]+" ");
				
			}
			System.out.println();
		}
		
		getWay(map, 1 , 1);
		System.out.println("走路");
		for(int i = 0; i<8; i++) {
			for(int j= 0; j<7; j++) {
				System.out.print(map[i][j]+" ");
				
			}
			System.out.println();
		}
		
		
	}
	
	public static boolean getWay(int[][] map, int i , int j) {
		if(map[6][5]==2) {
			return true;
		}else {
			if(map[i][j]==0) {
				map[i][j]=2;
				
				if(getWay(map, i+1, j)) {
					return true;
				}else if(getWay(map, i, j+1)) {
					return true;
				}else if(getWay(map, i-1, j)) {
					return true;
				}else if(getWay(map, i, j-1)) {
					return true;
				}else {
					map[i][j]=3;
					return false;
				}
				
			}else {
				return false;
			}
		}
	}
}
