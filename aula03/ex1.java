package aula03;
import java.util.Scanner;
import java.lang.Math;

public class ex1 {
    public static void main(String[] args) {
        double a, b, notaP, notaT;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("Insira a nota da componente prática entre 0 e 20:");
            a = sc.nextDouble();
            notaP = Math.round(a*10.0)/10.0;
        }while ( (notaP > 20) || (notaP < 0) );

        do{
            System.out.print("Insira a nota da componente teórica entre 0 e 20:");
            b = sc.nextDouble();
            notaT = Math.round(b*10.0)/10.0;
        }while ( (notaT > 20) || (notaT < 0) );

        if ((notaP < 7) || (notaT < 7)){
            System.out.println("66");
        }
        else{
            System.out.println(Math.round(0.4 * notaT + 0.6 * notaP));
        } 
        sc.close();
    }
        
}