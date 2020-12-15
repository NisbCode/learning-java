package Estudando.javacore.ZZC_threads.test;



/**
 * DEADLOCK:
 * quando 2 threads estão correndo e uma se torna
 * dependente do lock que a outra tem para que possa continuar
 * a correr. Como essa espera é o passo final para que
 * as threads completem sua "missão", ela acaba acontecendo
 * pra sempre, fazendo, assim, com que o código morra
 */

public class DeadlockTest {
    // a chamada doas classes de exemplo
    public static void main(String[] args) {
        ThreadExemplo1 threadEx1 = new ThreadExemplo1();
        ThreadExemplo2 threadEx2 = new ThreadExemplo2();

        Thread t0 = new Thread(threadEx1);
        Thread t1 = new Thread(threadEx1);
        Thread t2 = new Thread(threadEx2);
        Thread t3 = new Thread(threadEx2);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }

    // atribuição dos locks
    private static final Object lock2 = new Object();
    private static final Object lock1 = new Object();

    // classe ThreadExemplo1 com método run
    private static class ThreadExemplo1 extends Thread{
        public void run(){


            // o synchronized para garantir quem vai executar primeiro
            synchronized (lock1){
                System.out.println("Dentro do lock2 da ThreadExemplo1");
                System.out.println(Thread.currentThread().getName() + ": Segurando lock 1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": Esperando pelo lock 1");


                synchronized (lock2){
                    System.out.println("Dentro do lock1 da ThreadExemplo1");
                    System.out.println(Thread.currentThread().getName() + ": segurando lock 2");
                }
            }
        }
    }

    private static class ThreadExemplo2 extends Thread{
        public void run(){
            synchronized (lock1){
                System.out.println("Dentro do lock1 da ThreadExemplo2");
                System.out.println(Thread.currentThread().getName() + ": Segurando lock 2");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": Esperando pelo lock 2");
                synchronized (lock2){
                    System.out.println("Dentro do lock2 da ThreadExemplo2");
                    System.out.println(Thread.currentThread().getName() + " : segurando lock 1");
                }
            }
        }
    }
}


