// src/tema02_array_primitivo/q2_pratica/Main.java
package tema02_array_primitivo.q2_pratica;

public class Main {

    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        System.out.println(">>> Gerenciador de Playlist Musical <<<\n");

        // --- Etapa 1: Adicionar 5 músicas no final ---
        System.out.println("--- Adicionando 5 músicas ao final ---");
        playlist.adicionarNoFim("Bohemian Rhapsody");
        playlist.adicionarNoFim("Stairway to Heaven");
        playlist.adicionarNoFim("Hotel California");
        playlist.adicionarNoFim("Imagine");
        playlist.adicionarNoFim("Smells Like Teen Spirit");
        playlist.exibir();

        // --- Etapa 2: Inserir na posição 2 (shift para a direita) ---
        System.out.println("--- Inserindo na posição 2 ---");
        playlist.inserirNaPosicao(2, "Wish You Were Here");
        playlist.exibir();

        // --- Etapa 3: Remover da posição 0 (shift para a esquerda) ---
        System.out.println("--- Removendo da posição 0 ---");
        playlist.removerDaPosicao(0);
        playlist.exibir();

        // --- Resumo final ---
        System.out.println("=== Estado Final ===");
        System.out.println("Músicas na playlist: " + playlist.getTamanho());
        System.out.println("Capacidade total: " + playlist.getCapacidade());
    }
}
