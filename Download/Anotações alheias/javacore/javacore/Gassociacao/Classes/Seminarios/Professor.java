package br.com.abc.javacore.Gassociacao.Classes.Seminarios;

public class Professor {
    //Atributos de associação
    private Seminario[] seminario;

    //Atributos da classe
    private String nome;
    private String especialidade;

    //Construtores
    public Professor(String nome, String especialidade){
        this.nome = nome;
        this.especialidade = especialidade;
    }
    public Professor(){}

    public Professor(String nome) {
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    //Getters e Setters dos atributos de associação
    public Seminario[] getSeminario() {
        return seminario;
    }
    public void setSeminario(Seminario[] seminario) {
        this.seminario = seminario;
    }

    //Método print
    public void imprime(){
        System.out.println("----- Ficha do professor -----");
        System.out.println("Nome: " + this.nome);
        System.out.println("Especialidade: " + this.especialidade);
        if(seminario != null && seminario.length !=0){
            for(Seminario seminario : this.seminario){
                System.out.println("Seminarios participantes: " + seminario.getTitulo());
            }
            return;
        }
        System.out.println("Professor não vinculado a nenhum seminario");
    }
}
