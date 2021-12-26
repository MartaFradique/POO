package aula08.ex2;

import java.util.ArrayList;

public class Ementa {
    private String nome, local;
    ArrayList<Prato> pratos = new ArrayList<Prato>();

    public Ementa(String nome, String local) {
        this.nome = nome;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void addPrato(Prato prato, DiaSemana diaDaSemana) {
        boolean adicionar = true;
        for (Prato i : pratos) {
            if (i.equals(prato)) {
                adicionar = false;
                break;
            }
        }

        if (adicionar) {
            prato.setDiaDaSemana(diaDaSemana);
            pratos.add(prato);
        }

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((local == null) ? 0 : local.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((pratos == null) ? 0 : pratos.hashCode());
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
        Ementa other = (Ementa) obj;
        if (local == null) {
            if (other.local != null)
                return false;
        } else if (!local.equals(other.local))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (pratos == null) {
            if (other.pratos != null)
                return false;
        } else if (!pratos.equals(other.pratos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String string = "";
        for (Prato i : pratos) {
            string += i.toString() + ", dia " + i.getDiaDaSemana() + "\n";
        }
        return string;
    }
}