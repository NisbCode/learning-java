package Estudando.javacore.ZZFpadroesdeprojeto.teste;


import Estudando.javacore.ZZFpadroesdeprojeto.classes.Moeda;
import Estudando.javacore.ZZFpadroesdeprojeto.classes.MoedaFactory;
import Estudando.javacore.ZZFpadroesdeprojeto.classes.Pais;

public class MoedaFactoryTest {
    public static void main(String[] args) {
        Moeda moeda = MoedaFactory.criarMoeda(Pais.BRASIL);
        System.out.println(moeda.getSimbolo());
    }
}
