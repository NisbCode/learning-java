package br.com.abc.javacore.Zgenerics.teste;

import br.com.abc.javacore.Ycolecoes.classe.Consumidor;

import java.util.ArrayList;
import java.util.List;

/***
 * GENERICS:
 * Usadas para determinar o tipo único de uma lista, para que
 * não haja trocentos instanceofs, o que deixaria o código trabalhoso
 * Implementado a partir do java 5
 */

public class GenericsTeste {
    public static void main(String[] args) {
        // Como era antes do java 5
        List lista = new ArrayList();
        lista.add("String");
        lista.add(1L);
        lista.add(new Consumidor("Amanda Marques", "151651"));

        // Para se fazer um for disso, teria que pegar a classe Object,
        // já que abrange todas as classes
        for (Object obj : lista) {
            // E então, para cada instância de objeto diferente,
            // deve-se imprimir o for daquele objeto especifico
            if (obj instanceof String){
                System.out.println(obj);
            }
            if (obj instanceof Long){
                System.out.println(obj);
            }
            if (obj instanceof Consumidor){
                Consumidor c = (Consumidor) obj;
                System.out.println(obj);
            }

            // Trabalhoso demais, né?
        }

    }

}
