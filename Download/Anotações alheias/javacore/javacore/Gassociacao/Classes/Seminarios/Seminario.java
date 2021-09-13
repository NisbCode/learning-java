package br.com.abc.javacore.Gassociacao.Classes.Seminarios;

public class Seminario {
    //Atributos de Associação
    private Aluno[] alunos;
    private Professor professor;
    private Local local;

    //Atributos da classe
    private String titulo;

    //Construtores
    public Seminario(){}

    public Seminario(String titulo){
        this.titulo = titulo;
    }

    //Getters e Setters
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return titulo;
    }

    //Getters e Setters dos atributos de associação
    public Aluno[] getAlunos() {
        return alunos;
    }
    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Local getLocal() {
        return local;
    }
    public void setLocal(Local local) {
        this.local = local;
    }

    //Método print
    public void imprime(){
        System.out.println("----- Ficha do seminário -----");
        if(this.professor != null){
            System.out.println("Professor: " + this.professor.getNome());
        }

        if(this.local != null){
            System.out.println("Local: " + this.local.getRua());
            return;
        }
        System.out.println("Nenhum local cadastrado para esse seminário");
        System.out.println("-------- Alunos participantes --------");
        if (this.alunos != null && this.alunos.length != 0){
            for(Aluno aluno : this.alunos){
                System.out.println("Alunos: " + aluno);
                return;
            }
            System.out.println("Nenhum aluno cadastrado nesse seminario");
        }
    }
}
