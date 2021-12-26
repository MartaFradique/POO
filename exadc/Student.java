package exadc;

public class Student{
    private int Nmec;
    private String nome;
    private double ATP,AC,AP;

    public Student(int nmec, String nome, double aTP, double aC, double aP) {
        Nmec = nmec;
        this.nome = nome;
        ATP = aTP;
        AC = aC;
        AP = aP;
    }

    public int notaFinal(){
        return (int) Math.round( (ATP*0.30) + (AC *0.20) + (AP*0.50) );
    }

    public int getNmec() {
        return Nmec;
    }

    public String getNome() {
        return nome;
    }

    public double getATP() {
        return ATP;
    }

    public double getAC() {
        return AC;
    }

    public double getAP() {
        return AP;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(AC);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(AP);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ATP);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + Nmec;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        Student other = (Student) obj;
        if (Double.doubleToLongBits(AC) != Double.doubleToLongBits(other.AC))
            return false;
        if (Double.doubleToLongBits(AP) != Double.doubleToLongBits(other.AP))
            return false;
        if (Double.doubleToLongBits(ATP) != Double.doubleToLongBits(other.ATP))
            return false;
        if (Nmec != other.Nmec)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Student [AC=" + AC + ", AP=" + AP + ", ATP=" + ATP + ", Nmec=" + Nmec + ", nome=" + nome + "]";
    }

}