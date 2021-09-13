package Estudando.javacore.D_sobrecargaconstrutores.classes;

public class Estudante {
    private String nome;
    private String matricula;
    private double[] notas;



//LEMBRETE: CONSTRUTOR NÃO TEM RETORNO
    public Estudante(String nome, String matricula, double[] notas){
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
    }

    //Fazer um segundo construtor sem argumentos, faz com que não seja obrigado a colocação de todos eles
    public Estudante(){

    }




    public void imprime() {
        System.out.println(this.nome);
        System.out.println(this.matricula);
        for (double nota : notas) {
            System.out.println(nota + " ");
        }
    }




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;

    }
}
