package testesmodelo.exb;

import java.util.Comparator;
import java.util.TreeSet;

public class Biblioteca {
    Comparator<Publicacao> ordenarPublicacoes = new Comparator<Publicacao>() {
        public int compare(Publicacao x, Publicacao y){
            return x.getTitulo().compareToIgnoreCase(y.getTitulo());
        }
    };
    
    private String nome,endereco;
    private TreeSet<Publicacao> publicacoes = new TreeSet<Publicacao>(ordenarPublicacoes);//(x,y) -> x.getTitulo().compareToIgnoreCase(y.getTitulo())

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public TreeSet<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void add(Publicacao publicacao ){
        publicacoes.add(publicacao);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((ordenarPublicacoes == null) ? 0 : ordenarPublicacoes.hashCode());
        result = prime * result + ((publicacoes == null) ? 0 : publicacoes.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Biblioteca other = (Biblioteca) obj;
        if (endereco == null) {
            if (other.endereco != null)
                return false;
        } else if (!endereco.equals(other.endereco))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (ordenarPublicacoes == null) {
            if (other.ordenarPublicacoes != null)
                return false;
        } else if (!ordenarPublicacoes.equals(other.ordenarPublicacoes))
            return false;
        if (publicacoes == null) {
            if (other.publicacoes != null)
                return false;
        } else if (!publicacoes.equals(other.publicacoes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String string ="";
        for(Publicacao publicacao:publicacoes){
            string+=publicacao.toString() + "\n";
        }
        return string.substring(0,string.length()-1);
    }
}