package br.com.abc.javacore.Oexception.runtimeexception.teste.devdojo;

/***
 * EXCEPTIONS:
 * Erros que dão no programa
 * podem ser do tipo Checked (sob o controle do
 * programador, tipo um código errado), ou unchecked
 * (além do controle do programador, tipo um banco
 * de dados ruim)
 */

//RuntimeExceptions são erros checked
//erros causados pela logica do programador
public class RuntimeExceptionTeste {
    public static void main(String[] args) {
        /***
         * ArithmeticExeption:
         * Erros matemáticos, tipo dividir por 0
         */

        //int a = 20/0;
        //System.out.println(a); //isso vai dar erro

        //Forma de impedir:
//        int a = 10;
//        int b = 0;
//        if(b != 0){
//            int c = a/b;
//            System.out.println(c);
//        }
        //Else: n vai mostrar nada, mas vai executar o codigo corretamente

        /***
         * NullPointerExeption:
         * ocorre quando tentamos referenciar um
         * objeto atraves de uma variavel de referencia,
         * mas nessa variavel não tem nada gravado
         */
//        Object o = null;  //null = não é um objeto declarado
//        System.out.println(o.toString());

        /***
         * ArrayIndexOutOfBoundsException:
         * Quando tentamos colocar algo num espaço de
         * memória que não está aberto
         * ex, colocar pra guardar algo na posição 3 de um
         * array [2], que tem as posições 0 e 1
         */

        //Teste de try catch aqui

        try{
            int[] d = new int[2];
            System.out.println(d[3]);
            //Trabalhar com a exceção mais especifica possivel
        } catch(ArrayIndexOutOfBoundsException excecao){
            excecao.printStackTrace();
        }
        System.out.println("Fora do bloco catch");

    }
}
