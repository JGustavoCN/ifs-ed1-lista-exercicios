// src/tema05_lista_simples/q1_conceito/Main.java
package tema05_lista_simples.q1_conceito;

/**
 * Questão 13 — Correia Transportadora de Fábrica (Conceito)
 *
 * Demonstra a criação e uso de uma Lista Simplesmente Encadeada
 * com operações de inserção no início (O(1)) e no final (O(n)).
 *
 * Referência: Goodrich & Tamassia — Cap. 3.2 (Singly Linked Lists)
 *             Cormen — Seção 10.2 (Linked Lists)
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  QUESTÃO 13 — CORREIA TRANSPORTADORA DE FÁBRICA");
        System.out.println("==============================================\n");

        CorreiaTransportadora correia = new CorreiaTransportadora();

        // ============================================================
        // 1. Adicionar 3 caixas no final da correia
        // ============================================================
        System.out.println("--- Passo 1: Adicionando 3 caixas no FINAL ---\n");

        correia.adicionarNoFim("CX-101");
        correia.adicionarNoFim("CX-102");
        correia.adicionarNoFim("CX-103");

        // ============================================================
        // 2. Exibir a correia
        // ============================================================
        System.out.println("\n--- Passo 2: Estado atual da correia ---\n");
        correia.exibirCorreia();
        System.out.println("   Tamanho: " + correia.tamanho + " caixas");

        // ============================================================
        // 3. Adicionar 1 caixa no início (urgente)
        // ============================================================
        System.out.println("\n--- Passo 3: Adicionando caixa URGENTE no INÍCIO ---\n");
        correia.adicionarNoInicio("CX-URGENTE");

        // ============================================================
        // 4. Exibir a correia novamente com o tamanho atualizado
        // ============================================================
        System.out.println("\n--- Passo 4: Estado final da correia ---\n");
        correia.exibirCorreia();
        System.out.println("   Tamanho: " + correia.tamanho + " caixas");

        // ============================================================
        // Análise de complexidade
        // ============================================================
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\n[ANÁLISE DE COMPLEXIDADE]");
        System.out.println("  adicionarNoInicio(): O(1) — apenas redireciona ponteiros.");
        System.out.println("  adicionarNoFim():    O(n) — percorre toda a lista.");
        System.out.println("  >> Em arrays, a situação é INVERSA:");
        System.out.println("     inserir no final: O(1), inserir no início: O(n) (shift).");
        System.out.println("  >> Lista encadeada: ideal para inserções frequentes no início.");
    }
}
