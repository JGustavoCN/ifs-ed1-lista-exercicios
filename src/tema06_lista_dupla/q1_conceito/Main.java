// src/tema06_lista_dupla/q1_conceito/Main.java
package tema06_lista_dupla.q1_conceito;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== QUESTÃO 16: HISTÓRICO DE NAVEGAÇÃO (CONCEITO) ===\n");

        HistoricoBrowser historico = new HistoricoBrowser();

        historico.visitar("google.com");
        historico.visitar("github.com");
        historico.visitar("stackoverflow.com");

        System.out.println();
        historico.exibirOrdemDireta();
        historico.exibirOrdemReversa();

        System.out.println("\nTamanho do histórico: " + historico.getTamanho());
    }
}
