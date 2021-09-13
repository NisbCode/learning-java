package br.com.abc.javacore.texpressoesregulares.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * 1- EXPRESSÕES REGULARES:
 * usadas quando você precisa usar padrões para
 * buscar itens em arquivos de texto
 */

public class ExpressoesRegulares {
    public static void main(String[] args) {
        /***
         * 2- Classes Pattern e Matcher
         */
        //regex = padrão, palavra utilizada
        //em muitos lugares para substituir
        String regex = "ab";
        String texto = "abaaaba";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto2:  " + texto);
        System.out.println("indice: 0123456789");
        System.out.println("expressão: " + matcher.pattern());
        System.out.println("posicoes encontradas");
        while (matcher.find()) {
            System.out.println(matcher.start() + " ");
        }

        System.out.println("---------------------------------");

        //Aqui você insere o texto, você vê bastante essa variável ter o nome de regex
        String texto2 = "Teamwork makes the dream works";
        //Aqui, o texto que você quer encontrar
        String textoProcurado = "dream";
        //Metodo Pattern.compile(), usado para transformar uma expressão
        // regular para uma expressão de memoria
        Pattern padraoDream = Pattern.compile(textoProcurado);
        //matcher(): usado para comparar o texto2 procurado com o original
        Matcher compararTextos = padraoDream.matcher(texto2);
        //impressão dos dados
        System.out.println("Texto: " + texto2);
        System.out.println("expressão a ser encontrada: " + compararTextos.pattern());
        //Enquanto o padraoDream for encontrado...
        while (compararTextos.find()) {
            //imprima em quais posições ele começou a aparecer
            System.out.println("Encontrado na posição: " + compararTextos.start());
        }

        /***
         * META CARACTERES
         * Usados para auxiliar na busca do texto
         * \d - metacaracter para encontrar todos os digitos
         * \D+ - metacaracter para encontrar tudo o que não é digito
         * \s - espaços em branco, que também são expresos
         * pelos metas \t \n \f \r
         * \S - caracteres de espaços não brancos
         * \w - caracteres de palavras (a-z, A-Z, digitos e _)
         * \W - encontrar tudo o que não é palavra
         * [] - quando você quer encontrar apenas determinadas
         * letras, podem ser definidos intervalos de letras separados
         * por traços. Também pode ser incluídos intervalos de numeros
         * () - agrupar caracteres
         * | - utilizado como ou
         * Ex: o(v|c)o = o código vai encontrar ovo ou oco
         * $ - encontrar um caractere no final da lista
         * . - pode ser substituido por qualquer coisa
         */

        System.out.println("---------------------------------");

        String texto3 = "cafeBABE";
        //regex1 = o texto a ser buscado
        //Se for um metacaracter, tem que ter mais uma barra invertida
        String regex1 = "[a-zA-C]";
        Pattern padraoAnalisado = Pattern.compile(regex1);
        Matcher compararPadraoTexto = padraoAnalisado.matcher(texto3);
        System.out.println("Texto:  " + texto3);
        System.out.println("indice: 0123456789101112");
        System.out.println("expressão a ser encontrada: " + compararPadraoTexto.pattern());
        while (compararPadraoTexto.find()) {
            System.out.println("Encontrado na posição: " + compararPadraoTexto.start());
        }

        /***
         * METACARACTERES QUANTIFICADORES:
         * Servem para encontrar uma ou mais ocorrencias
         * de determinada expressão
         * ? - 0 ou 1
         * + - uma ou mais
         * * - 0 ou mais
         * customizadas - {m, n}, de m até n ocorrencias+
         */
        System.out.println("---------------------");
        //Para encontrar numeros hexadecimais
        int numeroHex = 0xF;
        //Texto para analise
        String textoHexadecimal = "12 0x 0X 0xFFABC  0x10g 0x1";
        //partes que devem ser encontradas
        String regex2 = "0[xX]([0-9a-fA-F])+";
        Pattern padraoAnalisado2 = Pattern.compile(regex2);
        Matcher comparador = padraoAnalisado2.matcher(textoHexadecimal);
        System.out.println("Texto:  " + textoHexadecimal);
        System.out.println("expressão a ser encontrada: " + comparador.pattern());
        System.out.println("Posições:");
        while (comparador.find()){
            System.out.println("Posição: " + comparador.start() + " | Caractere encontrado: " + comparador.group());
        }


    }
}