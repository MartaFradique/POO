package aula02;
import java.util.Scanner;

public class ex5 {
	public static void main(String[] args) {
		double v1, d1, v2, d2, vm;
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira a velociade do primeiro trajeto: ");
		v1 = sc.nextDouble();
		System.out.print("Insira a distancia do primeiro trajeto: ");
        d1 = sc.nextDouble();
        System.out.print("Insira a velociade do segundo trajeto: ");
		v2 = sc.nextDouble();
		System.out.print("Insira a distancia do segundo trajeto: ");
        d2 = sc.nextDouble();
		vm = v1 * (d1 / (d1 + d2)) + v2 * (d2/ (d1 + d2));
		System.out.println("A velocidade média final é " + vm);
		sc.close();
	}
}