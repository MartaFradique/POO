package testesmodelo.exb;

import java.util.Arrays;

public class Publicacao{
    private String titulo, editora;

    public Publicacao(String titulo, String editora) {
        this.titulo = titulo;
        this.editora = editora;
    }

    public Publicacao(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((editora == null) ? 0 : editora.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
        Publicacao other = (Publicacao) obj;
        if (editora == null) {
            if (other.editora != null)
                return false;
        } else if (!editora.equals(other.editora))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "editora=" + editora + ", titulo=" + titulo;
    }
}

class Livro extends Publicacao {
    private String[] autores;
    private String ISBN;

    public Livro(String titulo, String editora, String autores, String iSBN) {
        super(titulo, editora);
        this.autores = autores.split("; ");
        ISBN = iSBN;
    }

    public Livro(String titulo, String editora, String autores) {
        super(titulo, editora);
        this.autores = autores.split("; ");
    }

    public String getAutores() {
        return  Arrays.toString(autores);
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
        result = prime * result + Arrays.hashCode(autores);
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
        Livro other = (Livro) obj;
        if (ISBN == null) {
            if (other.ISBN != null)
                return false;
        } else if (!ISBN.equals(other.ISBN))
            return false;
        if (!Arrays.equals(autores, other.autores))
            return false;
        return true;
    }

	@Override
	public String toString() {
		return "Livro [ISBN=" + ISBN + ", autores=" + Arrays.toString(autores) + ", " + super.toString() + "]";
	}
}

class Revista extends Publicacao{
    private String ISSN;
    private Period periodicidade;

    public Revista(String titulo, String editora, String iSSN) {
        super(titulo, editora);
        ISSN = iSSN;
    }

    public Revista(String titulo, String editora) {
        super(titulo, editora);
    }

    public String getISSN() {
        return ISSN;
    }

    public Period getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(Period periodicidade) {
        this.periodicidade = periodicidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((ISSN == null) ? 0 : ISSN.hashCode());
        result = prime * result + ((periodicidade == null) ? 0 : periodicidade.hashCode());
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
        Revista other = (Revista) obj;
        if (ISSN == null) {
            if (other.ISSN != null)
                return false;
        } else if (!ISSN.equals(other.ISSN))
            return false;
        if (periodicidade != other.periodicidade)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Revista [ISSN=" + ISSN + ", periodicidade=" + periodicidade + ", " + super.toString() + "]";
    }
    
}

class Jornal extends Publicacao{
    private Ver versao;
    private Period periodicidade;

    public Jornal(String titulo, Ver versao) {
        super(titulo);
        this.versao = versao;
    }

    public Jornal(String titulo) {
        super(titulo);
    }

    public Ver getVersao() {
        return versao;
    }

    public Period getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(Period periodicidade) {
        this.periodicidade = periodicidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((periodicidade == null) ? 0 : periodicidade.hashCode());
        result = prime * result + ((versao == null) ? 0 : versao.hashCode());
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
        Jornal other = (Jornal) obj;
        if (periodicidade != other.periodicidade)
            return false;
        if (versao != other.versao)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Jornal [periodicidade=" + periodicidade + ", versao=" + versao + ", " + super.toString() + "]";
    }

}