package br.com.abc.javacore.Bintroducaometodos.teste;

import br.com.abc.javacore.Bintroducaometodos.classes.CalculadoraStatic;

public class CalculadoraStaticTeste {

    //                      : ou [], ambos corretos por serem varargs
    public static void main(String... args) {

        CalculadoraStatic calc = new CalculadoraStatic();

        /***
         * Nesse caso, não precisamos criar um objeto
         * é possivel chamar diretamente a classe para atribuir os valores
         */

       CalculadoraStatic.somaDoisNumeros();

        CalculadoraStatic.subtraiDoisNumeros();

//                   Argumento: com o que você vai preencher os parâmetros
        CalculadoraStatic.multiplicaDoisNumeros(5,5);

        System.out.println(CalculadoraStatic.divideDoisNumeros(20,0));

        System.out.println("Continuando a execução" );

        /***
         * Múltiplos valores como parâmetro
         */
        int[] numerosArgumentos = {7, 2, 3};
        CalculadoraStatic.somaArray(numerosArgumentos);



        /***
         * Varargs:
         * possivel passar array ou valores separados
         * por vírgula
         */
//        calc.somaVarArgs(numerosArgumentos);
//        calc.somaVarArgs(1,2,3,4,6);
//        calc.somaVarArgsMaisParametros(1, 3,5,6);

        CalculadoraStatic.somaVarArgs(numerosArgumentos);


    }

}
