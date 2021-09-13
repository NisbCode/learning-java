package Estudando.javacore.M_interfaces.test;

import Estudando.javacore.M_interfaces.classes.Produto;

public class TestProduto {
    public static void main(String[] args) {
        Produto p = new Produto("Ventilador Linox", 4, 750);
        p.calcularImposto();
        p.calculaFrete();
        System.out.println(p);
    }
}
