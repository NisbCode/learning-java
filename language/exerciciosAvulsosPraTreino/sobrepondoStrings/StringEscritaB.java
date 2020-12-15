package Estudando.exerciciosAvulsosPraTreino.sobrepondoStrings;

public interface StringEscritaB extends StringEscrita{

    default void frase1() {
        String a = "Minha janta será batata frita";
        System.out.println("Dentro do StringEscritaB: " + a);
    }
}
