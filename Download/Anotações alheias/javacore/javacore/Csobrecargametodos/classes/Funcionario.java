package br.com.abc.javacore.Csobrecargametodos.classes;

public class Funcionario {
    private String name;
    private String cpf;
    private double salary;
    private String rg;

    /***
     * CONSTRUTOR:
     * Uma das funções é definir regras para a classe
     */
    public Funcionario(String name, String cpf, double salary, String rg){
        //agora, com isso, é necessário passar o nome como parametro
//      // de objeto
        this.name = name;
        this.cpf = cpf;
        this.salary = salary;
        this.rg = rg;
    }

//    O construtor anterior tornou todas as opções
//    obrigatórias, pra reverter isso, só usar
//    novamente a sobrecarga:
    public Funcionario(){}

    /***
     * Usar o construtor torna desnecessário o uso
     * do método init, mas ele vai ser mantido aqui
     * para consulta
     */
////    Alternativa a escrever um monte de settings
//    public void init(String name, String cpf, double salary){
//        this.name = name;
//        this.cpf = cpf;
//        this.salary = salary;
//
//    }
//
//    /***
//     * SOBRECARGA DE MÉTODOS:
//     * quando você dá mais atributos a uma classe
//     * sem mexer na primeira versão dela, a fim de
//     * não parar o serviço de pessoas que não
//     * trabalhem diretamente com o desenvolvedor e
//     * ainda a usem
//     * apenas o nome precisa ser o mesmo, o que muda é
//     * a quantidade ou o tipo dos parâmetros
//     */
//    public void init(String name, String cpf, double salary, String rg){
////        para evitar linhas de código, é necessário
////        chamar o primeiro init e dar a eles os
////        parâmetros, algo semelhante ao super()
////        do javascript
//        init(name, cpf, salary);
////        Usariamos se não tivessemos chamado o init
////        a´em cima
////      this.name = name;
////      this.cpf = cpf;
////      this.salary = salary;
//        this.rg = rg;
//    }


    public void imprimeInformacoes(){
        System.out.println("Nome: " + this.name);
        System.out.println("Salário: " + this.salary);
        System.out.println("CPF: " + this.cpf);
        System.out.println("RG: " + this.rg);

    }

//      O método init torna desnecessário, mas tá
//      aqui para fins de consulta
//    public void setName(String name){
//        this.name = name;
//    }
//    public void setCpf(String cpf){
//        this.cpf = cpf;
//    }
//    public void setSalary(double salary){
//        this.salary = salary;
//    }

    public String getName(){
        return this.name;
    }
    public String getCpf(){
        return this.cpf;
    }
    public double getSalary(){
        return this.salary;
    }
}
