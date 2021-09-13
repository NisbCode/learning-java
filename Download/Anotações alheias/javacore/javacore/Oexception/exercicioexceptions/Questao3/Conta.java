package br.com.abc.javacore.Oexception.exercicioexceptions.Questao3;

public class Conta {
    //Definindo as propriedades
    private double saldo = 0;
    public double limite;
    public double valorDeposito;
    public double valorSaque;


    //métodos
    public void deposito(double valorDeposito){
        this.valorDeposito = valorDeposito;
        this.saldo += valorDeposito;
        System.out.println("Novo saldo: " + this.saldo);
    }

    public void saque(double valorSaque) throws ContaException {
        this.valorSaque = valorSaque;
        this.saldo -= valorSaque;
        if (valorSaque > valorDeposito) {
            throw new ContaException();
        } else {
            System.out.println("Novo saldo: " + this.saldo);
        }

    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
