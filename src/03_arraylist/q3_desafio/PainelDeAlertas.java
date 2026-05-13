// src/03_arraylist/q3_desafio/PainelDeAlertas.java
package q3_desafio;

import java.util.ArrayList;

/**
 * Questão 9 — Painel de Alertas
 *
 * Encapsula um ArrayList<Alerta> para gerenciar a lista de alertas
 * gerados pelos sensores IoT da fábrica.
 */
public class PainelDeAlertas {

    private ArrayList<Alerta> alertas;

    public PainelDeAlertas() {
        this.alertas = new ArrayList<>();
    }

    /**
     * Registra um novo alerta no painel.
     *
     * @param alerta O alerta a ser registrado.
     */
    public void registrar(Alerta alerta) {
        alertas.add(alerta);
    }

    /**
     * Exibe todos os alertas registrados com seus dados.
     */
    public void exibirTodos() {
        System.out.println("--------------------------------------");
        if (alertas.isEmpty()) {
            System.out.println("  (nenhum alerta registrado)");
        } else {
            for (int i = 0; i < alertas.size(); i++) {
                System.out.println("  [" + i + "] " + alertas.get(i));
            }
        }
        System.out.println("  Total: " + alertas.size() + " alerta(s)");
        System.out.println("--------------------------------------");
    }

    /**
     * Retorna uma referência à lista interna de alertas.
     * Usada pelo Main para criar cópias e testar as estratégias de remoção.
     *
     * @return A lista de alertas.
     */
    public ArrayList<Alerta> getAlertas() {
        return alertas;
    }
}
