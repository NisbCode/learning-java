package br.com.abc.javacore.Ycolecoes.teste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortListTeste {
    public static void main(String[] args) {
        // Lista de nomes
        List<String> nomes = new ArrayList<>();
        nomes.add("Amanda");
        nomes.add("Marques");
        nomes.add("Jeon");
        nomes.add("Jeongguk");
        // Para colocar um item antes do outro
        // na compilação, só colocar o índice antes
        nomes.add(0, "Jimin");
        /***
         * MÉTODO SORT:
         * Organiza a lista na ordem alfabetica
         * ou cronológica
         * Deve vir antes do for
         */
        Collections.sort(nomes);

        for (String nome : nomes){
            System.out.println(nome);
        }

        // Lista de numeros
        List<Double> numeros = new ArrayList<>();
        numeros.add(1.1);
        numeros.add(1.5);
        numeros.add(1.3);
        numeros.add(1.9);
        numeros.add(2d);

        // Método sort
        Collections.sort(numeros);

        for (Double numero : numeros){
            System.out.println(numero);
        }

    }
}
