package br.com.abc.javacore.Oexception.exercicioexceptions.Questao3;

public class ContaException extends Exception {
    public ContaException(){
        super("O valor do saque é maior que o saldo. Tente novamente.");
    }
}
