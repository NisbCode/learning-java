package br.com.abc.javacore.Ycolecoes.teste;

import br.com.abc.javacore.Ycolecoes.classe.Produto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/***
 * REMOVENDO ITENS COM ITERATOR
 */

public class IteratorTeste {
    public static void main(String[] args) {
                        // Troca do ArrayList pro LinkedList,
                        // porque a execução dele é mais rapida se tratando
                        // de remoção
        List<Produto> produtos = new ArrayList<>();

        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0, 0);
        Produto produto2 = new Produto("321", "Picanha", 26.4, 10);
        Produto produto3 = new Produto("879", "Teclado Razer", 1000.0, 5);
        Produto produto4 = new Produto("012", "Samsung Galaxy S7", 3250.0, 0);

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);

//        // Forma sem o iterator (mais complicada e não recomendada)
//        for(Produto produto : produtos){
//            // Teoricamente é possível fazer dessa forma, usando
//            // um remove() dentro de um for, mas na prática vai
//            // dar uma ConcurrentModificationException,
//            // ou seja, a tentativa de modificar um array em tempo de execução
//            if(produto.getQuantidade() == 0){
//                produtos.remove(produto);
//            }
//        }

        // Com o interator
        Iterator<Produto> produtoIterator = produtos.iterator();
        // Enquanto tiver um próximo item...
        while (produtoIterator.hasNext()){
            // ... chame e avalie esse item
            Produto produto = produtoIterator.next();
            if(produto.getQuantidade() == 0){
                produtoIterator.remove();
            }
        }

        System.out.println("Restam " + produtos.size() + " produtos");
    }
}
