package br.com.abc.javacore.Isobrescrita.classes;

public class Pessoa {
    private String nome;
    private int idade;

//    Sobrescrevendo o método toString, da classe Object,
//    que faz com que o objeto dentro de um sout retorne
//    um endereço de memoria
    //Exibindo que um método está sendo sobrescrito (não obrigatorio)
    @Override
    public String toString(){
        return "Nome: " + this.nome + " | Idade: " + this.idade;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
