package aula07.ex2;
import java.lang.Math;

public class Objeto{
    private double x=0;
    private double y=0;
    private double distanciaPercorrida=0;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void move(int newX, int newY){
        distanciaPercorrida=Math.sqrt( Math.pow( (x - newX),2 ) + Math.pow( (y - newY),2 ) );
        x=newX;
        y=newY;
    }

    @Override
    public String toString() {
        return "Objeto [distanciaPercorrida=" + distanciaPercorrida + ", x=" + x + ", y=" + y + "]";
    }
}

class Robo extends Objeto{
    private String id;
    private TipoDeJogador tipoDeJogador;
    private int golosMarcados=0;
    
    public void marcar(){
        golosMarcados++;
    }

    public Robo(String id, TipoDeJogador tipoDeJogador) {
        this.id = id;
        this.tipoDeJogador = tipoDeJogador;
    }

    @Override
    public String toString() {
        return "Robo [golosMarcados=" + golosMarcados + ", id=" + id + ", tipoDeJogador=" + tipoDeJogador + "], " + super.toString();
    }
    
}

class Bola extends Objeto{
    private String cor;

    public Bola(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Bola [cor=" + cor + "], " + super.toString();
    }
}