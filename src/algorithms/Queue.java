package algorithms;

public interface Queue<Item> extends Iterable<Item> {
	public boolean isEmpty();
	public int size();
	public void enQueue(Item item);
	public Item deQueue();
}
