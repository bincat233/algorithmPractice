package test;

import algorithms.*;

public class CopyStringStack {
	public static Stack<String> copy(Stack<String> src){
		LinkedStack<String> cpy = new LinkedStack<>();
		LinkedStack<String> tmp = new LinkedStack<>();
		for(String s : src){
			tmp.push(s);
		}
		for(String s : tmp){
			cpy.push(s);
		}
		return cpy;
	}
}
