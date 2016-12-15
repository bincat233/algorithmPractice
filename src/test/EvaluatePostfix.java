package test;

import java.util.*;


public class EvaluatePostfix {
	static Scanner in = new Scanner(System.in);
	public String evaluatePostfix(String in){
		Stack<Double> vals = new Stack<>();
		String[] org = in.split(" ");
		for(String s:org){
			double v;
			if(s.equals("q"))	break;
			else if(s.equals("+")){v = vals.pop(); v = vals.pop()+v;vals.push(v);}
			else if(s.equals("-")){v = vals.pop(); v = vals.pop()-v;vals.push(v);}
			else if(s.equals("*")){v = vals.pop(); v = vals.pop()*v;vals.push(v);}
			else if(s.equals("/")){v = vals.pop(); v = vals.pop()/v;vals.push(v);}
			else vals.push(Double.parseDouble(s));
		}
		return vals.pop()+"";
	}
	public static void main(String[] args){
		EvaluatePostfix e = new EvaluatePostfix();
		String s;
		while(!(s = in.nextLine()).toLowerCase().equals("q"))
			System.out.println(e.evaluatePostfix(s));
		
	}
}
