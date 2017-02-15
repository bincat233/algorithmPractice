package algorithms;

public class ArrayGeneralizedQueue <Item> {
	
	Item[] a;
	int N;
	
	public static void main(String[] args) {
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayGeneralizedQueue() {
		a = (Item[]) new Object[10];
		N = 0;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int size) {
		Item[] old = a;
		a = (Item[]) new Object[size];
		for(int i = 0; i < N; i++)
			a[i] = old[i];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void insert(Item x) {
		if(N == a.length) resize(2*a.length);
		a[N] = x;
		N++;
	}
	
	public Item delete(int k) {
		Item i = a[k];
		while(a[k+1]!=null) {
			a[k] = a[k+1];
			k++;
		}
		N--;
		if(N==a.length/4) resize(a.length/2);
		return i;
	}
	
	
}
