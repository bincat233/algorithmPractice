package test;

import algorithms.LinkedStack;

public class TestOfStack {
	public static void main(String[] args){
		String options = args[0];
		int sign = 0;
		for(int i = 0; i < options.length(); i++) {
			char c = options.charAt(i);
			if(c=='-') sign--;
			else sign++;
			
			if(sign<0)break;	 
		}
		
		if(sign < 0) {
			System.out.println("该序列不成立");
			return;
		}
		
		System.out.println("该序列成立");
		
		//如参数1为空，结束程序
		
		if(args.length<2) return;
		String out = args[1];
		
		LinkedStack<Character> s = new LinkedStack<>();
		int n = -1;
		int i;
		for(i = 0; i < options.length(); i++) {
			char c = options.charAt(i);
			if(c=='-') {
				n++;
				char a = s.pop();
				char b = out.charAt(n);
				//System.out.println(a+" "+b);
				if(a != b) break;
			}
			else s.push(options.charAt(i));;
				 
		}
		if(i >= options.length())
			System.out.println("出栈正确");
		else
			System.out.println("出栈失败");
	}
}
