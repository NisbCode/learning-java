package br.com.abc.javacore.ZZFpadroesdeprojeto.teste;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Aviao;

public class AviaoTeste {
    public static void main(String[] args) {
        agendarAssento("1A");
        agendarAssento("1A");
    }

    private static void agendarAssento(String assento){
        Aviao a = new Aviao();
        System.out.println(a.escolherAssento(assento));
    }


}
