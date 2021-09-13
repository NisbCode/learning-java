package br.com.abc.javacore.Npolimorfismo.classes;

public class Vendedor extends Funcionario {
    private double totalVendas;

    //5- chamar o construtor da subclasse assim
    //que ela for criada
    public Vendedor(String nome, double salario, double totalVendas) {
        super(nome, salario);
        this.totalVendas = totalVendas;
    }

    //6- Definir getters e setters de totalVendas
    public double getTotalVendas(){
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }


    @Override
    public void calculaPagamento() {
        this.salario += totalVendas*0.5;
    }
}
