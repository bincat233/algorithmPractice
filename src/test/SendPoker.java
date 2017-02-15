package test;

import algorithms.RandomQueue;
public class SendPoker {
	static class Card{
		String face;
		String color;
		void print(){
			System.out.print(color+face+" ");
		}
	}
	public static void main(String[] args){
		//初始化牌组
		RandomQueue<Card> cards = new RandomQueue<>();
		for(int i = 1; i <= 13; i++) {
			for(int j = 0; j < 4; j++){
				Card c = new Card();
				//牌面
				if(i == 1)
					c.face = "A";
				else if(i == 11)
					c.face = "J";
				else if(i == 12)
					c.face = "P";
				else if(i == 13)
					c.face = "K";
				else
					c.face = i+"";
				//花色
				if(j==0)
					c.color="♥️";
				else if(j==1)
					c.color="♠️";
				else if(j==2)
					c.color="♦️";
				else if(j==3)
					c.color="♣️";
				cards.enqueue(c);
			}
		}
		
		//发牌
		for(int i = 0; i < 4; i++){
			System.out.println("玩家"+(char)('A'+i)+": ");
			for(int j = 0; j < 13; j++)
				cards.dequeue().print();
			System.out.println();
		}
	}
}
