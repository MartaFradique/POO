package aula01;

public class exemplo2 {

	public static void main(String[] args) {
		recursivoSimples(100);
	}

	public static void recursivoSimples(int x) {
		System.out.println(x);
		x--;
		if (x>0) 
			recursivoSimples(x);
	}

}