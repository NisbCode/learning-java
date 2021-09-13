package br.com.abc.javacore.ZZKstreams.teste;

import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

import java.util.Comparator;
import java.util.List;

public class StreamTeste3 {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();
        // anyMatch(): verifica se existe algum elemento desse stream que seja
        // compativel com o predicate desse método
        System.out.println(pessoas.stream().anyMatch(p -> p.getSalario() > 4000));
        // allMatch(): checha tudo na lista corresponde ao predicate
        System.out.println(pessoas.stream().allMatch(p -> p.getIdade() > 18));
        // noneMatch(): checa se algum dos itens da lista não corresponde ao predicate
        System.out.println(pessoas.stream().noneMatch(p -> p.getIdade() < 18));
        pessoas.stream()
                .filter(p -> p.getIdade() < 25)
                .findAny()
                .ifPresent(p -> System.out.println(p.getNome()));
        pessoas.stream()
                .filter(pessoa -> pessoa.getIdade() > 30)
                .findFirst()
                .ifPresent(p -> System.out.println(p.getNome()));

        pessoas.stream()
                .filter(pessoa -> pessoa.getIdade() > 30)
                .sorted(Comparator.comparing(Pessoa::getIdade).reversed())
                .findFirst()
                .ifPresent(p -> System.out.println(p.getNome()));
    }
}
