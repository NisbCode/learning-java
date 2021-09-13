package Estudando.javacore.V_io;

import java.io.Console;

public class ConsoleTest {
    public static void main(String[] args) {
        Console c = System.console();
        char[] pw = c.readPassword("%s", "pv: ");   //readPassword retorna char podendo ser eliminado totalmente, agr Strings ficam salvas no pool String
        for(char pass : pw){
            c.format("%c ", pass);
        }
        c.format("\n");
        String texto;
        while (true){
            texto = c.readLine("%s", "\n Digite: ");
            c.format("esse texto %s foi digitado", retorno(texto));
        }
    }
    public static String retorno(String argl){
        return argl;
    }
}