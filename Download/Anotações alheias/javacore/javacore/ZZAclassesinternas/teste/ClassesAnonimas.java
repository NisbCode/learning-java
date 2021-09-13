package br.com.abc.javacore.ZZAclassesinternas.teste;

import br.com.abc.javacore.Zgenerics.classe.Carro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/***
 * CLASSE ANONIMA:
 * Usada quando você precisa que um método tenha uma
 * característica diferente do que foi devinido a ele
 * Não vai ter nome e vai deixar de existir depoois
 * de ser usada
 */

class Animal {
    public void andar() {
        System.out.println("Andando");
    }
}

public class ClassesAnonimas {
    public static void main(String[] args) {
        // Para criar a classe (também é possivel
        // com interface):
        Animal a = new Animal() {
            public void andar() {
                System.out.println("Andando anonimamente");
            }
        };
        a.andar();

        List<Carro> carroList = new ArrayList<>();
        carroList.add(new Carro("BMW"));
        carroList.add(new Carro("Audi"));
        // Para implementar uma interface anonima:
        Collections.sort(carroList, new Comparator<Carro>(){

                @Override
                public int compare(Carro o1, Carro o2) {
                return o1.getNome().compareTo(o2.getNome());
                    }
            });
            // Desse modo mais complexo era feito até a versão 7,
            // a partir da 8 você pode usar o Lambda:
//        Collections.sort(carroList, (o1, o2) -> o1.getNome().compareTo(o2.getNome()){

    }
}

