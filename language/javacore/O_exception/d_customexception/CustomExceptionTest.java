package Estudando.javacore.O_exception.d_customexception;

public class CustomExceptionTest {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidException e) {
            e.printStackTrace();
        }
    }

    private static void logar() throws LoginInvalidException {
        String usuarioBancoDeDados = "Goku";
        String senhaBancoDeDados = "111";
        String usuarioDigitado = "Goku";
        String senhaDigitada = "123";
        if (!usuarioBancoDeDados.equals(usuarioDigitado) || !senhaBancoDeDados.equals(senhaDigitada)) {
            throw new LoginInvalidException();
        }else{
            System.out.println("Logado");
        }
    }
}