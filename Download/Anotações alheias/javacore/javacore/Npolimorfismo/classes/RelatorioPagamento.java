package br.com.abc.javacore.Npolimorfismo.classes;

import com.sun.javafx.geom.transform.GeneralTransform3D;

public class RelatorioPagamento {
    public void relatorioPagamentoGerente(Gerente gerente){
        System.out.println("Gerando relatorio de pagamento para a gerencia");
        gerente.calculaPagamento();
        System.out.println("Nome: " + gerente.getNome());
        System.out.println("Salario desse mês: " + gerente.getSalario());

    }

    public void relatorioPagamentoVendedor(Vendedor vendedor){
        System.out.println("Gerando relatorio de pagamento para a gerencia");
        vendedor.calculaPagamento();
        System.out.println("Nome: " + vendedor.getNome());
        System.out.println("Salario desse mês: " + vendedor.getSalario());
    }

    public void relatorioPagamentoGenerico(Funcionario funcionario){
        System.out.println("Gerando relatorio de pagamento para a gerencia");
        funcionario.calculaPagamento();
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Salario desse mês: " + funcionario.getSalario());
        //9- Para que os métodos/atributos que
        // estão na subclasse sejam chamados mesmo
        // que o objeto seja criado a partir da
        // superclasse, deve-se fazer um cast explícito

        //Vai dar certo com gerente, mas não com vendedor,
        // pois eles não possuem relação entre si

        //A fim de contornar isso usamos o instanceof
        if (funcionario instanceof Gerente){
            Gerente g = (Gerente) funcionario;
            System.out.println("Participação nos lucros: " + g.getParticipacaoNosLucros());
        }
        if (funcionario instanceof Vendedor){
            Vendedor v = (Vendedor) funcionario;
            System.out.println("Total de vendas: " + v.getTotalVendas());
            //ou
            //System.out.println("Total de vendas: " + ((Vendedor) funcionario  ).getTotalVendas());
        }

    }

}
