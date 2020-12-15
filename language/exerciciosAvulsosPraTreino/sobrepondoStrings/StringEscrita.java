package Estudando.exerciciosAvulsosPraTreino.sobrepondoStrings;

public interface StringEscrita {
    default void frase1() {
        String a = "Minha janta é miojo";
        System.out.println("Dentro do StringEscrita: " + a);
    }
}
