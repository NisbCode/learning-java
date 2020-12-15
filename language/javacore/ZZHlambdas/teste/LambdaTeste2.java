package Estudando.javacore.ZZHlambdas.teste;

import Estudando.javacore.ZZHlambdas.classe.Carro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

/**
 * INTERFACES LAMBDA
 * Predicate: retorna um boolean de teste, serve pra fazer validações
 * Consumer: recebe um objeto T, que deve ser adicionado pelo desenvolvedor
 * e faz uma operação com ele
 * Function: recebe um tipo T nos argumentos e retorna um tipo R, diferente do inicial
 */

public class LambdaTeste2 {
    public static void main(String[] args) {
        // A lista                              // Agora a operação com o objeto T: nesse caso, imprimir os itens da lista
        forEach(asList("William", "DevDojo", "facebook.com/devdojobr"), (String s) -> System.out.println(s));

        // Lista de inteiros, agora determinada                                                                   // A atribuição do método apply, que vem a retornar o
        // método length para cada palavra da lista
        List<Integer> listaTamanhoNomes = tamanhoPalavras(asList("William", "DevDojo", "facebook.com/devdojobr"), (String s) -> s.length());
        System.out.println(listaTamanhoNomes);

        //Como seria p pegar apenas um tipo de atributo de uma lista usando lambdas, é oq agt já conhece:
        List<Carro> list = asList(new Carro("rosa", 2018), new Carro("preto", 2015), new Carro("azul", 1985));
        List<String> listCor = tamanhoPalavras(list, (Carro carro) -> carro.getCor());
        System.out.println(listCor);


        //Para usar tipos primitivos em alta performace:
        Predicate<Integer> par = (Integer i)  -> i % 2 == 0;    //Ele te obriga a pôr o Integer
        IntPredicate impar = (int i) -> i % 2 == 1;             //Evitam esse whapper automático
        System.out.println(impar.test(1000));
    }


    // Interface Consumer
    public static <T> void forEach(List<T> listaT, Consumer<T> consumidorT) {
        // para cada elemento na listaT, cujo tipo será determinado ao imprimir ou na criação da lista
        for (T elemento : listaT) {
            // método accept da interface Consumer,
            // que deverá ser feito pelo desenvolvedor, já
            // que vem de uma interface
            consumidorT.accept(elemento);
        }
    }

    // Interface function
    public static <T, R> List<R> tamanhoPalavras(List<T> lista, Function<T, R> function) {
        // Uma lista contendo os itens do resultado
        List<R> result = new ArrayList<>();
        // Para cada item do tipo T, tirado da lista dada como argumento...
        for (T item : lista) {
            // ... adicione esse item na lista utilizando o método apply
            // da interface function
            result.add(function.apply(item));
        }
        return result;
    }
}
