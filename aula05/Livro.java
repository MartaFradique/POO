package aula05;

public class Livro {
    private int id;
    private String titulo;
    private String tipoEmprestimo="NORMAL";
    private static int n =99;
    private String disponibilidade = "Disponível";

    int getId() {
        return id;
    }

    String getTitulo() {
        return titulo;
    }
    
    String getDisponibilidade() {
        return disponibilidade;
    }

    String getTipoEmprestimo(){
        return tipoEmprestimo;
    }

    public Livro (String titulo,String tipoEmprestimo) {
        this.tipoEmprestimo =tipoEmprestimo;
        this.titulo =titulo;
        n++;
        this.id = n;
    }

    public Livro (String titulo) {
        this.titulo =titulo;
        n++;
        this.id = n;
    }

    void setTipoEmprestimo(String tipoEmprestimo){
        this.tipoEmprestimo =tipoEmprestimo;
    }
    
    void setDisponibilidade(String disponibilidade){
        this.disponibilidade=disponibilidade;
    }

    @Override
    public String toString(){
        return "Livro " + id + "; " + titulo + "; " + tipoEmprestimo + ";" + disponibilidade;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((tipoEmprestimo == null) ? 0 : tipoEmprestimo.hashCode());
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
		Livro other = (Livro) obj;
		if (id != other.id)
			return false;
		if (tipoEmprestimo == null) {
			if (other.tipoEmprestimo != null)
				return false;
		} else if (!tipoEmprestimo.equals(other.tipoEmprestimo))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
    
    
}
