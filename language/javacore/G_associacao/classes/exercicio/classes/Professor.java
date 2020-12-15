package Estudando.javacore.G_associacao.classes.exercicio.classes;

public class Professor {
    private String nome;
    private String especialidade;
    private Seminario[] seminario;


    public Professor() {
    }

    public Professor(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }


    public void print() {
        System.out.println("---------- Relatório de Professores ----------");
        System.out.println("Nome do professor: " + this.nome);
        System.out.println("Especialidade: " + this.especialidade);
        if (seminario != null && seminario.length != 0) {
            for (Seminario sem : seminario) {
                System.out.println("Título: " + sem.getTitulo());
            }
        }else{
            System.out.println("Professor não vinculado a nenhum seminário");
        }
    }



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

    public Seminario[] getSeminario() {
        return seminario;
    }

    public void setSeminario(Seminario[] seminario) {
        this.seminario = seminario;
    }
}
