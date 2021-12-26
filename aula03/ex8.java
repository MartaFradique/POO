package aula03;
import java.util.Scanner;
import java.lang.Math;

public class ex8 {
    public static void main(String[] args) {
        double notaf;
        double v[][]= new double[16][2];
        Scanner sc = new Scanner(System.in);

        for(int i =0 ; i < 16 ; i++){
            v[i][0]=Math.random()*20;
            v[i][1]=Math.random()*20;
        }

        System.out.printf("%5s %6s %6s", "NotaT", "NotaP", "Pauta");
        System.out.println();
        
        for(int i =0 ; i < 16 ; i++){
            double notaT =Math.round( (v[i][0]) * 10.0) / 10.0;
            double notaP =Math.round( (v[i][1]) * 10.0) / 10.0;

            if ((notaP < 7) || (notaT < 7)){
                notaf = 66;
            }
            else{
                notaf = Math.round(0.4 * notaT + 0.6 * notaP);
            } 

            System.out.printf("%5.1f %5.1f %5.0f ", notaT, notaP, notaf );
            System.out.println();
        }
        
        sc.close();
    }
}