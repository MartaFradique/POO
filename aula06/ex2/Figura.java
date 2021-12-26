package aula06.ex2;

public class Figura{
    private String cor;

    public Figura(String cor) {
        this.cor=cor;
    }

    @Override
    public String toString() {
        return "cor=" + cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    
}