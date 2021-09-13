package br.com.abc.javacore.QWrappers.teste;

/***
 * CLASSES WRAPPER
 * Criadas para dar mais poder aos tipos primitivos
 * (byte, short, int, long, float, double, char e boolean)
 */

public class WrappersTeste {
    public static void main(String[] args) {

        /***
         * AUTOBOXING:
         * Colocar um tipo primitivo em um Wrapper
         */
        //Para criar classes Wrapper
        //Não é mais tipo primitivo, é objeto
        Byte byteWrapper = 1;
        Short shortWrapper = 1;
        //Outra forma de declarar uma variavel
        //Classes Integer, Float e Boolean convertem de
        // String para os seus valores
        Integer intWrapper = new Integer("10");
        Long longWrapper= Long.valueOf(10L);
        Float floatWrapper = 10F;
        Double doubleWrapper = 10D;
        Character characterWrapper = 'A';
        Boolean booleanWrapper = true;

        /***
         * UNBOXING:
         * O qu você tem feito desde o começo
         */
        int i = intWrapper;

        //Conversão de valores: método Parse
        String valor = "10";
        Float f = Float.parseFloat(valor);

        //Retornar um Wrapper: método Classe.valueOf

        //Classe Character
        //isDigit: método se retorna se é digito ou n
        System.out.println(Character.isDigit('A'));
        //isLetter: retorna se é letra ou não
        System.out.println(Character.isLetter('A'));
        //isLetterOrDigit: retorna se é letra ou digito
        System.out.println(Character.isLetterOrDigit('A'));
        //isUpperCase: checa se uma letra é maiuscula ou não
        System.out.println(Character.isUpperCase('A'));
        //isLowerCase: checa se é uma letra minuscula ou não
        System.out.println(Character.isLowerCase('A'));
        //toUpperCase: imprime letra minuscula em maiuscula
        System.out.println(Character.toUpperCase('a'));
    }



}
