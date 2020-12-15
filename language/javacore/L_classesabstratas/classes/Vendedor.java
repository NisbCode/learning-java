package Estudando.javacore.L_classesabstratas.classes;

public class Vendedor extends Funcionario {
    private double totalVendas;

    public Vendedor(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public Vendedor(String nome, String clt, double salario, double totalVendas) {
        super(nome, clt, salario);
        this.totalVendas = totalVendas;
    }

//    Como vendedor é um funcionário, e funcionário é uma pessoa, tendo em vista que vendedor é uma classe
//    concreta, ela deverá ter o método sobreescrito

    @Override
    public void imprime() {
    }


    @Override
    public void calculaSalario() {
        this.salario = salario + (totalVendas * 0.05);
    }


    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }
}
