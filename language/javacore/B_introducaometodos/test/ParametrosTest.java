package Estudando.javacore.B_introducaometodos.test;

import Estudando.javacore.B_introducaometodos.classes.Calculadora;

public class ParametrosTest {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        int num1 = 5;
        int num2 = 10;
        calc.alterandoImpressoes(num1, num2);
        System.out.println("Dontro do teste");
        System.out.println(num1);
        System.out.println(num2);
    }
}
