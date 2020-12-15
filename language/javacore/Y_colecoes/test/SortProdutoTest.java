package Estudando.javacore.Y_colecoes.test;


import Estudando.javacore.Y_colecoes.classes.Produto;

import java.util.*;

/***
 * COMPARATOR:
 * Alternativa a interface Comparable
 * caso o padrão de ordem deva ser mudado depois que o
 * método compareTo já foi chamado
 */
class ProdutoNomeComparator implements Comparator<Produto> {

    @Override
    // Aqui são dois argumentos porque o outro compara
    // elementos da própria classe com outros, aqui
    // estamos pegandos dois elementos de outra classe pra
    // comparar e nenhum dessa
    public int compare(Produto o1, Produto o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}

public class SortProdutoTest {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0);
        Produto produto2 = new Produto("321", "Picanha", 26.4);
        Produto produto3 = new Produto("878", "Teclado Razer", 1000.0);
        Produto produto4 = new Produto("012", "Samsung Galaxy S7", 3250.0 );

        produtos.add(produto1);  //Para adicionar estes produtos a lista de produtos
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);

        // Nesse caso, não tem um padrão pré definido,
        // sendo assim, o java vai dar erro de compilação
        // Para contornar isso, deve-se implementar a classe
        // Comparable

        // Depois da lista vem o padrão do Comparator
//        N é necessário criar um método da classe mas assim c  vai poder chamar ou criar várias ordenações
        Collections.sort(produtos, new ProdutoNomeComparator());

        System.out.println("Produtos na List:");
        for (Produto produto : produtos){
            System.out.println(produto);
        }

        // Também funciona com Arrays:
        Produto[] produtoArray = new Produto[4];
        produtoArray[0] = produto1;
        produtoArray[1] = produto2;
        produtoArray[2] = produto3;
        produtoArray[3] = produto4;

        // Para imprimir um array é possível usar isso,
        // ao invés do for
        System.out.println(" ");
        System.out.println("Produtos impressos em Array");
        System.out.println(Arrays.toString(produtoArray));

        // Agora usando um método sort() num array
        System.out.println(" ");
        System.out.println("Produtos com sort() em Array:");
        // Vai ter o padrão definido pela Camparable, se não
        // for adicionado o Comparator
        Arrays.sort(produtoArray);
        for (Produto produto : produtoArray){
            System.out.println(produto);
        }

    }
}
