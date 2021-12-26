package aula04;
import java.util.Scanner;

public class ex1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String s;
        
		System.out.print("Insira uma palavra, frase ou parágrafo:");
        s = sc.nextLine();

        System.out.println("Frase convertida para minúsculas: " + s.toLowerCase());
        System.out.printf("O último carater da frase: %s %n", s.charAt(s.length()-1));
        System.out.printf("Os 3 primeiros carateres: %s %s %s %n", s.charAt(0) , s.charAt(1) , s.charAt(2));
        System.out.println("Frase convertida para máiusculas: " + s.toUpperCase());
        System.out.println("Frase contêm a sequencia 've': " + s.contains("ve"));
        System.out.println("Acrescentar á frase um '.': " + s.concat("."));
        
		sc.close();
	}
}