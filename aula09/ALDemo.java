package aula09;
import aula06.ex1.*;
import java.util.*;

public class ALDemo {

    public static void main(String[] args) {
        ArrayList<Integer> c1 = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10)
            c1.add(i);
        System.out.println("Size: " + c1.size());
        for (int i = 0; i < c1.size(); i++)
            System.out.println("Elemento: " + c1.get(i));

        ArrayList<String> c2 = new ArrayList<>();
        c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva");
        System.out.println(c2);
        Collections.sort(c2);
        System.out.println(c2);
        c2.remove("Frio");
        c2.remove(0);
        System.out.println(c2);

        // a)
        c2.add("Chuva");
        System.out.println(c2);
        System.out.println(c2.contains("Tempestade"));
        System.out.println(c2.indexOf("Chuva"));
        System.out.println(c2.lastIndexOf("Chuva"));
        c2.set(0, "Tempestade");
        System.out.println(c2);
        System.out.println(c2.subList(0, 2));

        // b)
        Set<Pessoa> c3 = new HashSet<>();
        Data data=new Data(5,7,2001);
        Pessoa maria=new Pessoa("Maria", 8, data);
        c3.add(new Pessoa("Eva", 10, new Data(15,12,2001)));
        c3.add(new Pessoa("Ana", 11, new Data(10,10,2000)));
        c3.add(new Pessoa("Rui", 9, new Data(2,2,2002)));
        c3.add(new Pessoa("Rita", 12, new Data(20,1,1999)));
        c3.add(maria);
        c3.add(maria);
        Iterator <Pessoa> pi = c3.iterator();
        while(pi.hasNext()) {
            System.out.println(pi.next());
        }

        //c)
        Set<Data> c4 = new TreeSet<Data>();
        c4.add(data);
        c4.add(new Data(12, 12, 2001));
        c4.add(new Data(6, 10, 2000));
        c4.add(new Data(20, 1, 1999));
        c4.add(new Data(1, 5, 2001));
        Iterator <Data> n = c4.iterator();
        while(n.hasNext()) {
            System.out.println(n.next());
        }
    }
}