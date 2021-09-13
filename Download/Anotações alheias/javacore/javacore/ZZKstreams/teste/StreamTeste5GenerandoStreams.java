package br.com.abc.javacore.ZZKstreams.teste;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTeste5GenerandoStreams {
    public static void main(String[] args) {
        // rangeClosed(): gerar uma sequencia numérica incluindo o ultimo numero
        IntStream.rangeClosed(1, 50).filter(n -> n % 2 == 0).forEach(s -> System.out.print(s + " "));
        System.out.println();
        // range(): gerar uma sequencia numérica sem incluir o ultimo numero
        IntStream.range(1, 50).filter(n -> n % 2 == 0).forEach(s -> System.out.println(s + " "));

        // Stream de palavras
        Stream<String> stringStream = Stream.of("Wings", "Love Yourself", "Vai dar view pra BTS, manas");
        System.out.println();
        stringStream.map(String::toUpperCase).forEach(s -> System.out.println(s + " "));

        // Também é possivel criar uma stream vazia
        Stream<String> empty = Stream.empty();

        // E também é possível criar através de arrays
        int nums[] = {1, 2, 3, 4, 5};
        // average(): retorna a média aritmética dos numeros
        OptionalDouble average = Arrays.stream(nums).average();
        System.out.println(average.getAsDouble());

        // Também é possível trabalhar com arquivos
        try (Stream<String> lines = Files.lines(Paths.get("Teste.txt"), Charset.defaultCharset())) {
            lines.flatMap(line -> Arrays.stream(line.split("\n")))
                    // O filtro são os itens que contém a palavra File
                    .filter(p -> p.contains("File"))
                    .forEach(System.out::println);
        } catch (IOException e){
            e.printStackTrace();
        }

        /**
         * STREAMS INFINITOS
         * Streams que precisam ser finalizadas, senão continuarão indeterminadamente
         * Isso é feito utilizando o limit(), para limitar o numero de operações
         */

        // pode-se usar o iterate()
        Stream.iterate(1, n -> n + 2).limit(10).forEach(System.out::println);

        // Método criando a sequencia de fibonacci (0, 1, 2, 3, 5, 8, 13, 21...) mostrando numero
        // atual e soma com seu anterior
        Stream.iterate(new int[] {0, 1}, a -> new int[] {a[1], a[0] + a[1]})
            .limit(5)
            .forEach(t -> System.out.println(Arrays.toString(t)));

        // e aqui mostrando os resultados
        Stream.iterate(new int[] {0, 1}, a -> new int[] {a[1], a[0] + a[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        // e o generate()
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        ThreadLocalRandom t = ThreadLocalRandom.current();
        Stream.generate(() -> t.nextInt(1, 100)).limit(100).forEach(System.out::println);

    }
}
