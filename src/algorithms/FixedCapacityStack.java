package algorithms;

public class FixedCapacityStack<Item> {
	private Item[] a;
	private int N;
	
	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int cap) {
		a = (Item[])new Object[cap];
	}
	
	void push(Item i){
		a[N++] = i;
	}
	
	public Item pop(){
		return a[--N];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public boolean isFull(){
		return N==a.length;
	}
	
	public static void main(String[] args) {
		FixedCapacityStack<String> stack = new FixedCapacityStack<>(3);
		stack.push("1");
		stack.push("2");
		stack.push("3");
		System.out.println(stack.isFull());
	}

}
