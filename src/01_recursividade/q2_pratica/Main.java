// src/01_recursividade/q2_pratica/Main.java
package q2_pratica;

public class Main {

    /**
     * Verifica se uma string é um palíndromo utilizando recursividade.
     * 
     * @param codigo A string limpa a ser verificada.
     * @param inicio O índice inicial da verificação.
     * @param fim O índice final da verificação.
     * @return true se for palíndromo, false caso contrário.
     */
    public static boolean isPalindromo(String codigo, int inicio, int fim) {
        // Caso base 1: Se os índices se cruzaram ou se igualaram, todos os pares foram verificados e são iguais.
        if (inicio >= fim) {
            return true;
        }
        
        // Caso base 2: Se os caracteres nas extremidades atuais são diferentes, não é palíndromo.
        if (codigo.charAt(inicio) != codigo.charAt(fim)) {
            return false;
        }
        
        // Passo recursivo: verificar os caracteres mais internos (avançando o início e recuando o fim).
        return isPalindromo(codigo, inicio + 1, fim - 1);
    }

    public static void main(String[] args) {
        String[] testes = {"Ovo", "Ame o poema", "Senha123"};
        
        System.out.println("Validador de Códigos de Segurança");
        System.out.println("---------------------------------");
        
        for (String teste : testes) {
            // Tratamento: removendo espaços e convertendo para minúsculas
            String limpa = teste.replaceAll("\\s+", "").toLowerCase();
            
            boolean resultado = isPalindromo(limpa, 0, limpa.length() - 1);
            
            System.out.println("Código original: '" + teste + "'");
            System.out.println("Código limpo: '" + limpa + "'");
            System.out.println("É válido (palíndromo)? " + (resultado ? "Sim" : "Não"));
            System.out.println("-");
        }
    }
}
