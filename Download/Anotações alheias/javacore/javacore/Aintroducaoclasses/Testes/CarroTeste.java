package br.com.abc.javacore.Aintroducaoclasses.Testes;

import br.com.abc.javacore.Aintroducaoclasses.classe.Carro;

public class CarroTeste {
    public static void main(String[] args) {

        Carro carro = new Carro();
        carro.modelo = "Fusca";
        carro.placa = "QWJ1029";
        carro.velocidadeMaxima = 120f;

        System.out.println(carro.placa);

    }
}
