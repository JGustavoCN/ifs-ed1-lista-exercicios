// src/tema06_lista_dupla/q3_desafio/Main.java
package tema06_lista_dupla.q3_desafio;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== QUESTÃO 18: PLAYLIST COM REORDENAÇÃO (DESAFIO) ===\n");

        PlaylistDupla minhaLista = new PlaylistDupla();

        minhaLista.adicionar("Musica 1");
        minhaLista.adicionar("Musica 3");
        minhaLista.exibir();

        // Inserindo M2 entre M1 e M3
        minhaLista.inserirEntre("Musica 2", "Musica 1", "Musica 3");
        minhaLista.exibir();

        // Removendo M1 (testa religação com o header)
        minhaLista.remover("Musica 1");
        minhaLista.exibir();
    }
}
