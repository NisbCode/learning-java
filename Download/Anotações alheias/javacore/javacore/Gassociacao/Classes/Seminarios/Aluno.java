package br.com.abc.javacore.Gassociacao.Classes.Seminarios;

public class Aluno {
    //Atributos de associação
    private Seminario seminario;

    //Atributos da classe
    private String nome;
    private int idade;

    //Construtores
    public Aluno(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public Aluno(){}

    //Getters e Setters dos atributos de classe
    public void setName(String name){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setIdade(int Idade){
        this.idade = idade;
    }
    public int getIdade(){
        return idade;
    }

    //Getters e Setters dos atributos de associação
    public Seminario getSeminario() {
        return seminario;
    }

    public void setSeminario(Seminario seminario) {
        this.seminario = seminario;
    }

    //Método print
    public void imprime(){
        System.out.println("----- Ficha do aluno -----");
        System.out.println("Nome: " + this.nome);
        if (this.seminario != null){
            System.out.println("Seminário: " + this.seminario.getTitulo());
            return;
        }
        System.out.println("Idade: " + this.idade);


    }
}
