package aula11;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Ex2 {
    public static void main(String[] args) throws IOException {
        ArrayList<Voo> voos = new ArrayList<>();
        HashMap<String, String> companhias = new HashMap<>();

        try (Scanner input = new Scanner(new FileReader("voos.txt"))) {

            // guardar os voos do ficheiro voos.txt no ArrayList voos
            input.nextLine();// ler a primeira linha que n contem informaçao dos voos
            while (input.hasNextLine()) {
                String[] linha = input.nextLine().split("\\t");// cortar linhas com as tabs

                if (linha.length == 4) {
                    Voo viagem = new Voo(new Hora(linha[0]), linha[1], linha[2], new Hora(linha[3]));
                    voos.add(viagem);// adicionar voo no ArrayList de voos
                } else {
                    Voo viagem = new Voo(new Hora(linha[0]), linha[1], linha[2]);
                    voos.add(viagem);// adicionar voo no ArrayList de voos
                }
            }

            input.close();
        } catch (Exception e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }

        try (Scanner input = new Scanner(new FileReader("companhias.txt"))) {
            // guardar os voos do ficheiro companhias.txt no HashMap companhias
            input.nextLine();// ler a primeira linha que n contem informaçao das companhias
            while (input.hasNextLine()) {
                String[] linha = input.nextLine().split("\\t");// cortar linhas com as tabs
                companhias.put(linha[0], linha[1]);
            }

            input.close();
        } catch (Exception e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }

        // a) e b)
        try (PrintWriter out = new PrintWriter(new File("Infopublico.txt"))) {
            System.out.printf("%-7s%-10s%-20s%-23s%-8s%-8s%n", "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");
            out.printf("%-7s%-10s%-20s%-23s%-8s%-8s%n", "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");

            for (Voo voo : voos) {
                if (voo.getAtraso() == null) {
                    System.out.printf("%-7s%-10s%-20s%-23s%n", voo.getHora(), voo.getVoo(),
                            companhias.get(voo.getVoo().substring(0, 2)), voo.getOrigem());
                    out.printf("%-7s%-10s%-20s%-23s%n", voo.getHora(), voo.getVoo(),
                            companhias.get(voo.getVoo().substring(0, 2)), voo.getOrigem());
                } else {
                    System.out.printf("%-7s%-10s%-20s%-23s%-8s%-8s%5s%n", voo.getHora(), voo.getVoo(),
                            companhias.get(voo.getVoo().substring(0, 2)), voo.getOrigem(), voo.getAtraso(),
                            "Previsto: ", voo.getHora().somarHora(voo.getAtraso()));
                    out.printf("%-7s%-10s%-20s%-23s%-8s%-8s%5s%n", voo.getHora(), voo.getVoo(),
                            companhias.get(voo.getVoo().substring(0, 2)), voo.getOrigem(), voo.getAtraso(),
                            "Previsto: ", voo.getHora().somarHora(voo.getAtraso()));
                }

            }

            out.close();

        } catch (Exception e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }

        System.out.println();
        // c)
        Map<String, String> atrasoMedio_companhia = new TreeMap<>();// key:atraso médio; value:companhia
        Map<String, ArrayList<Hora>> companhia_arrayAtrasos = new HashMap<>();// key:companhia; value:array de atrasos

        for (Voo voo : voos) {//criar companhia_arrayAtrasos
            String companhia = companhias.get(voo.getVoo().substring(0, 2));
            if (voo.getAtraso() != null) {
                if (companhia_arrayAtrasos.containsKey(companhia)) {
                    companhia_arrayAtrasos.get(companhia).add(voo.getAtraso());
                } else {
                    ArrayList<Hora> array = new ArrayList<>();
                    array.add(voo.getAtraso());
                    companhia_arrayAtrasos.put(companhia, array);
                }
            }
        }

        for(String companhia:companhia_arrayAtrasos.keySet()){//criar atrasoMedio_companhia
            atrasoMedio_companhia.put( mediaHora(companhia_arrayAtrasos.get(companhia)) , companhia);
        }

        /*
        Set<Entry<String, ArrayList<Hora>>> set = companhia_arrayAtrasos.entrySet();//criar atrasoMedio_companhia
        for (Entry<String, ArrayList<Hora>> companhia : set) {
            atrasoMedio_companhia.put(mediaHora(companhia.getValue()), companhia.getKey());
        }          */

        for(String atrasoMedio:atrasoMedio_companhia.keySet()){
            System.out.printf("%-20s%-5s%n", atrasoMedio_companhia.get(atrasoMedio), atrasoMedio);
        }

        /*
        Set<Entry<String, String>> set0 = atrasoMedio_companhia.entrySet();
        for (Entry<String, String> companhia : set0) {
            System.out.printf("%-20s%-5s%n", companhia.getValue(), companhia.getKey());
        }    */

        System.out.println();
        // d)
        TreeMap<String, Integer> companhia_Nvoos = new TreeMap<>();// key:companhia; value:numero de voos
        TreeMap<Integer, ArrayList<String>> nVoos_arrayCompanhias = new TreeMap<>(); // key:simétrico do numero de voos; value:array de voos

        for (Voo voo : voos) { // criar companhia_Nvoos
            String origem = voo.getOrigem();
            if (companhia_Nvoos.containsKey(origem)) {
                int numeroVoos = companhia_Nvoos.get(origem) + 1;
                companhia_Nvoos.put(origem, numeroVoos);
            } else {
                companhia_Nvoos.put(origem, 1);
            }
        }

        // O treeMap ordenena por ordem crescente a chave,mas nós queremos por ordem decrescente,
        // então sabendo que os numeros das chaves sao sempre positivos multiplicamos por -1,
        // assim serão apresentadas as companhias por ordem cresecente do simétrico do numero de voos (chave)
        //corresnpondendo assim á ordem decrescente do numero de voos

        for(String companhia : companhia_Nvoos.keySet()){
            if (nVoos_arrayCompanhias.containsKey( (-1) * companhia_Nvoos.get(companhia) ) ) {
                nVoos_arrayCompanhias.get((-1) *companhia_Nvoos.get(companhia)).add(companhia);
            } else {
                ArrayList<String> array = new ArrayList<>();
                array.add(companhia);
                nVoos_arrayCompanhias.put(companhia_Nvoos.get(companhia) * (-1), array);
            }
        }

        /*Set<Entry<String, Integer>> set1 = companhia_Nvoos.entrySet();//criar nVoos_arrayCompanhias
        for (Entry<String, Integer> companhia : set1) {
            if (nVoos_arrayCompanhias.containsKey((-1) * companhia.getValue())) {
                nVoos_arrayCompanhias.get((-1) * companhia.getValue()).add(companhia.getKey());
            } else {
                ArrayList<String> array = new ArrayList<>();
                array.add(companhia.getKey());
                nVoos_arrayCompanhias.put(companhia.getValue() * (-1), array);
            }
        }*/

        try (PrintWriter out = new PrintWriter(new File("cidades.txt"))) {

            Set<Entry<Integer, ArrayList<String>>> set2 = nVoos_arrayCompanhias.entrySet();
            for (Entry<Integer, ArrayList<String>> companhia : set2) {
                for (String i : companhia.getValue()) {
                    out.printf("%-25s%-5d%n", i, (-1) * companhia.getKey());
                    //multiplicar por -1 a chave, pois a chave é o simétrico do numero de voos
                }
            }

            out.close();
        } catch (Exception e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }
    }

    //funçao mediaHora devolve a string da hora média de um determinado array de horas
    public static String mediaHora(ArrayList<Hora> horas) {
        // Representar a soma só em minutos de modo a facilitar o calculo da média
        int somaEmMinutos = 0;
        for (Hora hora : horas) {
            somaEmMinutos += hora.getHora() * 60 + hora.getMin();
        }

        int mediaEmMinutos = somaEmMinutos / horas.size();
        int horaMedia = 0;
        if (mediaEmMinutos > 59) {
            int horasAdicionaisDosMin = mediaEmMinutos / 60;
            mediaEmMinutos -= 60 * horasAdicionaisDosMin;
            horaMedia += horasAdicionaisDosMin;
        }
        if (horaMedia > 23) {
            horaMedia -= 24;
        }
        return String.format("%02d:%02d", horaMedia, mediaEmMinutos);
    }
}