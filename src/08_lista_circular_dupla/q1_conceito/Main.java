// src/08_lista_circular_dupla/q1_conceito/Main.java
package q1_conceito;

/**
 * Questão 22 — Carrossel de Imagens de um Site (Conceito)
 * 
 * Demonstra a estrutura de uma Lista Circular Duplamente Encadeada,
 * onde a navegação é infinita para ambos os lados.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("  QUESTÃO 22: CARROSSEL DE IMAGENS (CONCEITO)");
        System.out.println("==============================================\n");

        CarrosselCircular carrossel = new CarrosselCircular();
        carrossel.adicionarImagem("Foto_Praia.jpg");
        carrossel.adicionarImagem("Foto_Montanha.jpg");
        carrossel.adicionarImagem("Foto_Cidade.jpg");

        System.out.println();
        carrossel.exibirHorario();
        carrossel.exibirAntiHorario();
        
        System.out.println("\n[OBS] Note como o 'anterior' da primeira foto");
        System.out.println("      leva à última, e o 'proximo' da última");
        System.out.println("      leva de volta à primeira.");
    }
}
