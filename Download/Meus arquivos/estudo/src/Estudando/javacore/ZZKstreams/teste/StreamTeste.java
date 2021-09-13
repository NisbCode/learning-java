package Estudando.javacore.ZZKstreams.teste;

import Estudando.javacore.ZZKstreams.classes.Pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * STREAMS:
 * Trabalha com coleções de forma muito mais simples, quase da
 * mesma forma usada em banco de dados
 * DIFERENÇA ENTRE STREAMS E COLLECTIONS
 * Collections: armazenam dados
 * Stream: computa dados, faz alguma coisa com esses dados
 * além disso, as interações em Streams são internas (não precisam de for)
 */

public class StreamTeste {
    // Pegar os 3 primeiros nomes das pessoa com menos de 25 anos ordenados pelo nome
    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();
        Collections.sort(pessoas, (o1, o2) -> o1.getNome().compareToIgnoreCase(o2.getNome()));
        List<String> nomesMenorQue25Java7 = new ArrayList<>();
        for (Pessoa pessoaItem : pessoas){
            if (pessoaItem.getIdade() < 25){
                nomesMenorQue25Java7.add(pessoaItem.getNome());
                if (nomesMenorQue25Java7.size() >= 3){
                    break;
                }
            }
        }
        System.out.println(nomesMenorQue25Java7);

        System.out.println("---------------------------------------------------");
        /**
         * Isso era feito até a versão 7 do Java
         * A partir do Java 8:
         */
        List<String> nomesMenorQue25Java8 = pessoas
                // stream(): pega as informações em tempo real
                .stream()

                // filter(): para filtrar os resultados
                .filter(pessoa -> pessoa.getIdade() < 25)

                // sorted(): para implementar o comparator, dentro do método comparing
                .sorted(Comparator.comparing(Pessoa::getNome))

                // limit(): limita a quantidade de itens
                .limit(3)

                // map(): é um Function, pega um tipo de valor e transformar em outro tipo de valor
                // vai pegar os valores de getNome()
                .map(Pessoa::getNome)

                // ... e jogar tudo pra dentro de uma lista como collect()
                .collect(Collectors.toList());

        // Todos até o collect(), são métodos stream, ou seja, métodos que retornavam outras streams,
        // métodos assim são chamados de Intermediate
        // Já o collect é um método Terminal, porque retorna uma lista, uma coisa diferente de streams
        // Apenas os Terminal executam processamento

        System.out.println(nomesMenorQue25Java8);

        /**
         * Mais dois metodos uteis
         */
        System.out.println(pessoas
                .stream()
                // distinct(): mostra quantos elementos distintos tem na lista
//                .distinct()
                .filter(pessoa -> pessoa.getIdade() < 25)
                .sorted(Comparator.comparing(Pessoa::getNome))
                .limit(3)
                // skip(): pula o resultado selecionado dentro dos parenteses, de acordo com a ordenação
                .skip(1)
                .map(Pessoa::getNome)
                // count(): conta quantos elementos há na lista
                .count()
        );

        // E ainda tem um for
        pessoas.stream().forEach(System.out::println);

    }


}
