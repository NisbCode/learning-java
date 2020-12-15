package Estudando.javacore.N_polimorfismo.test;

import Estudando.javacore.N_polimorfismo.classes.Funcionario;
import Estudando.javacore.N_polimorfismo.classes.Gerente;
import Estudando.javacore.N_polimorfismo.classes.RelatorioPagamento;
import Estudando.javacore.N_polimorfismo.classes.Vendedor;

public class PolimorfismoTest {
    public static void main(String[] args) {
        Gerente g = new Gerente("Ludmilla", 5000, 2000);
        Vendedor v = new Vendedor("Renan", 2000, 20000);
        RelatorioPagamento relatorio = new RelatorioPagamento();
//        relatorio.relatorioPagamentoGerente(g);
//        System.out.println("----------------------");
//        relatorio.relatorioPagamentoVendedor(v);
//        DEMOROU MT PRA EU ENTENDER, MAS ESSAS LINHAS AQ NA FRENTE FAZEM REFEREÊNCIA AO MÉTODO DO FUNC.
//        Ele faz referencia ao método mas c variável na classe Gerente/Vendedor
//        Isso faz c q vc use a classe Func para criar tds as outras coisas q fazem o msm método
        relatorio.relatorioPagamentoGenerico(g);
        System.out.println("-------------------------");
        relatorio.relatorioPagamentoGenerico(v);
    }
}
