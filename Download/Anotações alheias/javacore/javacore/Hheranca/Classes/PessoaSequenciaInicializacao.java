package br.com.abc.javacore.Hheranca.Classes;

public class PessoaSequenciaInicializacao {
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
    private String cpf;

    static {
        System.out.println("--- Dentro do bloco de inicialização de pessoa estático  ---");
    }

    {
        System.out.println("--- Dentro do bloco de inicialização de pessoa 1 ---");
    }

    {
        System.out.println("--- Dentro do bloco de inicialização de pessoa 2 ---");
    }

    public void printInformations(){
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
    }

    public PessoaSequenciaInicializacao(){
        System.out.println("--- Dentro do construtor de pessoa padrão ---");
    }

    public PessoaSequenciaInicializacao(String nome){
        System.out.println("--- Dentro do construtor de pessoa 1 ---");
        this.nome = nome;
    }

    public PessoaSequenciaInicializacao(String nome, String cpf){
        this(nome);
        this.cpf = cpf;
        System.out.println("--- Dentro do construtor de pessoa 2 ---");
    }

}
