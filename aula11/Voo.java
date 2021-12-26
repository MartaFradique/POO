package aula11;

public class Voo {
    private Hora hora,atraso;
    private String voo, origem;

    public Voo(Hora hora, String voo, String origem) {
        this.hora = hora;
        this.voo = voo;
        this.origem = origem;
    }

    public Voo(Hora hora,String voo, String origem,Hora atraso) {
        this.hora = hora;
        this.atraso = atraso;
        this.voo = voo;
        this.origem = origem;
    }

    public Hora getHora() {
        return hora;
    }

    public Hora getAtraso() {
        return atraso;
    }

    public String getVoo() {
        return voo;
    }

    public String getOrigem() {
        return origem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((atraso == null) ? 0 : atraso.hashCode());
        result = prime * result + ((hora == null) ? 0 : hora.hashCode());
        result = prime * result + ((origem == null) ? 0 : origem.hashCode());
        result = prime * result + ((voo == null) ? 0 : voo.hashCode());
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
        Voo other = (Voo) obj;
        if (atraso == null) {
            if (other.atraso != null)
                return false;
        } else if (!atraso.equals(other.atraso))
            return false;
        if (hora == null) {
            if (other.hora != null)
                return false;
        } else if (!hora.equals(other.hora))
            return false;
        if (origem == null) {
            if (other.origem != null)
                return false;
        } else if (!origem.equals(other.origem))
            return false;
        if (voo == null) {
            if (other.voo != null)
                return false;
        } else if (!voo.equals(other.voo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Voo [atraso=" + atraso + ", hora=" + hora + ", origem=" + origem + ", voo=" + voo + "]";
    }
}