package Estudando.javacore.ZZD_concorrencia.test;


import java.util.concurrent.locks.ReentrantLock;

/**
 * CLASSE ReentrantLock
 * Obtém o lock de algum objeto, como o synchronized,
 * contudo, tem alguns aprimoramentos. Por exemplo,
 * segurar aquele lock por apenas um período de tempo,
 * o dar aquele lock à thread que está a mais tempo sem atuar
 * Só deve ser usado no lugar do synchronized em casos bem específicos,
 * em que os exemplos anteriores sejam necessários para o funcionamento
 */

public class LockTest {
    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        new Thread(new Worker("A", lock)).start();
        new Thread(new Worker("B", lock)).start();
        new Thread(new Worker("C", lock)).start();
        new Thread(new Worker("D", lock)).start();
        new Thread(new Worker("E", lock)).start();
        new Thread(new Worker("F", lock)).start();
        new Thread(new Worker("G", lock)).start();
    }
    static class Worker implements Runnable{
        private String nome;
        private ReentrantLock reentrantLock;

        public Worker(String nome, ReentrantLock reentrantLock){
            this.nome = nome;
            this.reentrantLock = reentrantLock;
        }

        @Override
        public void run() {
            /**
             * 2.1- método usado para obter o lock
             */
            reentrantLock.lock();
            try {
                // se o reentrantLock está sendo segurado pela thread atual...
                if(reentrantLock.isHeldByCurrentThread()){
                    System.out.printf("Thread %s entrou numa sessão crítica \n", nome);  //%s é substituido pelo nome dito dps da vírgula
                }
                System.out.printf("%d Threads esperando na fila \n", reentrantLock.getQueueLength());
                System.out.printf("Thread %s vai trabalhar por 2 segundos \n", nome);
                Thread.sleep(2000);
                System.out.printf("Thread %s terminou o trabalho \n", nome);



            } catch (InterruptedException e) {
                e.printStackTrace();
                /**
                 * 2.2- o unlock deve vir num finally
                 */
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
