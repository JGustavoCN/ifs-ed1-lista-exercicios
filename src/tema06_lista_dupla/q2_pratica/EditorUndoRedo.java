// src/tema06_lista_dupla/q2_pratica/EditorUndoRedo.java
package tema06_lista_dupla.q2_pratica;

/**
 * Classe EditorUndoRedo — Gerencia histórico de ações permitindo desfazer e refazer.
 * Implementa a lógica de descarte de estados futuros ao realizar nova ação após undo.
 */
public class EditorUndoRedo {
    private NoDuplo cabeca;
    private NoDuplo cursorAtual;

    public EditorUndoRedo() {
        cabeca = null;
        cursorAtual = null;
    }

    /**
     * Registra uma nova ação. Se houver ações futuras (redo), elas são descartadas.
     * @param acao descrição da ação
     */
    public void novaAcao(String acao) {
        NoDuplo novo = new NoDuplo(acao);

        if (cabeca == null) {
            cabeca = novo;
            cursorAtual = novo;
        } else {
            // Descartar ramificações futuras (Redo path)
            // O cursor atual passa a apontar para o novo, e o novo aponta para o cursor
            novo.anterior = cursorAtual;
            cursorAtual.proximo = novo;
            cursorAtual = novo; // Move o cursor para o estado mais recente
        }
        System.out.println("[AÇÃO] " + acao);
    }

    /**
     * Volta para a ação anterior.
     */
    public void undo() {
        if (cursorAtual != null && cursorAtual.anterior != null) {
            cursorAtual = cursorAtual.anterior;
            System.out.println("[UNDO] Estado atual: " + cursorAtual.acao);
        } else if (cursorAtual != null) {
            System.out.println("[UNDO] Você já está na primeira ação: " + cursorAtual.acao);
        } else {
            System.out.println("[UNDO] Nenhuma ação para desfazer.");
        }
    }

    /**
     * Avança para a próxima ação (se existir).
     */
    public void redo() {
        if (cursorAtual != null && cursorAtual.proximo != null) {
            cursorAtual = cursorAtual.proximo;
            System.out.println("[REDO] Estado atual: " + cursorAtual.acao);
        } else {
            System.out.println("[REDO] Nada para refazer.");
        }
    }

    public void exibirStatus() {
        System.out.print("Histórico: ");
        NoDuplo aux = cabeca;
        while (aux != null) {
            if (aux == cursorAtual) System.out.print(">"); // Indica posição do cursor
            System.out.print("[" + aux.acao + "] ");
            aux = aux.proximo;
        }
        System.out.println();
    }
}
