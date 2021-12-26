package aula11;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ex1 {
    public static void main(String[] args) throws IOException {
        try (Scanner input = new Scanner(new FileReader("major.txt"))) {
            String anterior = null;
            input.useDelimiter("[\\\t\n\r .,:'‘’;?!-*{}=+&/()\\[\\]”“\"\']+");
            Map<String, Map<String, Integer>> words = new TreeMap<>();

            while (input.hasNext()) {
                String word = input.next().toLowerCase();
                if (word.length() >= 3) {
                    // se chave não existe no map, criar
                    if (words.get(word) == null) {
                        words.put(word, new TreeMap<String, Integer>());
                    }
                    // palavra no dicionário, adicionar par (se existir)
                    if (anterior != null) {
                        Map<String, Integer> valor = words.get(anterior);
                        if (words.get(anterior).get(word) == null) {
                            // chave não existe no map, criar
                            valor.put(word, 1);
                        } else {
                            // chave existe, incrementar
                            int valorAnterior = Integer.parseInt(valor.get(word).toString());
                            valor.put(anterior, valorAnterior + 1);
                        }
                        words.put(anterior, valor);
                    }
                    anterior = word;
                }
            }

            for (String s : words.keySet()) {
                System.out.println(s + "=" + words.get(s));
            }

            input.close();
        } catch (IOException e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }

    }
}
