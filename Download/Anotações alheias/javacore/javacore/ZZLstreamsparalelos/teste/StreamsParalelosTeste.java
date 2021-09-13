package br.com.abc.javacore.ZZLstreamsparalelos.teste;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * STREAM PARALELOS
 * uso de threads com streams
 * Nem sempre você vai saber quando utilizar Streams paralelos,
 * então, é necessário você tomar algumas medidas antes de resulver usar:
 * - Benchmark: testar o código sem stream, com stream e com streams paralelas
 * pra ver qual gasta menos processamento
 * - Boxing e unboxing: observar se os streams fazem boxing e unboxing dos
 * objetos que você está usando (usa se você estiver usando classes wrapper),
 * isso gasta processamento
 * - findFirst() e limit() funcionam melhor quando são sequenciais
 * - Com quantidade altas de dados
 * - Desempenho de Streams paralelas em listas (do melhor para o pior):
 *      ArrayList = IntStream.range ou LongStream.range > HashSet = TreeSet > LinkedList = Stream.iterate
 * - Ter uma noção do tamanho do Stream, do quanto vai gastar as operações que eles vão fazer
 * - Considerar o processamento do merge, ou seja, se vai demorar  pra juntar as operações que foram quebradas
 */

public class StreamsParalelosTeste {
    public static void main(String[] args) {
        long numeroLong = 10_000_000;
        forSoma(numeroLong);
        forSomaStreams(numeroLong);

        // O tempo para o forSoma executar vai ser menor que
        // para o forSomaStreams, pois o forSomaStreams faz
        // boxing e unboxing dos tipos primitivos, gastando
        // mais processamento

        // Uma alternativa seria 2 threads executarem esses códigos
        // em partes. Ficaria mais rápido teoricamente, porém, na prática,
        // fica mais lento, ou seja, não é recomendavel
        forSomaStreamsParalelos(numeroLong);

        // É possível você ver quantos processadores disponiveis pro
        // paralelismo você tem, lembra?
        System.out.println("Processadore disponiveis: " + Runtime.getRuntime().availableProcessors());

        // Mas agora você também pode mudar a quantidade de processadores
        // usados,o que vai afetar no uso de todas as streams paralelas
        // do sistema. Contudo, não é recomendavel fazer isso, pois
        // mais threads não significam mais velocidade (e vc pode cagar seu pc)

        // Agora fazendo a mesma operação com o rangeClosed(),
        // muito mais rapido que os Streams paralelos
        forSomaRangeClosedStreams(numeroLong);

        // E, ainda, usando paralelismo nele
        forSomaRangeClosedStreamsParallels(numeroLong);

        /**
         * No fim a operação que levou menos tempo foi o forSoma,
         * mas há casos em que as Streams Paralelas vão ser bem úteis
         */
    }

    // Como essa operação de soma conteceria até o java 7
    private static void forSoma(long numero){
        System.out.println("Dentro do For");
        long resultado = 0;
        long tempoInicial = System.currentTimeMillis();
        // Para cada vez que o i <= numero...
        for (long i = 1L; i <= numero; i++) {
            // ... o resoltado será acrescido pelo valor do numero
            resultado += i;
        }
        long tempoFinal = System.currentTimeMillis();
        System.out.println("Resultado: " + resultado);
        // Quanto tempo durou a operação
        System.out.println("Duração " + (tempoFinal - tempoInicial) + " ms");

    }

    private static void forSomaStreams(long numero){
        System.out.println("Dentro do For Streams (que é sequencial)");
        long resultado = 0;
        long tempoInicial = System.currentTimeMillis();
        // Note que um for na sintaxe atualizada do java 8 pode ser feito dessa forma
        resultado = Stream.iterate(1L, i -> i + 1)
                .limit(numero)
                // reduce(): usado para operações matemáticas em streams, aqui é
                // como se você "reduzisse" esse numero a uma soma
                .reduce(0L, Long::sum);

        long tempoFinal = System.currentTimeMillis();
        System.out.println("Resultado: " + resultado);
        // Quanto tempo durou a operação
        System.out.println("Duração " + (tempoFinal - tempoInicial) + " ms");

    }

    private static void forSomaStreamsParalelos(long numero){
        System.out.println("Dentro do For Streams Paralelos");
        long resultado = 0;
        long tempoInicial = System.currentTimeMillis();
        resultado = Stream.iterate(1L, i -> i + 1)
                .limit(numero)
                // parallel(): definindo que o código será executado por mais de uma thread
                .parallel()
                .reduce(0L, Long::sum);

        long tempoFinal = System.currentTimeMillis();
        System.out.println("Resultado: " + resultado);
        // Quanto tempo durou a operação
        System.out.println("Duração " + (tempoFinal - tempoInicial) + " ms");

    }

    // Agora fazendo pelo método rangeClosed()
    private static void forSomaRangeClosedStreams(long numero){
        System.out.println("Dentro do For Soma Range Closed Streams (que também é sequencial)");
        long resultado = 0;
        long tempoInicial = System.currentTimeMillis();
                              // Percorre o intervalo entre 1L e numero e para cada item,
                              // você soma eles entre si
        resultado = LongStream.rangeClosed(1L, numero).reduce(0L, Long::sum);

        long tempoFinal = System.currentTimeMillis();
        System.out.println("Resultado: " + resultado);
        // Quanto tempo durou a operação
        System.out.println("Duração " + (tempoFinal - tempoInicial) + " ms");

    }

    // Agora fazendo pelo método rangeClosed() mas usando o paralelismo
    private static void forSomaRangeClosedStreamsParallels (long numero){
        System.out.println("Dentro do For Soma Range Closed Streams Paralelo");
        long resultado = 0;
        long tempoInicial = System.currentTimeMillis();
        // Percorre o intervalo entre 1L e numero e para cada item,
        // você soma eles entre si
        resultado = LongStream.rangeClosed(1L, numero).parallel().reduce(0L, Long::sum);

        long tempoFinal = System.currentTimeMillis();
        System.out.println("Resultado: " + resultado);
        // Quanto tempo durou a operação
        System.out.println("Duração " + (tempoFinal - tempoInicial) + " ms");

    }

}
