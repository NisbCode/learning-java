package br.com.abc.javacore.Bintroducaometodos.teste;

import br.com.abc.javacore.Bintroducaometodos.classes.ProfessorParametroReference;

public class ProfessorParametroReferenciaTeste {
    public static void main(String[] args) {

        ProfessorParametroReference marcos = new ProfessorParametroReference();
        marcos.cpf = "122.222.232-20";
        marcos.matricula = "1112";
        marcos.nome = "Marcos";
        marcos.rg = 12546;


        ProfessorParametroReference samanta = new ProfessorParametroReference();
        samanta.cpf = "122.222.232-20";
        samanta.matricula = "1112";
        samanta.nome = "Samanta";
        samanta.rg = 12546;

//        System.out.println("Dentro do professor test");
//        System.out.println(marcos.nome);
//        marcos.imprime(marcos);
//        System.out.println(marcos.nome);

        marcos.imprime();

//        marcos.imprime(marcos);
//        samanta.imprime(samanta);




    }
}
