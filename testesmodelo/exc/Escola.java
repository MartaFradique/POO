package testesmodelo.exc;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Escola {
    private String nome, endereco;
    private HashSet<Teste> testes = new HashSet<>();

    public Escola(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public HashSet<Teste> getTestes() {
        return testes;
    }

    public void add(Teste teste) {
        testes.add(teste);
    }

    public Set<Teste> provasComPrazo_ordenadas(){
        Set<Teste> provasOrdenadas =new TreeSet<>( (x,y) -> x.getDisciplina().compareToIgnoreCase( y.getDisciplina() ) );

        testes.forEach(teste -> {
            if(teste instanceof ProvasComPrazo)
                provasOrdenadas.add(teste);
        });
        
        return provasOrdenadas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((testes == null) ? 0 : testes.hashCode());
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
        Escola other = (Escola) obj;
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
        if (testes == null) {
            if (other.testes != null)
                return false;
        } else if (!testes.equals(other.testes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String string ="";
        for(Teste teste:testes){
            string+=teste.toString() + "\n";
        }
        return string.substring(0,string.length()-1);
    }
    
}