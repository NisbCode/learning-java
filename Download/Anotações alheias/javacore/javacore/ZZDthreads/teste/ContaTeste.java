package br.com.abc.javacore.ZZDthreads.teste;

import br.com.abc.javacore.ZZDthreads.classe.Conta;

public class ContaTeste implements Runnable {

    private Conta conta = new Conta();

    public static void main(String[] args) {
        ContaTeste contaTeste = new ContaTeste();
        Thread amanda = new Thread(contaTeste, "Amanda");
        Thread jungkook = new Thread(contaTeste, "Jungkook");

        amanda.start();
        jungkook.start();

    }

    // synchronized: quer dizer que apenas um método poderá executar
    // esse código por vez, pode ser estatico tbm, mas no argumento,
    // deve ser adicionada a classe envolvida.class
    private void saque(int valor) {
        // o synchronized pode ser feito também por bloco,
        // adicionando como argumento o objeto com o qual
        // se está lidando

        synchronized (conta) {
            System.out.println("Dentro do synchronized");
            if (conta.getSaldo() >= valor) {
                System.out.println(Thread.currentThread().getName() + " está indo sacar");
                conta.saque(valor);
                System.out.println(Thread.currentThread().getName() + " completou o saque. Saldo: " + conta.getSaldo());
            } else {
                System.out.println("Sem dinheiro para " + Thread.currentThread().getName() + " efetuar o saque. Saldo: " + conta.getSaldo());
            }
            System.out.println("Saindo do synchronized");
        }
    }


    public void run() {
        for (int i = 0; i < 5; i++) {
            saque(10);
            if (conta.getSaldo() < 0) {
                System.out.println("Se esse código tá aqui é pq fodeu mt, \n" +
                        "pq TEM UM NUMERO NEGATIVO AQUI E N DEVERIA TER KRL");
            }
        }
    }


}
