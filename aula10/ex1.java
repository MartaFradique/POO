package aula10;

import java.util.*;

public class ex1 {
    public static void main(String[] args) {
        Map<String, String> mapa = new HashMap<>();
        
        //adicionar
        mapa.put("branco" , "Que tem a cor da neve.");
        mapa.put("amarelo","Que tem a cor do sol.");
        mapa.put("azul","Que tem a cor do céu");
        mapa.put("vermelho", "Que tem a cor do sangue");
        mapa.put("verde","Que tem a cor da relva");

        System.out.println(mapa);
        
        //remover
        mapa.remove("azul");
        System.out.print("Depois de remover o conjunto com a chave azul: ");
        System.out.println(mapa);

        //alínea b
        
        System.out.print("HashMap:");
		System.out.println(mapa);
		System.out.print("Lista de keys:");
		System.out.println(mapa.keySet());
		System.out.print("Lista de valores:");
        System.out.println(mapa.values());
    }
}