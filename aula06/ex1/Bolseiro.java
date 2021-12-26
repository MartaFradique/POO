package aula06.ex1;

public class Bolseiro extends Aluno{
    private int bolsa=0;

    public Bolseiro(String iNome, int iBI, Data iDataNasc){
        super(iNome, iBI, iDataNasc);
    }

    int getBolsa(){
        return bolsa;
    }

    public void setBolsa(int bolsa) {
        this.bolsa = bolsa;
    }

    @Override
    public String toString() {
        return super.toString() + ", bolsa=" + bolsa ;
    }

    
}