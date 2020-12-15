package Estudando.javacore.T_expressoesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressoesRegularesTest {
    public static void main(String[] args) {

        //Algumas opções de buscas possíveis
        //  \d todos os digitos (Número)
        //  \D  tudo o que não for digito
        //  \s espaços em branco e símbolos cm "\t \n \f \r"
        //  \S caractere que não é branco
        //  \w caractere de palavras a-z, A-Z , digitos e o underline (_)
        //  \W tudo que não for caractere de palavra
        //  [] faz ele prucurar aquelas letras com o case sensitive ativado
        //  Quantificadores:
        //  ?  zero ou uma
        //  *  zero ou mais
        //  +  uma ou mais
        //  {m, n} m até n
        //  () agrupar para escolhas   ex.: o(v|c)o ===> ovo ou oco
        //  |  ou
        //  $  fim de linha
        //  \\.  coringa; serve p ser substituido por qualquer coisa ex.: 1.3 = 123, 133, 1A3, 1#3, 1 3
        //  ^  caractere de negação usado para excluir oq vc não quer na seleção ex.: [^ABC] quer dizer q vc quer td menos ABC
        int hex = 0x1;
        String regex = "proj([^,])+";
        String texto = "proj1.bkj, proj1.java, proj1.class, proj1final.java, pproj2.bkp, texto, diagrama, foto";
        System.out.println("Email valido?" + "#@!abrao@mail".matches(regex));
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto: " + texto);
        System.out.println("indice: 012345678901234567");
        System.out.println("expressão: " + matcher.pattern());
        System.out.println("posições encontradas");
        while(matcher.find()){
            System.out.println(matcher.start() + " " + matcher.group());
        }
    }
}