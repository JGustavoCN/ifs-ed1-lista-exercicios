// src/07_lista_circular_simples/q3_desafio/Processo.java
package q3_desafio;

public class Processo {
    int id;
    String nome;
    int tempoRestante;

    public Processo(int id, String nome, int tempo) {
        this.id = id;
        this.nome = nome;
        this.tempoRestante = tempo;
    }

    @Override
    public String toString() {
        return "[" + id + ":" + nome + " (" + tempoRestante + "ms)]";
    }
}
