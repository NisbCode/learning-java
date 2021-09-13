package Estudando.javacore.O_exception.e_sobreescritaexcecption.test;

import Estudando.javacore.O_exception.e_sobreescritaexcecption.classes.Funcionario;
import Estudando.javacore.O_exception.e_sobreescritaexcecption.classes.Pessoa;

public class SobreescritaComExceptionsTest {
    public static void main(String[] args) {
        Funcionario func = new Funcionario();
        Pessoa pessoa = new Pessoa();

//      Como as exceções foram definidar para Pessoas, ao chamar Funcionario, elas n
        func.salvar();
    }
}
