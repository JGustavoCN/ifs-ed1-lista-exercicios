// src/tema07_lista_circular_simples/q2_pratica/Main.java
package tema07_lista_circular_simples.q2_pratica;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== QUESTÃO 20: GERENCIADOR DE TURNOS (PRÁTICA) ===\n");

        GerenciadorTurnos jogo = new GerenciadorTurnos();
        jogo.adicionarJogador("Alice");
        jogo.adicionarJogador("Bruno");
        jogo.adicionarJogador("Carla");
        jogo.adicionarJogador("Diego");

        jogo.exibirJogadores();
        System.out.println();

        // Rodada 1
        System.out.println("--- Rodada 1 ---");
        for (int i = 0; i < 4; i++) {
            System.out.println("Turno de: " + jogo.proximoTurno());
        }

        // Eliminação
        System.out.println();
        jogo.eliminarJogador("Bruno");
        jogo.exibirJogadores();

        // Rodada 2
        System.out.println("\n--- Rodada 2 ---");
        for (int i = 0; i < jogo.getTotalJogadores(); i++) {
            System.out.println("Turno de: " + jogo.proximoTurno());
        }
    }
}
