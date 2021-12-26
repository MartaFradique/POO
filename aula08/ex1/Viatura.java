package aula08.ex1;

public class Viatura implements KmPercorridosInterface {
    private String marca, modelo, matricula;
    private double cilindrada;// cm cubicos
    private int ultimoTrajeto = 0, distanciaTotal = 0;// km

    public Viatura(String marca, String modelo, String matricula, double cilindrada) {
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        if (validarMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            System.out.println("Matricula inválida.Viatura sem matricula.");
        }
    }

    public int distanciaTotal() {
        return distanciaTotal;
    }

    public void trajeto(int quilometros) {
        distanciaTotal += quilometros;
        ultimoTrajeto = quilometros;
    }

    public int ultimoTrajeto() {
        return ultimoTrajeto;
    }

    public boolean validarMatricula(String matricula) {
        // para uma string ser uma matricula tem de ter 3 conjuntos de 2 numeros ou de 2 letras separadas por traços
        if (matricula.length() == 8) {
            if (matricula.substring(2, 3).equals("-") && matricula.substring(5, 6).equals("-")) {
                if ((matricula.substring(0, 2).matches("[A-z]{2}")) || (matricula.substring(0, 2).matches("[0-9]+"))) {
                    if ((matricula.substring(3, 5).matches("[A-z]{2}")) || (matricula.substring(3, 5).matches("[0-9]+"))) {
                        if ((matricula.substring(6, 8).matches("[A-z]{2}")) || (matricula.substring(6, 8).matches("[0-9]+"))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (validarMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            System.out.println("Matricula inválida.Viatura com matricula anterior.");
        }
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "cilindrada=" + cilindrada + ", distanciaTotal=" + distanciaTotal + ", marca=" + marca + ", matricula="
                + matricula + ", modelo=" + modelo + ", ultimoTrajeto=" + ultimoTrajeto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(cilindrada);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + distanciaTotal;
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + ultimoTrajeto;
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
        Viatura other = (Viatura) obj;
        if (Double.doubleToLongBits(cilindrada) != Double.doubleToLongBits(other.cilindrada))
            return false;
        if (distanciaTotal != other.distanciaTotal)
            return false;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (ultimoTrajeto != other.ultimoTrajeto)
            return false;
        return true;
    }
}

class Motociclo extends Viatura {
    private TipoDeMotociclo tipoDeMotociclo;

    public Motociclo(String marca, String modelo, String matricula, double cilindrada,
            TipoDeMotociclo tipoDeMotociclo) {
        super(marca, modelo, matricula, cilindrada);
        this.tipoDeMotociclo = tipoDeMotociclo;
    }

    public TipoDeMotociclo getTipoDeMotociclo() {
        return tipoDeMotociclo;
    }

    @Override
    public String toString() {
        return "Motociclo [tipoDeMotociclo=" + tipoDeMotociclo + ", " + super.toString() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((tipoDeMotociclo == null) ? 0 : tipoDeMotociclo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Motociclo other = (Motociclo) obj;
        if (tipoDeMotociclo != other.tipoDeMotociclo)
            return false;
        return true;
    }

}

class Automovel extends Viatura {
    private double capacidadeBagageira;
    private int numeroDeQuadro;

    public Automovel(String marca, String modelo, String matricula, double cilindrada, double capacidadeBagageira,
            int numeroDeQuadro) {
        super(marca, modelo, matricula, cilindrada);
        this.capacidadeBagageira = capacidadeBagageira;
        this.numeroDeQuadro = numeroDeQuadro;
    }

    public double getCapacidadeBagageira() {
        return capacidadeBagageira;
    }

    public int getNumeroDeQuadro() {
        return numeroDeQuadro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(capacidadeBagageira);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + numeroDeQuadro;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Automovel other = (Automovel) obj;
        if (Double.doubleToLongBits(capacidadeBagageira) != Double.doubleToLongBits(other.capacidadeBagageira))
            return false;
        if (numeroDeQuadro != other.numeroDeQuadro)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Automovel [capacidadeBagageira=" + capacidadeBagageira + ", numeroDeQuadro=" + numeroDeQuadro + ", "
                + super.toString() + "]";
    }
}

class Taxi extends Automovel {
    private int numeroDeLicença;

    public Taxi(String marca, String modelo, String matricula, double cilindrada, double capacidadeBagageira,
            int numeroDeQuadro, int numeroDeLicença) {
        super(marca, modelo, matricula, cilindrada, capacidadeBagageira, numeroDeQuadro);
        this.numeroDeLicença = numeroDeLicença;
    }

    public int getNumeroDeLicença() {
        return numeroDeLicença;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + numeroDeLicença;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Taxi other = (Taxi) obj;
        if (numeroDeLicença != other.numeroDeLicença)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Taxi [numeroDeLicença=" + numeroDeLicença + ", " + super.toString() + "]";
    }
}

class Pesado extends Viatura {
    private double peso;
    private int numeroDeQuadro;

    public Pesado(String marca, String modelo, String matricula, double cilindrada, double peso, int numeroDeQuadro) {
        super(marca, modelo, matricula, cilindrada);
        this.peso = peso;
        this.numeroDeQuadro = numeroDeQuadro;
    }

    public double getPeso() {
        return peso;
    }

    public int getNumeroDeQuadro() {
        return numeroDeQuadro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + numeroDeQuadro;
        long temp;
        temp = Double.doubleToLongBits(peso);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pesado other = (Pesado) obj;
        if (numeroDeQuadro != other.numeroDeQuadro)
            return false;
        if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pesado, numeroDeQuadro=" + numeroDeQuadro + ", peso=" + peso + ", " + super.toString();
    }

}

class Mercadorias extends Pesado {
    private double cargaMaxima;

    public Mercadorias(String marca, String modelo, String matricula, double cilindrada, double peso,
            int numeroDeQuadro, double cargaMaxima) {
        super(marca, modelo, matricula, cilindrada, peso, numeroDeQuadro);
        this.cargaMaxima = cargaMaxima;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(cargaMaxima);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mercadorias other = (Mercadorias) obj;
        if (Double.doubleToLongBits(cargaMaxima) != Double.doubleToLongBits(other.cargaMaxima))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Mercadorias [cargaMaxima=" + cargaMaxima + ", " + super.toString() + "]";
    }

}

class Passageiros extends Pesado {
    private int numeroMaximoPassageiros;

    public Passageiros(String marca, String modelo, String matricula, double cilindrada, double peso,
            int numeroDeQuadro, int numeroMaximoPassageiros) {
        super(marca, modelo, matricula, cilindrada, peso, numeroDeQuadro);
        this.numeroMaximoPassageiros = numeroMaximoPassageiros;
    }

    public int getNumeroMaximoPassageiros() {
        return numeroMaximoPassageiros;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + numeroMaximoPassageiros;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Passageiros other = (Passageiros) obj;
        if (numeroMaximoPassageiros != other.numeroMaximoPassageiros)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Passageiros [numeroMaximoPassageiros=" + numeroMaximoPassageiros + ", " + super.toString() + "]";
    }
}