package aula12;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex2 {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Movie> movies_selection = new ArrayList<>();
        Set<String> genres = new HashSet<>();

        try (Scanner input = new Scanner(new FileReader("movies.txt"))) {

            // guardar os movies do ficheiro movies.txt no ArrayList movies
            input.nextLine();// ler a primeira linha que n contem informaçao dos movies
            while (input.hasNextLine()) {
                String[] linha = input.nextLine().split("\\t");// cortar linhas com as tabs
                // adicionar movie no ArrayList de movies
                movies.add(new Movie(linha[0], Double.parseDouble(linha[1]), linha[2], linha[3],
                        Integer.parseInt(linha[4])));
            }
            input.close();
        } catch (Exception e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }

        //b)
        movies.sort((x, y) -> Movie.compareName(x, y));
        movies.forEach(System.out::println);
        System.out.println();

        //c)
        movies.sort((x, y) -> {
            if (x.getScore() > y.getScore())
                return -1;
            else if (x.getScore() < y.getScore())
                return 1;
            else
                return 0;
        });
        movies.forEach(System.out::println);
        System.out.println();

        movies.sort((x, y) -> {
            if (x.getRunningTime() > y.getRunningTime())
                return 1;
            else if (x.getRunningTime() < y.getRunningTime())
                return -1;
            else
                return 0;
        });
        movies.forEach(System.out::println);
        System.out.println();

        //d)
        movies.forEach( movie -> genres.add(movie.getGenre()) );
        genres.forEach(System.out::println);

        //e)
        movies.forEach(movie -> {
            if(movie.getScore()>60 && movie.getGenre().equals("comedy"))
                movies_selection.add(movie);                
        });

        try (PrintWriter out = new PrintWriter(new File("myselection.txt"))) {
            movies_selection.forEach(out::println);
            out.close();
        } catch (Exception e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }
    }
}