package Estudando.javacore.E_blocodeinicializacao.test;

import Estudando.javacore.E_blocodeinicializacao.classes.Cliente;

public class ClienteTest {
    public static void main(String[] args) {
        Cliente c = new Cliente();
        System.out.println("\n");
        System.out.print("Exibindo quantidade de parcelas possíveis: ");
        for(int par : c.getParcelas()){
            System.out.print(par + " ");
        }
    }
}