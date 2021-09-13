package br.com.abc.javacore.Oexception.error.teste;

/***
 * ERROS:
 * fluxos que não seguem caminhos que deveriam ser seguidos
 * param o codigo e, diferente de exceções, não podem
 * ser tratados
 */

public class ErrorTeste {
    public static void main(String[] args) {
        staticOverflowError();
    }
    //Erro stack: empilhamento da chamada dos objetos em memoria
    public static void staticOverflowError(){
        staticOverflowError();
    }
}
