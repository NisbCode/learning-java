package br.com.abc.javacore.Aintroducaoclasses.Testes;

import br.com.abc.javacore.Aintroducaoclasses.classe.Estudante;

/***
 * COESÃO:
 * Uma classe fazer um código que ela nasceu
 * para fazer
 * Ex: classe de estudante n é pra fazer professor
 * Baixa coesão = mta coisa diferente num lugar só (supermercado)
 * Alta coesão = coisas ESPECÍFICAS da classe (loja apenas de chocolate)
 */

public class EstudanteTeste {
    public static void main(String[] args) {

        Estudante joao = new Estudante();
            joao.nome = "João";
            joao.matricula = "1212";
            joao.idade = 15;

        System.out.println(joao.nome);
        System.out.println(joao.matricula);
        System.out.println(joao.idade);

    }
}
