package br.com.abc.javacore.texpressoesregulares.test;

/***
 * TOKENS E DELIMITADORES:
 * Quando você está lidando com textos e precisa separar itens
 * (tokens) para trabalhar individualmente com cada um deles
 * Os delimitadores servem para auxiliar na excolha dos tokens
 */

public class TokenTeste {
    public static void main(String[] args) {
        String str = "Namjoon, Seokjin, Yoongi, Hoseok, Jimin, Taehyung, Jungkook";
                                //delimitador: espaço
        String[] tokens = str.split(" ");
        for(String item : tokens){
            System.out.println(item.trim());
        }
    }


}
