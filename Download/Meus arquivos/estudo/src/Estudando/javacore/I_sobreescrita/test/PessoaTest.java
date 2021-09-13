package Estudando.javacore.I_sobreescrita.test;

import Estudando.javacore.I_sobreescrita.classes.Pessoa;

public class PessoaTest {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Joaquina na Esquina");
        p.setIdade(300);
        System.out.println(p);

    }
}
