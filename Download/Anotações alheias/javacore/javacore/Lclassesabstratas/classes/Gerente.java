package br.com.abc.javacore.Lclassesabstratas.classes;

//Depois é criada a classe gerente
public class Gerente extends Funcionario {

//    Lembrando que o construtor deve ser criado novamente
//    em classes filhas
    public Gerente(String nome, String clt, double salario) {
        super(nome, clt, salario);
    }

    public Gerente() {}

//    Sobrescrita do método calculaSalario de funcionario
//    note que adaptamos o modificador do salario
//    para protected ao inves de private, assim é
//    possivel mudar apenas usando this
    @Override
    public void calculaSalario() {
        this.salario += this.salario * 0.2;
    }


}
