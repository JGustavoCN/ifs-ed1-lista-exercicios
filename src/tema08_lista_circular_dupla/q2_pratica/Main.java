// src/tema08_lista_circular_dupla/q2_pratica/Main.java
package tema08_lista_circular_dupla.q2_pratica;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== QUESTÃO 23: PLAYER PREMIUM (PRÁTICA) ===\n");

        PlayerPremium player = new PlayerPremium();
        player.adicionar(new Musica("Starboy", "The Weeknd"));
        player.adicionar(new Musica("Flowers", "Miley Cyrus"));
        player.adicionar(new Musica("Shape of You", "Ed Sheeran"));

        System.out.println("Iniciando com: " + player.getTocando());
        
        System.out.println("\n--- Navegando ---");
        player.proxima();   // Vai para Flowers
        player.anterior();  // Volta para Starboy
        player.anterior();  // SALTA PARA O FIM (Shape of You) - Loop Infinito!
        player.anterior();  // Volta para Flowers
    }
}
