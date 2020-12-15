package Estudando.javacore.Y_colecoes.test;


import Estudando.javacore.Y_colecoes.classes.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * BINARY SEARCH:
 * Funciona que nem o método contains(), pra ver se tem um determinado
 * item na lista, mas retorna o indice de onde está esse item,
 * não apenas true ou false cm o .containsAll
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);

        // Ordem de utilização:
        // 1- Deve-se criar um padrão usando a Comparable
        Collections.sort(numeros);

        // 2- Só então deve-se usar o binarySearch()
        System.out.println("Este item está no índice: " + Collections.binarySearch(numeros, 7));

        // 3- E para achar o item dentro da posição requerida
//        System.out.println("O item procurado é: "  + numeros.get(Collections.binarySearch(numeros, 2)));

        // Exemplo com objetos do tipo Produto
        List<Produto> produtos = new ArrayList<>();
        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0);
        Produto produto2 = new Produto("321", "Picanha", 26.4);
        Produto produto3 = new Produto("878", "Teclado Razer", 1000.0);
        Produto produto4 = new Produto("012", "Samsung Galaxy S7", 3250.0 );

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);

        Collections.sort(produtos, new ProdutoNomeComparator());

        // Novo produto na lista
        Produto produto5 = new Produto("000", "Antena", 50.0 );

        // Busca por esse novo produto
        // Ordem: lista, item, Comparator


        for (Produto produto : produtos){
            System.out.println(produto);
        }
        // A fórmula -(ponto de interceção) - 1 vai fazer retornar -1,
        // ou seja, o item buscado (a antena) está na posição 0
        System.out.println(Collections.binarySearch(produtos, produto5, new ProdutoNomeComparator()));
    }
}