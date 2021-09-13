package Estudando.javacore.ZZGcomportamentoporparametro.predicate;


import Estudando.javacore.ZZGcomportamentoporparametro.classe.Carro;
import Estudando.javacore.ZZGcomportamentoporparametro.interfaces.CarroPredicate;

import java.util.Calendar;

public class CarrosDezAnosRecentePredicate implements CarroPredicate {

    @Override
    public boolean test(Carro carro) {
        return carro.getAno() > (Calendar.getInstance().get(Calendar.YEAR) - 10);
    }
}
