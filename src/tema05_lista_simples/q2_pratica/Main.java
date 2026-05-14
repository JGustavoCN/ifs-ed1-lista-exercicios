// src/tema05_lista_simples/q2_pratica/Main.java
package tema05_lista_simples.q2_pratica;

/**
 * Questão 14 — Gerenciador de Processos de Sistema Operacional (Prática)
 *
 * Demonstra operações clássicas de manipulação de ponteiros em uma
 * Lista Simplesmente Encadeada: inserção no início, inserção no final
 * e remoção da cabeça.
 *
 * Referência: Goodrich & Tamassia — Cap. 3.2 (Singly Linked Lists)
 *             Cormen — Seção 10.2 (Linked Lists)
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  QUESTÃO 14 — GERENCIADOR DE PROCESSOS DO S.O.");
        System.out.println("==============================================\n");

        ListaDeProcessos lista = new ListaDeProcessos();

        // ============================================================
        // 1. Iniciar 3 processos no início
        // ============================================================
        System.out.println("--- Passo 1: Iniciando 3 processos no INÍCIO ---\n");

        lista.iniciarProcesso(new Processo(1, "kernel"));
        lista.iniciarProcesso(new Processo(2, "navegador"));
        lista.iniciarProcesso(new Processo(3, "editor"));

        // Nota: a cabeça agora é o último inserido (editor),
        // pois cada inserção no início "empurra" os anteriores.

        // ============================================================
        // 2. Iniciar 1 processo no final
        // ============================================================
        System.out.println("\n--- Passo 2: Iniciando 1 processo no FINAL ---\n");

        lista.iniciarProcessoNoFim(new Processo(4, "backup"));

        // ============================================================
        // 3. Exibir todos os processos ativos
        // ============================================================
        System.out.println("\n--- Passo 3: Processos ativos ---\n");
        lista.exibirProcessos();
        System.out.println("   Total: " + lista.contarProcessos() + " processos");

        // ============================================================
        // 4. Finalizar o primeiro processo (cabeça)
        // ============================================================
        System.out.println("\n--- Passo 4: Finalizando o primeiro processo ---\n");

        Processo finalizado = lista.finalizarPrimeiro();
        if (finalizado != null) {
            System.out.println("   >>> Processo finalizado: " + finalizado);
        }

        // ============================================================
        // 5. Exibir lista atualizada e contagem
        // ============================================================
        System.out.println("\n--- Passo 5: Estado após finalização ---\n");
        lista.exibirProcessos();
        System.out.println("   Total: " + lista.contarProcessos() + " processos");

        // ============================================================
        // Análise de complexidade
        // ============================================================
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\n[ANÁLISE DE COMPLEXIDADE]");
        System.out.println("  iniciarProcesso():       O(1) — insere no início.");
        System.out.println("  iniciarProcessoNoFim():  O(n) — percorre toda a lista.");
        System.out.println("  finalizarPrimeiro():     O(1) — remove a cabeça.");
        System.out.println("\n[DICA] Para tornar inserção no fim O(1), basta");
        System.out.println("  manter um ponteiro 'cauda' (tail) apontando sempre");
        System.out.println("  para o último nó da lista.");
    }
}
