package Estudando.javacore.ZZMcompletablefuture.teste;


import Estudando.javacore.ZZMcompletablefuture.classe.Loja;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LojaTeste {
    public static void main(String[] args) {
        Loja americanas = new Loja();
        Loja casasBahia = new Loja();
        Loja bestBuy = new Loja();
        Loja wallmart = new Loja();

//        System.out.println("Preços exibidos de forma síncrona");
//
//        // Tempo de inicio da operação
//        long start = System.currentTimeMillis();
//
//        System.out.println(americanas.getPreco());
//        System.out.println(casasBahia.getPreco());
//        System.out.println(bestBuy.getPreco());
//        System.out.println(wallmart.getPreco());
//
//        // Tempo do término da operação
//        long end = System.currentTimeMillis();
//
//        System.out.println("Tempo da operação: " + (end - start) + " ms");

        System.out.println("------------------------------------------------");

        System.out.println("Preços exibidos de forma assíncrona");

        // Tempo de inicio da operação
        long startAsync = System.currentTimeMillis();
        // Aqui a gente faz a operação de pegar os preços
        Future<Double> precoAsyncAmericanas = americanas.getPrecoAsync();
        Future<Double> precoAsyncCasasBahia = casasBahia.getPrecoAsync();
        Future<Double> precoAsyncBestBuy = bestBuy.getPrecoAsync();
        Future<Double> precoAsyncWallmart = wallmart.getPrecoAsync();

        // Marcamos o fim desse processo de busca
        long endAsyncInvocacao = System.currentTimeMillis();

        System.out.println("Tempo de invocação dos preços: " + (endAsyncInvocacao - startAsync) + " ms");

        // Método que será feito enquanto os preços são invocados
        enrolandoComSoma();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // E após o enrolandoComSoma(), exibir as buscas que a thread ja fez
        try {
                                           // Independente do que acontecer, é uma boa prática deixar
                                           // o tempo pro timeout, basicamente um "parar o código no tempo
                                           // n se ele travar em algum ponto". Isso impede que threads
                                           // continuem rodando em caso de exceções
            System.out.println("Americanas: " + precoAsyncAmericanas.get(3, TimeUnit.SECONDS));
            System.out.println("CasasBahia: " + precoAsyncCasasBahia.get(3, TimeUnit.SECONDS));
            System.out.println("BestBuy: " + precoAsyncBestBuy.get(3, TimeUnit.SECONDS));
            System.out.println("Wallmart: " + precoAsyncWallmart.get(3, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        long endAsyncExibicao = System.currentTimeMillis();

        System.out.println("Tempo de invocacao e exibição dos precos: " + (endAsyncExibicao - startAsync) + " ms");

    }

    private static void enrolandoComSoma() {
        long soma = 0;
        for (int i = 0; i < 1_000_000; i++) {
            soma += i;
        }
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(soma);
    }

}
