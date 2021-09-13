package br.com.abc.javacore.ZZGcomportamentoporparametro.predicate;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classe.Carro;
import br.com.abc.javacore.ZZGcomportamentoporparametro.interfaces.CarroPredicate;

public class CarrosCorDouradoPredicate implements CarroPredicate {

    @Override
    public boolean test(Carro carro) {
        return carro.getCor().equalsIgnoreCase("dourado");
    }
}
