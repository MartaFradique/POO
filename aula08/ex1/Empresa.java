package aula08.ex1;

import java.util.ArrayList;

public class Empresa {
    private String nome, códigoPostal, email;
    ArrayList<Viatura> viaturas = new ArrayList<Viatura>();

    public Empresa(String nome, String códigoPostal, String email) {
        this.nome = nome;
        this.códigoPostal = códigoPostal;
        if (validarEmail(email)) {
            this.email = email;
        } else {
            System.out.println("Email não válido.Empresa sem email.");
        }
    }

    public boolean validarEmail(String email) {
        // para ser um email tem de possuir um @ e um ponto final que não seja o ultimo caracter
        if (email.contains("@") && email.indexOf(".") != email.length()-1 && email.lastIndexOf(".") > email.indexOf("@")) {
            return true;
        }
        return false;
    }

    public Viatura viaturaQuePercorreuMaisKm() {
        Viatura viatura = viaturas.get(0);
        for (int i = 1; i < viaturas.size(); i++) {
            if (viaturas.get(i).distanciaTotal()>viatura.distanciaTotal()){
                viatura=viaturas.get(i);
            }
        }
        return viatura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCódigoPostal() {
        return códigoPostal;
    }

    public void setCódigoPostal(String códigoPostal) {
        this.códigoPostal = códigoPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validarEmail(email)) {
            this.email = email;
        } else {
            System.out.println("Email não válido.Empresa com email anterior.");
        }
    }

    public String getViaturas() {//apresentar matriculas das viaturas da empresa
        String string = "";
        for (Viatura i : viaturas) {
            string += i.getMatricula() +";";
        }
        return string;
    }

    public void adicionarViatura(Viatura viatura) {
        viaturas.add(viatura);
    }

    public void removerViatura(Viatura viatura) {
        viaturas.remove(viatura);
    }

    public String ordenarPorCilindrada() {//apresentar matriculas das viaturas da empresa
        double cilindrada = viaturas.get(0).getCilindrada();
        String string = "" + viaturas.get(0).getMatricula();

        for (int i = 1; i < viaturas.size(); i++) {
            if (viaturas.get(i).getCilindrada() > cilindrada) {
                string = viaturas.get(i).getMatricula() + ", " + string;
            } else {
                string += ", " + viaturas.get(i).getMatricula();
            }
            cilindrada = viaturas.get(i).getCilindrada();
        }

        return string + ".";
    }

    @Override
    public String toString() {
        return "Empresa [códigoPostal=" + códigoPostal + ", email=" + email + ", nome=" + nome + ", viaturas="
                + viaturas + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((códigoPostal == null) ? 0 : códigoPostal.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((viaturas == null) ? 0 : viaturas.hashCode());
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
        Empresa other = (Empresa) obj;
        if (códigoPostal == null) {
            if (other.códigoPostal != null)
                return false;
        } else if (!códigoPostal.equals(other.códigoPostal))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (viaturas == null) {
            if (other.viaturas != null)
                return false;
        } else if (!viaturas.equals(other.viaturas))
            return false;
        return true;
    }

}