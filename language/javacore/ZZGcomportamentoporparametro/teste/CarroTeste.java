package Estudando.javacore.ZZGcomportamentoporparametro.teste;


import Estudando.javacore.ZZGcomportamentoporparametro.classe.Carro;
import Estudando.javacore.ZZGcomportamentoporparametro.interfaces.CarroPredicate;
import Estudando.javacore.ZZGcomportamentoporparametro.predicate.CarrosCorDouradoPredicate;
import Estudando.javacore.ZZGcomportamentoporparametro.predicate.CarrosDezAnosRecentePredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class CarroTeste {
    public static void main(String[] args) {   //asList p inicializar a lista
        List<Carro> carros = asList(new Carro("Vermelho", 2014), new Carro("Dourado", 2006),(new Carro("Preto", 2012)));
        List<Integer> num = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        System.out.println(filtrarCarros(carros, new CarrosCorDouradoPredicate()));
        System.out.println(filtrarCarros(carros, new CarrosDezAnosRecentePredicate()));

        //Classe anonima:
        System.out.println(filtrarCarros(carros, new CarroPredicate() {
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equalsIgnoreCase("dourado");
            }
        }));

        //Classe anonima usando interface Predicate:
        System.out.println(filtrar(num, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        }));


    }

    public static List<Carro> filtrarCarros(List<Carro> listaDeCarros, CarroPredicate carroPredicate) {
        List<Carro> listaFiltrarCarros = new ArrayList<>();
        for (Carro carro : listaDeCarros){
            if (carroPredicate.test(carro))
                listaFiltrarCarros.add(carro);
        }
        return listaFiltrarCarros;
    }

    public static <T> List<T> filtrar(List<T> list, Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for(T e : list){
            if(predicate.test(e)){
                result.add(e);
            }
        }
        return  result;
    }


}
