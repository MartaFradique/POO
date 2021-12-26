package aula04;
import java.util.Scanner;

public class ex2 {
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String s;
        
		System.out.print("Insira uma frase:");
		s = sc.nextLine();
		System.out.println("Número de caracteres numéricos: " + countDigits(s));
		System.out.println("Número de espaços: " + countSpaces(s));
		System.out.println("Só contem minúsculas. " + soContemMinusculas(s));
		System.out.println("Frase sem espaços a mais: " + takeOutSpaces(s));
		System.out.println("Frase é um palíndromo. " + palindromo(s));
		
        
		sc.close();
	}

	public static int countDigits(String s){
		int v=0;
		for(int i =0; i < s.length(); i++){
			if(Character.isDigit( s.charAt(i))){
				v++;
			}
		}
		return v;
	}

	public static int countSpaces(String s){
		int v=0;
		for(int i =0; i < s.length(); i++){
			if(s.substring(i, i+1).equals(" ")){
				v++;
			}
		}
		return v;
	}

	public static boolean soContemMinusculas(String s){
		return s.equals(s.toLowerCase());
	}

	public static String takeOutSpaces(String s){
		String v="";
		v+=s.charAt(0);
		for(int i =1; i < s.length(); i++){
			if(  !( ( s.charAt(i) == ' ' ) && ( s.charAt(i-1) == ' ' ) ) ){
				v+=s.charAt(i);
			}
		}
		return v;
	}

	public static boolean palindromo(String s){
		String v="";

		for(int i =s.length()-1; i >= 0; i--){
			v+=s.charAt(i);
		}

		return s.equals(v);
	}

}