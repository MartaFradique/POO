package aula02;
import java.util.Scanner;

public class ex4 {
	public static void main(String[] args) {
        double t, m, l, total;
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o montante investido: ");
		m = sc.nextDouble();
		System.out.print("Insira a taxa de juro mensal em percentagem: ");
		l = sc.nextDouble();
		t = l / 100;
		total = (((((m * t) + m) * t) + ((m * t) + m)) * t) + ((((m * t) + m) * t) + ((m * t) + m));
		// total = m * (Math.pow((1+t),3) - 1)
		System.out.println("O valor total ao final de 3 messes é " + total);
		sc.close();
	}
}