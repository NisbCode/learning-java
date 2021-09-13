package Estudando.javacore.B_introducaometodos.test;

import Estudando.javacore.B_introducaometodos.classes.Calculadora;

public class CalculadoraTest {
    public static void main(String[] args) {

        Calculadora calc = new Calculadora();

        System.out.println("Somando");
        calc.somaDoisNumeros();


        System.out.println("Subtraindo");
        calc.subtracaoDoisNumeros();


        System.out.println("Multiplicando");
        calc.multiplicacaoDoisNumeros(11.2, 2);


        System.out.println("Dividindo");
        double result = calc.divisaoDoisNumeros(22.2, 11);
        System.out.println(result);
        //outra forma de imprimir a divisão:
        //System.out.println(calc.divisaoDoisNumeros(22.2, 11));]


        System.out.println("Imprimindo Divisão");
        calc.imprimindoDoisNumerosDivididos(77, 37);



        System.out.println("Continuando a exec");

        int[] numeros = {1, 2, 3, 4, 5};
        calc.somaArray(numeros);


        //agora usando o VarArgs
        // a diferença d eusar ele ou não é o fato de que usando você pode diretamente chamar os números
        //agora, como visto ali acima, sem usar ele você teria que criar uma variável contendo estes valores
        //Ou seja, poupa linha e é mais rápido:


        calc.somaVarArgs(1, 2, 3, 4, 5);
    }
}
