package aula03;
import java.util.Scanner;
import java.lang.Math;

public class ex7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1;

		do{
			double a = Math.ceil(Math.random()*100);

			System.out.print("Advinha um número entre 1 e 100: ");
			int k = sc.nextInt();
			int t = 1;

			while(k!=a){
				if(k < a){
					System.out.println("Baixo");
				}
				if(k > a){
					System.out.println("Alto");
				}
				System.out.print("Tente outra vez: ");
				k = sc.nextInt();
				t++;
			}

			System.out.println("Advinhou! Tentativas: " + t);
			System.out.println("Pretende continuar? Prima (S)im");
			s1 = sc.next();

		}while( ( s1.equals("S") ) || s1.equals("Sim")  );
		sc.close();
	}
}