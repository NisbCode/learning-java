package Estudando.javacore.N_polimorfismo.classes;

public class RelatorioPagamento {

//    Cada um fez seu próprio pagamento, essa classe serve apenas para fazer o relatório


//    public void relatorioPagamentoGerente (Gerente gerente){
//        System.out.println("Gerando relatório de pagamento para a gerência");
//        gerente.calcularPagamento();
//        System.out.println("Nome: " + gerente.getNome());
//        System.out.println("Salário desse mês: " + gerente.getSalario());
//    }
//
//    public void relatorioPagamentoVendedor (Vendedor vendedor){
//        System.out.println("Gerando relatório de pagamento para os vendedores");
//        vendedor.calcularPagamento();
//        System.out.println("Nome: " + vendedor.getNome());
//        System.out.println("Salário desse mês: " + vendedor.getSalario());
//    }


//    Isso é um parâmetro poliformico, ao invés de passar um parâmetro específico, vc passa um genérico:
    public void relatorioPagamentoGenerico (Funcionario funcionario) {
        System.out.println("Gerando relatório de pagamento");
        funcionario.calcularPagamento();
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Salário desse mês: " + funcionario.getSalario());
//        Aq vc vai além de fazer uma referencia do objeto de Funcionário para o de Gerente
//        Vai fazer um cast explicito, dizendo assim para o java q vc sabe oq tá fazendo
//        Ps.: Esse "g" é o g q agt cria, N UM DOS 3937268 Q AGT CRIOU NO CÓDIGO T O D O
        if (funcionario instanceof Gerente) {
            Gerente g = (Gerente) funcionario;
            System.out.println("Participação nos lucos: " + g.getPnl());
        }
        if (funcionario instanceof Vendedor) {
            Vendedor v = (Vendedor) funcionario;
//            Tb se pode fazer um cast assim, sem criar uma variável
            System.out.println("Total de vendas: " + ((Vendedor) funcionario).getTotalVendas());
        }
    }
}