package Estudando.javacore.Y_colecoes.test;

/***
 * CONVERTENDO LISTAS EM ARRAYS E VICE-VERSA
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversãoDeListasArraysTest {
    public static void main(String[] args) {
        List<Integer> numerosList = new ArrayList<>();
        numerosList.add(2);
        numerosList.add(0);
        numerosList.add(4);
        numerosList.add(3);

        // Para converter, deve-se criar um array
        // e os valores da lista serão copiados
        // para o array
        Integer[] numerosArray = new Integer[numerosList.size()]; //Diretamente criamos um Array
        numerosList.toArray(numerosArray);    //E colocamos a lista dentro dele
        System.out.println("Conteúdo da lista: " + numerosList);
        System.out.println("Conteúdo do array: " + Arrays.toString(numerosArray));

        System.out.println("----------------");


        // Para fazer o contrário agora:
        Integer[] numerosArray2 = new Integer[4];
        numerosArray2[0] = 10;
        numerosArray2[1] = 9;
        numerosArray2[2] = 8;
        numerosArray2[3] = 7;
        // Método asList obs: o que você mudar no array, vai mudar na lista
        // por estarem vinculados em memória, isso impede que
        // mais itens sejam adicionados a lista
        List<Integer> numerosList2 = Arrays.asList(numerosArray2);

        // A fim de contornar:
        List<Integer> numerosList3 = new ArrayList<>();
        numerosList3.addAll(Arrays.asList(numerosArray2)); //addAll vai pegar td da lista e pôr no Array
        // E pra testar:
        numerosList3.add(11);

        System.out.println("Conteúdo do array2: " + Arrays.toString(numerosArray2));
        System.out.println("Conteúdo da lista2: " + numerosList2);

        System.out.println("Conteúdo da lista3: " + numerosList3);

    }
}
