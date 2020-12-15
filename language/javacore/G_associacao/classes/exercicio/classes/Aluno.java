package Estudando.javacore.G_associacao.classes.exercicio.classes;

public class Aluno {
    private String nome;
    private int idade;
    private Seminario seminario;


    public Aluno() {
    }


    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }


    public void print() {
        System.out.println("---------- Relatório de Alunos ----------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        if (this.seminario != null) {
            //Sem o ".getTitulo()" você imprimirá o endereço e não a ação
            System.out.println("Seminário incrito: " + this.seminario.getTitulo());
        }else{
            System.out.println("O aluno não está inscrito em nenhum seminário");
        }
    }

    public Seminario getSeminario() {
        return seminario;
    }

    public void setSeminario(Seminario seminario) {
        this.seminario = seminario;
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
