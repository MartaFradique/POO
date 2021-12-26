package aula05;
import java.util.Arrays;

public class Utilizador {
    private String nome;
    private int nMec;
    private String curso;
    private int[] livros = new int[3];

    public Utilizador (String nome, int nMec, String curso) {
        this.nome = nome;
        this.nMec = nMec;
        this.curso = curso;
    }

    int setnMec(int nMec){
        return this.nMec= nMec;
    }

    @Override
    public String toString(){
        return "Aluno " + nMec + "; " + nome + "; " + curso + ";" + "Livros requisitados:" + Arrays.toString(livros);
    }
    
    int getnMec(){
        return nMec;
    }
    
    int[] getLivros() {
		return livros;
	}
    
    public void setLivros(int[] livros) {
		this.livros = livros;
	}
    
    public void setLivro(int livro,int n) {
		this.livros[n] = livro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + Arrays.hashCode(livros);
		result = prime * result + nMec;
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
		Utilizador other = (Utilizador) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (!Arrays.equals(livros, other.livros))
			return false;
		if (nMec != other.nMec)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
    
    
    
}
