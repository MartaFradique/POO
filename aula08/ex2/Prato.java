package aula08.ex2;

import java.lang.Comparable;
import java.util.ArrayList;

public class Prato implements Comparable<Prato> {
    private String nome;
    private double totalCalorias=0, totalproteínas=0, pesoTotal=0;
    private DiaSemana DiaDaSemana;
    ArrayList<Alimento> alimentos = new ArrayList<Alimento>();

    public Prato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getTotalCalorias() {
        return totalCalorias;
    }

    public DiaSemana getDiaDaSemana() {
        return DiaDaSemana;
    }

    public void setDiaDaSemana(DiaSemana diaDaSemana) {
        DiaDaSemana = diaDaSemana;
    }

    public int quantidadeIngredientes(){
        return alimentos.size();
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public double getTotalproteínas() {
        return totalproteínas;
    }

    @Override
    public int compareTo(Prato o) {//comparaçao em calorias
        if(totalCalorias>o.totalCalorias){
            return 1;
        }
        else if (totalCalorias<o.totalCalorias){
            return -1;
        }
        return 0;
    }

    public boolean addIngrediente(Alimento aux){
        for(Alimento i:alimentos){
            if(i.equals(aux)){
                return false;
            }
        }

        alimentos.add(aux);
        totalCalorias+=aux.getCalorias();
        totalproteínas+=aux.getProteínas();
        pesoTotal+=aux.getPeso();
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((alimentos == null) ? 0 : alimentos.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        long temp;
        temp = Double.doubleToLongBits(totalCalorias);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Prato other = (Prato) obj;
        if (alimentos == null) {
            if (other.alimentos != null)
                return false;
        } else if (!alimentos.equals(other.alimentos))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (Double.doubleToLongBits(totalCalorias) != Double.doubleToLongBits(other.totalCalorias))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Prato '" + nome + "', composto por " + alimentos.size() + " Ingredientes" ;
    }
}

class PratoDieta extends Prato{
    private double limiteMaximoCalorias;

    public PratoDieta(String nome, double limiteMaximoCalorias) {
        super(nome);
        this.limiteMaximoCalorias = limiteMaximoCalorias;
    }

    public double getLimiteMaximoCalorias() {
        return limiteMaximoCalorias;
    }

    public void setLimiteMaximoCalorias(double limiteMaximoCalorias) {
        this.limiteMaximoCalorias = limiteMaximoCalorias;
    }

    public boolean addIngrediente(Alimento aux){
        if(this.getTotalCalorias()+aux.getCalorias()>limiteMaximoCalorias){
            return false;
        }
        return super.addIngrediente(aux);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(limiteMaximoCalorias);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PratoDieta other = (PratoDieta) obj;
        if (Double.doubleToLongBits(limiteMaximoCalorias) != Double.doubleToLongBits(other.limiteMaximoCalorias))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " - Dieta (" + limiteMaximoCalorias + " Calorias)  " ;
    }
}

class PratoVegetariano extends Prato{

    public PratoVegetariano(String nome) {
        super(nome);
    }
    
    public boolean addIngrediente(Alimento aux){
        if(aux instanceof Vegetariano){
            return super.addIngrediente(aux);
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " - Prato Vegetariano" ;
    }
}