package aula02;
import java.util.Scanner;
import java.lang.Math;

public class ex7 {
	public static void main(String[] args) {
        double d,p,k,x1, y1, x2, y2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira a abcissa de p1: ");
		x1 = sc.nextInt();
		System.out.print("Insira a ordenada de p1: ");
        y1 = sc.nextInt();
        System.out.print("Insira a abcissa de p2: ");
		x2 = sc.nextInt();
		System.out.print("Insira a ordenada de p2: ");
        y2 = sc.nextInt();
        k = Math.pow((x1 - x2),2);
        p = Math.pow((y1 - y2),2);
        d = Math.sqrt(k+p);
        System.out.println("A distancia entre os pontos é " + d);
		sc.close();
	}
}