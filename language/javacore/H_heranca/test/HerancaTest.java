package Estudando.javacore.H_heranca.test;

import Estudando.javacore.H_heranca.classe.Endereco;
import Estudando.javacore.H_heranca.classe.Funcionario;
import Estudando.javacore.H_heranca.classe.Pessoa;

public class HerancaTest {
    public static void main(String[] args) {
//        O construtor te obriga a pôr o parâmetro aqui:
        Pessoa p = new Pessoa("Ildenira");
        p.setCpf("836.480.822-08");
        Endereco end = new Endereco();
        end.setBairro("Barreto");
        end.setRua("Rua Gavião Cunha");
        //Aqui vamos setar que o endereço da pessoa é o da classe endereco
        p.setEndereco(end);


        p.imprime();

        System.out.println("----------------------------");
//      Por ser uma classe filha cujo construtor tem um parâmetro, ele será escrito aqui:
        Funcionario f = new Funcionario("Carlinhos");
        f.setCpf("657.246.222-02");
        f.setEndereco(end);
        f.setSalario(7652);

        f.imprime();
    }
}
