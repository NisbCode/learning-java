package Estudando.javacore.R_string;

public class StringTest {
    public static void main(String[] args) {

        String nome = "Willian";
        nome = nome.concat(" Suane ");
        String nome2 = "Willian";
        String nome3 = new String("Ana"); //Cria: 1- variável de referência; 2-objeto tipo String; 3-String no pool de String

        String teste = " Goku";
        String teste2 = "0123456789      y    ";
        System.out.println(teste.charAt(3));
        System.out.println(teste.equalsIgnoreCase(teste2));
        System.out.println(teste.length());
        System.out.println(teste.replace('o', 'a'));
        System.out.println(teste.toLowerCase());
        System.out.println(teste.toUpperCase());
        System.out.println(teste2.substring(0, 5));
        System.out.println(teste2.trim());
    }
}
