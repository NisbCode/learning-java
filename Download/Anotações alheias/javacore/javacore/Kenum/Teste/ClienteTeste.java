package br.com.abc.javacore.Kenum.Teste;

import br.com.abc.javacore.Kenum.classe.Cliente;
import br.com.abc.javacore.Kenum.classe.TipoCliente;

public class ClienteTeste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Anna", TipoCliente.PESSOA_FISICA, Cliente.TipoPagamento.APRAZO);

        System.out.println(cliente);
        System.out.println(TipoCliente.PESSOA_FISICA.getId());
    }
}
