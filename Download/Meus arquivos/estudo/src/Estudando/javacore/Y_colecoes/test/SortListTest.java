package Estudando.javacore.Y_colecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListTest {
    public static void main(String[] args) {
        // Lista de nomes
        List<String> nomes = new ArrayList<>();
        nomes.add("Naty");
        nomes.add("Bomfim");
        nomes.add("Melanie");
        nomes.add("Martinez");
        // Para colocar um item antes do outro
        // na compilação, só colocar o índice antes
        nomes.add(0, "Billie");


        /**
         * MÉTODO SORT:
         */

        Collections.sort(nomes);  //Classe Collections; método sort; com parâmetro da lsita
//      Ele ordena como a String (Q é o caso dessa lista) deve ser ordenada

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