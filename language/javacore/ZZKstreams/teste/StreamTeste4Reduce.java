package Estudando.javacore.ZZKstreams.teste;


import Estudando.javacore.ZZKstreams.classes.Pessoa;

import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * OPERAÇÕES COM STREAMS USANDO reduce()
 */

public class StreamTeste4Reduce {
    public static void main(String[] args) {

                                 /** 3 FORMAS DE SOMAR */
        System.out.println("----------------------3 FORMAS DE SOMAR----------------------");
        // primeira forma
        Stream<Integer> stream = getStream();  //Tá lá embaixo os componentes
        Optional<Integer> reduceOptional = stream.reduce((x, y) -> x + y);  //X e Y são a soma do 1 vaçor c o segundo

        // segunda forma
        Stream<Integer> stream2 = getStream();
        // Para que o valor seja Inteiro ao inves de optional é só colocar um inteiro na frente
        Integer reduceInteiro = stream2.reduce(0, (x, y) -> x + y);

        System.out.println("A soma de todos os itens de stream1 é:" + reduceOptional.get());//Por ser Optional
        System.out.println("A soma de todos os itens da stream2 é:" + reduceInteiro);

        // terceira forma
        Stream<Integer> stream3 = StreamTeste4Reduce.getStream();
        Optional<Integer> reduceOptionalMR = stream3.reduce(Integer::sum); //Comando de somar do próprio reduce

        System.out.println("A soma de todos os itens da stream3 é:" + reduceOptionalMR.get());



        // Agora com outros operaçoes
        Stream<Integer> streamSubtracao = asList(80, 30, 10).stream();
        Integer subtracao = streamSubtracao.reduce(0, (x, y) -> x - y);  //Esse 0 na frente diz q vc quer q comece a operação c esse número
        System.out.println(subtracao);

        Integer mult = getStream().reduce(1, (x, y) -> x * y);
        System.out.println("A multiplicação entre os itens da stream é: " + mult);

        Optional<Integer> maximo = getStream().reduce((x, y) -> x > y ? x : y);
        System.out.println("O maior dessa stream é " + maximo);

        Optional<Integer> maximo2 = getStream().reduce(Integer::max);
        System.out.println("O maior dessa stream é " + maximo2);

        // Criando a lista de pessoas da classe pessoa e somando os valores de todos que tem salario acima de 4000
        Stream<Pessoa> streamPessoa = Pessoa.bancoDePessoas().stream();
        Optional<Double> somaSalarioOptional = streamPessoa.filter(p -> p.getSalario() > 4000)
                // focando no salario, ao inves da pessoa
                .map(Pessoa::getSalario)
                .reduce(Double::sum);
        System.out.println("A soma de todos os salarios acima de 4000 é com Wrappers: " + somaSalarioOptional.get());

        // O mesmo método anterior, mas lidando com tipos primitivos ao inves de wrapper, o que
        // economiza em processamento
        Stream<Pessoa> streamPessoa2 = Pessoa.bancoDePessoas().stream();
        Double somaSalarioDoubleStream = streamPessoa2.filter(p -> p.getSalario() > 4000)
                .mapToDouble(Pessoa::getSalario)
                .sum();
        System.out.println(somaSalarioDoubleStream);

    }

    // Um stream só pode ser utilizado uma vez, sendo assim, para usar o mesmo, ele deve ser criado novamente
    private static Stream<Integer> getStream() {

        return asList(1, 2, 3, 4, 5, 6).stream();
    }
}
