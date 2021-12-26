package testesmodelo;

import java.lang.Comparable;
import java.util.Arrays;

public class Cabine implements Comparable<Cabine> {
    private int numero, capMax;
    private String[] ocupantes;

    public Cabine(int numero, int capMax, String[] ocupantes) {
        this.numero = numero;
        this.capMax = capMax;
        setPassageiros(ocupantes);
    }

    public Cabine(int numero, int capMax) {
        this.numero = numero;
        this.capMax = capMax;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapMax() {
        return capMax;
    }

    public void setMaxOcupantes(int capMax) {
        this.capMax = capMax;
    }

    public String[] getOcupantes() {
        return ocupantes;
    }

    public void setPassageiros(String[] ocupantes) {
        if (ocupantes.length > capMax)
                throw new IllegalArgumentException();
        else
            this.ocupantes = ocupantes;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + capMax;
        result = prime * result + numero;
        result = prime * result + Arrays.hashCode(ocupantes);
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
        Cabine other = (Cabine) obj;
        if (capMax != other.capMax)
            return false;
        if (numero != other.numero)
            return false;
        if (!Arrays.equals(ocupantes, other.ocupantes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String string ="Nº" + numero + "(max "+ capMax +" pessoas ) : ";
        if(ocupantes==null)
            string+= "Disponível para venda!";
        else
            string+=Arrays.toString(ocupantes);
        return string;
    }

    @Override
    public int compareTo(Cabine o) {
        if(numero < o.getNumero())
            return -1;
        else if(numero > o.getNumero())
            return 1;
        else
            return 0;
    }
}

class CabineComJanela extends Cabine implements InterfaceExtras{
    private TipoDeJanela tipoJanela;
    private Extra pacote;

    public CabineComJanela(int numero, int capMax, TipoDeJanela tipoJanela, String[] ocupantes) {
        super(numero, capMax, ocupantes);
        this.tipoJanela = tipoJanela;
    }

    public CabineComJanela(int numero, int capMax, TipoDeJanela tipoJanela) {
        super(numero, capMax);
        this.tipoJanela = tipoJanela;
    }

    public TipoDeJanela getTipoJanela() {
        return tipoJanela;
    }

    public void setTipoJanela(TipoDeJanela tipoJanela) {
        this.tipoJanela = tipoJanela;
    }

    @Override
    public Extra getPacote() {
        return pacote;
    }

    @Override
    public void pacoteExtra(Extra pacote){
        this.pacote=pacote;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((tipoJanela == null) ? 0 : tipoJanela.hashCode());
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
        CabineComJanela other = (CabineComJanela) obj;
        if (tipoJanela != other.tipoJanela)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cabine com Janela " + tipoJanela + "[" + super.toString() + "]";
    }
}

class CabineComVaranda extends Cabine implements InterfaceExtras{
    private TipoDeVaranda tipoVaranda;
    private Extra pacote;

    public CabineComVaranda(int numero, int capMax, TipoDeVaranda tipoVaranda, String[] ocupantes) {
        super(numero, capMax, ocupantes);
        this.tipoVaranda = tipoVaranda;
    }

    public CabineComVaranda(int numero, int capMax, TipoDeVaranda tipoVaranda) {
        super(numero, capMax);
        this.tipoVaranda = tipoVaranda;
    }

    public TipoDeVaranda getTipoVaranda() {
        return tipoVaranda;
    }

    public void setTipoDeVaranda(TipoDeVaranda tipoVaranda) {
        this.tipoVaranda = tipoVaranda;
    }

    @Override
    public Extra getPacote() {
        return pacote;
    }

    @Override
    public void pacoteExtra(Extra pacote){
        this.pacote=pacote;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((tipoVaranda == null) ? 0 : tipoVaranda.hashCode());
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
        CabineComVaranda other = (CabineComVaranda) obj;
        if (tipoVaranda != other.tipoVaranda)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cabine com Varanda " + tipoVaranda + "[" + super.toString() + "]";
    }
}

class Suite extends Cabine{
    private int NumQuartos;

    public Suite(int numero, int capMax) {
        super(numero, capMax);
    }

    public int getNumQuartos() {
        return NumQuartos;
    }

    public void setNumQuartos(int numQuartos) {
        NumQuartos = numQuartos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + NumQuartos;
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
        Suite other = (Suite) obj;
        if (NumQuartos != other.NumQuartos)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Suite c/"+ NumQuartos + " quartos [" + super.toString() + "]";
    }
    
    
}