package aula07.ex2;

public class Equipa{
    private String nome;
    private String nomeResponsavel;
    private int golosMarcados=0;
    private int golosSofridos=0;
    private Robo[] robos;

    public Equipa(String nome, String nomeResponsavel, Robo[] robos) {
        this.nome = nome;
        this.nomeResponsavel = nomeResponsavel;
        this.robos = robos;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public int getGolosMarcados() {
        return golosMarcados;
    }

    public int getGolosSofridos() {
        return golosSofridos;
    }

    public String getRobos() {
        String string="";
        for(Robo robo:robos){
            string+=robo+"; ";
        }
        return string;
    }

    public void marcouGolo(){
        golosMarcados++;
    }

    public void sofreuGolo(){
        golosSofridos++;
    }

    @Override
    public String toString() {
        return "Equipa [golosMarcados=" + golosMarcados + ", golosSofridos=" + golosSofridos + ", nome=" + nome
                + ", nomeResponsavel=" + nomeResponsavel + ", robos=" + this.getRobos() + "]";
    }
}