package aula02;
import java.util.Scanner;

public class ex2 {
	public static void main(String[] args) {
		double c, f;
		Scanner sc = new Scanner(System.in);
		System.out.print("Insira a temperatura em graus: ");
		c = sc.nextDouble();
		f = 1.8*c +32;
		System.out.println("A temperatura em Fahrenheit é " + f);
		sc.close();
	}
}