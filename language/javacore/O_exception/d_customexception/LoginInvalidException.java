package Estudando.javacore.O_exception.d_customexception;

public class LoginInvalidException extends Exception {

//    Não use esse espaço para tratamentos
    public LoginInvalidException(){
        super("Usuário ou senha inválida");
    }
}
