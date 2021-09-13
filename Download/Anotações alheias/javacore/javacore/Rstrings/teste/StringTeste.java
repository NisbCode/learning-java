package br.com.abc.javacore.Rstrings.teste;

/***
 * CLASSE STRING:
 * Strings são imutáveis, ou seja, quando você "muda"
 * uma String, na verdade você está criando ela de novo
 */

public class StringTeste {
    public static void main(String[] args) {

        //Ordem de criação:
        //1- Variável de referencia
        String nome = "Amanda";

        //Pode ser criado dessa forma também
        //Ordem de criação:
        //1- variavel de referencia, 2- Objeto String, 3- uma string no pool de strings
        String sobrenome = new String(" Marques");

        //Nesse caso, existe a variavel nome,
        //está sendo criada outra variavel
        //pro sobrenome e ainda mais uma
        // para juntar os 2
        nome.concat( "Marques");//Mesma coisa que: nome += " Marques"

        //Agora dessa forma a variável
        //passa a referenciar outra coisa
        nome =  nome.concat( "Marques");

        System.out.println(nome + sobrenome);

        /***
         * Método charAt: descobrir um caractere no
         * meio de uma string
         * como array, começa no 0
         */
        String teste = "Goku";
        System.out.println(teste.charAt(2));

        /***
         * Método equals: vê se duas strings são iguais em seus conteúdos
         */
        String teste2 = "goku";
        System.out.println(teste.equals(teste2));
        /***
         * Método equalsIgnoreCase: ignora a diferença entre letra
         * maiúscula e minúscula
         */
        System.out.println(teste.equalsIgnoreCase(teste2));

        /***
         * Método lenght: descobre o tamanho da string
         */
        System.out.println(teste.length());

        /***
         * Método replace: substituir um caractere por outro
         */
        System.out.println(teste.replace('o', 'a'));

        /***
         * Método toLowerCase e toUpperCase:
         * passar para letra minúscula ou maiúscula
         */
        System.out.println(teste.toLowerCase());
        System.out.println(teste.toUpperCase());

        /***
         * Método substring: pegar apenas uma parte da string
         * como um array, começa na posição 0
         */
        String teste3 = "012345";
        System.out.println(teste3.substring(0,2));

        /***
         * Método trim: tira todos os espaços que há no começo e no fim da string
         */
        String teste4 = "    46848798   ";
        System.out.println(teste4.trim());



    }
}
