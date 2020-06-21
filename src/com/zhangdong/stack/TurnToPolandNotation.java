package com.zhangdong.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class TurnToPolandNotation {
	
	public static void main(String[] args) {
		String s = "1+((2+3)*4)-5";
		
		List<String> strList = checkStrToList(s);
		
		List<String> list = turnToPolandNotation(strList);
		
		int result = counter(list);
		System.out.println(result);
		
		//turnToPolandNotation(s);
	}
	
	private static List<String> checkStrToList(String str) {
		ArrayList<String> strList = new ArrayList<>();
		
		
		
		String mark = "";
		Pattern pattern = Pattern.compile("\\d+");
		for(int i=0 ; i<str.length(); i++) {
			
			String sflag = String.valueOf(str.charAt(i));
			if(pattern.matcher(sflag).matches()) {
				mark = mark + sflag;
			} else {
				if(!"".equals(mark)) {
					strList.add(mark);
				}
				strList.add(sflag);
				mark = "";
			}
			
			if(i==str.length()-1) {
				strList.add(mark);
			}
		}
		
		
		return strList;
	}
	
	public static List<String> turnToPolandNotation(List<String> strList){
		
		
		Stack<String> s1 = new Stack<>();
		List<String> s2 = new ArrayList<>();
		
		Pattern pattern = Pattern.compile("\\d+");
		for(int i=0 ; i<strList.size(); i++) {
			
			String sflag = strList.get(i);
			if(pattern.matcher(sflag).matches()) {
				s2.add(sflag);
			}else {
				checkflag(sflag, s1, s2);
			}
		}
		
		s2.add(s1.pop());
		
		return s2;
	}
	

	private static void checkflag(String sflag, Stack<String> s1, List<String> s2) {
		if(s1.isEmpty()) {
			s1.push(sflag);
		} else {
			
			if("(".equals(sflag)) {
				s1.push("(");
			}else if(")".equals(sflag)) {
				while (true) {
					if("(".equals(s1.peek())) {
						s1.pop();
						break;
					}else {
						s2.add(s1.pop());
					}
				}
			}else {
				
				String iteam = s1.peek();
				if(iteam.equals("(")){
					s1.push(sflag);
				}else if((iteam.equals("+")||iteam.equals("-")) && (sflag.equals("*")||sflag.equals("/"))) {
					s2.add(s1.pop());
					s1.push(sflag);
				}else if((iteam.equals("*")||iteam.equals("/")) && (sflag.equals("+")||sflag.equals("-"))) {
					s2.add(sflag);
				}else if(((iteam.equals("*")||iteam.equals("/")) && (sflag.equals("/")||sflag.equals("*")))||
						((iteam.equals("+")||iteam.equals("-")) && (sflag.equals("+")||sflag.equals("-")))) {
					s2.add(s1.pop());
					s1.push(sflag);
				}
			}
			
		}
		
	}

	public static Stack<String> turnToPolandNotation(String str){
		
		
		Stack<String> s1 = new Stack<>();
		Stack<String> s2 = new Stack<>();
		
		String mark = "";
		Pattern pattern = Pattern.compile("\\d+");
		for(int i=0 ; i<str.length(); i++) {
			
			String sflag = String.valueOf(str.charAt(i));
			if(pattern.matcher(sflag).matches()) {
				mark = mark + sflag;
			}else {
				if(!"".equals(mark)) {
					s2.push(mark);
				}
				mark = "";
				checkflag(sflag, s1, s2);
			}
			
			if(i==str.length()-1) {
				s2.push(mark);
			}
			
		}
		
		s2.push(s1.pop());
		
		
		for(String s : s2) {
			System.out.println(s);
		}
		
		
		return null;
	}

	private static void checkflag(String sflag, Stack<String> s1, Stack<String> s2) {
		if(s1.isEmpty()) {
			s1.push(sflag);
		} else {
			
			if("(".equals(sflag)) {
				s1.push("(");
			}else if(")".equals(sflag)) {
				while (true) {
					if("(".equals(s1.peek())) {
						s1.pop();
						break;
					}else {
						s2.push(s1.pop());
					}
				}
			}else {
				
				String iteam = s1.peek();
				if(iteam.equals("(")){
					s1.push(sflag);
				}else if((iteam.equals("+")||iteam.equals("-")) && (sflag.equals("*")||sflag.equals("/"))) {
					s2.push(s1.pop());
					s1.push(sflag);
				}else if((iteam.equals("*")||iteam.equals("/")) && (sflag.equals("+")||sflag.equals("-"))) {
					s2.push(sflag);
				}else if(((iteam.equals("*")||iteam.equals("/")) && (sflag.equals("/")||sflag.equals("*")))||
						((iteam.equals("+")||iteam.equals("-")) && (sflag.equals("+")||sflag.equals("-")))) {
					s2.push(s1.pop());
					s1.push(sflag);
				}
			}
			
		}
		
	}
	
	public static int counter(List<String> list) {
		
		Stack<String> stack = new Stack<>();
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			if(str.matches("\\d+")) {
				stack.push(str);
			}else {
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				switch (str) {
				case "+":
					result = num1 + num2;
					break;
				case "-":
					result = num1 - num2;
					break;
				case "*":
					result = num1 * num2;
					break;
				case "/":
					result = num1 / num2;
					break;

				default:
					break;
				}
				
				stack.push("" + result);
				
			}
			
		}
		
		return Integer.parseInt(stack.pop());
	}
	
	
}
