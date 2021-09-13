package Estudando.javacore.ZZFpadroesdeprojeto.teste;


import Estudando.javacore.ZZFpadroesdeprojeto.classes.Pessoa;

public class PessoaTeste {
    public static void main(String[] args) {
        Pessoa p = new Pessoa.PessoaBuilder("Naty")
                .nomeDoMeio("Ignácio Silva") //Chamando, praticamente, os métodos obrigatórios
                .ultimoNome("Bomfim")
                .apelido("Nisb")
                .nomeDaMae("Deise")
                .build();// Deve ser usado p chamar a criação de pessoa
        System.out.println(p);
    }

}
