// src/02_array_primitivo/q3_desafio/Main.java
package q3_desafio;

public class Main {

    public static void main(String[] args) {
        FilaDeSenhas fila = new FilaDeSenhas();

        System.out.println(">>> Sistema de Senhas de Atendimento Hospitalar <<<\n");

        // --- Etapa 1: Chamar 5 senhas normais (lota a fila) ---
        System.out.println("--- Emitindo 5 senhas (lotando a fila) ---");
        fila.chamarProximaSenha(); // Senha 1
        fila.chamarProximaSenha(); // Senha 2
        fila.chamarProximaSenha(); // Senha 3
        fila.chamarProximaSenha(); // Senha 4
        fila.chamarProximaSenha(); // Senha 5
        fila.exibirFila();

        // --- Etapa 2: Tentar chamar 6ª senha (fila lotada) ---
        System.out.println("--- Tentando emitir 6ª senha ---");
        fila.chamarProximaSenha(); // Deve exibir "Fila lotada!"
        System.out.println();

        // --- Etapa 3: Redimensionar para capacidade 10 ---
        System.out.println("--- Redimensionando a fila ---");
        fila.redimensionar(10);
        fila.exibirFila();

        // --- Etapa 4: Encaixar prioritário na posição 0 ---
        System.out.println("--- Encaixando paciente prioritário ---");
        fila.encaixarPrioritario(0); // Senha 6, na posição 0
        fila.exibirFila();

        // --- Etapa 5: Paciente da posição 3 desiste ---
        System.out.println("--- Paciente na posição 3 desistiu ---");
        fila.desistir(3);
        fila.exibirFila();

        // --- Resumo final ---
        System.out.println("=== Estado Final ===");
        System.out.println("Senhas na fila: " + fila.getQuantidade());
        System.out.println("Capacidade total: " + fila.getCapacidade());
    }
}
