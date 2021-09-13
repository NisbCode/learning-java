package Estudando.javacore.ZZGcomportamentoporparametro.predicate;


import Estudando.javacore.ZZGcomportamentoporparametro.classe.Carro;
import Estudando.javacore.ZZGcomportamentoporparametro.interfaces.CarroPredicate;

public class CarrosCorDouradoPredicate implements CarroPredicate {

    @Override
    public boolean test(Carro carro) {
        return carro.getCor().equalsIgnoreCase("dourado");
    }
}
