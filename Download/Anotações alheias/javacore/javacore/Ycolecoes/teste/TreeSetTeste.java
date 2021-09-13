package br.com.abc.javacore.Ycolecoes.teste;

import br.com.abc.javacore.Ycolecoes.classe.Celular;
import br.com.abc.javacore.Ycolecoes.classe.Produto;

/***
 * INTERFACE NAVIGABLE SET:
 * Adiciona características que o Set não possui
 * Vantagem: elementos ordenados automáticamente ao ser
 * inseridos
 * Regras:
 * 1- Os elementos adicionados devem ser objetos que
 * implementam Comparable, se não implementar, virá uma
 * ClassCastException
 */

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetTeste {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0);
        Produto produto2 = new Produto("321", "Picanha", 10d);
        Produto produto3 = new Produto("879", "Teclado Razer", 1000.0);
        Produto produto4 = new Produto("012", "Samsung Galaxy S7", 3250.0);
        // Duplicata do produto4, vai continuar não funcionando
        Produto produto5 = new Produto("012", "Samsung Galaxy S7", 3250.0);
        Celular celular = new Celular("iPhone 10", "1234");

        NavigableSet<Produto> produtoNavigableSet = new TreeSet<>();
        NavigableSet<Celular> celularNavigableSet = new TreeSet<>();

        produtoNavigableSet.add(produto1);
        produtoNavigableSet.add(produto2);
        produtoNavigableSet.add(produto3);
        produtoNavigableSet.add(produto4);
        produtoNavigableSet.add(produto5);

        for(Produto produto : produtoNavigableSet.descendingSet()){
            System.out.println(produto);
        }

        System.out.println("--------------------");

        /***
         * Métodos Importantes: baseados num produto de
         * referência, retornam:
         * lower(): o item anterior
         * floor(): a referencia e o item anterior
         * higher(): o posterior
         * ceiling(): a referencia e o posterior
         *
         * descendingSet(): retorna a lista na ordem inversa, deve ser
         * usado na lista de referencia do for-each
         *
         * pollFirst(): retorna o produto requerido e o exclui da lista
         * pollLast(): mesma coisa, mas com o ultimo produto
         */
        // Qual o produto de preço mais baixo antes do produto 4
        System.out.println("Produto mais barato antes do produto4" + produtoNavigableSet.lower(produto4));

        System.out.println("-------------------------------");

        // pollFirst Teste
        System.out.println(produtoNavigableSet.size());
        System.out.println(produtoNavigableSet.pollFirst());
        System.out.println(produtoNavigableSet.size());



    }
}
