// src/04_generics/q1_conceito/Main.java
package q1_conceito;

/**
 * Questão 10 — Laboratório de Análises Clínicas (Conceito)
 *
 * Demonstra o contraste entre o uso de Object[] (sem segurança de tipos)
 * e a classe genérica Tubo<T> (com segurança em tempo de compilação).
 *
 * Referência: Goodrich & Tamassia — Cap. 2.5 (Generics)
 *             Cormen — Conceito de abstração de tipos
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  QUESTÃO 10 — LABORATÓRIO DE ANÁLISES CLÍNICAS");
        System.out.println("==============================================\n");

        // ============================================================
        // PARTE A — SEM GENERICS (código problemático com Object[])
        // ============================================================
        System.out.println("--- PARTE A: Sem Generics (Object[]) ---\n");

        Object[] amostras = new Object[3];
        amostras[0] = "O+";          // String — tipo sanguíneo
        amostras[1] = 7500;          // Integer — contagem de leucócitos
        amostras[2] = 99.7;          // Double — taxa de glicose

        System.out.println("Amostras armazenadas no array Object[]:");
        System.out.println("  [0] Tipo sanguíneo: " + amostras[0]);
        System.out.println("  [1] Leucócitos:     " + amostras[1]);
        System.out.println("  [2] Glicose:        " + amostras[2]);
        System.out.println();

        // Casting correto — funciona, mas exige que o programador "saiba" o tipo
        String tipoSanguineo = (String) amostras[0];
        System.out.println("[OK] Casting correto: tipoSanguineo = " + tipoSanguineo);

        // Casting INCORRETO — compila sem erros, mas explode em tempo de execução!
        // O compilador não tem como saber que amostras[1] é Integer e não String.
        try {
            System.out.println("\n[PERIGO] Tentando casting de Integer para String...");
            String valorErrado = (String) amostras[1]; // ClassCastException!
            System.out.println("Valor: " + valorErrado); // Nunca chega aqui
        } catch (ClassCastException e) {
            System.out.println("[ERRO] ClassCastException capturada!");
            System.out.println("  Mensagem: " + e.getMessage());
            System.out.println("  >> Sem Generics, o compilador NÃO consegue detectar");
            System.out.println("     esse erro. Ele só aparece quando o programa roda.");
        }

        System.out.println("\n" + "=".repeat(50));

        // ============================================================
        // PARTE B — COM GENERICS (solução segura com Tubo<T>)
        // ============================================================
        System.out.println("\n--- PARTE B: Com Generics (Tubo<T>) ---\n");

        // Cada tubo é parametrizado com um tipo específico
        Tubo<String> tuboSangue = new Tubo<>();
        Tubo<Integer> tuboLeucocitos = new Tubo<>();
        Tubo<Double> tuboGlicose = new Tubo<>();

        // Inserção tipada — o compilador garante que só aceita o tipo correto
        tuboSangue.inserir("AB-");
        tuboLeucocitos.inserir(8200);
        tuboGlicose.inserir(105.3);

        System.out.println();

        // Retirada SEM casting — o retorno já é do tipo correto
        String sangue = tuboSangue.retirar();         // Retorna String diretamente
        Integer leucocitos = tuboLeucocitos.retirar(); // Retorna Integer diretamente
        Double glicose = tuboGlicose.retirar();        // Retorna Double diretamente

        System.out.println("Amostras retiradas (sem casting):");
        System.out.println("  Tipo sanguíneo: " + sangue);
        System.out.println("  Leucócitos:     " + leucocitos);
        System.out.println("  Glicose:        " + glicose);

        System.out.println();

        // DEMONSTRAÇÃO: Tentativa de inserir tipo incompatível
        // A linha abaixo, se descomentada, gera ERRO DE COMPILAÇÃO:
        //
        // tuboSangue.inserir(42);  // ERRO: incompatible types: int cannot be converted to String
        //
        // >> Com Generics, o erro é detectado pelo COMPILADOR (tempo de compilação),
        //    e NÃO em tempo de execução como na Parte A. Isso é "Type Safety".
        System.out.println("[INFO] Tentativa de 'tuboSangue.inserir(42)' geraria ERRO DE COMPILAÇÃO.");
        System.out.println("       O compilador protege o código antes mesmo de ele ser executado!");

        System.out.println("\n" + "=".repeat(50));
        System.out.println("\n[CONCLUSÃO]");
        System.out.println("  Parte A (Object[]): Erros só aparecem em EXECUÇÃO (ClassCastException).");
        System.out.println("  Parte B (Tubo<T>):  Erros são detectados em COMPILAÇÃO (Type Safety).");
        System.out.println("  >> Generics eliminam castings e previnem bugs antes do deploy.");
    }
}
