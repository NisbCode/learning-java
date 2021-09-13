package br.com.abc.javacore.Bintroducaometodos.teste;

import br.com.abc.javacore.Bintroducaometodos.classes.Calculadora;

public class CalculadoraTeste {

    //                      : ou [], ambos corretos por serem varargs
    public static void main(String... args) {

        Calculadora calc = new Calculadora();

       calc.somaDoisNumeros();

        calc.subtraiDoisNumeros();

//                   Argumento: com o que você vai preencher os parâmetros
        calc.multiplicaDoisNumeros(5,5);

        System.out.println(calc.divideDoisNumeros(20,0));

        System.out.println("Continuando a execução" );

        /***
         * Múltiplos valores como parâmetro
         */
        int[] numerosArgumentos = {7, 2, 3};
        calc.somaArray(numerosArgumentos);



        /***
         * Varargs:
         * possivel passar array ou valores separados
         * por vírgula
         */
//        calc.somaVarArgs(numerosArgumentos);
//        calc.somaVarArgs(1,2,3,4,6);
//        calc.somaVarArgsMaisParametros(1, 3,5,6);

        calc.somaVarArgs(numerosArgumentos);


    }

}
