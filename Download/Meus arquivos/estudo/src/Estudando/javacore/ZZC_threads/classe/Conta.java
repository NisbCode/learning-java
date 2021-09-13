package Estudando.javacore.ZZC_threads.classe;


public class Conta {
    private int saldo = 50;

    public int getSaldo() {
        return saldo;
    }

    public void saque(int valor) {
        saldo -= valor;
    }
}
