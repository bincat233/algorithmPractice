package test;

import java.util.Arrays;

import algorithms.BinarySearch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TestRandomMatch {
	public static void main(String[] args){
		int T = Integer.parseInt(args[0]);
		int[] Ns = new int[]{1000,10000,100000,1000000};
		for(int N:Ns){
			double avg = 0;
			for(int tu = 0; tu < T; tu++){
				int[] a = new int[N];
				int counter = 0;
				for(int i = 0; i < N; i++){
					a[i] = StdRandom.uniform(100000, 999999);
				}
				Arrays.sort(a);
				
				int[] b = new int[N];
				for(int i = 0; i < N; i++){
					b[i] = StdRandom.uniform(100000, 999999);
				}
				Arrays.sort(b);

				int loc = -1;
				for(int n = 0; n < a.length; n++){
					if(n!=0&&a[n]==a[n-1])
						loc = BinarySearch.rank(a[n], b);
					if(loc>=0)
						counter++;
				}
				
				avg+=counter;
				
				
			}
			avg/=T;
			StdOut.printf("N=%d\tavg=%f\n", N, avg);
		}
	}
}
