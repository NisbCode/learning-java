package br.com.abc.javacore.ZZJoptional.teste;

import br.com.abc.javacore.ZZJoptional.classes.CarroOptional;
import br.com.abc.javacore.ZZJoptional.classes.PessoaOptional;
import br.com.abc.javacore.ZZJoptional.classes.SeguradoraOptional;
import br.com.abc.javacore.ZZJoptional.classes2.Seguradora;

import java.util.Optional;

public class OptionalTeste2 {
    public static void main(String[] args) {
        SeguradoraOptional seguradora = new SeguradoraOptional("DevDojo Seguros");
        CarroOptional carroOptional = new CarroOptional(seguradora, "Audi");
        PessoaOptional pessoaOptional = new PessoaOptional(carroOptional, "Carlos", 25);
        PessoaOptional pessoaOptional2 = new PessoaOptional(new CarroOptional(seguradora, "Gol"), "Ana", 22);

        obterNomeSeguradoraOptional(Optional.ofNullable(pessoaOptional));

        checarNomeSeguradoraOptional(seguradora);

        Optional<String> seguradoraPorIdade = obterNomeSeguradoraPorIdade(pessoaOptional2, 18);



    }

    // Um monte de ifs pra checar se todas essas variaveis são nulas, sem Optional
    /**
     * public static String obterNomeSeguradora(PessoaOptional p){
     *         if (p != null){
     *             CarroOptional carro = p.getCarroOptional();
     *             if (carro != null){
     *                 SeguradoraOptional seguradora =  carro.getSeguradoraOptional();
     *                 if (seguradora != null){
     *                     return seguradora.getNome();
     *                 }
     *             }
     *         }
     *     }
     */


    // O método acima, com Optional
    public static String obterNomeSeguradoraOptional(Optional<PessoaOptional> pessoaOptional){
        System.out.println(
                // flatMap(): retorna um método optional
                pessoaOptional.flatMap(PessoaOptional::getCarroOptional)
                    .flatMap(CarroOptional::getSeguradoraOptional)
    //                    // map(): usado para retornar o metodo que o desenvolvedor
    //                    // quer pegar, não sendo um optional
                        .map(SeguradoraOptional::getNome)
                            .orElse(Optional.of("Não existe seguradora"))
        );
        return "";
    }

    // Um método para ver se o nome da seguradora é Devdojo sem o uso de Optional
    /**
     * private static void checarNomeSeguradora(SeguradoraOptional seguradora){
     *         if (seguradora != null && seguradora.getNome().equals("DevDojo Seguros")){
     *             System.out.println("é o devdojo");
     *         } else {
     *             System.out.println("não é o devdojo");
     *         }
     *     }
     *
     */

    // Com Optional
    private static void checarNomeSeguradoraOptional(SeguradoraOptional seguradora){
        Optional<SeguradoraOptional> seguradoraOptional = Optional.ofNullable(seguradora);
        // if (seguradora != null && seguradora.getNome().equals("DevDojo Seguros"))
        seguradoraOptional.filter(s -> s.getNome().equals(Optional.of("DevDojo Seguros")))
        //              System.out.println("é o devdojo");
                        .ifPresent(x -> System.out.println("é o devdojo"));
    }

    private static Optional<String> obterNomeSeguradoraPorIdade(PessoaOptional pessoa, int idadeMinima){
         return Optional.ofNullable(pessoa)
                // o método filter() se equipara a um if quando se lida com Optional, a condição
                // é um lambda
                .filter(pessoaLambda -> pessoa.getIdade() >= idadeMinima)
                .flatMap(PessoaOptional::getCarroOptional)
                .flatMap(CarroOptional::getSeguradoraOptional)
                .map(SeguradoraOptional::getNome)
                .orElse(Optional.of("Idade minima não atingida"));

    }

}
