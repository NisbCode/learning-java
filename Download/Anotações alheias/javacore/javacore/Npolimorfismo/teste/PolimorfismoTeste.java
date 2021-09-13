package br.com.abc.javacore.Npolimorfismo.teste;

import br.com.abc.javacore.Npolimorfismo.classes.Funcionario;
import br.com.abc.javacore.Npolimorfismo.classes.Gerente;
import br.com.abc.javacore.Npolimorfismo.classes.RelatorioPagamento;
import br.com.abc.javacore.Npolimorfismo.classes.Vendedor;

public class PolimorfismoTeste {
    public static void main(String[] args) {
        Gerente g = new Gerente("Osvaldo", 5000, 2000);
        Vendedor v = new Vendedor("Pedro", 2000, 20000);

        RelatorioPagamento relatorio = new RelatorioPagamento();
//        relatorio.relatorioPagamentoGerente(g);
//        System.out.println(" --------------------");
//        relatorio.relatorioPagamentoVendedor(v);
        relatorio.relatorioPagamentoGenerico(g);
        System.out.println("-----------------");
        relatorio.relatorioPagamentoGenerico(v);

        /***
         * 8- WIDENING:
         * Quando a variável é do tipo primitivo,
         * ocorre quando um tipo menor é acomodado
         * num tipo maior
         * Ex:
         * float f = 10
         * double d = f;
         *
         * Quando a variável é do tipo reference,
         * ocorre quando a variável de referência
         * de uma subclasse é acomodada em uma
         * da sua superclasse
         * Só funciona ao trabalhar com herança
         */
        Funcionario f = g;
        System.out.println("######################################");
        System.out.println("Salário obtido pelo Widening de f: " + f.getSalario());


        Funcionario testeFuncionario = new Gerente("Bang PD", 100000, 50000);
        //Pelo principio do Widening, não é possível
        //alocar uma super classe dentro de uma variavel
        //do tipo subclasse (mas o contrario sim)
//        Gerente testeGerente = testeFuncionario;
        //Para resolver é necessário fazer um cast explícito
        //para a classe menor
        Gerente testeGerente = (Gerente) testeFuncionario;

    }
}
