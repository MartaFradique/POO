package aula06.ex2;

public class Circulo extends Figura {
    private Ponto centro;
    private double raio;

    public Circulo(double x, double y, double r, String cor){
        super(cor);
        centro = new Ponto(x,y);
        raio = r;
    }

    Ponto getCentro() {
        return centro;
    }

    double getRaio() {
        return raio;
    }

    void setCentro(Ponto centro) {
        this.centro = centro;
    }

    void setRaio(double raio) {
        this.raio = raio;
    }

    public double area(){
        return Math.PI*Math.pow(this.getRaio(), 2);
    }

    public double perimetro(){
        return 2* Math.PI*this.getRaio() ;
    }

    public boolean intersecao(Circulo c){
        double distCentros=Math.sqrt(Math.pow(this.getCentro().getX()-c.getCentro().getX(), 2)+Math.pow(this.getCentro().getY()-c.getCentro().getY(), 2));
        if( ( this.getRaio() + c.getRaio() ) >= distCentros ){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Círculo: centro= (" + centro.getX() + "," + centro.getY() + ") ; raio=" + raio + "; " + super.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((centro == null) ? 0 : centro.hashCode());
        long temp;
        temp = Double.doubleToLongBits(raio);
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
        Circulo other = (Circulo) obj;
        if (centro == null) {
            if (other.centro != null)
                return false;
        } else if (!centro.equals(other.centro))
            return false;
        if (Double.doubleToLongBits(raio) != Double.doubleToLongBits(other.raio))
            return false;
        return true;
    }

    
}
