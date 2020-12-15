package Estudando.javacore.k_enumeracoes.test;

import Estudando.javacore.k_enumeracoes.classes.Cliente;
import Estudando.javacore.k_enumeracoes.classes.TipoCliente;

public class ClienteTest {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Ana", TipoCliente.PESSOA_FISICA, Cliente.TipoPagamento.APRAZO);
        System.out.println(TipoCliente.PESSOA_JURIDICA.getId());
        System.out.println(cliente);
    }
}
