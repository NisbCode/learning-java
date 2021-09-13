package br.com.abc.javacore.Hheranca.Classes;

//Quando uma classe não extende nada, ela, por padrão
//extende a classe Object, a mãe de todas as classes
public class Pessoa extends Object {
    /**
     * MODIFICADOR PROTECTED:
     * Permite que apenas programadores selecionados
     * assecem esses atributos
     * REQUISITOS: Podem acessar apenas classes do mesmc
     * pacote que as que tem o protected, ou as que estão
     * em pacotes diferentes, mas filhas de classes desse
     * pacote
     */
    protected String nome;
    protected String cpf;
    protected Endereco endereco;


    public Pessoa(String nome){
        this.nome = nome;
    }

    public Pessoa(String nome, String cpf){
        this(nome);
        this.nome = nome;
    }


    public void imprime(){
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Endereço: " + this.endereco.getRua() + ", " + this.endereco.getBairro());
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
