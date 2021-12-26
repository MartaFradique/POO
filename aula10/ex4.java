package aula10;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ex4 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new FileReader("words.txt"));
        Set<String> words = new HashSet<>();

        while (input.hasNext()) {
            String word = input.next();
            System.out.println(word);
            if(word.length()>2){
                words.add(word);
            }
        }

        input.close();

        //b)
        System.out.print("Palavras com mais do que 2 caracteres: ");
        System.out.println(words);

        //c)
        System.out.println("Palavras  terminadas em s:");
        for(String word: words){
            if(word.endsWith("s")){
                System.out.println(word);
            }
        }

        //d)
        Iterator<String> i = words.iterator();
		while (i.hasNext()) {
			String str = (String) i.next();
			if (!str.matches("[a-zA-ZÀ-ÿ]+")) {
					i.remove();
				}
        }
        System.out.print("Palavras com mais do que 2 caracteres e que contenham só letras: ");
        System.out.println(words);
    }
}