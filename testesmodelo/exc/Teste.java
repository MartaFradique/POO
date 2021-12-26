package testesmodelo.exc;

public class Teste {
    private String disciplina,prof,data_hora,salas;

    public Teste(String disciplina, String prof, String data_hora, String salas) {
        this.disciplina = disciplina;
        this.prof = prof;
        this.data_hora = data_hora;
        this.salas = salas;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getProf() {
        return prof;
    }

    public String getData_hora() {
        return data_hora;
    }

    public String getSalas() {
        return salas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data_hora == null) ? 0 : data_hora.hashCode());
        result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
        result = prime * result + ((prof == null) ? 0 : prof.hashCode());
        result = prime * result + ((salas == null) ? 0 : salas.hashCode());
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
        Teste other = (Teste) obj;
        if (data_hora == null) {
            if (other.data_hora != null)
                return false;
        } else if (!data_hora.equals(other.data_hora))
            return false;
        if (disciplina == null) {
            if (other.disciplina != null)
                return false;
        } else if (!disciplina.equals(other.disciplina))
            return false;
        if (prof == null) {
            if (other.prof != null)
                return false;
        } else if (!prof.equals(other.prof))
            return false;
        if (salas == null) {
            if (other.salas != null)
                return false;
        } else if (!salas.equals(other.salas))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "data_hora=" + data_hora + ", disciplina=" + disciplina + ", prof=" + prof + ", salas=" + salas;
    }
}

class ExameEscrito extends Teste implements ProvasComPrazo{
    private int versoes=1, prazo;
    private boolean consulta=false;

    public ExameEscrito(String disciplina, String prof, String data_hora, String salas, int versoes) {
        super(disciplina, prof, data_hora, salas);
        this.versoes = versoes;
    }

    public ExameEscrito(String disciplina, String prof, String data_hora, String salas) {
        super(disciplina, prof, data_hora, salas);
    }

    public int getVersoes() {
        return versoes;
    }

    @Override
    public int getPrazo() {
        return prazo;
    }

    @Override
    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public boolean isConsulta() {
        return consulta;
    }

    public void setConsulta(boolean consulta) {
        this.consulta = consulta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (consulta ? 1231 : 1237);
        result = prime * result + prazo;
        result = prime * result + versoes;
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
        ExameEscrito other = (ExameEscrito) obj;
        if (consulta != other.consulta)
            return false;
        if (prazo != other.prazo)
            return false;
        if (versoes != other.versoes)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ExameEscrito [consulta=" + consulta + ", prazo=" + prazo + ", versoes=" + versoes + ", " + super.toString() + "]";
    }
    
}

class ProvaOral extends Teste{
    private Lingua lingua=Lingua.UK;

    public ProvaOral(String disciplina, String prof, String data_hora, String salas, Lingua lingua) {
        super(disciplina, prof, data_hora, salas);
        this.lingua = lingua;
    }

    public ProvaOral(String disciplina, String prof, String data_hora, String salas) {
        super(disciplina, prof, data_hora, salas);
    }

    public Lingua getLingua() {
        return lingua;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((lingua == null) ? 0 : lingua.hashCode());
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
        ProvaOral other = (ProvaOral) obj;
        if (lingua != other.lingua)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProvaOral [lingua=" + lingua+ ", " + super.toString() + "]";
    }

}

class TesteComputador extends Teste implements ProvasComPrazo{
    private String link;
    private int prazo;

    public TesteComputador(String disciplina, String prof, String data_hora, String salas) {
        super(disciplina, prof, data_hora, salas);
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int getPrazo() {
        return prazo;
    }

    @Override
    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((link == null) ? 0 : link.hashCode());
        result = prime * result + prazo;
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
        TesteComputador other = (TesteComputador) obj;
        if (link == null) {
            if (other.link != null)
                return false;
        } else if (!link.equals(other.link))
            return false;
        if (prazo != other.prazo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TesteComputador [link=" + link + ", prazo=" + prazo + ", " + super.toString() + "]";
    }
}