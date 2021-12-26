package aula07.ex1;

public class Alojamento{
    private final String codigo,nome,local;
    private double preçoPorNoite;
    private boolean disponibilidade=true;
    private double avaliaçao;

    public Alojamento(String codigo, String nome, String local, double preçoPorNoite) {
        this.codigo = codigo;
        this.nome = nome;
        this.local = local;
        this.preçoPorNoite = preçoPorNoite;
    }

    public void CheckIn(){
        this.disponibilidade=false;
    }

    public void CheckOut(){
        this.disponibilidade=true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public double getPreçoPorNoite() {
        return preçoPorNoite;
    }

    public void setPreçoPorNoite(double preçoPorNoite) {
        this.preçoPorNoite = preçoPorNoite;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public double getAvaliaçao() {
        return avaliaçao;
    }

    public void setAvaliaçao(double avaliaçao) {
        if(1.0<=avaliaçao && avaliaçao<=1.5){
            this.avaliaçao = avaliaçao;
        }
        else{
            System.out.println("A avaliação tem que estar entre 1.0 e 5.0)");
        }
        //caso a avaliaçao nao estiver entre 1 e 5 nao realizará nada
    }

    @Override
    public String toString() {
        return "Alojamento [avaliaçao=" + avaliaçao + ", codigo=" + codigo + ", disponibilidade=" + disponibilidade
                + ", local=" + local + ", nome=" + nome + ", preçoPorNoite=" + preçoPorNoite + "]";
    }
}

class Apartamento extends Alojamento{
    private int numeroDeQuartos;

    public Apartamento(String codigo, String nome, String local, double preçoPorNoite, int numeroDeQuartos) {
        super(codigo, nome, local, preçoPorNoite);
        this.numeroDeQuartos = numeroDeQuartos;
    }

    public int getNumeroDeQuartos() {
        return numeroDeQuartos;
    }

    public void setNumeroDeQuartos(int numeroDeQuartos) {
        this.numeroDeQuartos = numeroDeQuartos;
    }

    @Override
    public String toString() {
        return super.toString() + ", Apartamento [numeroDeQuartos=" + numeroDeQuartos + "]";
    }

}


class Quarto extends Alojamento{
    private TipoDequarto tipo;

    public Quarto(String codigo, String nome, String local, double preçoPorNoite, TipoDequarto tipo) {
        super(codigo, nome, local, preçoPorNoite);
        this.tipo = tipo;
    }

    public TipoDequarto getTipo() {
        return tipo;
    }

    public void setTipo(TipoDequarto tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Quarto [tipo=" + tipo + "]";
    }

}
