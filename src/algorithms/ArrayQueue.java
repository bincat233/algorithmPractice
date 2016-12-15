package algorithms;

import java.util.Iterator;

public class ArrayQueue<Item> implements Queue<Item>, Iterable<Item> {
	private Item[] a;
	//first为队首，last为队尾+1
	private int first;
	private int last;
	private int N;
	
	public ArrayQueue(int cap){
		if(cap>0)
			initQueue(cap);
	}
	
	public ArrayQueue() {
		initQueue(10);
	}
	
	@SuppressWarnings("unchecked")
	private void initQueue(int cap){
		a = (Item[]) new Object[cap];
	}

	@Override
	public boolean isEmpty() {
		return first == last;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public void enQueue(Item item) {
		if(N==a.length) resize(a.length*2);
		a[last] = item;
		last = (last+1)%a.length;
		N++;
	}

	@Override
	public Item deQueue(){
		if(isEmpty()) return null;
		Item item = a[first];
		a[first] = null;
		first = (first+1)%a.length;
		N--;
		if(N>0 && N<a.length/4) resize(a.length/2);
		return item;
	}
	
	private void resize(int max){
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		for(int i = 0; i < N; i++){
			temp[i] = a[i];
		}
		a = temp;
	}
	
	private class ArrayQueueIterator implements Iterator<Item>{
		int i = first;
		@Override
		public boolean hasNext() {
			return i != last;
		}

		@Override
		public Item next() {
			Item item = a[i];
			i = (i+1)%a.length;
			return item;
		}
		
	}

	@Override
	public Iterator<Item> iterator() {
		return new ArrayQueueIterator();
	}
}
