package aula12;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex1 {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        int total=0;

        try (Scanner input = new Scanner(new FileReader("words.txt"))) {
            input.useDelimiter("[\\\t\n\r .,:'‘’;?!-*{}=+&/()\\[\\]”“\"\']+");

            while (input.hasNext()) {
                String word = input.next();
                total++;
                words.add(word);
            }

            System.out.println("Número Total de Palavras: " + total);
            System.out.println("Número de Diferentes Palavras: " + words.size());

            input.close();
        } catch (IOException e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }
    }
}