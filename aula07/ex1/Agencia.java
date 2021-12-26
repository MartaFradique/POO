package aula07.ex1;

import java.util.Arrays;

public class Agencia {
    private String nome;
    private String endereço;
    public Alojamento[] alojamentos;
    public Viatura[] viaturas;

    public Agencia(String nome, String endereço, Alojamento[] alojamentos, Viatura[] viaturas) {
        this.nome = nome;
        this.endereço = endereço;
        this.alojamentos = alojamentos;
        this.viaturas = viaturas;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public String getAlojamentos() {
        String string ="";
        for(Alojamento alojamento:alojamentos){
            string+=alojamento+ "; ";
        }
        return string;
    }

    public void setAlojamentos(Alojamento[] alojamentos) {
        this.alojamentos = alojamentos;
    }

    public String getViaturas() {
        String string ="";
        for(Viatura viatura:viaturas){
            string+=viatura+ "; ";
        }
        return string;
    }

    public void setViaturas(Viatura[] viaturas) {
        this.viaturas = viaturas;
    }

    @Override
    public String toString() {
        return "Agencia [alojamentos=" + Arrays.toString(alojamentos) + ", endereço=" + endereço + ", nome=" + nome
                + ", viaturas=" + Arrays.toString(viaturas) + "]";
    }

}

