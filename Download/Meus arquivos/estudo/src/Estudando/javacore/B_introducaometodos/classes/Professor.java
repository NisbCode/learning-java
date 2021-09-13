package Estudando.javacore.B_introducaometodos.classes;

public class Professor {
    public String nome;
    public String matricula;
    public String RG;
    public String CPF;

    public void imprime(){
        System.out.println("------------------------");
        System.out.println(this.nome);
        System.out.println(this.matricula);
        System.out.println(this.RG);
        System.out.println(this.CPF);
    }
}
