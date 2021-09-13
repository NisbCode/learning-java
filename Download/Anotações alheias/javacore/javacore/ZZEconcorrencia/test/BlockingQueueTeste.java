package br.com.abc.javacore.ZZEconcorrencia;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * BLOCKING QUEUE
 * Trabalha no modelo produtor-consumidor, em que uma thread
 * produz os dados e coloca numa queue, entquanto outra consome dessa lista
 */

public class BlockingQueueTeste {
    public static void main(String[] args) throws InterruptedException {
                                                              // Quantos itens a queue pode ter
        BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1);
        Thread t1 = new Thread(new RemoveFromQueue(bq));
        // Lembrete: put(), adiciona um valor dentro da queue
        bq.put("William");
        // Lembrete: peek(), pega o valor e não o remove da queue
        System.out.println(bq.peek());
        System.out.println("Tentando colocar outro valor");

        t1.start();

        bq.put("DevDojo, o melhor dojo de TI do Brasil");
        System.out.println("Inserindo o ultimo valor");
    }

    static class RemoveFromQueue implements Runnable{
        private BlockingQueue<String> bq;

        public RemoveFromQueue(BlockingQueue<String> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " entrando em espera por 2 segundos");
            try {
                TimeUnit.SECONDS.sleep(2);
                // take(), vai remover o valor que tem na queue e
                // permitir que a thread que está esperando para adicionar
                // outro faça seu trabalho
                System.out.println("Removendo o valor " + bq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * OUTRAS BLOCKING QUEUES
     * SynchronousQueue: tem capacidade 0, ou seja, não pode ter
     * algum item dentro. Isso faz com que, se o desenvolvedor
     * faz algum comando, por exemplo, adicionar algo, então a
     * operação fica bloqueada até outra thread vir e fazer a
     * operação oposta, tipo remover, nesse caso
     *
     * DelayQueue: objetos que não devem ser consumidos antes de
     * um determinado tempo
     */
}
