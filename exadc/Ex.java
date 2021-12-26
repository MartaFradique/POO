package exadc;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex {
    public static void main(String[] args) {
        Map<String, ArrayList<Double>> localidades = new TreeMap<>();// key:localidade,valor:array de valores
        Double media = 0.0;
        int count = 0;

        try (Scanner input = new Scanner(new FileReader("qdv.txt"))) {

            while (input.hasNextLine()) {
                String linha = input.nextLine();

                if (!linha.startsWith("#")) {
                    String[] line = linha.split("\\t");
                    String valor = line[1].replaceAll(",", ".");
                    media += Double.parseDouble(valor);
                    count++;

                    // se chave não existe no map, criar
                    if (localidades.get(line[0]) == null) {
                        localidades.put(line[0], new ArrayList<>());
                    }
                    // adicionar valor no array de valores
                    ArrayList<Double> valores = localidades.get(line[0]);
                    valores.add(Double.parseDouble(valor));
                    localidades.put(line[0], valores);
                }
            }

            input.close();
        } catch (Exception e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }

        System.out.println("1) Média dos valores da segunda coluna: " + media/count);

        System.out.print("2) Localidades presentes na primeira coluna: ");
        for (String key : localidades.keySet()) {
            System.out.print(key + "; ");
        }
        System.out.println();

        for (String key : localidades.keySet()) {
            double med = 0.0;
            for (Double valor : localidades.get(key)) {
                med += valor;
            }
            System.out.println(key + " : " + localidades.get(key).size() + " : " + med / localidades.get(key).size());
        }
    }
}