package aula06.ex3;

public class Conjunto {
    private int[] conjunto = new int[0];
    private int index = 0;

    public void insert(int n) {
        // verificar se o conjunto ja tem o elemento que queremos adicionar
        boolean adicionar = true;
        for (int number : conjunto) {
            if (number == n) {
                adicionar = false;
                break;
            }
        }

        if (adicionar) {// adicionar elemento
            int[] vetor = new int[conjunto.length + 1];
            // copiar do array conjunto para array vetor
            for (int indice = 0; indice < conjunto.length; indice++) {
                vetor[indice] = conjunto[indice];
            }
            // nomear o array vetor em conjunto,sendo o nosso novo conjunto
            conjunto = vetor;
            conjunto[index] = n;
            index++;
        }
    }

    public boolean contains(int n) {
        for (int number : conjunto) {
            if (number == n) {
                return true;
            }
        }

        return false;
    }

    public void remove(int n) {
        // percorrer lista e verificar se tem o elemento que queremos remover
        for (int indice = 0; indice < conjunto.length; indice++) {
            if (conjunto[indice] == n) {
                for (int k = indice + 1; k < conjunto.length; k++) {// remover numero
                    conjunto[k - 1] = conjunto[k];
                }
                index--;

                int[] vetor = new int[conjunto.length - 1];
                // copiar do array conjunto para array vetor
                for (int k = 0; k < vetor.length; k++) {
                    vetor[k] = conjunto[k];
                }
                // nomear o array vetor em conjunto,sendo o nosso novo conjunto
                conjunto = vetor;
            }
        }
    }

    public void empty() {
        int[] vetor = new int[0];
        conjunto = vetor;
        index = 0;
    }

    @Override
    public String toString() {
        String string = "";
        for (int number : conjunto) {
            string += number + " ";
        }
        return string;
    }

    public int size() {
        return conjunto.length;
    }

    public Conjunto unir(Conjunto add) {
        Conjunto uniao = new Conjunto();

        for (int indice = 0; indice < conjunto.length; indice++) {
            uniao.insert(conjunto[indice]);
        }
        for (int indice = 0; indice < add.conjunto.length; indice++) {
            uniao.insert(add.conjunto[indice]);
        }

        return uniao;
    }

    public Conjunto interset(Conjunto inter) {
        Conjunto intersecao = new Conjunto();

        // percorrer cada elemento do vetor this com cada elemento do vetor inter
        for (int indice = 0; indice < conjunto.length; indice++) {
            for (int i = 0; i < inter.conjunto.length; i++) {
                if (conjunto[indice] == inter.conjunto[i]) {// inserir no vetor uniao caso dois elementos sejam iguais
                    intersecao.insert(conjunto[indice]);
                }
            }
        }

        return intersecao;
    }

    public Conjunto subtrair(Conjunto dif) {
        Conjunto diferenca = new Conjunto();
        // copiar o vetor this para o vetor diferença
        for (int number : conjunto) {
            diferenca.insert(number);
        }

        // percorrer cada elemento do vetor this com cada elemento do vetor dif
        for (int indice = 0; indice < conjunto.length; indice++) {
            for (int i = 0; i < dif.conjunto.length; i++) {
                if (conjunto[indice] == dif.conjunto[i]) {// remover no vetor diferença(que é a copia do this) caso dois elementos sejam iguais
                    diferenca.remove(conjunto[indice]);
                }
            }
        }

        return diferenca;
    }

}