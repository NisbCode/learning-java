package br.com.abc.javacore.Csobrecargametodos.teste;

import br.com.abc.javacore.Csobrecargametodos.classes.Funcionario;

public class FuncionarioTeste {
    public static void main(String[] args) {
        Funcionario hwasa = new Funcionario("Hwasa", "111.222.333-44", 4500, "56546546");
        Funcionario moonbyul = new Funcionario();

//                Se usássemos o método init
//        hwasa.init("Hwasa", "111.222.333-44;", 4500, "565255995");

//                Se usássemos o método setting
//        hwasa.setName("Hwasa");
//        hwasa.setCpf("111.222.333-44");
//        hwasa.setSalary(4500);

        hwasa.imprimeInformacoes();
        System.out.println("-----------------");
        moonbyul.imprimeInformacoes();


    }
}
