package br.com.abc.javacore.Ycolecoes.teste;

import br.com.abc.javacore.Ycolecoes.classe.Celular;

import java.util.ArrayList;
import java.util.List;

public class ListCelularTeste {
    public static void main(String[] args) {
        Celular motoG = new Celular("Moto G", "12354");
        Celular samsungS7 = new Celular("Samsung S7", "12384");
        Celular sonyXperia = new Celular("Samsung S7", "01484");

        List<Celular> celularList = new ArrayList<>();
        celularList.add(motoG);
        celularList.add(samsungS7);
        celularList.add(samsungS7);

        for (Celular cel : celularList){
            System.out.println(cel);
        }
        // Para checar se um celular existe na lista:
        Celular galaxyS7 = new Celular("Galaxy S7", "12354");
        System.out.println(celularList.contains(galaxyS7)); // Retorna um boolean dizendo se sim ou se não
    }
}
