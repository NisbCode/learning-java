package Estudando.javacore.ZZKstreams.teste;

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

        List<List<String>> nomes = new ArrayList<>();                       //Criando uma lista de listas de String
        nomes.add(asList("DevDojo", "Valeu por aumentar a letra"));
        nomes.add(asList("William", "pq vc demorou 180 aulas pra isso?"));
        List<String> collect = nomes.stream()                               //Agr concatenando os itens dessas duas listas numa só

                .flatMap(Collection::stream)                                //flatMap() pra concatenar os a stream das listas nomes

                .collect(Collectors.toList());                              //collect() transformando essa concatenação em List<String>


        //Imprimindo como fica ambas as listas
        System.out.println(nomes);
        //Imprimindo as listas numa coisa só
        System.out.println(collect);


        /** Missão: criar em List<> um método que faça
         * uma contagem de letra por letra lidando com arrays **/

        List<String> palavras = asList("Ola", "Goku");

        String[] split = palavras.get(0).split("");           // split(): separa letra por letra
        System.out.println(Arrays.toString(split));                 //Aqui vemos que infelizmente ele só pega a primeira palavra já que é apenas uma String

        // Attempt 1: Ainda não é o que queremos, pois o tipo retornado é uma lista de arrays de Strings
        List<String[]> collect1 = palavras.stream().map(p -> p.split("")).collect(Collectors.toList());  //pegue as palavras, transforme em stream, pegue o resultado final, enquanto tiver palavra, a separe, colete e taque numa lista

        // Attempt 2: Forçando a lista "palavras" para que o resultado seja um String[]
        //Para isso eu transformei em um Array para usar um método da classe Arrays q converte para uma Stream q fiz um cast forçando
        //a ser uma String, pois este método retornaria um Object
        //O problema é que queremos uma lista de Strings para conter tds as letras
        Stream<String> stream = Arrays.stream((String[]) palavras.toArray());
        List<String> collect2 = palavras.stream()  //Stream<Strings>
                .map(p -> p.split(""))          //Stream<Strings[]>      ISSO É NECESSÁRIO P Q DIVIDA A LETRA MAS RETORNA UM ARRAY DNV
                .flatMap(Arrays::stream)              //Stream<Strings>         AÍ TU VOLTA PRO Q QUER
                .collect(Collectors.toList());        //E COLOCA NUMA LIST

        System.out.println(collect2);
    }
}