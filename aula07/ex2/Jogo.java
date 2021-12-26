package aula07.ex2;

//System.currentTimeMillis():This method returns the difference, measured in milliseconds,
//between the current time and midnight,January 1, 1970

public class Jogo{
    private Equipa equipa1;
    private Equipa equipa2;
    private Bola bola;
    private long duraçaoDoJogo; //milisegundos
    private long horaFinalDoJogo;//milisegundos
    private long horaInicialDoJogo;//milisegundos

    public Jogo(Equipa equipa1, Equipa equipa2, Bola bola, int duraçaoDoJogo) {
        this.equipa1 = equipa1;
        this.equipa2 = equipa2;
        this.bola = bola;
        this.duraçaoDoJogo = duraçaoDoJogo *1000; //argumento está em segundos, entao passar para milisegundos
    }

    public Equipa getEquipa1() {
        return equipa1;
    }

    public Equipa getEquipa2() {
        return equipa2;
    }

    public Bola getBola() {
        return bola;
    }

    public long getDuraçaoDoJogo() {
        return duraçaoDoJogo/1000;//apresentar duração em segundos na consola
    }

    public void iniciarJogo(){
        horaInicialDoJogo=System.currentTimeMillis();//milisegundos
        horaFinalDoJogo=horaInicialDoJogo+duraçaoDoJogo;//milisegundos
    }

    public void tempoDecorrido(){
        if(System.currentTimeMillis()>=horaFinalDoJogo){
            System.out.println("O jogo já terminou");
        }
        else{
            //apresentar tempo decorrido em segundos na consola
            System.out.println("Tempo decorrido, a partir do inicio do jogo : " + ( (System.currentTimeMillis()-horaInicialDoJogo)/1000 ) );
        }
    }

    public void golo(Equipa equipaQueMarcouGolo,Robo robo,Equipa equipaQueSofreuGolo){//método que regista um golo durante um jogo
        //verificar se o jogo já terminou,caso ja tenha terminado nao vai fazer alteraçoes
        if(System.currentTimeMillis()<horaFinalDoJogo){
            equipaQueMarcouGolo.marcouGolo();//atualizar os golos marcados da equipa que marcou
            robo.marcar();//atualizar os golos marcados do robo que marcou
            equipaQueSofreuGolo.sofreuGolo(); //atualizar os golos sofridos da equipa adversária 
        }
    }

    @Override
    public String toString() {
        return "Jogo [bola=" + bola + ", duraçaoDoJogo=" + duraçaoDoJogo/1000 + ", equipa1=" + equipa1 + ", equipa2="
                + equipa2 +"]";
    }
    
}