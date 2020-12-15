package Estudando.javacore.Y_colecoes.test;

/***
 * INTERFACE SET:
 * Para usar no lugar do list por alguns beneficios
 * Não é indexado
 * Principal característica: Não permite elementos duplicados
 */

import Estudando.javacore.Y_colecoes.classes.Produto;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0);
        Produto produto2 = new Produto("321", "Picanha", 10d);
        Produto produto3 = new Produto("879", "Teclado Razer", 1000.0);
        Produto produto4 = new Produto("012", "Samsung Galaxy S7", 3250.0);
        // Duplicata do produto4
        Produto produto5 = new Produto("012", "Samsung Galaxy S7", 3250.0);

        // LinkedHashSet: se preocupa em manter a
        // ordem de exceção
        Set<Produto> produtoSet = new LinkedHashSet<>();
        produtoSet.add(produto1);
        produtoSet.add(produto2);
        produtoSet.add(produto3);
        produtoSet.add(produto4);

        for(Produto p : produtoSet) {
            System.out.println(p);
        }
    }
}
