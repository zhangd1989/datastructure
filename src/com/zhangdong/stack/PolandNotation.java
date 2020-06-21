package com.zhangdong.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class PolandNotation {
	public static void main(String[] args) {
		
		String suffxExpression = "1 2 + 3 - 2 * 3 +";
		
		List<String> list = new ArrayList<String>(Arrays.asList(suffxExpression.split(" ")));
		
		
		System.out.println(counter(list));
	}
	
	public static int counter(List<String> list) {
		
		Stack<String> stack = new Stack<>();
		
		Pattern pattern = Pattern.compile("\\d+");
		
		int num = 0;
		
		for(String str : list) {
			if(pattern.matcher(str).matches()) {
				stack.push(str);
			}else {
				
				int num1 = Integer.parseInt(stack.pop());
				int num2 = Integer.parseInt(stack.pop());
				
				if("+".equals(str)) {
					
					num = num1 + num2;
					
				}else if("-".equals(str)) {

					num = num2 - num1;
					
				}else if("*".equals(str)) {

					num = num1 * num2;
					
				}else if("/".equals(str)) {

					num = num2 / num1;
					
				}
				stack.push("" + num);
				
			}
		}
		
		return Integer.parseInt(stack.pop());
		
	}
}
