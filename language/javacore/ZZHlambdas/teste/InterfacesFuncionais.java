package Estudando.javacore.ZZHlambdas.teste;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * INTERFACES FUNCIONAIS
 * Deve ser usada quando você precisa usar alguma interface em que
 * o tipo seja um Wrapper, pois é funcional, ou seja, gasta
 * menos processamento
 */

public class InterfacesFuncionais {
    public static void main(String[] args) {
        // ao invés de ser assim
                            // Target type: o dado que o argumento
                            // está esperando, que, se for correspondente
                            // com o contexto e mais de uma interface tiverem
                            // esses dados, ambas podem ser utilizads
                            // Ex: utilizar CarroPredicate, com o parametro
        //                  // carro e Predicate, com o parâmetro T,
                            // generico, que pode ser mudado pra CarroOptional
                            // Functional Descriptor: o que a função tá
                            // pedindo, no caso da Predicate/CarroPredicate,
                            // o método test
        Predicate<Integer> pares = (Integer i) -> i % 2 == 0;
                    // Lembrando: é necessário ter a variavel e
                    // a chamada do médoto da interface
        System.out.println(pares.test(1000));
        IntPredicate impar = (int i) -> i % 2 == 1;
        System.out.println(impar.test(1000));
    }
}
