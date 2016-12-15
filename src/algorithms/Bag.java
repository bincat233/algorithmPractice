package algorithms;

import java.util.Iterator;


public class Bag <Item> implements Iterable<Item> {
	private Item[] a;
	private int N;
	
	public Bag(){
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public Bag(int cap){
		a = (Item[]) new Object[cap];
	}
	
	public void add(Item item){
		if(N == a.length) resize(a.length*2);
		a[N++] = item;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	private void resize(int max){
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		for(int i = 0; i < N; i++){
			temp[i] = a[i];
		}
		a = temp;
	}
	
	private class ArrayIterator implements Iterator<Item>{
		private int i = 0;
		@Override public boolean hasNext() {return i < N;}
		@Override public Item next() {Item temp = a[i++]; return temp;}
		@Override public void remove() {}
	}

	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}
}
