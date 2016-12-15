package algorithms;

import java.util.Iterator;

public class ArrayStack<Item> implements Iterable<Item>, Stack<Item> {
	private Item[] a;
	private int N;
	
	public ArrayStack(){
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int cap){
		a = (Item[]) new Object[cap];
	}
	
	public Item pop(){
		Item item = a[--N];
		a[N] = null;
		//maybe N is 0...
		if(N > 0 && N == a.length/4) resize(a.length/2);
		return item;
	}
	
	public void push(Item item){
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
	
	
	
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i = N;
		@Override public boolean hasNext() {return i > 0;}
		@Override public Item next() {return a[--i];}
		@Override public void remove() {}
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	@Override
	public Item peek() {
		// TODO ¸ÄÌìÀ´Ð´
		return null;
	}
	
}
