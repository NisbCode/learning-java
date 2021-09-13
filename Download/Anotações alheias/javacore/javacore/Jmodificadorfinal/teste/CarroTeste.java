package br.com.abc.javacore.Jmodificadorfinal.teste;

import br.com.abc.javacore.Jmodificadorfinal.classes.Carro;

public class CarroTeste {
    public static void main(String[] args) {
        Carro c = new Carro();
        System.out.println(c.getComprador());
        c.getComprador().setNome("Kuririn");
        System.out.println(c.getComprador());
        //Uma vez criada a referencia para um comprador,
        //não pode criar outra, isso que o moddificador
        //final faz
//        c.comprador = new Comprador;

    }
}
