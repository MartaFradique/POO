package aula04;
import java.util.Scanner;

public class ex4 {
	public static void main(String[] args) {
        int array[]= readVal();
        result(array);
    }
    
    public static int[] readVal(){
        Scanner sc = new Scanner(System.in);
        int array[]= new int[3];
        System.out.println("Introduza um mês:");
        array[0] = sc.nextInt();
        System.out.println("Introduza um ano:");
        array[1] = sc.nextInt();
        System.out.println("Introduza o dia da semana em que começa o mês (1 = Segunda, 2 = Terça, 3 = Quarta, 4 = Quinta, 5 = Sexta, 6 = Sábado, 7 = Domingo) :");
        array[2]=sc.nextInt();
        sc.close();
        return array;
    }

    public static int lastDay(int m,int a){
        int f;
        switch(m){
            case(2):
            if( ( a%4 == 0 && a%100 != 0) || (a%400 == 0) ){
                f = 29;
            }
            else{
                f=28;
            }
            break;
            case (4):
            case(6):
            case(9):
            case(11):
            f=30;
            break;
            default:
            f=31;
        }
		
		return f;
    }
    
    public static String stringMonth(int m){
        String array[]= {"January","February","March","April","May","June","July","August","September","October","November","December"};
		return array[m-1];
    }

    public static void result(int[] array){
        int k=1;
        int m =array[0];
        int a =array[1];
        int d =array[2];

        String v[][]= new String[6][7];

        System.out.printf("%11s %5s %n",stringMonth(m),a);
        System.out.printf("%2s %3s %3s %3s %3s %3s %2s %n","Su", "Mo", "Tu", "We", "Th", "Fr", "Sa") ;

        if (d==7){
            d=0;
        }

        for(int i =0 ; i < 6; i++){
            for(int x =0 ; x < 7; x++){ // x --> coluna i --> linha d --> dia da se,mana k --> dias do mes
                if( ( (x<d) && (i==0) ) || (k>lastDay(m,a)) ){
                    v[i][x]=" ";
                }
                else{
                    v[i][x]=k+"";
                    k++;
                }
            }
        }
        
        for(int i =0 ; i < 6; i++){
            System.out.printf("%2s %3s %3s %3s %3s %3s %2s %n",v[i][0], v[i][1], v[i][2], v[i][3], v[i][4], v[i][5], v[i][6]) ;
            
        }
    }
}