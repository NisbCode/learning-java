package br.com.abc.javacore.Oexception.runtimeexception.teste.caelumacademy;

import br.com.abc.javacore.Oexception.objetocontaparateste.classes.Conta;

// O programa sempre retoma a execução a partir
// do ponto em que o catch tá
// Faça o teste: coloque um try-catch no for, na condição
// dentro do for, no exceptionIndiceArray e no metodo1

public class ContaException {
    public static void main(String[] args) {
        System.out.println("Início do método main");
        metodo1();
        System.out.println("Fim do método main");
    }


    public static void metodo1() {
        System.out.println("Início do método1");
        ContaException.exceptionIndiceArray();
        System.out.println("Fim do método1");
    }


    public static void exceptionIndiceArray() {
        System.out.println("Início do método exceptionIndice()");
        Conta contaJin = new Conta();

        for (int contador = 0; contador <= 15; contador++) {
            contaJin.deposito(1000);
            if (contador == 5) {
                contaJin = null;
            }
        }
        System.out.println("Fim do método exceptionIndice()");
    }

}
