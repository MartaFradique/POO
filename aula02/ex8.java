package aula02;
import java.util.Scanner;
import java.lang.Math;

public class ex8 {
	public static void main(String[] args) {
        double e, p, k, a, b, c, f;
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira a distancia do cateto A: ");
		a = sc.nextInt();
		System.out.print("Insira a distancia do cateto B: ");
        b = sc.nextInt();
        k = Math.pow(a,2);
        p = Math.pow(b,2);
        c = Math.sqrt(k+p);
        e = Math.asin(b/c);
        f = (e * 180)/ Math.PI;
        // f = Math.toDegress(e)
        System.out.println("O valor de hipotenusa é " + c);
        System.out.println("O valor do angulo entre o cateto A e a hipotenusa é " + f);
		sc.close();
	}
}