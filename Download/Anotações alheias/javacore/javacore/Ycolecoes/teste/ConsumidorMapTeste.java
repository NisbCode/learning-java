package br.com.abc.javacore.Ycolecoes.teste;

import br.com.abc.javacore.Ycolecoes.classe.Consumidor;
import br.com.abc.javacore.Ycolecoes.classe.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumidorMapTeste {
    public static void main(String[] args) {
        Consumidor consumidor = new Consumidor("Amanda Porto", "123");
        Consumidor consumidor2 = new Consumidor("DevDojo", "321");

        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0);
        Produto produto2 = new Produto("321", "Picanha", 26.4);
        Produto produto3 = new Produto("878", "Teclado Razer", 1000.0);
        Produto produto4 = new Produto("012", "Samsung Galaxy S7", 3250.0 );

        Map<Consumidor, Produto> map = new HashMap<>();
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

        Map<Consumidor, List<Produto>> map2 = new HashMap<>();
        map2.put(consumidor, produtosConsumidor1);
        map2.put(consumidor2, produtosConsumidor2);

        for (Map.Entry<Consumidor, List<Produto>> entry : map2.entrySet()){
            System.out.println(entry.getKey().getNome() + ":");
            for (Produto produto : entry.getValue()){
                System.out.println(produto.getNome());
            }
        }
    }
}
