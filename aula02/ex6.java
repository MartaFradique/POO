package aula02;
import java.util.Scanner;

public class ex6 {
	public static void main(String[] args) {
        int s,h,m;
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o tempo em segundos: ");
		s = sc.nextInt();
		h = (s /60) / 60;
		m = (s /60) % 60;
		s = s % 60;
		System.out.printf("%02d:%02d:%02d",h,m,s);
		sc.close();
	}
}