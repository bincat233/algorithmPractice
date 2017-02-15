package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class RandomBag<Item> implements Iterable<Item>{
	Random random;
	int n;
	Item[] a;
	
	@SuppressWarnings("unchecked")
	public RandomBag(){
		random = new Random();
        a = (Item[]) new Object[2];
        n = 0;
	}
    public boolean isEmpty() {
        return n == 0;
    }
    public int size() {
        return n;
    }
    private void resize(int capacity) {
        assert capacity >= n;
        @SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++)
            temp[i] = a[i];
        a = temp;
    }
    public void add(Item item) {
        if (n == a.length) resize(2*a.length);    // double size of array if necessary
        a[n++] = item;                            // add item
    }
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i;
        private int[] index;
        private ArrayIterator(){
        	index = new int[n];
        	for(int i = 0; i < n; i++){
        		index[i] = i;
        	}
        	for(int i = n; i > 0; i--){
        		int current = random.nextInt(i);
        		int t = index[current];
        		index[current] = index[i-1];
        		index[i-1] = t;
        	}
        }
        public boolean hasNext()  { return i < n;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[index[i++]];
        }
    }
    public static void main(String[] args) {
    	RandomBag<String> bag = new RandomBag<String>();
        bag.add("Hello");
        bag.add("World");
        bag.add("how");
        bag.add("are");
        bag.add("you");

        for (String s : bag)
            StdOut.println(s);
    }

}
