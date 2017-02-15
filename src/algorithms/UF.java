package algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
	private int[] id;
	private int count;
	
	UF(int N){
		count = N;
		id = new int[N];
		for(int i = 0; i < N; i++)
			id[i] = i;
	}
////	quick-find算法
//
//	void union(int p, int q){
//		int pID = find(p);
//		int qID = find(q);
//		if(pID==qID) return;
//		for(int i = 0; i < id.length; i++)
//			if(id[i]==qID) id[i] = pID;
//		count--;
//	}
//
//	int find(int p){
//		return id[p];
//	}
	
//	quick-union算法

	void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot) return;
		id[pRoot] = qRoot;
		count--;
	}
	
	int find(int p){
		while(id[p] != p)
			p = id[p];
		return p;
	}
	
	boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	int count(){
		return count;
	}
	
	public static void main(String[] args){
		int N = StdIn.readInt();
		UF uf = new UF(N);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			//文件结束提示
			if(p==7878&&q==6464)break;
			if(uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p+" "+q);
		}
		StdOut.println(uf.count()+" components");
	}
}
