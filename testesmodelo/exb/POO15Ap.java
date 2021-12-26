package testesmodelo.exb;

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
        ap.alinea1(); 
        // ap.alinea2(); 
        ap.alinea3(); 
    }

    public void alinea1() {
        Biblioteca bAveiro = new Biblioteca("Biblioteca Municipal de Aveiro",  "Largo Dr. Jaime Magalhães Lima, 3800 - 156 Aveiro, Portugal"); 
        bAveiro.add(new Livro("História da Europa", "Lisboa: Dom Quixote",   "Jean-Baptiste Duroselle", "972-20-0824-2"));
        bAveiro.add(new Livro("Papillon", "Amadora: Bertrand", "Henri Charrière"));
        bAveiro.add(new Livro("Branca de neve e os sete anões", "Abril Morumbi",  "Jacob Grimm; Wilhelm Grimm"));
        bAveiro.add(new Revista("Revista municipal", "Aveiro: C.M.A.", "0874-727X"));
        bAveiro.add(new Jornal("Diário de notícias", Ver.CORES)); 
        Jornal gaf = new Jornal ("O gafanhoto"); 
        gaf.setPeriodicidade(Period.BIMESTRAL);
        bAveiro.add(gaf); 

        System.out.println(bAveiro); // imprime todas as publicações da biblioteca    
        try {
            PrintWriter fl = new PrintWriter(new File("output.txt"));
            fl.println(bAveiro); fl.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } 
    } 

    public void alinea3(){
        Map<String,HashSet<Publicacao>> map =new HashMap<>();

        try (Scanner input =new Scanner(new File("samples.txt"))){
            input.nextLine();

            while(input.hasNextLine()){
                String[] linha = input.nextLine().split("\\t");

                if(!map.containsKey(linha[2]))
                    map.put(linha[2], new HashSet<Publicacao>());

                HashSet<Publicacao> set =map.get(linha[2]);

                if(linha[0].equals("1")){
                    if(linha.length==4)
                        set.add(new Livro(linha[1], linha[2], linha[3]));
                    else
                        set.add(new Livro(linha[1], linha[2], linha[3], linha[4]));
                }
                else{
                    set.add(new Revista(linha[1], linha[2]));
                }

                map.put(linha[2], set);
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        
        map.keySet().forEach(editora -> {
            System.out.println(editora +" -> " + map.get(editora).size());
        });
    }
}