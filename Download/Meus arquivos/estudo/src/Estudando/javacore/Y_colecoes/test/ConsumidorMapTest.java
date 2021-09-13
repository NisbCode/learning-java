package Estudando.javacore.Y_colecoes.test;


import Estudando.javacore.Y_colecoes.classes.Consumidor;
import Estudando.javacore.Y_colecoes.classes.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumidorMapTest {
    public static void main(String[] args) {
        Consumidor consumidor = new Consumidor("Nathália Ignácio", "123");
        Consumidor consumidor2 = new Consumidor("DevDojo", "321");

        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0);
        Produto produto2 = new Produto("321", "Picanha", 26.4);
        Produto produto3 = new Produto("878", "Teclado Razer", 1000.0);
        Produto produto4 = new Produto("012", "Samsung Galaxy S7", 3250.0 );

        Map<Consumidor, Produto> map = new HashMap<>();  //Quero saber oq aquele consumidor comprou
        map.put(consumidor, produto2);
        map.put(consumidor2, produto4);
        for (Map.Entry<Consumidor, Produto> entry : map.entrySet()){
            System.out.println(entry.getKey().getNome() + " - " + entry.getValue().getNome());
        }

        System.out.println("-----------------------");


        // E se um consumidor comprou mais que um produto?:
        List<Produto> produtosConsumidor1 = new ArrayList<>();
        produtosConsumidor1.add(produto1);
        produtosConsumidor1.add(produto2);
        List<Produto> produtosConsumidor2 = new ArrayList<>();
        produtosConsumidor2.add(produto3);
        produtosConsumidor2.add(produto4);

        Map<Consumidor, List<Produto>> map2 = new HashMap<>(); //Uma Lsita de Cponsumidores comprando uma lista de produtos
        map2.put(consumidor, produtosConsumidor1);
        map2.put(consumidor2, produtosConsumidor2);

        for (Map.Entry<Consumidor, List<Produto>> entry : map2.entrySet()){
            System.out.println(entry.getKey().getNome() + ":");
            for (Produto produto : entry.getValue()){  //Só q vc vai precisar de um for p dizer o value q é uma lista
                System.out.println(produto.getNome());
            }
        }
    }
}
