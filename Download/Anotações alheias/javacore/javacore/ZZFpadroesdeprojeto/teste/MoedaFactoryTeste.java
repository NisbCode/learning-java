package br.com.abc.javacore.ZZFpadroesdeprojeto.teste;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Moeda;
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.MoedaFactory;
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Pais;

public class MoedaFactoryTeste {
    public static void main(String[] args) {
        Moeda moeda = MoedaFactory.criarMoeda(Pais.BRASIL);
        System.out.println(moeda.getSimbolo());
    }
}
