package br.com.abc.javacore.Fmodificadoresestatico.teste;

import br.com.abc.javacore.Fmodificadoresestatico.classes.Cliente;

public class ClienteTeste {
    public static void main(String[] args) {
        Cliente jackson = new Cliente();
        Cliente jaebum = new Cliente();
        Cliente mark = new Cliente();

        System.out.println("Exibindo quantidade de parcelas possíveis");
//        for(int parcela : jackson.getParcelas()){
//            System.out.print(parcela + " ");
//        }
        System.out.println("Tamanho: " + Cliente.getParcelas().length);
        System.out.println("Tamanho: " + Cliente.getParcelas().length);
        System.out.println("Tamanho: " + Cliente.getParcelas().length);
    }

}
