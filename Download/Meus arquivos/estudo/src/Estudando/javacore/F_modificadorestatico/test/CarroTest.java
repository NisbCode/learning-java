package Estudando.javacore.F_modificadorestatico.test;

import Estudando.javacore.F_modificadorestatico.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro.setVelocidadeLimite(220);
        Carro c1 = new Carro("BMW", 230);
        Carro c3 = new Carro("Audi", 275);
        Carro c2 = new Carro("Mercedes", 290);


        c1.imprime();
        c2.imprime();
        c3.imprime();

        //Vamos mudar o valor da variável static para ver a diferença:
        System.out.println("****************************************");

        //valores estáticos são chamados assim:
        Carro.velocidadeLimite = 220;

        c1.imprime();
        c2.imprime();
        c3.imprime();

        //Mudando um, muda caceta toda
    }
}
