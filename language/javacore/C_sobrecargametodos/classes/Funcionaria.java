package Estudando.javacore.C_sobrecargametodos.classes;

public class Funcionaria {
    private String nome;
    private String CPF;
    private String RG;
    private double salario;

    //Este é o construtor. Aqui dentro nós podemos por exemplo ditar regras,como NÃO poder criar um funcionário sem nome:
    public Funcionaria(String nome){
        this.nome = nome;
    }

    //Segunda forma de construir um construtor
    public Funcionaria(){

    }

    //Nós aqui pegamos todas as variáveis "set" e colocamos aqui
    public void init(String nome, String CPF, double salario){
        this.nome = nome;
        this.CPF = CPF;
        this.salario = salario;
    }
        //Agora aprendendo sobre sobrecarga de parâmetros
        public void init(String nome, String CPF, double salario, String RG){

        //Esta linha vai chamar os comandos de um MÉTODO já usados antes para que não repita comandos
        init(nome, CPF, salario);

                this.RG = RG;
            }

            //Tmabém acrescentei aq na forma de imprimir
    public void imprime(){
        System.out.println(this.nome);
        System.out.println(this.CPF);
        System.out.println(this.salario);
        System.out.println(this.RG);
    }


    public void setNome (String nome){
        this.nome = nome;
    }
    public void setCPF (String CPF){
        this.CPF = CPF;
    }
    public void setSalario (double salario){
        this.salario = salario;
    }



    public String getNome(){
        return this.nome;
    }
    public String getCPF(){
        return this.CPF;
    }
    public double getSalario(){
        return this.salario;
    }

}
