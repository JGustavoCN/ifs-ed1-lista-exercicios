// src/07_lista_circular_simples/q3_desafio/Main.java
package q3_desafio;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== QUESTÃO 21: ESCALONADOR ROUND ROBIN (DESAFIO) ===\n");

        EscalonadorRoundRobin scheduler = new EscalonadorRoundRobin(20);

        scheduler.adicionarProcesso(1, "Chrome", 50);
        scheduler.adicionarProcesso(2, "VSCode", 20);
        scheduler.adicionarProcesso(3, "Spotify", 30);

        scheduler.executar();
    }
}
