package aula03;
import java.util.Scanner;

public class ex6 {
	public static void main(String[] args) {
        int a,m;
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o mês: ");
        m = sc.nextInt();
        System.out.print("Insira o ano: ");
        a = sc.nextInt();

        System.out.printf("Número de dias do mês %2d do ano %4d: ",m ,a );

        switch(m){
            case(2):
            if( ( a%4 == 0 && a%100 != 0) || (a%400 == 0) ){
                System.out.println("29");
            }
            else{
                System.out.println("28");
            }
            break;
            case(6):
            case(9):
            case(11):
            System.out.println("30");
            break;
            default:
            System.out.println("31");
        }

        sc.close();
	}
}