package Estudando.javacore.ZZD_concorrencia.test;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CLASSE Executors
 * Serve para lidar diretamente com as threads em um nível mais alto,
 * ter um controle maior sobre o comportamento exato delas
 */

public class ExecutorTest {
    public static void main(String[] args) {
        /**
         * Quantidades de processadores nesse computador
         * cada nucleo de processador possui 2 threads que
         * vão trabalhar exatamente ao mesmo tempo, e as
         * outras threads trabalharão serão executadas
         * após uma pacela de tempo
         */
        System.out.println("Quantidade de processadores da maquina: " + Runtime.getRuntime().availableProcessors());

        // Com esse método, definimos que duas threads apenas vão trabalhar no cumprimento dessa tarefa
        ExecutorService executorService = Executors.newFixedThreadPool(2); //O bom é vc usar menos q a quantidade de Threads q será disponível(Ex.: se tenho duas, põe -/= à 4)

        // e essas 2 threads vão se dividir para executar essas tarefas msm q vc inicie mais do q tem, o programa reutilizará outros  existentes
        executorService.execute(new ThreadTrabalhadoraExecutor("1"));
        executorService.execute(new ThreadTrabalhadoraExecutor("2"));
        executorService.execute(new ThreadTrabalhadoraExecutor("3"));
        executorService.execute(new ThreadTrabalhadoraExecutor("4"));
        executorService.execute(new ThreadTrabalhadoraExecutor("5"));

        // depois que terminar o uso do pool de executors, é necessário esse método para finalizar o processo
        executorService.shutdown();

        // Só que pra garantir que a finalização seja anunciada, é necessario adicionar um
        // while
        while (!executorService.isTerminated()){}
        System.out.println("O processo terminou?: " + executorService.isTerminated());
        System.out.println("Finalizado");

        /**
         * Tem mais dois métodos que tambem podem ser utilizados ao invés do newFixedThreadPool():
         * -newCachedThreadPool(): cria quantas threads forem necessarias para a execução do processo
         * e remove threads inutilizadas por 60 segundos
         *
         * -newSingleThreadExecutor(): Usa apenas uma thread para executar as tarefas e as tarefas
         * que não podem ser realizadas naquele momento são colocadas numa queue
         */
    }
}

class ThreadTrabalhadoraExecutor implements Runnable {
    private String num;

    public ThreadTrabalhadoraExecutor(String num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " iniciou: " + num);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finalizou");
    }
}

