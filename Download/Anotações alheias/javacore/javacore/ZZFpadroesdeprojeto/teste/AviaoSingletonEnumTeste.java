package br.com.abc.javacore.ZZFpadroesdeprojeto.teste;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.AviaoSingleton;
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.AviaoSingletonEnum;

public class AviaoSingletonEnumTeste {
    public static void main(String[] args) {
        AviaoSingletonEnum.agendarAssento("1A");
        AviaoSingletonEnum.agendarAssento("1A");

    }
}
