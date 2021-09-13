package br.com.abc.javacore.Hheranca.Classes;

public class Funcionario extends Pessoa {
    private double salario;


    //Construtor de funcionario -- Mesmo parametro do de pessoa
    public Funcionario(String nome) {
        //Chamando o construtor de pessoa
        //Deve ser a primeira linha de execução
        //não é permitido super e this no mesmo consrtutor
        super(nome);
    }

    public void imprime() {
        super.imprime();
        System.out.println("Salário: " + this.salario);
        imprimeReciboPagamento();
    }

    public void imprimeReciboPagamento() {
        System.out.println("Eu, " + super.nome + ", recebi o pagamento de: " + this.salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
