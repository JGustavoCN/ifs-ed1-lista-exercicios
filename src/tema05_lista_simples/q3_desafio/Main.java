// src/tema05_lista_simples/q3_desafio/Main.java
package tema05_lista_simples.q3_desafio;

/**
 * Questão 15 — Central de Ocorrências Policiais (Desafio)
 * 
 * Demonstra a manipulação de uma Lista Simplesmente Encadeada em um cenário real,
 * focando em buscas seguras e remoções em qualquer posição (cabeça, meio, fim).
 * 
 * Referência: Goodrich & Tamassia — Cap. 3.2 (Singly Linked Lists)
 *             Cormen — Seção 10.2 (Linked Lists)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("  QUESTÃO 15 — CENTRAL DE OCORRÊNCIAS POLICIAIS");
        System.out.println("==============================================\n");

        CentralOcorrencias central = new CentralOcorrencias();

        // 1. Registrar 5 boletins de ocorrência
        System.out.println("--- Passo 1: Registrando 5 B.O.s ---");
        central.registrar(new BoletimOcorrencia(1001, "Furto", "Celular levado no centro."));
        central.registrar(new BoletimOcorrencia(1002, "Acidente", "Colisão leve entre dois carros."));
        central.registrar(new BoletimOcorrencia(1003, "Agressão", "Discussão em bar que terminou em briga."));
        central.registrar(new BoletimOcorrencia(1004, "Perda", "Carteira perdida no parque."));
        central.registrar(new BoletimOcorrencia(1005, "Outros", "Som alto perturbando a vizinhança."));

        // 2. Listar todas as ocorrências
        central.listarOcorrencias();

        // 3. Buscar o B.O. número 1003
        System.out.println("--- Passo 3: Buscando B.O. #1003 ---");
        BoletimOcorrencia bo1003 = central.buscarPorNumero(1003);
        if (bo1003 != null) {
            System.out.println("Encontrado: " + bo1003);
        } else {
            System.out.println("B.O. #1003 não encontrado.");
        }
        System.out.println();

        // 4. Buscar um B.O. inexistente
        System.out.println("--- Passo 4: Buscando B.O. inexistente (#9999) ---");
        BoletimOcorrencia boInexistente = central.buscarPorNumero(9999);
        if (boInexistente != null) {
            System.out.println("Encontrado: " + boInexistente);
        } else {
            System.out.println("[OK] B.O. #9999 não encontrado (conforme esperado).");
        }
        System.out.println();

        // 5. Remover o B.O. 1001 (cabeça da lista)
        System.out.println("--- Passo 5: Removendo B.O. #1001 (Cabeça) ---");
        central.removerPorNumero(1001);
        central.listarOcorrencias();

        // 6. Remover o B.O. 1003 (meio da lista)
        System.out.println("--- Passo 6: Removendo B.O. #1003 (Meio) ---");
        central.removerPorNumero(1003);
        central.listarOcorrencias();

        // 7. Remover o B.O. 1005 (final da lista)
        System.out.println("--- Passo 7: Removendo B.O. #1005 (Fim) ---");
        central.removerPorNumero(1005);
        central.listarOcorrencias();
        System.out.println("Total de ocorrências restantes: " + central.totalOcorrencias());
        System.out.println();

        // 8. Tentar remover o B.O. 9999 (inexistente)
        System.out.println("--- Passo 8: Removendo B.O. inexistente (#9999) ---");
        central.removerPorNumero(9999);

        System.out.println("\n" + "=".repeat(50));
        System.out.println("\n[CONCEITOS CHAVE APLICADOS]");
        System.out.println("  1. Travessia de Ponteiros: Uso do 'atual = atual.proximo' para navegar.");
        System.out.println("  2. Ponteiro Anterior: Essencial para 'religar' a lista ao remover um nó.");
        System.out.println("  3. Casos de Borda: Tratamento específico para cabeça, fim e lista vazia.");
        System.out.println("  4. Segurança: Verificação de null antes de acessar atributos (NullPointerException).");
    }
}
