package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomQueue<Item> implements Iterable<Item>{
	Item[] q;
	int n;
	int first;
	int last;
	@SuppressWarnings("unchecked")
	public RandomQueue(int size){
		q = (Item[]) new Object[size];
		n = 0;
		first = 0; 
		last = 0;
	}
	public RandomQueue(){
		this(10);
	}
	private void resize(int s){
		@SuppressWarnings("unchecked")
		Item[] t = (Item[]) new Object[s];
		for(int i = 0; i < n; i++){
			t[i] = q[(first+i)%q.length];
		}
		q = t;
		first = 0;
		last = n;
	}
	public boolean isEmpty(){
		return n==0;
	}
	public void enqueue(Item item){
		q[last++] = item;
		n++;
		if(n==q.length) resize(2*n);
		if(last==q.length) last = 0;
	}
	public Item dequeue(){
		if(isEmpty()) throw new NoSuchElementException();
		int r = (first + (int) (n*Math.random())) % q.length;
		Item temp = q[r];
		q[r] = q[first];
		q[first] = null;
		first = (first + 1) % q.length;
		n--;
		if(n > 0 && n == q.length/4) resize(q.length/2);
		return temp;
	}
	public Item sample(){
		return q[(first + (int) (n*Math.random())) % q.length];
	}
	public static void main(String[] args){
		int[] sum = new int[5];
		for(int t = 0; t < 100000; t++){
			RandomQueue<String> ss = new RandomQueue<>();
			ss.enqueue("11 ");
			ss.enqueue("22 ");
			ss.enqueue("33 ");
			ss.enqueue("44 ");
			ss.enqueue("55 ");
			for(int i = 0; i < 5; i++){
				String o = ss.dequeue();
				if(o.equals("22 ")){
					sum[i]++;
				}
				System.out.print(o);
			}
			System.out.println();
		}
		for(int t:sum){
			System.out.print(t+" ");
		}
	}
	private class ArrayIterator implements Iterator<Item>{
		int[] indexes;
		int c = 0;
		// TODO 还可以优化，比如抛弃 indexes ，比如一个循环搞定
		public ArrayIterator() {
			indexes = new int[n];
			for(int i = 0; i < n; i++){
				indexes[i] = i;
			}
			for(int i = n-1; i >= 0; i--){
				int x = (int)(Math.random()*i);
				indexes[i] = indexes[x];
				indexes[x] = i;
			}
			
		}
		@Override
		public boolean hasNext() {
			return c<n;
		}
		@Override
		public Item next() {
			Item t = q[indexes[c]];
			c++;
			return t;
		}
	}
	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}
}
