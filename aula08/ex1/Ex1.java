package aula08.ex1;

public class Ex1 {
    public static void main(String[] args) {
        Motociclo motociclo = new Motociclo("marca", "modelo", "11-WW-44", 50, TipoDeMotociclo.desportivo);
        Taxi taxi = new Taxi("marca2", "modelo2", "TT-90-20", 3000, 7, 2, 1);
        Taxi taxi1 = new Taxi("marca2", "modelo2", "TT-90-20", 3000, 7, 2, 1);
        Mercadorias mercadorias = new Mercadorias("marca3", "modelo3", "70-GH-40", 10000, 60000, 2, 1000);
        Passageiros passageiros = new Passageiros("marca4", "modelo4", "60-PP-80", 10050, 3000, 4, 60);

        System.out.println("Testar métodos da classe Motociclo e Viatura:");
        System.out.println("Matrícula:" + motociclo.getMatricula());
        System.out.println("Marca:" + motociclo.getMarca());
        System.out.println("Modelo:" + motociclo.getModelo());
        motociclo.setCilindrada(55);
        System.out.println("Cilindrada, depois do método set:" + motociclo.getCilindrada());
        System.out.println("Tipo de motociclo:" + motociclo.getTipoDeMotociclo());
        System.out.println("Comparação de motociclos(teste passado se der true):" + motociclo.equals(motociclo));
        motociclo.trajeto(10);
        System.out.println("Distância do ultimo trajeto:" + motociclo.ultimoTrajeto());
        System.out.println("Distância total percorrida:" + motociclo.distanciaTotal());
        System.out.println(motociclo);
        System.out.println();

        System.out.println("Testar métodos da classe Automóvel e Viatura:");
        Automovel automovel = new Automovel("marca1", "modelo1", "A5-55-20", 2000, 5, 1);
        System.out.println(
                "Automóvel que vamos testar não tem matricula, pois quando criamos colocamos uma matricula inválida");
        System.out.println("Matrícula:" + automovel.getMatricula());
        automovel.setMatricula("FF-55-20");
        System.out.println("Matrícula depois do set:" + automovel.getMatricula());
        System.out.println("Capacidade Bagageira:" + automovel.getCapacidadeBagageira());
        System.out.println("Número de quadro:" + automovel.getNumeroDeQuadro());
        System.out.println("Comparação com uma viatrura(teste passado se der false):" + automovel.equals(motociclo));
        System.out.println(automovel);
        System.out.println();

        System.out.println("Testar métodos da classe Táxi:");
        System.out.println("Número de licença:" + taxi.getNumeroDeLicença());
        System.out.println("Comparação com uma viatrura(teste passado se der true):" + taxi.equals(taxi1));
        System.out.println(taxi);
        System.out.println();

        System.out.println("Testar métodos da classe Mercadorias e Peso:");
        System.out.println("Peso:" + mercadorias.getPeso());
        System.out.println("Número de quadro:" + mercadorias.getNumeroDeQuadro());
        System.out.println("Carga máxima:" + mercadorias.getCargaMaxima());
        System.out.println("Comparação com uma viatrura(teste passado se der true):"
                + mercadorias.equals(new Mercadorias("marca3", "modelo3", "70-GH-40", 10000, 60000, 2, 1000)));
        System.out.println(mercadorias);
        System.out.println();

        System.out.println("Testar métodos da classe Passageiros:");
        System.out.println("Número máximo de passageiros:" + passageiros.getNumeroMaximoPassageiros());
        System.out.println("Comparação com uma viatrura(teste passado se der true):"
                + passageiros.equals(new Passageiros("marca3", "modelo3", "70-GH-40", 10000, 60000, 2, 1000)));
        System.out.println(passageiros);
        System.out.println();

        System.out.println("Testar métodos da classe Empressa:");
        Empresa empresa = new Empresa("nome", "5000-600", "kijgmail.com");
        empresa.setEmail("kijgmail.com");
        System.out.println("Email depois do set:" + empresa.getEmail());
        System.out.println("Nome:" + empresa.getNome());
        empresa.setNome("ghy");
        System.out.println("Nome depois do set:" + empresa.getNome());
        empresa.setCódigoPostal("4000-500");
        System.out.println("Código postal depois do set:" + empresa.getCódigoPostal());
        empresa.adicionarViatura(motociclo);
        empresa.adicionarViatura(mercadorias);
        empresa.adicionarViatura(taxi);
        System.out.println("Matrículas das viaturas da empresa:" + empresa.getViaturas());
        empresa.removerViatura(taxi);
        System.out.println("Matrículas das viaturas da empresa depois de remover o taxi:" + empresa.getViaturas());
        System.out.println("Ordenar matrículas das viaturas por cilindrada:" + empresa.ordenarPorCilindrada());
        System.out.println("Viatura da empresa que percorreu mais quilometros:" + empresa.viaturaQuePercorreuMaisKm());
        System.out.println("Comparação com uma empresa(teste passado se der false):"
                + empresa.equals(new Empresa("ndf", "5009-300", "sfd@hotmail.com")));
        System.out.println(empresa);
    }
}