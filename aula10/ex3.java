package aula10;
import java.util.*;

public class ex3 {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> mapa = new TreeMap<>();
        String string ="Hello World";

        for(int i=0 ; i < string.length() ; i++){
            String letra=string.substring(i, i+1);
            if(mapa.containsKey(letra)){
                mapa.get(letra).add(i);
            }
            else{
                ArrayList<Integer> array = new ArrayList<>();
                array.add(i);
                mapa.put(letra,array);
            }
        }

        System.out.println(mapa);
    }
}