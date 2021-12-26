package aula03;
import java.util.Scanner;
import java.lang.Math;

public class ex5 {
	public static void main(String[] args) {
        double m, t;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("Insira o montante investido (positivo e múltiplo de 1000): ");
            m = sc.nextDouble();
        }while(m <= 0 || m%1000 != 0);

        do{
            System.out.print("Insira a taxa de juro mensal em percentagem (entre 0% e 5%): ");
            t = sc.nextInt();
        }while(t < 0 || t > 5);

        for(int i=1;i<=12;i++){
            System.out.println("O valor mensal do fundo do mês "+ i +" é "+ m * Math.pow(1 +(t/100), i) );
        }
        sc.close();
        System.out.println(Math.round( (Math.random()*20) * 10.0) / 10.0);
	}
}