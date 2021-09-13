package br.com.abc.javacore.Oexception.objetocontaparateste.classes;


public class Conta {
    //Definindo as propriedades
    private double saldo = 0;
    public final Pessoa proprietario = new Pessoa();
    private TipoConta tipo;

    //Construtores
    public Conta(TipoConta tipo) {
        this.tipo = tipo;
    }

    public Conta() {
    }

    //métodos
    public void deposito(double valorDeposito){
        this.saldo += valorDeposito;
        System.out.println("Novo saldo: " + this.saldo);
    }

    public void saque(double valorSaque){
        this.saldo -= valorSaque;
        System.out.println("Novo saldo: " + this.saldo);
    }

    //método toString()
    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                ", proprietario=" + proprietario +
                ", tipo=" + tipo.getTipoParaImpressão() +
                '}';
    }

    //Getters e setters
    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public double getSaldo() {
        return saldo;
    }
}
