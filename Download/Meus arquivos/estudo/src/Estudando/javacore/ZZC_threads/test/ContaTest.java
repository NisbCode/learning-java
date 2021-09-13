package Estudando.javacore.ZZC_threads.test;


import Estudando.javacore.ZZC_threads.classe.Conta;

public class ContaTest implements Runnable {

    private Conta conta = new Conta();

    public static void main(String[] args) {
        ContaTest contaTeste = new ContaTest();
        Thread nathalia = new Thread(contaTeste, "Nathália");
        Thread jungkook = new Thread(contaTeste, "Jungkook");

        nathalia.start();
        jungkook.start();

    }

    public static void imprime(){
        synchronized (ContaTest.class){
            System.out.println("Classe sincronizada é o mesmo q usar synchronized com static só q nesse caso está escrito por extenso");
        }
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
