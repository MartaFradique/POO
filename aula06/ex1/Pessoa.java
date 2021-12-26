package aula06.ex1;

public class Pessoa {
    private String nome;
    private int cc;
    private Data dataNasc;

    public Pessoa(String nome, int cc, Data dataNasc) {
        this.nome = nome;
        this.cc = cc;
        this.dataNasc = dataNasc;
    }

    String getName() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + ", CC: " + cc + ", Data: " + dataNasc;
    }

    
}
