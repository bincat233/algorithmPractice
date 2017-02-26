package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Merge {
	//将b归并至a
	public static void merge(Comparable[] a, Comparable[] b, int lo, int mid, int hi) {
//		System.out.println("merge("+lo+","+mid+","+hi+")");show(a);show(b);
		int i = lo, j = mid + 1;
		
		for(int k = lo; k <= hi; k++)
			if	(i > mid)	a[k] = b[j++];
			else if	(j > hi)	a[k] = b[i++];
			else if	(less(b[j], b[i]))	a[k] = b[j++];
			else	a[k] = b[i++];
//		System.out.println("merge end");show(a);show(b);
	}
	
	//对a插入排序
	public static void insertion(Comparable[] a, int lo, int hi){
//		System.out.println("insertion("+lo+","+hi+")");show(a);
		// 添加哨兵
		for(int i = lo; i <= hi; i++)
			if(less(a[i], a[lo])) exch(a, lo, i);
		for(int i = lo+1; i <= hi; i++){
			Comparable t = a[i];
			int j;
			for(j = i; less(t, a[j-1]); j--)
				a[j] = a[j-1];//后移
			a[j] = t;
		}
	}
	
	public static void sort(Comparable[] a){
		// 通过传参使每次排序有自己的b[]数组
		Comparable[] b = new Comparable[a.length];
		sort(a, b, 0, a.length - 1);
	}
	
	//b移至a中
	private static void move(Comparable[] a, Comparable[] b, int lo, int hi){
//		System.out.println("move("+lo+","+hi+")");show(a);show(b);
		while(lo<=hi){
			a[lo] = b[lo];
			lo++;
		}
	}
	
	private static void sort(Comparable[] a, Comparable[] b, int lo, int hi){
//		System.out.println("sort("+lo+","+hi+")");show(a);show(b);
		//数组规模小于15时使用插入排序
		if(hi-lo < 15) {
			if(a[lo]==null) move(a, b, lo, hi);
			insertion(a, lo, hi);
			return;
		}
		int mid = lo + (hi-lo)/2;
		//递归
		sort(b, a, lo, mid);
		sort(b, a, mid+1, hi);
		if(less(b[mid+1], b[mid])) 
			merge(a, b, lo, mid, hi);
		else move(a, b, lo, hi);
//		System.out.println("sort("+lo+","+hi+")"+" end");show(a);show(b);
	}
	
	private static boolean less(Comparable a, Comparable b) 
	{ return a.compareTo(b) < 0; }
	
	private static void exch(Comparable[] a, int i, int j)
	{ Comparable t = a[i]; a[i] = a[j]; a[j] = t;}
	
	private static void show(Comparable[] a) { 
//		StdOut.print(a.hashCode()+": ");
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
