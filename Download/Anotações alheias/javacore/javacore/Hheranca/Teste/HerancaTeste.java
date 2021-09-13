package br.com.abc.javacore.Hheranca.Teste;

import br.com.abc.javacore.Hheranca.Classes.Endereco;
import br.com.abc.javacore.Hheranca.Classes.Funcionario;
import br.com.abc.javacore.Hheranca.Classes.Pessoa;

public class HerancaTeste {
    public static void main(String[] args) {
        Pessoa youngsun = new Pessoa("Youngsun");
        Endereco endereco = new Endereco();

        youngsun.setCpf("156.489.758-98");
        endereco.setBairro("Bairo 1");
        endereco.setRua("Rua 25");
        youngsun.setEndereco(endereco);

        youngsun.imprime();

        System.out.println("------------------------");

        Funcionario youngsunDeGravata = new Funcionario("Youngsun de Gravata");
        youngsunDeGravata.setCpf("156.489.758-98");
        youngsunDeGravata.setEndereco(endereco);
        youngsunDeGravata.setSalario(2000);
//        youngsunDeGravata.imprime();



    }
}
