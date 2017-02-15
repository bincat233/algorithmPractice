package algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz;
	private int count;
	
	WeightedQuickUnionUF(int N){
		count = N;
		id = new int[N];
		sz = new int[N];
		for(int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
//	加权quick-union算法	
	void union(int p, int q){
		int i = find(p);
		int j = find(q);
		if(i == j) return;
		if(sz[j] > sz[i]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}
	
	int find(int p){
		int root = p;
		while(id[root] != root)
			root = id[root];
		while(id[p] != p){
			int t = p;
			p = id[p];
			id[t] = root;
		}
		return root;
	}	
	
	boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	int count(){
		return count;
	}
	
	public static void main(String[] args){
		int N = StdIn.readInt();
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			//文件结束提示
			if(p==7878&&q==6464)break;
			if(uf.connected(p, q)) continue;
			uf.union(p, q);
//			StdOut.println(p+" "+q);
		}
		StdOut.println(uf.count()+" components");
	}
}