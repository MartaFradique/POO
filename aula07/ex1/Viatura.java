package aula07.ex1;

public class Viatura{
    private Char classe;
    private TipoDeCombustivel combustivel;
    private boolean disponibilidade=true;

    public Viatura(Char classe, TipoDeCombustivel combustivel) {
        this.classe = classe;
        this.combustivel = combustivel;
    }

    public Char getClasse() {
        return classe;
    }

    public void setClasse(Char classe) {
        this.classe = classe;
    }

    public TipoDeCombustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(TipoDeCombustivel combustivel) {
        this.combustivel = combustivel;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    @Override
    public String toString() {
        return "Viatura [classe=" + classe + ", combustivel=" + combustivel + "]";
    }

    public void levantar(){
        this.disponibilidade=false;
    }

    public void entregar(){
        this.disponibilidade=true;
    }
    
}