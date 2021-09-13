package br.com.abc.javacore.texpressoesregulares.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Datas {
    public static void main(String[] args) {

        String datas = "05/10/2010 05/05/2015 1/1/01 01/05/95 32/05/55"; //Validação: dd/mm/yyyy
        String regex = "\\d\\d/\\d\\d/\\d\\d\\d\\d";
        Pattern compilaTexto = Pattern.compile(regex);
        Matcher comparaTextos = compilaTexto.matcher(datas);

        System.out.println("Texto: " + datas);
        System.out.println("Padrão: " + regex);
        System.out.println("Padrões encontrados");
        while (comparaTextos.find()){
            System.out.println("Posição: " + comparaTextos.start() + " | Item: " + comparaTextos.group());

        }


    }
}
