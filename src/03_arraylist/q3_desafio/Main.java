// src/03_arraylist/q3_desafio/Main.java
package q3_desafio;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Questão 9 — Filtro de Alertas em Sistema de Monitoramento IoT (Desafio)
 *
 * Demonstra três estratégias de remoção de elementos de um ArrayList
 * durante a iteração:
 *   A) for tradicional (INCORRETA — pula elementos)
 *   B) Iterator.remove() (CORRETA — mantém consistência)
 *   C) removeIf() com lambda (MODERNA — concisa e segura)
 *
 * Referência: Goodrich & Tamassia — Cap. 7.4 (Iterators)
 *             Cormen — Cap. 10 (Elementary Data Structures)
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(">>> Sistema de Monitoramento IoT — Fábrica <<<\n");

        // --- Popula o painel com 10 alertas misturados ---
        PainelDeAlertas painel = new PainelDeAlertas();

        painel.registrar(new Alerta("Sensor-T01", "INFO",     "Temperatura estável em 22°C"));
        painel.registrar(new Alerta("Sensor-T02", "WARNING",  "Temperatura subindo: 38°C"));
        painel.registrar(new Alerta("Sensor-V01", "INFO",     "Vibração dentro do padrão"));
        painel.registrar(new Alerta("Sensor-P01", "CRITICAL", "Pressão acima do limite: 15 bar"));
        painel.registrar(new Alerta("Sensor-T03", "INFO",     "Temperatura estável em 21°C"));
        painel.registrar(new Alerta("Sensor-U01", "INFO",     "Umidade relativa: 55%"));
        painel.registrar(new Alerta("Sensor-V02", "WARNING",  "Vibração anômala detectada"));
        painel.registrar(new Alerta("Sensor-T04", "INFO",     "Temperatura estável em 23°C"));
        painel.registrar(new Alerta("Sensor-P02", "CRITICAL", "Vazamento detectado no duto 7"));
        painel.registrar(new Alerta("Sensor-E01", "WARNING",  "Consumo elétrico 20% acima da média"));

        System.out.println("--- Lista original de alertas (10 registros) ---");
        painel.exibirTodos();

        // ============================================================
        //  ESTRATÉGIA A — FOR TRADICIONAL (INCORRETA)
        //  Problema: ao remover o índice i, os elementos subsequentes
        //  são deslocados para a esquerda, mas i é incrementado
        //  normalmente, fazendo o próximo elemento ser "pulado".
        // ============================================================
        System.out.println("\n========== ESTRATÉGIA A: for tradicional (INCORRETA) ==========");
        ArrayList<Alerta> copiaA = new ArrayList<>(painel.getAlertas()); // Cópia independente

        System.out.println("Removendo alertas INFO com for (int i = 0; i < lista.size(); i++)...\n");

        int removidosA = 0;
        for (int i = 0; i < copiaA.size(); i++) {
            if (copiaA.get(i).getNivel().equals("INFO")) {
                System.out.println("  Removendo índice " + i + ": " + copiaA.get(i));
                copiaA.remove(i);
                removidosA++;
                // NOTA: i é incrementado pelo for, mas o próximo elemento
                // "caiu" para a posição i (shift para esquerda). Ele será pulado!
            }
        }

        System.out.println("\nResultado (Estratégia A) — Removidos: " + removidosA);
        System.out.println("ATENÇÃO: Alguns alertas INFO podem ter sobrevivido!");
        for (int i = 0; i < copiaA.size(); i++) {
            System.out.println("  [" + i + "] " + copiaA.get(i));
        }
        System.out.println("  Total restante: " + copiaA.size());

        // Verifica se ainda há INFO remanescentes
        int infoSobreviventes = 0;
        for (Alerta a : copiaA) {
            if (a.getNivel().equals("INFO")) {
                infoSobreviventes++;
            }
        }
        if (infoSobreviventes > 0) {
            System.out.println("  ⚠ FALHA: " + infoSobreviventes + " alerta(s) INFO não foi(foram) removido(s)!");
        }

        // ============================================================
        //  ESTRATÉGIA B — ITERATOR.REMOVE() (CORRETA)
        //  O Iterator mantém um cursor interno que é ajustado
        //  corretamente após a remoção, garantindo que nenhum
        //  elemento seja pulado.
        // ============================================================
        System.out.println("\n========== ESTRATÉGIA B: Iterator.remove() (CORRETA) ==========");
        ArrayList<Alerta> copiaB = new ArrayList<>(painel.getAlertas()); // Cópia independente

        System.out.println("Removendo alertas INFO com Iterator...\n");

        int removidosB = 0;
        Iterator<Alerta> iterator = copiaB.iterator();
        while (iterator.hasNext()) {
            Alerta alerta = iterator.next();
            if (alerta.getNivel().equals("INFO")) {
                System.out.println("  Removendo: " + alerta);
                iterator.remove(); // Remoção segura: atualiza o estado interno do Iterator
                removidosB++;
            }
        }

        System.out.println("\nResultado (Estratégia B) — Removidos: " + removidosB);
        for (int i = 0; i < copiaB.size(); i++) {
            System.out.println("  [" + i + "] " + copiaB.get(i));
        }
        System.out.println("  Total restante: " + copiaB.size());

        // ============================================================
        //  ESTRATÉGIA C — REMOVEIF() COM LAMBDA (MODERNA)
        //  Disponível desde Java 8. Internamente, o removeIf
        //  itera de forma segura e remove todos os elementos que
        //  satisfazem o Predicate fornecido.
        // ============================================================
        System.out.println("\n========== ESTRATÉGIA C: removeIf() com Lambda (MODERNA) ==========");
        ArrayList<Alerta> copiaC = new ArrayList<>(painel.getAlertas()); // Cópia independente

        System.out.println("Removendo alertas INFO com removeIf()...\n");

        int tamanhoAntes = copiaC.size();
        copiaC.removeIf(alerta -> alerta.getNivel().equals("INFO"));
        int removidosC = tamanhoAntes - copiaC.size();

        System.out.println("Resultado (Estratégia C) — Removidos: " + removidosC);
        for (int i = 0; i < copiaC.size(); i++) {
            System.out.println("  [" + i + "] " + copiaC.get(i));
        }
        System.out.println("  Total restante: " + copiaC.size());

        // ============================================================
        //  COMPARAÇÃO FINAL
        // ============================================================
        System.out.println("\n========== COMPARAÇÃO FINAL ==========");
        System.out.println("Lista original:      10 alertas (5 INFO, 3 WARNING, 2 CRITICAL)");
        System.out.println("Estratégia A (for):  " + copiaA.size() + " restantes — Removeu " + removidosA + " (INCORRETO: pulou elementos!)");
        System.out.println("Estratégia B (Iterator): " + copiaB.size() + " restantes — Removeu " + removidosB + " (CORRETO)");
        System.out.println("Estratégia C (removeIf): " + copiaC.size() + " restantes — Removeu " + removidosC + " (CORRETO)");
        System.out.println("======================================");
    }
}
