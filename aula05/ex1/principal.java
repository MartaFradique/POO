package aula05.ex1;

public class principal {
    public static void main(String[] args) {
        Retangulo r = new Retangulo(6,3);
        Retangulo re = new Retangulo(7,8);
        Triangulo t = new Triangulo(3, 4, 5);
        Triangulo tr = new Triangulo(3, 4, 5);
        Circulo c = new Circulo(2, 0, 3);
        Circulo ci = new Circulo(2, 0, 2);
        Ponto ponto = new Ponto(4,2);
        Ponto p = new Ponto(4,6);

        System.out.println(r);
        System.out.println(t);
        System.out.println(c);
        System.out.println(ponto);

        r.setAltura(2);
        r.setComprimento(3);
        t.setLado1(4);
        tr.setLado2(7);
        t.setLado3(9);
        c.setRaio(4);
        ci.setCentro(ponto);


        System.out.println(r);
        System.out.println(t);
        System.out.println(tr);
        System.out.println(c);
        System.out.println(ci);

        System.out.println(r.area());
        System.out.println(t.area());
        System.out.println(c.area());

        System.out.println(r.perimetro());
        System.out.println(t.perimetro());
        System.out.println(c.perimetro());

        System.out.println(r.equals(re));
        System.out.println(t.equals(tr));
        System.out.println(c.equals(ci));
        System.out.println(p.equals(ponto));

        
        System.out.println(c.intersecao(ci));

        System.out.println(t.getLado1());
        System.out.println(t.getLado2());
        System.out.println(t.getLado3());
        System.out.println(r.getAltura());
        System.out.println(r.getComprimento());
        System.out.println(c.getRaio());
        System.out.println(c.getCentro());
        System.out.println(ponto.getX());
        System.out.println(ponto.getY());
    }
}
