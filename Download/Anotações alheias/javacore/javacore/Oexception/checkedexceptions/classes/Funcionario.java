package br.com.abc.javacore.Oexception.checkedexceptions.classes;

import br.com.abc.javacore.Oexception.customexception.classes.LoginInvalidoException;

/***
 * SOBRESCRITA DE EXCEPTIONS
 * 1- Quando você sobrescreve um método, ele não lança
 * nenhuma exceção, isso porque o código pode mudar
 * completamente
 * Para ter a exceção, você deverá declarar elas de novo
 * Não é possivel lançar superclasses de classes exceptions
 * que você ja tenha declarado na classe pai, mas pode
 * declarar filhas das que ja declarou
 */

public class Funcionario extends Pessoa {
    public void salvar() throws LoginInvalidoException {

    }
}
