package br.com.abc.javacore.ZZDthreads.classe;

/**
 * THREADS
 * Como se fossem trabalhadores que fazem os processos do
 * java, quanto mais threads, mais processos podem ser
 * feitos ao mesmo tempo
 * Aqui no java, as threads são instâncias (objetos) e também
 * linhas executáveis, algo como processos paralelos
 * Há 2 tipos de threads:
 * Daemon: threads que não influenciam no trabalho da JVM
 * (ex: garbage collector)
 * User: threads que, enquanto não terminarem, não encerrarão
 * a JVM
 */

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        // Para saber o nome de uma thread
        System.out.println(Thread.currentThread().getName());
        /**
         * Threads baseadas nas instâncias
         */
//        ThreadExemplo t1 = new ThreadExemplo('A');
//        ThreadExemplo t2 = new ThreadExemplo('B');
//        ThreadExemplo t3 = new ThreadExemplo('C');
//        ThreadExemplo t4 = new ThreadExemplo('D');


        /**
         * Thread baseadas na interface
         */
        Thread t1 = new Thread(new ThreadExemploRunnable('A'), "Thread1");
        Thread t2 = new Thread(new ThreadExemploRunnable('B'), "Thread2");
        Thread t3 = new Thread(new ThreadExemploRunnable('C'), "Thread3");
        Thread t4 = new Thread(new ThreadExemploRunnable('D'), "Thread4");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();


//        /**
//         * MÉTODO setPriority(): define a prioridade de
//         * execução das threads, as boas praticas mandam
//         * usar os valores MAX_PRIORITY(10), MIN_PRIORITY(1)
//         * e NORM_PRIORITY(5), só não é algo confiavel
//         */
//        t4.setPriority(Thread.MAX_PRIORITY);
//        t1.start();
//        /**
//         * MÉTODO join(): faz com que um método só seja executado
//         * quando o anterior ja terminou de ser executado. Não é
//         * estático, ou seja, depende do objeto instanciado para
//         * existir, diferente dos anteriores
//         */
//        // esse join lança uma exceção, eu preferi lançar
//        // ela a classe que tratar com try-catch
//        t1.join();
//        t2.start();
//        t3.start();
//        t4.start();
//        // Isso não pode ser feito, pois uma thread ao ser
//        // inicializada, não pode ser inicializada de novo
//        t1.start();
//        // O sleep pode ser colocado aqui também
//        Thread.sleep(2000);
    }
}

/**
 * Thread objeto
 */
//class ThreadExemplo extends Thread {
//    private char c;
//
//    public ThreadExemplo (char c){
//        this.c = c;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 1000; i++) {
//            System.out.print(c);
//            if(i % 100 == 0){
//                System.out.println();
//                System.out.println("rola");
//            }
//        }
//    }
//}

/**
 * Criando thread baseada em interface
 */

class ThreadExemploRunnable implements Runnable {
    private char c;

    public ThreadExemploRunnable(char c) {
        this.c = c;
    }

    // O método run é obrigatório na implementação
    @Override
    public void run() {
        //        System.out.println("Thread executada: " + Thread.currentThread().getName());
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + c + " ");
            if (i % 10 == 0) {
                System.out.println();
            }

            //            if (Thread.currentThread().getName().equals("Thread1")){
            //                Thread.yield();
            //            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            /**
             * método yield(): faz com que a thread volte
             * para o estado Runnable, o estado de inicialização,
             * antes de ser acionado nela o run, e depois, faz com
             * que as que tem maior prioridade voltem para o estado
             * Running, quando o run é acionado
             */
            //            Thread.yield();
            //
            //            /**
            //             * MÉTODO sleep(), faz com que a thread durma por alguns
            //             * momentos para que possa ser feita a execução de outra thread
            //             */
            //            try {
            //                Thread.sleep(2000);
            //            } catch (InterruptedException e) {
            //                e.printStackTrace();
            //            }
        }

    }
}


