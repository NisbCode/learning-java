package br.com.abc.javacore.Npolimorfismo.classes;

/***
 * POLIMORFISMO
 */

     //1- lembrando da classe ser abstrata
     //e que os modificadores não podem ser
     // private
public abstract class Funcionario {
    protected String nome;
    protected double salario;

    //4- geração do construtor
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    //3- geração do toString
    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                '}';
    }

    public abstract void calculaPagamento();

    //2- geração dos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
