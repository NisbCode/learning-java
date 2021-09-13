package br.com.abc.javacore.Oexception.customexception.classes;

/***
 * EXCEÇÕES CUSTOMIZADAS
 * Feitas pelos proprios desenvolvedores
 */
public class LoginInvalidoException extends Exception{

    //Nunca colocar qualquer tipo de tratamento
    // nas classes de exeptions, porque as formas
    // de exceção estão sempre mudando
    public  LoginInvalidoException(){
        super("Usuário ou senha inválidos");
    }
}
