package Estudando.javacore.ZZD_concorrencia.test;


/**
 * Classe SchedulerThreadPool
 * propria para executar tarefaz de um tanto em
 * tanto tempo
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulerThreadPoolTest {
    private static final ScheduledExecutorService schedulerExecutorService = Executors.newScheduledThreadPool(1);

    public static void beep() {
        final Runnable horario = new Runnable() {
            @Override
            public void run() {
                System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()) + " beep");  //Setando p hr min e seg
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        /**
         * A mágica é feita através desse fazAlgumaCoisa:
         */
        // Parâmetros: Runtime, ponto de partida, periodo, unidade a ser usada
//        schedulerExecutorService.scheduleAtFixedRate(horario, 1, 5, TimeUnit.SECONDS);

        ScheduledFuture beep = schedulerExecutorService.scheduleAtFixedRate(horario, 1, 4, TimeUnit.SECONDS);
        final Runnable cancelar = new Runnable() {
            @Override
            public void run() {
                System.out.println("Cancelando");
                beep.cancel(false);
                schedulerExecutorService.shutdown();
            }
        };
        schedulerExecutorService.schedule(cancelar, 10, TimeUnit.SECONDS);


        /**
         * Além disso temos mais esses métodos:
         * scheduleWithFixedRate(): funciona da mesma forma
         * que o scheduleAtFixedRate(), só que, caso uma pausa de
         * processamento seja maior que o período,
         * o scheduleAtFixedRate() retorna logo em seguida
         * ao "despertar" do método, já o scheduleWithFixedRate()
         * apenas desperta após a contagem do período(Conta quanto vc pôs p começar a execução do trabalho mais quanto tempo de cooldown)
         *
         */


    }

    public static void main(String[] args) {
        beep();
    }

}
