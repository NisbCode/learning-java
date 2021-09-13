package br.com.abc.javacore.Oexception.objetocontaparateste.teste;

import br.com.abc.javacore.Oexception.objetocontaparateste.classes.Conta;
import br.com.abc.javacore.Oexception.objetocontaparateste.classes.TipoConta;

public class ContaTeste {
    public static void main(String[] args) {
        Conta contaHoseok = new Conta(TipoConta.PREMIUM);
        contaHoseok.getProprietario().setNome("Jung Hoseok");

        System.out.println(contaHoseok);

        contaHoseok.deposito(15000);

    }

}
