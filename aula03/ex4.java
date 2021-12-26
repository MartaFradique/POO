package aula03;
import java.util.Scanner;

public class ex4 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, n1, sum, min, max, numLidos;
        numLidos = 1;
        System.out.print("1º número: ");
        n1 = sc.nextInt();
        min = max = sum = n1;
        do {
            System.out.printf("%dº número: ", ++numLidos);
            n = sc.nextInt();
            if (n < min)
                min = n;
            else if (n > max)
                max = n;
            sum += n;
        } while (n != n1);
        sc.close();
        System.out.println("Média = " + (sum*1.0)/(numLidos*1.0));
        System.out.println("Mínimo = " + min);
        System.out.println("Máximo = " + max);
        System.out.println("Números Lidos = " + numLidos);

       
	}
}