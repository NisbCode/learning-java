package Estudando.javacore.J_modificadorfinal.test;

import Estudando.javacore.J_modificadorfinal.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro c = new Carro();
        c.getComprador().setNome("Hannah");
        System.out.println(c.getComprador());
    }
}
