package br.com.abc.javacore.Npolimorfismo.classes;

//7- Criação da classe gerente
public class Gerente extends Funcionario {
    private double participacaoNosLucros;

    //8- Criação do construtor
    public Gerente(String nome, double salario, double participacaoNosLucros) {
        super(nome, salario);
        this.participacaoNosLucros = participacaoNosLucros;
    }

    @Override
    public void calculaPagamento() {
        this.salario += this.participacaoNosLucros;
    }

    public double getParticipacaoNosLucros() {
        return participacaoNosLucros;
    }

    public void setParticipacaoNosLucros(double participacaoNosLucros) {
        this.participacaoNosLucros = participacaoNosLucros;
    }
}
