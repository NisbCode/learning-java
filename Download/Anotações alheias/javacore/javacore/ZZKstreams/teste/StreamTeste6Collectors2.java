package br.com.abc.javacore.ZZKstreams.teste;

import br.com.abc.javacore.ZZKstreams.classes.Genero;
import br.com.abc.javacore.ZZKstreams.classes.Maioridade;
import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * AGRUPAMENTO DE STREAMS
 */

public class StreamTeste6Collectors2 {
    public static void main(String[] args) {
        List<Pessoa> pessoas =  Pessoa.bancoDePessoas();

        // Antigamente...
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
        // Agrupando por genero
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

        // Agrupando por gênero e estatistica
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