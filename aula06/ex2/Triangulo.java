package aula06.ex2;
import java.lang.Math;

public class Triangulo extends Figura {
    private double lado1;
    private double lado2;
    private double lado3;

    double getLado1() {
        return lado1;
    }

    double getLado2() {
        return lado2;
    }

    double getLado3() {
        return lado3;
    }

    void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    public Triangulo (double lado1, double lado2,double lado3, String cor) {
        super(cor);
		this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }
    
    public double area(){
        double base = this.getLado1();
        double lado = this.getLado2();
        return (base * Math.sqrt( Math.pow(lado, 2) - ( Math.pow(base, 2)/4 ) ) ) / 2;
    }

    public double perimetro(){
        return this.getLado1() + this.getLado2() + this.getLado3() ;
    }

    @Override
    public String toString() {
        return "Triângulo: lado1=" + lado1 + "; lado2=" + lado2 + "; lado3=" + lado3 + "; " + super.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(lado1);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lado2);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lado3);
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
        Triangulo other = (Triangulo) obj;
        if (Double.doubleToLongBits(lado1) != Double.doubleToLongBits(other.lado1))
            return false;
        if (Double.doubleToLongBits(lado2) != Double.doubleToLongBits(other.lado2))
            return false;
        if (Double.doubleToLongBits(lado3) != Double.doubleToLongBits(other.lado3))
            return false;
        return true;
    }

    
}