package br.com.abc.javacore.ZZKstreams.teste;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamTeste2 {
    public static void main(String[] args) {
        // Criando uma lista de listas
        List<List<String>> nomes = new ArrayList<>();
        nomes.add(asList("DevDojo", "Valeu por aumentar a letra"));
        nomes.add(asList("William", "pq vc demorou 180 aulas pra isso?"));
        // agora concatenando os itens dessas duas listas numa coisa só
        List<String> collect = nomes.stream()
                                    // flatMap() transformando nomes em Stream<String>
                                    .flatMap(Collection::stream)
                                    // collect() transformando Stream<String> em List<String>
                                    .collect(Collectors.toList());
        // imprimindo ambas as listas
        System.out.println(nomes);
        // imprimindo a lista inteira numa coisa só
        System.out.println(collect);

        // Missão: criar em List<> um método que faça isso:
        // uma contagem de letra por letra lidando com arrays
        List<String> palavras = asList("Ola", "Goku");
                                    // split(): separa letra por letra
        String[] split = palavras.get(0).split("");
        System.out.println(Arrays.toString(split));

        // Attempt 1: Ainda não é o que queremos, pois o tipo retornado é List<String[]>
        List<String[]> collect1 = palavras.stream().map(p -> p.split("")).collect(Collectors.toList());
        // Attempt 2: Transformando a lista palavras em um array e forçando para que o resultado seja um String[]
        // com um cast, ao invés de um Object, convertemos isso para Stream com o método stream() da classe Array,
        // retornando Stream<String>. Ótimo, mas queremos List<String>
        Stream<String> stream = Arrays.stream((String[]) palavras.toArray());
//        Stream<String> stringStream = palavras.stream()
//                .map(palavrasLambda -> palavrasLambda.split(""))
//                .flatMap(Arrays::stream)
//                .collect(Collectors.toList());

//        System.out.println(stringStream);
    }

}
