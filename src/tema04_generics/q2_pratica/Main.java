// src/tema04_generics/q2_pratica/Main.java
package tema04_generics.q2_pratica;

/**
 * Questão 11 — Cofre Digital Parametrizado (Prática)
 *
 * Demonstra o uso da classe genérica Cofre<T> com três tipos distintos:
 * - Cofre<String>  → documentos (Alice)
 * - Cofre<Double>  → quantias monetárias (Bruno)
 * - Cofre<Integer> → códigos de acesso (Carla)
 *
 * Após o Type Erasure, todas as instâncias compartilham o mesmo bytecode.
 * O compilador garante a segurança antes da execução.
 *
 * Referência: Goodrich & Tamassia — Cap. 2.5 (Generics)
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  QUESTÃO 11 — COFRE DIGITAL PARAMETRIZADO");
        System.out.println("==============================================\n");

        // ============================================================
        // COFRE 1: Cofre<String> — Documentos da Alice (capacidade 5)
        // ============================================================
        System.out.println("--- COFRE DE DOCUMENTOS (Alice) ---\n");

        Cofre<String> cofreAlice = new Cofre<>("Alice", 5);

        // Guardando 4 documentos
        cofreAlice.guardar("Certidão de Nascimento");
        cofreAlice.guardar("Contrato de Aluguel");
        cofreAlice.guardar("Escritura do Imóvel");
        cofreAlice.guardar("Procuração Autenticada");

        // Tentando guardar duplicata — deve ser rejeitado
        cofreAlice.guardar("Contrato de Aluguel");

        System.out.println();

        // Recuperando documento na posição 2
        String doc = cofreAlice.recuperar(2);
        System.out.println("  >> Documento recuperado (posição 2): " + doc);

        // Listando conteúdo
        cofreAlice.listarConteudo();

        // ============================================================
        // COFRE 2: Cofre<Double> — Quantias do Bruno (capacidade 3)
        // ============================================================
        System.out.println("--- COFRE DE QUANTIAS (Bruno) ---\n");

        Cofre<Double> cofreBruno = new Cofre<>("Bruno", 3);

        // Guardando 3 quantias (lota o cofre)
        cofreBruno.guardar(15000.00);
        cofreBruno.guardar(8750.50);
        cofreBruno.guardar(32400.00);

        // Tentando guardar 4ª quantia — deve exibir "Cofre lotado!"
        cofreBruno.guardar(5000.00);

        System.out.println();

        // Removendo quantia na posição 1
        Double removido = cofreBruno.remover(1);
        System.out.println("  >> Quantia removida: R$ " + removido);

        cofreBruno.listarConteudo();

        // ============================================================
        // COFRE 3: Cofre<Integer> — Códigos da Carla (capacidade 4)
        // ============================================================
        System.out.println("--- COFRE DE CÓDIGOS DE ACESSO (Carla) ---\n");

        Cofre<Integer> cofreCarla = new Cofre<>("Carla", 4);

        // Guardando 2 códigos de acesso
        cofreCarla.guardar(904271);
        cofreCarla.guardar(183650);

        System.out.println();

        // Verificando se um código específico está no cofre
        cofreCarla.contem(904271);
        cofreCarla.contem(999999);

        cofreCarla.listarConteudo();

        // ============================================================
        // RESUMO FINAL
        // ============================================================
        System.out.println("=".repeat(50));
        System.out.println("[CONCLUSÃO]");
        System.out.println("  Cofre<String>, Cofre<Double> e Cofre<Integer> usam");
        System.out.println("  a MESMA classe Cofre<T> — mas o compilador garante");
        System.out.println("  que cada um aceita APENAS o tipo declarado.");
        System.out.println("  Após o Type Erasure, existe UMA SÓ classe Cofre no bytecode.");
    }
}
