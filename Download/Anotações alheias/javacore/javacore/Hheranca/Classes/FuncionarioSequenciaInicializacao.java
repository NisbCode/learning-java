package br.com.abc.javacore.Hheranca.Classes;

public class FuncionarioSequenciaInicializacao {
    /***
     * SEQUENCIA DE INICIALIZACAO:
     * 1- Espaço de memória é alocado para o objeto sendo construído
     * 2- cada um dos atributos do objeto é iniciado com valores defaullt
     * 3- o construtor da superclasse é chamado
     * 4- A inicialização dos atributos via ceclaração e o código do bloco de inicialização da super
     * classe são inicializados na ordem em que aparecem
     * 5- O código do construtor da superclasse é chamado
     * 6- O passo 4 para a subclasse é executado
     * 7- o código do construtor da classe é executado
     */
    private String nome;
    private double salario;

    static {
        System.out.println("--- Dentro do bloco de inicialização de funcionario estático  ---");
    }

    {
        System.out.println("--- Dentro do bloco de inicialização de funcionario 1 ---");
    }

    {
        System.out.println("--- Dentro do bloco de inicialização de funcionario 2 ---");
    }

    public FuncionarioSequenciaInicializacao(){
        System.out.println("--- Dentro do construtor de funcionario padrão ---");
    }

    public FuncionarioSequenciaInicializacao(String nome){
        System.out.println("--- Dentro do construtor de funcionario 1 ---");
        this.nome = nome;
    }

    public FuncionarioSequenciaInicializacao(String nome, double salario){
        System.out.println("--- Dentro do construtor de funcionario 2 ---");
        this.nome = nome;
        this.salario = salario;
    }


}
