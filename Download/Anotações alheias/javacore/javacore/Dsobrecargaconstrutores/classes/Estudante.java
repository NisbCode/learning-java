package br.com.abc.javacore.Dsobrecargaconstrutores.classes;

public class Estudante {
    private String matricula;
    private String nome;
    private double[] notas;
    private String dataMatricula;

    public Estudante(String matricula, String nome, double notas[]){
        this.matricula = matricula;
        this.nome = nome;
        this.notas = notas;

    }
    public Estudante(String matricula, String nome, double notas[], String dataMatricula){
        this();
        this.matricula = matricula;
        this.nome = nome;
        this.notas = notas;
        this.dataMatricula = dataMatricula;

    }

    public Estudante(){}

    public void imprime(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Matrícula: " + this.matricula);
        //lê-se: "para cada nota impressa do array, notas,
        // exiba a nota mostrada no momento com ume espaço"
        for(double nota: this.notas){
            System.out.println(nota + " ");
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }
}
