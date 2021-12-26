package aula03;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira um valor positivo:");
        int N = sc.nextInt();
        sc.close();
        for( ; N>=0 ; N--){
            System.out.println(N);
        }
    }
        
}