package br.com.abc.javacore.Eblocodeinicializacao.teste;

import br.com.abc.javacore.Eblocodeinicializacao.classes.Clientes.Cliente;

public class ClienteTeste {
    public static void main(String[] args) {
        Cliente jackson = new Cliente();

        System.out.println("Exibindo quantidade de parcelas possíveis");
        for(int parcela : jackson.getParcelas()){
            System.out.print(parcela + " ");
        }
    }

}
