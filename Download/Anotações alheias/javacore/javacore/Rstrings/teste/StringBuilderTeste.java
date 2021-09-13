package br.com.abc.javacore.Rstrings.teste;

/***
 * POR QUE O STRING BUILDER É MELHOR
 * Diferente da string normal, ela não cria uma string no pool
 * de strings, basicamente uma piscina oude todas as strings
 * da memória estão alocadas
 */

public class StringBuilderTeste {
    public static void main(String[] args) {
        String s = "Uma frase comum";
                            //capacity: o tamanho pré-definido da string
        StringBuilder sb = new StringBuilder(16);
        //Método append: é como o método concat da string,
        //e serve pra criar strings
        // é sobrecarregado, então tem várias categorias
        //de tipos primitivos
        sb.append("Uma frase comum");
        // O que acontece no fundo é isso:
        // s = sb.toString();
        System.out.println(sb);

        /***
         * MÉTODOS INTERESSANTES
         */

        /***
         * Método reverse: inverte a ordem das strings
         */
        System.out.println(sb.reverse());

        /***
         * Método delete: deleta um intervalo da string
         */
        System.out.println(sb.delete(0,2));

        /***
         * Método insert: inserir uma string em alguma posição
         */
                                //Posição e string a ser inserida
                                //começa contando da posição 1
        System.out.println(sb.insert(2, "####"));

    }

}
