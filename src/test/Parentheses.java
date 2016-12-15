package test;

import algorithms.*;

public class Parentheses {
	private Stack<Character> left = new LinkedStack<>();
	public boolean allParent(String in){
		for(int i = 0; i < in.length(); i++){
			char c = in.charAt(i);
			switch(c){
			case '{':
			case '(':
			case '[':
			case '<': left.push(c); break;
			case '}':
			case ')':
			case ']':
			case '>': if(!oneParent(c)) return false; break;
			}
		}
		return true;
	}
	private boolean oneParent(char a){
		switch(left.pop()){
		case '{': return a == '}';
		case '(': return a == ')';
		case '[': return a == ']';
		case '<': return a == '>';
		}
		return false;
	}
	
	public static void main(String[] args){
		Parentheses p = new Parentheses();
		boolean b = p.allParent("qq{{[4]3}12[3(32)6]()444<>}");
		System.out.println(b);
	}
}
