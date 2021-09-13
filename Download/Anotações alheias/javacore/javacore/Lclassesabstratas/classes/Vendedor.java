package br.com.abc.javacore.Lclassesabstratas.classes;

//1- Depois é criada a classe vendedor

//2- Quando definimos um método abstrato na classe pai,
// ele OBRIGATORIAMENTE tem que ser sobrescrito
public class Vendedor extends Funcionario{
    private double totalVendas;

    public Vendedor(String nome, String clt, double salario, double totalVendas) {
        super(nome, clt, salario);
        this.totalVendas = totalVendas;
    }

    public Vendedor(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    @Override
    public void calculaSalario() {
        //3- Não é obrigado a colocar código aqui,
        // mas é obrigado a sobrescrever
        this.salario += this.salario*0.05;
    }


    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

}
