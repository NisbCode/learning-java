package Estudando.javacore.ZZD_concorrencia.test;


import java.util.concurrent.*;

/**
 * INTERFACE Callable
 * Mesma coisa que a interface Runnable, que te manda usar
 * um método run, só que o run() dessa Callable não é void
 */

public class CallableTest implements Callable<String> { //Usando generics p informar oq vamos retornar no método Call
    public static void main(String[] args) {
        // Lembrete: não é recomendável usar wait(), notify()
        // e notifyAll() com executors porque isso interfere
        // na execução das threads
        CallableTest ct = new CallableTest();
        ExecutorService executorService = Executors.newCachedThreadPool();  //Explicado newCachedThreadPool(); na aula de ExecutorTest (50.7)
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
        //ThreadLocalRandom() e Math.random() servem p pôr um valor aleatório
        // ThreadLocalRandom(): mesma coisa que queo Math.random(),
        // mas apropriado para ambientes concorrentes. O Math.random() é
        // sincronizado, o que torna necessário adquirir o lock do
        // objeto. Com o ThreadLocalRandom() não tem esse problema,
        // pois cada thread vai ter seu próprio numero aleatorio
        // argumentos: intervalo entre numeros
        int contador = ThreadLocalRandom.current().nextInt(1, 11);  //Pegando valores de 1 à 11
        for (int i = 0; i < contador; i++) {
            System.out.println(Thread.currentThread().getName() + " executando...");

        }
        return "Trabalho finalizado. O número aleatório é: " + contador;  //O número aleatório de vezes q a Thread x funcionou foi x
    }
}