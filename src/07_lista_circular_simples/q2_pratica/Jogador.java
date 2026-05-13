// src/07_lista_circular_simples/q2_pratica/Jogador.java
package q2_pratica;

public class Jogador {
    String nome;
    int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
    }

    @Override
    public String toString() {
        return nome + " (Pontos: " + pontuacao + ")";
    }
}
