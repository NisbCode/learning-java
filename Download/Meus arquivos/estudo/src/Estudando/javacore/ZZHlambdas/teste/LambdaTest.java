package Estudando.javacore.ZZHlambdas.teste;


import Estudando.javacore.ZZHlambdas.classe.Carro;
import Estudando.javacore.ZZHlambdas.interfaces.CarroPredicate;

import java.util.function.Predicate;

/**
 * LAMBDAS
 * Foram introduzidos no java 8 para diminuir a verbosidade
 * de códigos. É uma forma concisa de escrever funções anonimas,
 * funções que não têm nome, mas tem tudo que uma função
 * apresenta. Pode ser colocada dentro de uma variável
 * ou até ser usada como parâmetro
 *
 * Sintaxe:
 * (CarroOptional carro) -> carro.getCor().equals("Verde");
 * (int a, int b) -> {sout(a+b)}
 *  parametro   seta       expressão
 */

public class LambdaTest {
    public static void main(String[] args) {
        // feito por função abstrata
        CarroPredicate carroPredicateAbstrato = new CarroPredicate() {
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equalsIgnoreCase("vermelho");
            }
        };

        // feito por lambda
        // Obs: é possivel utilizar tanto a interface CarroPredicate, de autoria propria, como a Predicate, do java,
        // aqui optamos pela Predicate do java
        Predicate<Carro> carroPredicateLambda = carro -> carro.getCor().equalsIgnoreCase("vermelho"); //Tb é possivel usar lambda sem por o tipo já q o java já sabe por vc usar antes

        System.out.println(carroPredicateAbstrato.test(new Carro("vermelho", 2015)));
        System.out.println(carroPredicateLambda.test(new Carro("vermelho", 2015)));
    }
}
