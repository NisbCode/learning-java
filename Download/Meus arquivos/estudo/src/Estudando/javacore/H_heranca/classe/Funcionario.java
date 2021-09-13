package Estudando.javacore.H_heranca.classe;

public class Funcionario extends Pessoa {
    private double salario;


    //Também vai precisar de um aqui já que são classes Funcionario É UMA pessoa $
    public Funcionario(String nome){
        super(nome);
    }


    //Agora valos aprender a sobreescrever
    public void imprime(){
        super.imprime();
        System.out.println("Salário: " + this.salario);
        //para adiantar e não termos que chamar dois métodos só para imprimir:
        imprimeReciboPagamento();
    }

    public void imprimeReciboPagamento(){
        System.out.println("Eu, " + super.nome + ", Recebi o valor de " + this.salario + ".");
    }
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
