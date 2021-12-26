package aula02;
import java.util.Scanner;

public class ex3 {
	public static void main(String[] args) {
		double q, m, f, i;
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira a quantidade de agua em kg: ");
		m = sc.nextDouble();
		System.out.print("Insira a temperatura inicial em graus: ");
        i = sc.nextDouble();
        System.out.print("Insira a temperatura final em graus: ");
		f = sc.nextDouble();
		q = m * (f - i) * 4184;
		System.out.println("A energia necessaria para aquecer a agua é " + q);
		sc.close();
	}
}