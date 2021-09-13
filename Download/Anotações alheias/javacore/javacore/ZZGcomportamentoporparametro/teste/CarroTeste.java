package br.com.abc.javacore.ZZGcomportamentoporparametro.teste;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classe.Carro;
import br.com.abc.javacore.ZZGcomportamentoporparametro.interfaces.CarroPredicate;
import br.com.abc.javacore.ZZGcomportamentoporparametro.predicate.CarrosCorDouradoPredicate;
import br.com.abc.javacore.ZZGcomportamentoporparametro.predicate.CarrosDezAnosRecentePredicate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class CarroTeste {
    public static void main(String[] args) {
        Carro ferrari1 = new Carro("Vermelho", 2014);
        Carro ferrari2 = new Carro("Dourado", 2006);
        Carro ferrari3 = new Carro("Preto", 2012);

        List<Carro> carros = asList(ferrari1, ferrari2, ferrari3);

        System.out.println(filtrarCarros(carros, new CarrosCorDouradoPredicate()));
        System.out.println(filtrarCarros(carros, new CarrosDezAnosRecentePredicate()));
    }

    public static List<Carro> filtrarCarros(List<Carro> listaDeCarros, CarroPredicate whichPredicate) {
        List<Carro> listaFiltrarCarros = new ArrayList<>();
        for (Carro carro : listaDeCarros){
            if (whichPredicate.test(carro))
                listaFiltrarCarros.add(carro);


        }
        return listaFiltrarCarros;
    }

}
