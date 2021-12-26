package aula07.ex1;

public class Menu{
    public static void main(String[] args){
        Alojamento alojamento1 = new Alojamento("100", "Pousada", "Lisboa", 30);
        Alojamento alojamento2 = new Alojamento("101", "FGH", "Porto", 25.5);
        Alojamento alojamento3 = new Alojamento("10o", "GAU", "Aveiro", 20.5);
        Apartamento apartamento = new Apartamento("100", "Pousada", "Lisboa", 30, 2);
        Quarto quarto =new Quarto("101", "FGH", "Porto", 25.5, TipoDequarto.single);
        Viatura viatura1=new Viatura(Char.A, TipoDeCombustivel.gasolina);
        Viatura viatura2=new Viatura(Char.B, TipoDeCombustivel.diesel);
        Alojamento[] alojamentos1={alojamento1,alojamento2};
        Alojamento[] alojamentos2={alojamento3};
        Viatura[] viaturas1={viatura1,viatura2};
        Viatura[] viaturas2={viatura1};
        Agencia agencia = new Agencia("TOI","Rua Júlio",alojamentos1,viaturas1);

        System.out.println("Testar métodos da classe Agencia:");
        System.out.println("Nome da agencia:"+ agencia.getNome());
        System.out.println();
        System.out.println("Endereço da agencia:" + agencia.getEndereço());
        System.out.println();
        System.out.println("Alojamentos da agencia:" + agencia.getAlojamentos());
        agencia.setAlojamentos(alojamentos2);
        System.out.println();
        System.out.println("Alojamentos da agencia (depois do set):" + agencia.getAlojamentos());
        System.out.println();
        System.out.println("Viaturas da agencia:" + agencia.getViaturas());
        agencia.setViaturas(viaturas2);
        System.out.println();
        System.out.println("Viaturas da agencia (depois do set):" + agencia.getViaturas());
        System.out.println();
        System.out.println(agencia);
        System.out.println();

        System.out.println("Testar métodos da classe Alojamento:");
        System.out.println("Nome do Alojamento1:"+ alojamento1.getNome());
        System.out.println();
        System.out.println("Código do Alojamento1:" + alojamento1.getCodigo());
        System.out.println();
        System.out.println("Local do Alojamento1:" + alojamento1.getLocal());
        System.out.println();
        System.out.println("Preço por noite do Alojamento1:" + alojamento1.getPreçoPorNoite());
        System.out.println();
        alojamento1.setPreçoPorNoite(30.5);
        System.out.println("Preço por noite do Alojamento1(depois do set):" + alojamento1.getPreçoPorNoite());
        System.out.println();
        alojamento1.CheckIn();
        System.out.println("Disponibilidade do Alojamento1(depois do check-in):" + alojamento1.isDisponibilidade());
        System.out.println();
        alojamento1.CheckOut();
        System.out.println("Disponibilidade do Alojamento1(depois do check-out):" + alojamento1.isDisponibilidade());
        System.out.println();
        alojamento1.setAvaliaçao(2.5);
        System.out.println("Avaliaçao do Alojamento1(depois do set):" + alojamento1.getAvaliaçao());
        System.out.println();
        System.out.println(alojamento1);
        System.out.println();

        System.out.println("Testar métodos da classe Apartamento:");
        apartamento.setNumeroDeQuartos(3);
        System.out.println("Numero de quartos do Apartamento (depois do set):"+ apartamento.getNumeroDeQuartos());
        System.out.println();
        System.out.println(apartamento);
        System.out.println();
        System.out.println("Testar métodos da classe Quarto:");
        quarto.setTipo(TipoDequarto.duplo);
        System.out.println("Tipo de quarto (depois do set):"+ quarto.getTipo());
        System.out.println();
        System.out.println(quarto);
        System.out.println();

        System.out.println("Testar métodos da classe Viatura:");
        viatura1.setClasse(Char.F);
        System.out.println("Classe da viatura1 (depois do set):"+ viatura1.getClasse());
        System.out.println();
        viatura1.setCombustivel(TipoDeCombustivel.diesel);
        System.out.println("Combustível da viatura1 (depois do set):"+ viatura1.getCombustivel());
        System.out.println();
        viatura1.levantar();
        System.out.println("Disponibilidade da viatura1 (depois de levantar):"+ viatura1.isDisponibilidade());
        System.out.println();
        viatura1.entregar();
        System.out.println("Disponibilidade da viatura1 (depois de entregar):"+ viatura1.isDisponibilidade());
        System.out.println();
        System.out.println(viatura1);
        System.out.println();
    }
}