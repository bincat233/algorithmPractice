package algorithms;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinkedStack<Item> implements Stack<Item> {
	private Node first;//ջ��
	private int N;//Ԫ������
	private int pushTimes, popTimes;
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
		pushTimes++;
		N++;
	}
	
	public Item pop(){
		if(isEmpty()) return null;
		Item item = first.item;
		first = first.next;
		popTimes++;
		N--;
		return item;
	}
	
	public Item peek(){
		return first.item;
	}
	
	private class LinkedStackIterator implements Iterator<Item>{
		private int pu = pushTimes;
		private int po = popTimes;
		private Node n = first;
		@Override
		public boolean hasNext() {
			test();
			return n != null;
		}

		@Override
		public Item next() {
			test();
			Item i = n.item;
			n = n.next;
			return i;
		}

		@Override
		public void remove() {
		}
		
		private void test(){
			if(pu!=pushTimes||po!=popTimes)
				throw new ConcurrentModificationException();
		}
		
	}

	@Override
	public Iterator<Item> iterator() {
		return new LinkedStackIterator();
	}

}
