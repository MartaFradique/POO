package aula08.ex2;

public class Alimento {
    private double proteínas,calorias,peso;

    public Alimento(double proteínas, double calorias, double peso) {
        this.proteínas = proteínas;
        this.calorias = calorias;
        this.peso = peso;
    }

    public double getProteínas() {
        return proteínas;
    }

    public void setProteínas(double proteínas) {
        this.proteínas = proteínas;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(calorias);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(peso);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(proteínas);
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
        Alimento other = (Alimento) obj;
        if (Double.doubleToLongBits(calorias) != Double.doubleToLongBits(other.calorias))
            return false;
        if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
            return false;
        if (Double.doubleToLongBits(proteínas) != Double.doubleToLongBits(other.proteínas))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Proteínas " + proteínas + ", calorias " + calorias + ", Peso " + peso;
    }
}

class Carne extends Alimento{
    private VariedadeCarne variedade;

	public Carne(VariedadeCarne variedade, double proteínas,double calorias, double peso) {
		super(proteínas, calorias, peso);
		this.variedade = variedade;
	}

    public VariedadeCarne getVariedade() {
        return variedade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((variedade == null) ? 0 : variedade.hashCode());
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
        Carne other = (Carne) obj;
        if (variedade != other.variedade)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Carne " + variedade + ", " + super.toString();
    }
}

class Peixe extends Alimento{
    private TipoPeixe tipo;

    public Peixe(TipoPeixe tipo, double proteínas,double calorias, double peso) {
        super(proteínas, calorias, peso);
        this.tipo = tipo;
    }

    public TipoPeixe getTipo() {
        return tipo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
        Peixe other = (Peixe) obj;
        if (tipo != other.tipo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Peixe " + tipo + ", " + super.toString();
    }
}

class Cereal extends Alimento implements Vegetariano{
    private String nome;

    public Cereal(String nome, double proteínas,double calorias, double peso) {
        super(proteínas, calorias, peso);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        Cereal other = (Cereal) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cereal " + nome + ", " + super.toString();
    }
}

class Legume extends Alimento implements Vegetariano{
    private String nome;

    public Legume(String nome, double proteínas,double calorias, double peso) {
        super(proteínas, calorias, peso);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        Legume other = (Legume) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Legume " + nome + ", " + super.toString();
    }
}