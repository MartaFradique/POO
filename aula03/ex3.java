package aula03;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        int n;
        String v = "";
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Insira um numero inteiro positivo:");
            n = sc.nextInt();
        }while(n < 0);

        switch (n) {
            case 0 :
            System.out.println("Não é primo");
            break;
            case 1 :
            System.out.println("Não é primo");
            break;
            case 2 :
            System.out.println("É primo");
            break;
            default:
            for(int i =2;i < n;i++){
                if(n % i==0){
                    v = "Não é primo";
                    break;
                }
                else{
                    v = "É primo";
                }
            }
            System.out.println( v );
        }
        sc.close();
    }
        
}