package br.com.abc.javacore.texpressoesregulares.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailsER {
    public static void main(String[] args) {

        String listaEmails = "fulano@hotmail.com.br, 102Abc@gmail.com, #@!abraao@mail, teste@gmail.br, teste@mail";
        // Na parte direita, é possivel ter numeros
        // e letras:
        //Também temos ponto, nesse caso, tratamos ele como um metacaractere
        String regex = "([a-zA-Z09\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        Pattern padraoEmail = Pattern.compile(regex);
        Matcher combinarTextos = padraoEmail.matcher(listaEmails);


        System.out.println("Emails: " + listaEmails);
        System.out.println("Expressão para busca: " + regex);
        System.out.println("Posições encontradas:");
        while(combinarTextos.find()){
            System.out.println("Posição: " + combinarTextos.start() + " | Caracteres encontrados: " + combinarTextos.group());
        }

        //Método matches(): usado para validar buscas de acordo com os padrões
        System.out.println(" ");
        System.out.println("Email analisado: #@!abraao@mail");
        System.out.println("Está de acordo com o padrão da expressão?: " + "#@!abraao@mail".matches(regex));

    }
}
