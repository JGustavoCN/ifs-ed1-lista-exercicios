// src/tema07_lista_circular_simples/q1_conceito/Main.java
package tema07_lista_circular_simples.q1_conceito;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== QUESTÃO 19: PLAYER DE MÚSICA CIRCULAR (CONCEITO) ===\n");

        PlayerCircular player = new PlayerCircular();

        player.adicionarMusica("Bohemian Rhapsody");
        player.adicionarMusica("Imagine");
        player.adicionarMusica("Hotel California");

        System.out.println();
        player.exibirPlaylist();
    }
}
