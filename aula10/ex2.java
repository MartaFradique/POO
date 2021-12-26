package aula10;
import java.util.*;

public class ex2 {
    public static void main(String[] args) {
        TreeMap<String, ArrayList<String>> mapa = new TreeMap<>();
        
         //alinea a 
         ArrayList<String> array1 = new ArrayList<>();
         array1.add("Que tem a cor da neve.");
         array1.add("Descorado, pálido.");
         array1.add("Cor de leite");
         ArrayList<String> array2 = new ArrayList<>();
         array2.add("Que tem a cor do sol.");
         array2.add("Baunilha");
         ArrayList<String> array3 = new ArrayList<>();
         array3.add("Que tem a cor do céu");
         array3.add("Cor do oceano");
         ArrayList<String> array4 = new ArrayList<>();
         array4.add("Que tem a cor do sangue");
         array4.add("Cor da língua");
         ArrayList<String> array5 = new ArrayList<>();
         array5.add("Que tem a cor da relva");
         array5.add("Cor das folhas");

         mapa.put("branco",array1);
         mapa.put("amarelo",array2);
         mapa.put("azul",array3);
         mapa.put("vermelho", array4);
         mapa.put("verde",array5);
         System.out.println(mapa);
         System.out.println();
         
         mapa.remove("azul");
         System.out.print("Depois de remover o conjunto com a chave azul: ");
         System.out.println(mapa);
         System.out.println();
         
         System.out.print("HashMap:");
         System.out.println(mapa);
         System.out.println();
         System.out.print("Lista de keys:");
         System.out.println(mapa.keySet());
         System.out.println();
         System.out.print("Lista de valores:");
         System.out.println(mapa.values());
         System.out.println();

         //alinea b
         System.out.print("Método significado, no termo com chave branco: ");
         System.out.println(significado(mapa, "branco"));
    }

    public static String significado(TreeMap<String, ArrayList<String>> t,String key){
        ArrayList<String> array = t.get(key);
        return array.get((int)(Math.random()*(t.size()-1)));
    }
}