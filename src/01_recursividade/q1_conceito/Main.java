// src/01_recursividade/q1_conceito/Main.java
package q1_conceito;

public class Main {
    
    /**
     * Calcula a soma total de peças defeituosas utilizando recursividade linear.
     * 
     * @param registros Array contendo a quantidade de peças defeituosas.
     * @param n O número de elementos a serem considerados (atua como índice limitador).
     * @return A soma total dos defeitos.
     */
    public static int somarDefeitos(int[] registros, int n) {
        // Caso base: se não há elementos para somar, a soma é 0.
        if (n <= 0) {
            return 0;
        }
        
        // Passo recursivo: soma o elemento atual (n-1) com o retorno da chamada para os demais elementos.
        return registros[n - 1] + somarDefeitos(registros, n - 1);
    }

    public static void main(String[] args) {
        int[] defeitos = {2, 5, 1, 0, 4};
        
        int total = somarDefeitos(defeitos, defeitos.length);
        
        System.out.println("Relatório de Auditoria de Lotes");
        System.out.println("-------------------------------");
        System.out.println("Total de peças defeituosas: " + total);
    }
}
