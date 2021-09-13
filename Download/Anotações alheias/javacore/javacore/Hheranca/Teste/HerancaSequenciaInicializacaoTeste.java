package br.com.abc.javacore.Hheranca.Teste;

import br.com.abc.javacore.Hheranca.Classes.FuncionarioSequenciaInicializacao;
import br.com.abc.javacore.Hheranca.Classes.PessoaSequenciaInicializacao;

public class HerancaSequenciaInicializacaoTeste {
    public static void main(String[] args) {
        PessoaSequenciaInicializacao carlinhos = new PessoaSequenciaInicializacao("Carlinhos", "545494");
        System.out.println("--------------------------------------------------------");
        FuncionarioSequenciaInicializacao carlinhosDeGravata = new FuncionarioSequenciaInicializacao("Carlinhos de Gravata", 15000);

    }
}
