package br.com.abc.javacore.Passert.teste;

public class Assert {
    private double salario = -3000;


    public void calculaSalario(){
        assert (this.salario < 0) : "O salário não pode ser menor que 0";

    }



}
