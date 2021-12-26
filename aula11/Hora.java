package aula11;


public class Hora {
    int hora,min;

    public Hora(int hora, int min) {
        this.hora = hora;
        this.min = min;
    }

    public Hora(String horaEmString){
        this.hora=Integer.parseInt( horaEmString.substring(0,2) );
        this.min=Integer.parseInt( horaEmString.substring(3,5) );
    }

    public int getHora() {
        return hora;
    }

    public int getMin() {
        return min;
    }

    public Hora somarHora(Hora hora){
        int minf=this.min + hora.min;
        int horaf = this.hora + hora.hora;

        if(minf > 59){
            int horasAdicionaisDosMin=minf/60;
            minf -= 60*horasAdicionaisDosMin;
            horaf += horasAdicionaisDosMin;
        }
        if(horaf>23){
            horaf-=24;
        }

        return new Hora(horaf,minf);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + hora;
        result = prime * result + min;
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
        Hora other = (Hora) obj;
        if (hora != other.hora)
            return false;
        if (min != other.min)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d",hora,min);
    }
    
}