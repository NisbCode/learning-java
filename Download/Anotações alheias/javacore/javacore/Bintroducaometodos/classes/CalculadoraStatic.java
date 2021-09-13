package br.com.abc.javacore.Bintroducaometodos.classes;

public class CalculadoraStatic {

    /***
     * Transformando todos os metodos em estaticos
     */

    public static void somaDoisNumeros() {
        System.out.println(5 + 5);
    }
    public static void subtraiDoisNumeros(){
            System.out.println(5-5);
        }

//                          Parâmetros: sintaxe similar ao for
    public static void multiplicaDoisNumeros(int num1, int num2){
        System.out.println(num1*num2);
    }

         /***
//       *Retornando métodos
        */
    public static double divideDoisNumeros(double num1, double num2){

        /***
         *primeira forma
         */
//        double resultado = num1 / num2;
//        return resultado;
        /***
         *segunda forma (mais recomendada)
         */
//        return num1/num2;
//      O return retorna o mesmo tipo de variavel dos parâmetros

        //Para não dar o erro infinity,
        //o código retorna 0 em caso de x/0
        if(num2 != 0){
            return num1/num2;

        }
        return 0;
    }

    public static void alteraDoisNumeros(int num1, int num2){
        num1 = 30;
        num2 = 40;
        System.out.println("Dentro do Altera 2 numeros");
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
    }

    /***
     *
     * PARÂMETRO TIPO ARRAY
     */

    public static void somaArray(int[] numeros){
        int soma = 0;
        for(int numero: numeros){
            soma -= numero;
        }
        System.out.println("Soma do Array: " + soma);
    }


    /***
     * PARÂMETRO TIPO VARARGS:
     * usado quando você não sabe com quantos
     * itens está trabalhando
     * Pode receber arrays como parâmetros ou os proprios
     * itens separados por vírgula, coisa que o parâmetro
     * do tipo array não faz
     * **Só é possível criar um vararg por método
     * **Caso entrem mais parâmetros, o vararg precisa
     * ser o ultimo do parenteses
     */

//    public static void somaVarArgs(int... numeros){
//        int soma = 0;
//        for(int indice : numeros){
//            soma += indice;
//
//        }
//        System.out.println("SomaVarArg: " + soma);
//    }

    public static void somaVarArgs(int... numeros){
        int soma = 0;
        for(int numero=0; numero<=10;numero++){
            soma+= numero;
        }
        System.out.println("SomaVarArgs: " + soma);
    }


    /***
     *Caso entrem mais parâmetros, o vararg precisa
     * ser o ultimo do parenteses
     */

//                  double: referente ao primeiro item do array --- logo depois vem o varargs
    public static void somaVarArgsMaisParametros(double valorDouble, int... numeros){
        int soma = 0;
        for(int indice : numeros){
            soma += indice;

        }
        System.out.println("SomaVarArgMaisParametros: " + soma);
    }


}








