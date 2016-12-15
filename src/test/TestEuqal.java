package test;

public class TestEuqal {
	public static void main(String[] args){
		int i;
		for(i = 0; i < args.length-1; i++){
			if(!args[1].equals(args[i+1])){
				System.out.println("not equals");
				break;
			}
		}
		if(i==args.length)
			System.out.println("equals");
	}
}
