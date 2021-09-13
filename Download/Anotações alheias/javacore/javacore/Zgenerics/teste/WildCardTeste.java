package br.com.abc.javacore.Zgenerics.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * WILDCAST CORINGA
 * Possibilita que parâmetros de métodos permitam
 * que argumentos façam polimorfismo em listas
 * Deve ser adicionado quando a lista está toda pronta,
 * todos os itens adicionados, porque, após isso, dá erro
 * de compilação a adição de novos itens
 */

abstract class Animal {
    public abstract void consulta();
}

class Cachorro extends Animal{

    @Override
    public void consulta() {
        System.out.println("Consultando cachorro");
    }
}

class Gato extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consultando gato");
    }
}

public class WildCardTeste {
    public static void main(String[] args) {
        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};

//        consultarAnimais(cachorros);
//        consultarAnimais(gatos);

        // O que se pode concluir?: Em arrays, é possível dar nos argumentos
        // do tipo Classe Pai, argumentos do tipo Classe Filha, pelo
        // polimorfismo

        List<Cachorro> cachorroList = new ArrayList<>();
        cachorroList.add(new Cachorro());
        List<Gato> gatoList = new ArrayList<>();
        gatoList.add(new Gato());

        consultarAnimaisList(cachorroList);
        consultarAnimaisList(gatoList);

        // Já em Lists, não é possível usar polimorfismo
        // (vai dar erro de compilação), os
        // argumentos devem ser dos mesmos tipos que os
        // parâmetros
        // Isso ocorre porque na hora de transformar as classes
        // em bytecode, os generics são ignorados
        // Como contornar?: usando o Wildcard (?)
    }

    public static void consultarAnimais(Animal[] animals) {
        for (Animal animal : animals) {
            animal.consulta();
        }
    }

    // Para que qualquer filha de animal possa servir de argumento:
    public static void consultarAnimaisList(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.consulta();
        }

    }

    // Para que qualquer super classe de cachorro possa servir de argumento:
    public static void consultarCachorroList(List<? super Cachorro> cachorroList){
        cachorroList.add(new Cachorro());
//        cachorroList.add(new Animal()); // Nesse caso, não se cria um objeto de animal pela classe Animal ser abstrata

    }

    // Também é possível criar condições para argumentos, por exemblo,
    // permitir a criação de uma lista apenas com itens contendo Comparable
                                // "O argumento apresentado é um comparable?"
    public static void ordenarLista(List<? extends Comparable> lista){
        Collections.sort(lista);
    }
}
