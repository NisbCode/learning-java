package br.com.abc.javacore.ZZHlambdas.teste;

import br.com.abc.javacore.ZZHlambdas.classe.Carro;
import br.com.abc.javacore.ZZHlambdas.classe.ComparadorCarro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

import static java.util.Arrays.asList;

/**
 * METHOD REFERENCES
 * basicamente, é quando você tem a necessidade de fazer referencia a
 * um método em um lambda (que não é bem referència, tá mais pra colocar uma
 * classe anônima dentro daquele método)
 */

public class TesteLambda3 {
    public static void main(String[] args) {
        // Como essa lista seria impressa do jeito que aprendemos até agora
        forEach(asList("William", "Devdojo", "facebook.com/devdojo"), (String string) -> System.out.println(string));
        // Pela consumerLambda ter um parâmetro T, ela já sabe que o desenvolvedor está lidando
        // com Strings, por isso, desnecessário adicionar classes
        forEach(asList("William", "Devdojo", "facebook.com/devdojo"), string -> System.out.println(string));

        // E finalmente, por apenas um método estar sendo utilizado nessa lambda, esse único pode ser
        // referenciado
        // Esse é um caso de REFERÊNCIA A MÉTODO ESTÁTICO, no qual a sintaxe é Classe::métodoEstatico
        forEach(asList("William", "Devdojo", "facebook.com/devdojo"), System.out::println);

        System.out.println("---------------- Referência a método estático ----------------");

        List<Carro> listaCarros = asList(new Carro("Azul", 1985), new Carro("Prata", 1968), new Carro("Ferrugem", 2016));
        // Como ficaria até agora
        Collections.sort(listaCarros, (Carro carro1, Carro carro2) -> carro1.getCor().compareToIgnoreCase(carro2.getCor()));
        // Com method references
        Collections.sort(listaCarros, ComparadorCarro::comparePorCor);
        System.out.println(listaCarros);

        System.out.println("---------------- Referência a instância de método ----------------");
        // É a mesmíssima coisa do anterior, a diferença é teórica, que você passa a usar um objeto
        // no lugar da própria classe. Isso é importante pra certificação Oracle
        ComparadorCarro comparadorCarroInstancia = new ComparadorCarro();
        // Como ficaria até agora
        Collections.sort(listaCarros, (Carro carro1, Carro carro2) -> carro1.getCor().compareToIgnoreCase(carro2.getCor()));
        // Com method references
        Collections.sort(listaCarros, comparadorCarroInstancia::comparePorAno);
        System.out.println(listaCarros);

        System.out.println("---------------- Referência a instância de método particular de objeto arbitrário ----------------");
        // Esse nome todoai pra dizer que você pode chamar um método não-estatico de uma classe
        List<String> listaNomes = asList("Moonbyul", "Solar", "Wheein", "Hwasa");
        // Como ficaria até agora
        listaNomes.sort((s1, s2) -> s1.compareTo(s2));
        // Com method references
        listaNomes.sort(String::compareTo);
        System.out.println(listaNomes);

        // Como ficaria até agora
        Function<String, Integer> stringToInteger = s -> Integer.parseInt(s);
        // Com method references
        Function<String, Integer> stringToInteger2 = Integer::parseInt;
        System.out.println(stringToInteger2.apply("10"));

        // Como ficaria até agora
        BiPredicate<List<String>, String> checkItemInList = (lista, elemento) -> lista.contains(elemento);
        // Com method references
        BiPredicate<List<String>, String> checkItemInList2 = List::contains;
        System.out.println("O nome está presente na lista?: " + checkItemInList2.test(listaNomes, "Moonbyul"));

        System.out.println("---------------- Referência por construtor ----------------");
        // Isso é realmente criar um construtor utilizando lambda
        // Como ficaria até agora
        BiFunction<String, Integer, Carro> carroBiFunction = (string, integer) -> new Carro(string, integer);
        // Com method references
        BiFunction<String, Integer, Carro> carroBiFunction2 = Carro::new;
        System.out.println(carroBiFunction.apply("Laranja", 1971));


    }

    // Método forEach, que permite com que façamos operações de lambdas
    // com listas
    public static <T> void forEach(List<T> listaT, Consumer<T> consumerLambda){
        // para cada elemento na listaT, cujo tipo será determinado
        // posteriormente
        for (T elemento : listaT){
            // método accept da interface Consumer,
            // que deverá ser feito pelo desenvolvedor, já
            // que vem de uma interface
            consumerLambda.accept(elemento);
        }
    }
}
