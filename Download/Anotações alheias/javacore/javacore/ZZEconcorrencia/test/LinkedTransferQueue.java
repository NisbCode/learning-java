package br.com.abc.javacore.ZZEconcorrencia;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * CLASSE LinkedTransferQueue
 * Classe que reune o comportamento das collections antes
 * citadas numa só classe, é mais recomendado usar, de acordo
 * com a Katy Sierra
 */

public class LinkedTransferQueue {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> tq = new java.util.concurrent.LinkedTransferQueue<>();
        /**
         * Formas de adicionar valores
         */
        // se não tiver nada nos parênteses, vai lançar exceção
        System.out.println(tq.add("Jungkook"));

        // bloqueia se a capacidade tiver estourada
        tq.put("Devdojo");

        // retorna true se for adicionado ou false se o limite
        // estiver estourado, recomendado no lugar do add
        System.out.println(tq.offer("Jungkook"));

        // offer() sobrecarregado, checa se um item foi adicionado
        // dentro de algum espaço de tempo
        System.out.println(tq.offer("Jungkook", 10, TimeUnit.SECONDS));

        // bloqueia a operação até que esse elemento seja consumido por
        // outra thread
//        tq.transfer("Devdojo");
        // vai retornar true se for consumido por uma thread que ta
        // esperando, se não tiver thread esperando, vai retornar false
        System.out.println(tq.tryTransfer("Devdojo"));

        // funciona da mesma forma que o offer sobrecarregado, mas
        // esse espera um determinado tempo para ser consumido
        System.out.println(tq.tryTransfer("Devdojo", 10, TimeUnit.SECONDS));

        // capacidade do TransferQueue
        System.out.println(tq.remainingCapacity());

        /**
         * Formas de pegar valores
         */
        // pega determinado valor sem remover, lança exceção
        // se tiver vazio
        System.out.println(tq.element());

        // pega o primeiro valor sem remover e retonar null
        // se for vazio
        System.out.println(tq.peek());

        // pega o primeiro valor e o remove da lista
        System.out.println(tq.poll());

        // poll() sobrecarregado, remove o primeiro valor e espera
        // esse tempo antes de retornar null se tiver vazio
        System.out.println(tq.poll(10, TimeUnit.MILLISECONDS));

        // remove o primeiro valor e retorna uma exceção se estiver vazio
        System.out.println(tq.remove());

        // vai remover o primeiro valor ou bloquear
        System.out.println(tq.take());
    }
}
