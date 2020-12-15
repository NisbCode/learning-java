package Estudando.javacore.Y_colecoes.test;

import Estudando.javacore.Y_colecoes.classes.Celular;

/***
 * MÉTODO EQUALS
 * Importante para o entendimento das coleções,
 * um dos assuntos mais essenciais do java
 */

public class EqualsTest {
    public static void main(String[] args) {
        // Relembrando como o método equals funcionava em String
        String nome1 = "Naty Ignácio";
//        String nome2 = "Naty Ignácio";
        // O caso anterior daria true porque ambas as
        // Strings estão armazenadas no pool de strings

        String nome2 = new String("Naty Ignácio");
        // Já nesse caso, é um objeto, está num local
        // diferente do pool de strings, num endereço de memória,
        // diferente, por isso vai retornar false
        // (A explicação acima é válida pra qualquer classe Wrapper)
        // O equals é usado justamente para comparar o significado
        // de ambos, independente dos endereços de memória

        Integer int1 = 5;
        Integer int2 = new Integer(5);

        System.out.println(nome1 == nome2);
        System.out.println(int1.equals(int2));

        // Agora, criando um objeto celular, usando a classe Celular
        Celular iPhone = new Celular("iPhone", "1253");
        Celular iPhone2 = new Celular("iPhone", "1253");
        // Se n usar esse equals dessa classe, provável q daria falso por eles n estarem no msm endr. de memória
//      Eles dão vdd pq dissemos q oq importa é o IMEI deles e n o endereço
        System.out.println(iPhone.equals(iPhone2));
    }
}
