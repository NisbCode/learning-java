package br.com.abc.javacore.ZZEconcorrencia;

import java.util.concurrent.*;

/**
 * INTERFACE Callable
 * Mesma coisa que a interface Runnable, que te manda usar
 * um método run, só que o run() dessa Callable não é void
 */

public class CallableTeste implements Callable<String> {
    public static void main(String[] args) {
        // Lembrete: não é recomendável usar wait(), notify()
        // e notifyAll() com executors porque isso interfere
        // na execução das threads
        CallableTeste ct = new CallableTeste();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> resultFuture = executorService.submit(ct);
        try {
            String s = resultFuture.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    @Override
    public String call() throws Exception {
        // ThreadLocalRandom(): mesma coisa que queo Math.random(),
        // mas apropriado para ambientes concorrentes. O Math.random() é
        // sincronizado, o que torna necessário adquirir o lock do
        // objeto. Com o ThreadLocalRandom() não tem esse problema,
        // pois cada thread vai ter seu próprio numero aleatorio
                                              // argumentos: intervalo entre numeros
        int contador = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i = 0; i < contador; i++) {
            System.out.println(Thread.currentThread().getName() + " executando...");
            
        }
        return "Trabalho finalizado. O número aleatório é: " + contador;
    }
}
