package testesmodelo;

import java.util.Arrays;
import java.util.TreeSet;

public class Cruzeiro {
    private String nome, data;
    private String[] lstCidades;
    private int duracao;
    private TreeSet<Cabine> cabines = new TreeSet<Cabine>();

    public Cruzeiro(String nome, String[] lstCidades, String data) {
        this.nome = nome;
        this.data = data;
        this.lstCidades = lstCidades;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLstCidades() {
        return Arrays.toString(lstCidades);
    }

    public void setLstCidades(String[] lstCidades) {
        this.lstCidades = lstCidades;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public TreeSet<Cabine> getCabines() {
        return cabines;
    }

    public void add(Cabine cabine) {
        cabines.add(cabine);
    }

    public double percentagemDeCabinesDisponiveis(){
        double numCabinesDisponiveis=0;
        for(Cabine cabine:cabines){
            if(cabine.getOcupantes() == null )
                numCabinesDisponiveis++;
        }

        return numCabinesDisponiveis * 100 / cabines.size();
    }

    public double mediaDePessoasPorQuarto_SuitesOcupadas(){
        double nOcupantesSuite = 0,nSuites = 0;
        for(Cabine cabine:cabines){
            if(cabine.getOcupantes() != null && cabine instanceof Suite ){
                Suite suite =(Suite) cabine;
                nOcupantesSuite += cabine.getOcupantes().length;
                nSuites += suite.getNumQuartos();
            }
        }
        
        return nOcupantesSuite/nSuites;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cabines == null) ? 0 : cabines.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + duracao;
        result = prime * result + Arrays.hashCode(lstCidades);
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        Cruzeiro other = (Cruzeiro) obj;
        if (cabines == null) {
            if (other.cabines != null)
                return false;
        } else if (!cabines.equals(other.cabines))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (duracao != other.duracao)
            return false;
        if (!Arrays.equals(lstCidades, other.lstCidades))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String string = "Navio " + nome + ", partida em "+ data + "\nItinerário: " + Arrays.toString(lstCidades) +"\n";
        for(Cabine cabine:cabines){
            string+=cabine.toString() + "\n";
        }
        return string;
    }
}