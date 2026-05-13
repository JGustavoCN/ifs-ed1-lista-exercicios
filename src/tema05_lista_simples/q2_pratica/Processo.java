// src/tema05_lista_simples/q2_pratica/Processo.java
package tema05_lista_simples.q2_pratica;

/**
 * Classe Processo — Representa um processo em execução no S.O.
 *
 * Cada processo possui um identificador único (pid) e um nome descritivo.
 */
public class Processo {

    int pid;       // Identificador único do processo
    String nome;   // Nome do processo (ex: "navegador", "editor")

    /**
     * Construtor parametrizado.
     *
     * @param pid  identificador único do processo
     * @param nome nome descritivo do processo
     */
    public Processo(int pid, String nome) {
        this.pid = pid;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PID=" + pid + " (" + nome + ")";
    }
}
