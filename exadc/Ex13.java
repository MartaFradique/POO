package exadc;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex13 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Map<Integer, ArrayList<Student>> notasFinais = new TreeMap<>();// key:nota final ,valor:array de pessoas com essa nota final 

        try (Scanner input = new Scanner(new File("notas.txt"))) {

            while (input.hasNextLine()) {
                String linha = input.nextLine();

                if (!linha.startsWith("*")) {
                    String[] line = linha.split("\\t");
                    if(line.length==5)
                        students.add( new Student( Integer.parseInt(line[0]) , line[1] , Double.parseDouble(line[2]) , Double.parseDouble(line[3]) , Double.parseDouble(line[4]) ) );
                }
            }

            input.close();
        } catch (Exception e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }

        students.forEach(student -> {
            // se chave não existe no map, criar
            if (notasFinais.get(student.notaFinal()) == null) {
                notasFinais.put(student.notaFinal(), new ArrayList<>());
            }
            // adicionar valor no array 
            ArrayList<Student> array = notasFinais.get(student.notaFinal());
            array.add(student);
            notasFinais.put(student.notaFinal(), array);
        });

        try (PrintWriter out = new PrintWriter(new File("Results.txt"))) {
            double media=0;
            for(int i =0; i<=20 ; i++){
                if(notasFinais.get(i)!=null){
                    out.printf("%3d%2s%2d%n",i,":", notasFinais.get(i).size() );
                    media+= (i* notasFinais.get(i).size() );
                }
                else{
                    out.printf("%3d%2s%2d%n",i,":", 0 );
                }
            }

            out.printf("%9s%2.2f","Média final :", media/students.size());

        } catch (Exception e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }
    }
}