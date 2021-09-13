package br.com.abc.javacore.Ycolecoes.teste;

import java.util.PriorityQueue;
import java.util.Queue;

/***
 * INTERFACE QUEUE (se fala "quiu", tá?)
 * Define os objetos por ordem de prioridade, definida
 * pelo Comparable. Se o tipo usado não tiver Comparable,
 * retornorá a exceção ClassCastException
 */

public class QueueTeste {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("C");
        queue.add("D");
        queue.add("A");
        queue.add("B");
        System.out.println(queue);

        /***
         * MÉTODOS ÚTEIS:
         * peek(): pega o primeiro elemento sem remover
         * poll() pega o primeiro elemento e o remove
         * offer(): define uma capacidade pra queue
         * remove(): remove os itens pela ordem em que estão
         * colocados
         */
    }
}
