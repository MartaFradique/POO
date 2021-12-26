package testesmodelo.exc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class POO15Ap {
    public static void main(String[] args) {
        POO15Ap ap = new POO15Ap();
        ap.alinea2(ap.alinea1());
        ap.alinea3();
    }

    public Escola alinea1() {
        System.out.println("\nA1)");
        Escola ih = new Escola("International House Aveiro", "Rua Domingos Carrancho, 1, 3800-145 Aveiro");
        ExameEscrito e1 = new ExameEscrito("Inglês para Empresas", "Anthony Laurel", "12.06.2015 15h", "15; 22", 4); // 4 versões
        e1.setConsulta(true);
        e1.setPrazo(6);
        ih.add(e1);
        ih.add(new ExameEscrito("Alemão", "Manfred Glesner", "12.06.2015 10h", "13"));
        TesteComputador t1 = new TesteComputador("Italiano Intermédio", "Luca Benini", "01.06.2015 10h", "25");
        t1.setLink("http://www.ihaveiro.com/outras-linguas/tii");
        ih.add(t1);
        ih.add(new ProvaOral("Inglês Avançado", "Anthony Laurel", "05.06.2015 10h", "3", Lingua.UK));
        System.out.println(ih); // imprime todas as provas da escola

        try {
            PrintWriter fl = new PrintWriter(new File("output2.txt"));
            fl.println(ih);
            fl.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ih;
    }

    public void alinea2(Escola escola){
        System.out.println("\nA2)");
        escola.provasComPrazo_ordenadas().forEach(System.out::println);
    }

    public void alinea3(){
        System.out.println("\nA3)");

        Map<String,HashSet<Teste>> mapa = new HashMap<>();
        try (Scanner input=new Scanner(new File("samples_s2.txt"))){
            input.nextLine();

            while(input.hasNextLine()){
                String[] linha=input.nextLine().split("\\t");

                if(!mapa.containsKey(linha[2]))
                    mapa.put(linha[2], new HashSet<Teste>());
                HashSet<Teste> set = mapa.get(linha[2]);

                if(linha[0].equals("1"))
                    set.add(new ExameEscrito(linha[1], linha[2], linha[3], linha[4]));
                else if(linha[0].equals("2"))
                    set.add(new ProvaOral(linha[1], linha[2], linha[3], linha[4]));
                else
                    set.add(new TesteComputador(linha[1], linha[2], linha[3], linha[4]));

                mapa.put(linha[2], set);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        mapa.keySet().forEach(prof -> {
            System.out.println(prof + " : " +mapa.get(prof).size());
        });
    }
}