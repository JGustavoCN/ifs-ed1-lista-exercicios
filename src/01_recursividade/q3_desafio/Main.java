// src/01_recursividade/q3_desafio/Main.java
package q3_desafio;

public class Main {

    /**
     * Realiza uma busca binária recursiva para encontrar o ID de uma transação.
     * 
     * @param transacoes Array contendo os IDs das transações, estritamente ordenado.
     * @param alvo ID da transação procurada.
     * @param inicio Índice inferior do sub-array atual.
     * @param fim Índice superior do sub-array atual.
     * @return O índice onde a transação se encontra, ou -1 se não for encontrada.
     */
    public static int buscarTransacao(int[] transacoes, int alvo, int inicio, int fim) {
        // Caso base 1: Os limites se cruzaram, indicando que o elemento não está no array.
        if (inicio > fim) {
            return -1;
        }
        
        // Encontra o ponto médio para dividir o array (evita overflow se os índices fossem muito grandes).
        int meio = inicio + (fim - inicio) / 2;
        
        // Caso base 2: Elemento encontrado no meio.
        if (transacoes[meio] == alvo) {
            return meio;
        }
        
        // Passo recursivo: Se o alvo é menor que o elemento central, buscar na metade inferior.
        if (alvo < transacoes[meio]) {
            return buscarTransacao(transacoes, alvo, inicio, meio - 1);
        } else {
            // Se o alvo é maior, buscar na metade superior.
            return buscarTransacao(transacoes, alvo, meio + 1, fim);
        }
    }

    public static void main(String[] args) {
        // Array obrigatoriamente ordenado simulando IDs de transações financeiras.
        int[] idsTransacoes = {105, 214, 332, 451, 560, 678, 799, 810, 925, 1040};
        
        System.out.println("Rastreador de Transações Financeiras (Busca Binária)");
        System.out.println("----------------------------------------------------");
        
        // Teste 1: Buscar ID existente
        int idProcurado1 = 799;
        int indiceEncontrado1 = buscarTransacao(idsTransacoes, idProcurado1, 0, idsTransacoes.length - 1);
        
        System.out.println("Buscando transação ID: " + idProcurado1);
        if (indiceEncontrado1 != -1) {
            System.out.println("Transação encontrada no índice: " + indiceEncontrado1);
        } else {
            System.out.println("Alerta: Transação NÃO encontrada.");
        }
        
        System.out.println("-");
        
        // Teste 2: Buscar ID inexistente
        int idProcurado2 = 500;
        int indiceEncontrado2 = buscarTransacao(idsTransacoes, idProcurado2, 0, idsTransacoes.length - 1);
        
        System.out.println("Buscando transação ID: " + idProcurado2);
        if (indiceEncontrado2 != -1) {
            System.out.println("Transação encontrada no índice: " + indiceEncontrado2);
        } else {
            System.out.println("Alerta: Transação NÃO encontrada no sistema.");
        }
    }
}
