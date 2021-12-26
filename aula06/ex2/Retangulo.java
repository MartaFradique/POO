package aula06.ex2;

public class Retangulo extends Figura {
    private double comprimento;
    private double altura;

    public Retangulo(double comprimento, double altura, String cor) {
        super(cor);
		this.comprimento = comprimento;
        this.altura = altura;
    }

    double getComprimento() {
        return comprimento;
    }

    double getAltura() {
        return altura;
    }

    void setAltura(double altura) {
        this.altura = altura;
    }

    void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
    
    public double area(){
        return this.getAltura()*this.getComprimento();
    }

    public double perimetro(){
        return ( 2*this.getAltura() ) + ( 2*this.getComprimento()) ;
    }
    
    @Override
    public String toString(){
        return "Retangulo: comprimento=" + comprimento + "; altura=" + altura+ "; " + super.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(altura);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(comprimento);
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
        Retangulo other = (Retangulo) obj;
        if (Double.doubleToLongBits(altura) != Double.doubleToLongBits(other.altura))
            return false;
        if (Double.doubleToLongBits(comprimento) != Double.doubleToLongBits(other.comprimento))
            return false;
        return true;
    }

    

}