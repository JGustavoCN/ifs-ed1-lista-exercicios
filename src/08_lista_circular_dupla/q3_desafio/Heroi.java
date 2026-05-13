// src/08_lista_circular_dupla/q3_desafio/Heroi.java
package q3_desafio;

public class Heroi {
    String nome;
    String classe;

    public Heroi(String nome, String classe) {
        this.nome = nome;
        this.classe = classe;
    }

    @Override
    public String toString() {
        return nome + " (" + classe + ")";
    }
}
