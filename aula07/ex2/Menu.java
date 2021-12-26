package aula07.ex2;
import java.util.Scanner;

public class Menu{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Objeto objeto=new Objeto();
        Robo robo01=new Robo("0", TipoDeJogador.Avancado);
        Robo robo02=new Robo("1", TipoDeJogador.GuardaRedes);
        Robo robo03=new Robo("2", TipoDeJogador.Defesa);
        Robo robo1=new Robo("3", TipoDeJogador.Medio);
        Robo robo2=new Robo("4", TipoDeJogador.GuardaRedes);
        Robo robo3=new Robo("5", TipoDeJogador.Avancado);
        Bola bola=new Bola("red");
        Robo[] robos0={robo01,robo02,robo03};
        Robo[] robos1={robo1,robo2,robo3};
        Equipa equipa0 =new Equipa("FCP", "maria", robos0);
        Equipa equipa1 =new Equipa("SLB", "marco", robos1);
        Jogo jogo=new Jogo(equipa0, equipa1, bola, 10);

        System.out.println("Testar métodos da classe Objeto:");
        System.out.println("Coordenadas do objeto: ("+ objeto.getX()+","+objeto.getY()+")");
        objeto.move(5, 2);
        System.out.println("Distância percorrida do objeto:"+objeto.getDistanciaPercorrida());
        System.out.println(objeto);
        System.out.println("---------------------------------------------------------------------------------------------------------");

        System.out.println("Testar métodos da classe Robo:");
        robo01.marcar();
        System.out.println(robo01);
        System.out.println("---------------------------------------------------------------------------------------------------------");

        System.out.println("Testar métodos da classe Bola:");
        System.out.println("Cor da bola: "+bola.getCor());
        bola.setCor("blue");
        System.out.println(bola);
        System.out.println("---------------------------------------------------------------------------------------------------------");

        System.out.println("Testar métodos da classe Equipa:");
        System.out.println("Nome da equipa0: "+equipa0.getNome());
        System.out.println();
        System.out.println("Nome do responsável da equipa0: "+equipa0.getNomeResponsavel());
        System.out.println();
        System.out.println("Robos da equipa0: "+equipa0.getRobos());
        System.out.println();
        System.out.println("Golos marcados pela equipa0: "+equipa0.getGolosMarcados());
        System.out.println();
        System.out.println("Golos sofridos pela equipa0: "+equipa0.getGolosSofridos());
        System.out.println();
        System.out.println(equipa0);
        System.out.println("---------------------------------------------------------------------------------------------------------");

        System.out.println("Testar métodos da classe Jogo:");
        System.out.println("Equipa 1 do jogo: "+jogo.getEquipa1());
        System.out.println();
        System.out.println("Equipa 2 do jogo: "+jogo.getEquipa2());
        System.out.println();
        System.out.println("Bola do jogo: "+jogo.getBola());
        System.out.println();
        System.out.println("Duração do jogo: "+jogo.getDuraçaoDoJogo());
        System.out.println();
        System.out.println(jogo);
        System.out.println("---------------------------------------------------------------------------------------------------------");

        System.out.println("Realizar um jogo de futebol robótico:");
        jogo.iniciarJogo();
        System.out.println("O jogo começa!");
        jogo.golo(equipa0, robo01, equipa1);
        robo2.move(2, 3);
        System.out.println("Prima enter para realizar os próximo métodos.");
        //A linha de código anterior serve para passar tempo no jogo sem qualquer evento,
        //assim podemos esperar o tempo necessario de modo que o jogo acabe antes de executar o próximo codigo 
        //e assim os próximos eventos do jogo nao se realizarão
        sc.nextLine();
        jogo.tempoDecorrido();
        jogo.golo(equipa1, robo2, equipa0);
        System.out.println("Distancia percorrida pelo robo2: "+ robo2.getDistanciaPercorrida());
        System.out.println("Golos marcados da equipa0: "+equipa0.getGolosMarcados()+ ", Golos marcados da equipa1: " + equipa1.getGolosMarcados());
        System.out.println("Golos sofridos da equipa0: "+equipa0.getGolosSofridos()+ ", Golos marcados da equipa1: " + equipa1.getGolosSofridos());
        sc.close();
    } 
}