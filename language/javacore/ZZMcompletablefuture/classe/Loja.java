package Estudando.javacore.ZZMcompletablefuture.classe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja {
    private String nome;

    public Loja(String nome) {
        this.nome = nome;
    }

    public Loja() {
    }

    public double getPreco(){
        // pega o preço dos produtos
        return calcularPreco();
    }

    public Future<Double> getPrecoAsync(){
        CompletableFuture<Double> precoFuturo = new CompletableFuture<>();
        Thread thread1 = new Thread(() -> {
            // É uma boa prática precaver métodos envolvendo threads com exceptions...
            try {
                precoFuturo.complete(calcularPreco());
            } catch (Exception e) {
                precoFuturo.completeExceptionally(e);
            }
        });
        thread1.start();
        return precoFuturo;
    }

    public Future<Double> getPrecoAsyncTunado(){
        // ... mas é muito mais fácil tratar deles assim, em uma linha
        // O método supplyAsynch() faz exatamente isso, cobre o método por exceptions
        // para que o código possa, pelo menos, ser finalizado
                                // Note o uso do this pra representar essa mesma classe
        return CompletableFuture.supplyAsync(this::calcularPreco);
    }

    private double calcularPreco(){
        delay();
        // Esse é tipo o método Math.random(), mas adaptado pra threads
        // e multiplicado por 100, pq o resultado aparece entre 0 e 1
//        System.out.println(1 / 0);       //<---Forçar um erro p demonstrar documentos 58.2 e 58.3
        return ThreadLocalRandom.current().nextDouble() * 100;
    }

    private static void delay(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getNome() {
        return nome;
    }
}
