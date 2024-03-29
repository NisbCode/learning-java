package Estudando.javacore.Y_colecoes.test;

import Estudando.javacore.Y_colecoes.classes.Celular;

import java.util.ArrayList;
import java.util.List;

public class ListCelularTest {
    public static void main(String[] args) {
        Celular celular1 = new Celular("Moto G", "12354");
        Celular celular2 = new Celular("Samsung S7", "12384");
        Celular celular3 = new Celular("Samsung S7", "01484");

        List<Celular> celularList = new ArrayList<>();
        celularList.add(celular1);
        celularList.add(celular2);
        celularList.add(celular3);

        for (Celular cel : celularList){
            System.out.println(cel);
        }
        // Para checar se um celular existe na lista:
        Celular celular4 = new Celular("Samsung S7", "12384");
        System.out.println(celular2 == celular4);  //Estão em locais diferentes
        System.out.println(celular4.equals(celular2)); //De fato ambos são iguais
        System.out.println(celularList.contains(celular4)); //Mas temos um método próprio p ver isso
    }
}
