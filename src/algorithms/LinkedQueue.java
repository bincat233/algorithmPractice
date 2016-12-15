package algorithms;

import java.util.Iterator;

public class LinkedQueue<Item> implements Queue<Item>, Iterable<Item> {
	/**结构:
	 * O-> O -> ... -> O -> O
	 * first                last
	 * 队首                               队尾
	 * */
	int N;
	Node first;//队首，最早添加的元素
	Node last;//队尾，最后添加的元素
	private class Node{
		Item item;
		Node next;
	}
	
	//队列空: 1.出队出光了(first会指向null) 2.未添加节点(同上)
	@Override
	public boolean isEmpty() {
		//队首为空
		return first == null;
		//N == 0 亦可
	}

	@Override
	public int size() {
		return N;
	}

	//入队，存放旧队尾，队尾指针指向新节点，旧队尾next指向新队尾
	@Override
	public void enQueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		//旧last可能不存在
		if(isEmpty()) first = last;
		else oldLast.next = last;
		N++;
	}

	//出队，队首指针后移
	@Override
	public Item deQueue() {
		if(isEmpty()) return null;
		Item item = first.item;
		first = first.next;
		//队空，队尾指针也应置空
		if(isEmpty()) last = null;
		N--;
		return item;
	}
	
	private class LinkedQueueIterator implements Iterator<Item>{
		Node node = first;
		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public Item next() {
			Item item = node.item;
			node = node.next;
			return item;
		}
		
	}

	@Override
	public Iterator<Item> iterator() {
		return new LinkedQueueIterator();
	}
}
