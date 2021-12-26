package aula04;
import java.util.Scanner;

public class ex3 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String v="";
        
		System.out.println("Introduza uma frase:");
		String s = sc.nextLine();

		String[] splitResult = s.split(" ");

		for (String i : splitResult) {
			if( i.length()>=3 ) {
				v+=i.charAt(0);
			}
		}
        
        
        System.out.println("Acrónimo:" + v);
        
		sc.close();
	}
}