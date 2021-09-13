package Estudando.javacore.ZZKstreams.teste;


import Estudando.javacore.ZZKstreams.classes.Genero;
import Estudando.javacore.ZZKstreams.classes.Maioridade;
import Estudando.javacore.ZZKstreams.classes.Pessoa;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * AGRUPAMENTO DE STREAMS
 */

public class StreamTeste6Collectors2 {
    public static void main(String[] args) {
        List<Pessoa> pessoas =  Pessoa.bancoDePessoas();

        // Antigamente... Para agrupar a lista por gênero
        Map<Genero, List<Pessoa>> generoListMap = new HashMap<>();
        List<Pessoa> masculinos = new ArrayList<>();
        List<Pessoa> femininos = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getGenero().equals(Genero.FEMININO)) {
                femininos.add(pessoa);
            } else {
                masculinos.add(pessoa);
            }
        }

        generoListMap.put(Genero.FEMININO, femininos);
        generoListMap.put(Genero.MASCULINO, masculinos);
        System.out.println(generoListMap);


        // Agora...
        Map<Genero, List<Pessoa>> collectGenero = pessoas.stream().collect(groupingBy(Pessoa::getGenero));
        System.out.println(collectGenero);





        // Agrupando por maioridade
        Map<Maioridade, List<Pessoa>> collectMaioridade = pessoas.stream().collect(groupingBy(p -> {
            if (p.getIdade() < 18) return Maioridade.MENOR;
            else return Maioridade.ADULTO;
        }));
        System.out.println(collectMaioridade);





        // Agrupando por genero e maioridade
        Map<Genero, Map<Maioridade, List<Pessoa>>> collectGeneroMaioridade = pessoas.stream()
                .collect(groupingBy(Pessoa::getGenero, groupingBy(p -> {
                    if (p.getIdade() < 18) return Maioridade.MENOR;
                    else return Maioridade.ADULTO;
                })));
        System.out.println(collectGeneroMaioridade);





        // Agrupando por genero e quantidade
        Map<Genero, Long> collectGeneroQuantidade = pessoas.stream()
                .collect(groupingBy(Pessoa::getGenero, Collectors.counting()));
        System.out.println(collectGeneroQuantidade);




        // Agrupando por genero e maior salário com optional (NESSE CASO, o optional é inútil pq se n tiver nd dentro, ele nem vai ter uma chave pra executar. então pra poupar processamento, temos o msm método sem ele)
        Map<Genero, Optional<Pessoa>> collectGeneroMaiorSalarioComOptional = pessoas.stream()
                .collect(groupingBy(Pessoa::getGenero,
                        Collectors.maxBy(Comparator.comparing(Pessoa::getSalario))));
        System.out.println(collectGeneroMaiorSalarioComOptional);




        // Agrupando por genero e maior salário sem optional
        Map<Genero, Pessoa> collectGeneroMaiorSalario = pessoas.stream()
                .collect(groupingBy(Pessoa::getGenero,
                        collectingAndThen(Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)),
                            Optional::get)));
        System.out.println(collectGeneroMaiorSalario);





        // Agrupando por gênero e estatistica(Como a soma dos salários, o minimo, quantos são, etc)
        Map<Genero, DoubleSummaryStatistics> collectGeneroEstatistica = pessoas.stream().collect(groupingBy(Pessoa::getGenero, summarizingDouble(Pessoa::getSalario)));
        System.out.println(collectGeneroEstatistica);





        // Agrupando por gênero e maioridade, mostrando os itens nomeados pela categoria deles
        Map<Genero, List<Maioridade>> collectMapping = pessoas.stream().collect(groupingBy(Pessoa::getGenero, mapping(p -> {
            if (p.getIdade() < 18) return Maioridade.MENOR;
            else return Maioridade.ADULTO;
        }, toList())));
        System.out.println(collectMapping);





        // Mesma coisa que o anterior, mas com uso de Set
        Map<Genero, Set<Maioridade>> collectMappingSet = pessoas.stream().collect(groupingBy(Pessoa::getGenero, mapping(p -> {
            if (p.getIdade() < 18) return Maioridade.MENOR;
            else return Maioridade.ADULTO;
        }, toSet())));
        System.out.println(collectMappingSet);

    }
}