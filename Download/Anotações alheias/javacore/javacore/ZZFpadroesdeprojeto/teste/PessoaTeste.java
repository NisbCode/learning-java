package br.com.abc.javacore.ZZFpadroesdeprojeto.teste;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Pessoa;

public class PessoaTeste {
    public static void main(String[] args) {
        Pessoa p = new Pessoa.PessoaBuilder("Amanda")
                .nomeDoMeio("Marques")
                .ultimoNome("Porto")
                .apelido("Amy")
                .nomeDaMae("Moonbyul")
                .build();
        System.out.println(p);
    }

}
