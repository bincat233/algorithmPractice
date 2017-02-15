package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackQueue<Item> implements Queue<Item> {
	Stack<Item> s1 = new LinkedStack<>();
	Stack<Item> s2 = new LinkedStack<>();
	public static void main(String[] args) {
		Queue<String> q = new StackQueue<>();
		q.enQueue("1");
		q.enQueue("2");
		q.enQueue("3");
		String s = q.deQueue();
		s+=q.deQueue();
		s+=q.deQueue();
		System.out.println(s);
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isEmpty() {
		return size()==0;
	}
	@Override
	public int size() {
		return s1.size()+s2.size();
	}
	@Override
	public void enQueue(Item item) {
		while(!s2.isEmpty()){
			s1.push(s2.pop());
		}
		s1.push(item);
	}
	@Override
	public Item deQueue() {
		Item i = null;
		if(isEmpty()) throw new NoSuchElementException();
		
		if(s2.size()==0) i = s1.pop();
		else {
			while(s2.size()>1){
				s1.push(s2.pop());
			}
			i = s2.pop();
		}
		return i;
	}
}
