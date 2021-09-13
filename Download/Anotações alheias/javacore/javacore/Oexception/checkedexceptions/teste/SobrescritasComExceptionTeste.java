package br.com.abc.javacore.Oexception.checkedexceptions.teste;

import br.com.abc.javacore.Oexception.checkedexceptions.classes.Funcionario;
import br.com.abc.javacore.Oexception.checkedexceptions.classes.Pessoa;
import br.com.abc.javacore.Oexception.customexception.classes.LoginInvalidoException;

import java.io.FileNotFoundException;

public class SobrescritasComExceptionTeste {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        Pessoa pessoa = new Pessoa();

        try{
            pessoa.salvar();
        } catch (LoginInvalidoException | FileNotFoundException e){
            e.printStackTrace();
        }

        //Descomente para ver os detalhes
//        pessoa.salvar();

    }
}
