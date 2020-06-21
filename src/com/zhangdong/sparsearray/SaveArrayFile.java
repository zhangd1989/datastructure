package com.zhangdong.sparsearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveArrayFile {
	
	public static void main(String[] args) {
		SaveArrayFile saf = new SaveArrayFile();
		
		int newArr[][] = saf.checkArrayFile();
		
		saf.checkSparseArr(newArr);
		
	}
	
	public void makeArrayFile(int chessArr[][]){
		
		File file = new File("e:\\array.txt");
		FileWriter out = null;
		try {
			out = new FileWriter(file);
			for (int i = 0; i < chessArr.length; i++) {
				for (int j = 0; j < chessArr[0].length; j++) {
					out.write(chessArr[i][j]+"\t");
				}
				out.write("\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(out!=null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	public int[][] checkArrayFile() {
		
		File file = new File("e:\\array.txt");
		int sparseArr[][] = null;
		try {
			
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			int row = 0;
			int col = 0;
			while ((line = in.readLine()) !=null) {
				String[] temp = line.split("\t");
				col = temp.length;
				row ++;
				
			}
			
			sparseArr = new int[row][col];
			row = 0;
			in = new BufferedReader(new FileReader(file));
			while ((line = in.readLine()) !=null) {
				String[] temp = line.split("\t");
				for (int i = 0; i < temp.length; i++) {
					sparseArr[row][i] = new Integer(temp[i]);
				}
				row++;
			}
			
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sparseArr;
		
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
		
		return sparseArr;
		
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
