package br.com.abc.javacore.Vio.teste;

import java.io.Console;

/***
 * CLASSE CONSOLE:
 * Não vai ser muito utilizada, mas é importante saber para
 * a certificação Java
 * Também não é possível utilizar no InteliJ, só no terminal
 */

public class ConsoleTeste {
    public static void main(String[] args) {
        Console c = System.console();
        // readLine() retorna String | readPassword retorna char
        // Isso é uma medida de segurança, porque char não forma um pool
        // como Strings, assim, não é possível que alguém acesse
        // esses dados e roube senhas
        char[] password = c.readPassword("%s", "password: ");
        for (char passwordItem : password){
            c.format("%s", passwordItem);
        }
        c.format("\n");
        String texto;
        while (true){
            texto = c.readLine("%s", "Digite: ");
            c.format(" esse texto %s foi digitado", retorno(texto));
        }

    }

    public static String retorno(String arg1){
        return "entrada de dados: " + arg1;
    }

    // CÓDIGO NÃO FUNCIONANDO NO TERMINAL
}
