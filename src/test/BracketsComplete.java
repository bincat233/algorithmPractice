package test;

import algorithms.*;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BracketsComplete {
	public static void main(String[] args){
		Stack<String> val = new LinkedStack<>();
		Stack<String> opt = new LinkedStack<>();
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(s.equals("=")) break;
			else if(s.equals("+")|| s.equals("-")|| s.equals("*")||s.equals("/"))
				opt.push(s);
			else if(s.equals(")")){
				String t = val.pop();
				val.push("( "+val.pop()+" "+opt.pop()+" "+t+" )");
			} else
				val.push(s);
		}
		StdOut.println(val.pop());
	}
}
