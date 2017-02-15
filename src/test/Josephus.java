package test;

import algorithms.LinkedQueue;

public class Josephus {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		LinkedQueue<Integer> people = new LinkedQueue<>();
		for(int i = 0; i < N; i++)
			people.enQueue(i);
		int i = 0;
		while(!people.isEmpty()) {
			int t = people.deQueue();
			if(++i == M){
				System.out.print(t+" ");
				i = 0;
			} else {
				people.enQueue(t);
			}
		}
	}

}
