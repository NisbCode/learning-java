package br.com.abc.javacore.Rstrings.teste;

/***
 * PERFORMANCE DAS STRINGS:
 * O uso de muitas srings compromete a performance
 * do sistema
 * Dá pra resolver
 */

public class StringPerformance {
    public static void main(String[] args) {
        //chamada o método no tempo em que ele foi cumprido
        long inicio = System.currentTimeMillis();
        concatString(30000);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto no String: " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        concatStringBuilder(30000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto no StringBuilder: " + (fim - inicio) + " ms");

    }


    //código pra fazer brotar uma caralhada de strings
    private static void concatString(int tamanho) {
        String string = " ";
        for (int i = 0; i < tamanho; i++) {
            string += i;
        }

    }

    private static void concatStringBuilder(int tamanho) {
        //Classe StringBuilder: melhora exponencialmente
        //a performance se usada no lugar do String
        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(i);
        }
    }
    private static void concatStringBuffer(int tamanho) {
        //Classe StringBuilder: mesma coisa da StringBuilder,
        //mas os métodos ão sincronizados, protegidos contra
        //acessos de multiplas treads (vai ser explicado)
        StringBuffer sb = new StringBuffer(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(i);
        }
    }
}