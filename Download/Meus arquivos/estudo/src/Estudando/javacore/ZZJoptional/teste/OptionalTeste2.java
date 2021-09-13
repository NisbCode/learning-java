package Estudando.javacore.ZZJoptional.teste;


import Estudando.javacore.ZZJoptional.classes.CarroOptional;
import Estudando.javacore.ZZJoptional.classes.PessoaOptional;
import Estudando.javacore.ZZJoptional.classes.SeguradoraOptional;

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
    public static String obterNomeSeguradoraOptional(Optional<PessoaOptional> pessoaOptional){   //Usar o Optional nessa classe no parâmetro diz q não necessariamente precisa ter uma pessoa para que o método execute
        System.out.println(
                // flatMap(): retorna um método optional
                pessoaOptional.flatMap(PessoaOptional::getCarroOptional)   //A partir da pessoa eu quero saber o nome do carro
                    .flatMap(CarroOptional::getSeguradoraOptional)         //A partir desse carro me dê a seguradora
    //                    // map(): usado para retornar o metodo que o desenvolvedor
    //                    // quer pegar, não sendo um optional
                        .map(SeguradoraOptional::getNome)   //Me retorne o Optional do nome da seguradora conforme o exigido antes
                        //Você usa o map aq e não antes pq aq ele já está retornando uma string, antes ele retornava um optional de string
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
        seguradoraOptional.filter(s -> s.getNome().equals(Optional.of("DevDojo Seguros")))  //.filter Verifica se tem conteúdo
                        .ifPresent(x -> System.out.println("é o devdojo"));                 //Se tiver retorne
    }

    private static Optional<String> obterNomeSeguradoraPorIdade(PessoaOptional pessoa, int idadeMinima){
         return Optional.ofNullable(pessoa)
                .filter(pessoaLambda -> pessoa.getIdade() >= idadeMinima)
                .flatMap(PessoaOptional::getCarroOptional)
                .flatMap(CarroOptional::getSeguradoraOptional)
                .map(SeguradoraOptional::getNome)
                .orElse(Optional.of("Idade minima não atingida"));

    }

}
