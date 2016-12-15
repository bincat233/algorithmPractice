package test;

import algorithms.*;
import edu.princeton.cs.algs4.StdIn;

public class GetLastK {

	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		Stack<String> stack = new LinkedStack<>();
		while(StdIn.hasNextLine()){
			String s = StdIn.readLine();
			if("".equals(s))break;
			stack.push(s);
		}
		String out = "";
		for(int i = 0; i < k; i++){
			out = stack.pop();
		}
		System.out.println(out);
	}

}
