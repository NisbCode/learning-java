package br.com.abc.javacore.ZZHlambdas.classe;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Numeros {
    public static boolean maiorQue50(int numero) {
        return numero > 50;
    }

    public static List<Integer> encontrarNumeros(List<Integer> listaNumeros, Consumer<Boolean> consumerLambda) {
        List<Integer> newList = new ArrayList<>();
        for (Integer item : listaNumeros) {
            if (maiorQue50(item)){
                consumerLambda.accept(newList.add(item));
            }

        }
        return newList;
    }

}

