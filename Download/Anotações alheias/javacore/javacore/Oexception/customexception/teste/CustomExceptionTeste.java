package br.com.abc.javacore.Oexception.customexception.teste;

import br.com.abc.javacore.Oexception.customexception.classes.LoginInvalidoException;

public class CustomExceptionTeste {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
    }

    public static void logar() throws LoginInvalidoException{
        String usuario = "goku";
        String senha = "111";
        String usuarioDigitado = "Goku";
        String senhaDigitada = "123";

        //Método equals, da classe String, verifica
        // se duas Strings são iguais
        //Exclamação no começo: "se for diferente..."
        if (!usuario.equals(usuarioDigitado) || !senha.equals(senhaDigitada)){
            throw new LoginInvalidoException();
        } else {
            System.out.println("Logado");
        }
    }
}
