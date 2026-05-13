// src/06_lista_dupla/q2_pratica/Main.java
package q2_pratica;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== QUESTÃO 17: SISTEMA UNDO/REDO (PRÁTICA) ===\n");

        EditorUndoRedo editor = new EditorUndoRedo();

        editor.novaAcao("Digitar 'Olá'");
        editor.novaAcao("Digitar 'Mundo'");
        editor.exibirStatus();

        editor.undo();
        editor.exibirStatus();

        // Ao fazer uma nova ação estando no meio do histórico, o "Mundo" deve sumir do Redo
        editor.novaAcao("Digitar 'Pessoal'");
        editor.exibirStatus();

        System.out.println("\nTentando Redo após nova ação:");
        editor.redo(); // Deve avisar que não há nada para refazer
    }
}
