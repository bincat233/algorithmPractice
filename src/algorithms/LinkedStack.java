package algorithms;

import java.util.Iterator;

public class LinkedStack<Item> implements Stack<Item> {
	private Node first;//Õ»¶¥
	private int N;//ÔªËØÊýÁ¿
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {return first == null;}
	
	public int size() {return N;}
	
	public void push(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public Item pop(){
		if(isEmpty()) return null;
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public Item peek(){
		return first.item;
	}
	
	private class LinkedStackIterator implements Iterator<Item>{
		private Node n = first;
		@Override
		public boolean hasNext() {
			return n != null;
		}

		@Override
		public Item next() {
			Item i = n.item;
			n = n.next;
			return i;
		}

		@Override
		public void remove() {
		}
		
		
		
	}

	@Override
	public Iterator<Item> iterator() {
		return new LinkedStackIterator();
	}

}
