// src/03_arraylist/q1_conceito/Main.java
package q1_conceito;

import java.util.ArrayList;

/**
 * Questão 7 — Registro de Check-ins em Museu (Conceito)
 *
 * Demonstra o uso básico do ArrayList<String> para armazenar uma
 * quantidade imprevisível de visitantes, explorando os métodos
 * fundamentais da API Collections: add(), size(), get(), contains()
 * e iteração com for-each.
 *
 * Referência: Goodrich & Tamassia — Cap. 7 (List Abstractions)
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(">>> Sistema de Check-in — Museu Interativo <<<\n");

        // Cria o ArrayList — não é preciso definir tamanho fixo!
        // Internamente, o Java aloca um array com capacidade inicial de 10.
        ArrayList<String> visitantes = new ArrayList<>();

        // --- Simulação: 8 visitantes chegam ao museu ---
        System.out.println("--- Registrando check-ins ---");
        visitantes.add("Ana Beatriz");
        visitantes.add("Carlos Eduardo");
        visitantes.add("Diana Rocha");
        visitantes.add("Eduardo Mendes");
        visitantes.add("Fernanda Oliveira");
        visitantes.add("Gustavo Almeida");
        visitantes.add("Helena Costa");
        visitantes.add("Igor Nascimento");

        // Exibe cada adição para acompanhar
        for (int i = 0; i < visitantes.size(); i++) {
            System.out.println("[CHECK-IN] Visitante #" + (i + 1) + ": " + visitantes.get(i));
        }

        // --- Total de visitantes com size() ---
        System.out.println("\n--- Resumo do dia ---");
        System.out.println("Total de visitantes registrados: " + visitantes.size());

        // --- Consulta do 3º visitante (índice 2) com get() ---
        String terceiroVisitante = visitantes.get(2);
        System.out.println("3º visitante (índice 2): " + terceiroVisitante);

        // --- Verifica presença com contains() ---
        String buscado = "Fernanda Oliveira";
        boolean encontrado = visitantes.contains(buscado);
        System.out.println("\"" + buscado + "\" está na lista? " + (encontrado ? "SIM ✓" : "NÃO ✗"));

        String naoVisitou = "Roberto Silva";
        boolean naoEncontrado = visitantes.contains(naoVisitou);
        System.out.println("\"" + naoVisitou + "\" está na lista? " + (naoEncontrado ? "SIM ✓" : "NÃO ✗"));

        // --- Lista completa com for-each ---
        System.out.println("\n--- Lista completa de visitantes ---");
        int contador = 1;
        for (String visitante : visitantes) {
            System.out.println("  " + contador + ". " + visitante);
            contador++;
        }

        System.out.println("\n[FIM] Sistema encerrado. " + visitantes.size() + " check-ins registrados hoje.");
    }
}
