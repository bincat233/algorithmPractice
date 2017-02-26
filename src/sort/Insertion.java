package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Insertion {
	public static void sort(Comparable[] a) {
		int N = a.length;
		// 添加哨兵(使a[0]最小)
		for(int i = 0; i < N; i++)
			if(less(a[i], a[0])) exch(a, 0, i);
		for(int i = 1; i < N; i++){
			Comparable t = a[i];
			int j;
			for(j = i; less(t, a[j-1]); j--)
				a[j] = a[j-1];//后移
			a[j] = t;
		}
	}
	
	private static boolean less(Comparable a, Comparable b) 
	{ return a.compareTo(b) < 0; }
	
	private static void exch(Comparable[] a, int i, int j)
	{ Comparable t = a[i]; a[i] = a[j]; a[j] = t;}
	
	private static void show(Comparable[] a) { 
		for(int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] a = {"s","a","D","w","q","2","3","B","0","A","1","A","u","d","3","a","2"};
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
