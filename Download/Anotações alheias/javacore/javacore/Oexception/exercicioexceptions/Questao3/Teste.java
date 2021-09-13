package br.com.abc.javacore.Oexception.exercicioexceptions.Questao3;

public class Teste {
    public static void main(String[] args) {
        try{
            Conta minhaConta = new Conta();
            minhaConta.deposito(100);
            minhaConta.setLimite(100);
            minhaConta.saque(1000);
        } catch (ContaException e){
            e.printStackTrace();
        }

    }
}
