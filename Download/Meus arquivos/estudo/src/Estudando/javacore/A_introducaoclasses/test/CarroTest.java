package Estudando.javacore.A_introducaoclasses.test;

import Estudando.javacore.A_introducaoclasses.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro carro = new Carro();

        carro.modelo = "Ferrari";
        carro.placa = "FBY1822";
        carro.velocidadeMaxima = 120f;

        System.out.println(carro.modelo);
        System.out.println(carro.placa);
        System.out.println(carro.velocidadeMaxima);
    }
}
