// src/tema03_arraylist/q2_pratica/Main.java
package tema03_arraylist.q2_pratica;

public class Main {

    public static void main(String[] args) {
        GerenciadorEncomendas gerenciador = new GerenciadorEncomendas();

        System.out.println(">>> Sistema de Encomendas — Transportadora Regional <<<\n");

        // --- Etapa 1: Registrar 6 encomendas ---
        System.out.println("--- Registrando encomendas do dia ---");
        gerenciador.registrar("BR123456789");
        gerenciador.registrar("BR987654321");
        gerenciador.registrar("BR555111222");
        gerenciador.registrar("BR444333666");
        gerenciador.registrar("BR777888999");
        gerenciador.registrar("BR111222333");
        gerenciador.exibirPainel();

        // --- Etapa 2: Tentar registrar duplicata ---
        System.out.println("--- Tentando registrar código duplicado ---");
        gerenciador.registrar("BR555111222"); // Deve ser rejeitado
        System.out.println();

        // --- Etapa 3: Inserir encomenda urgente na posição 0 ---
        System.out.println("--- Inserindo encomenda urgente ---");
        gerenciador.inserirUrgente(0, "BR000URGENTE");
        gerenciador.exibirPainel();

        // --- Etapa 4: Consultar encomenda na posição 3 ---
        System.out.println("--- Consultando encomenda na posição 3 ---");
        gerenciador.consultar(3);
        System.out.println();

        // --- Etapa 5: Localizar encomenda pelo código ---
        System.out.println("--- Localizando encomenda por código ---");
        gerenciador.localizar("BR777888999");
        gerenciador.localizar("BR000INEXISTENTE"); // Não existe
        System.out.println();

        // --- Etapa 6: Despachar 2 encomendas ---
        System.out.println("--- Despachando encomendas ---");
        gerenciador.despachar("BR123456789");
        gerenciador.despachar("BR444333666");
        System.out.println();

        // --- Etapa 7: Painel final ---
        System.out.println("--- Painel final ---");
        gerenciador.exibirPainel();

        System.out.println("=== Estado Final ===");
        System.out.println("Encomendas pendentes: " + gerenciador.getQuantidade());
    }
}
