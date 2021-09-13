package Estudando.javacore.H_heranca.classe;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected Endereco endereco;


    //Se você cria um construtor aqui $
    public Pessoa(String nome){
        this.nome = nome;
    }

    public Pessoa(String nome, String cpf){
        this(nome);
        this.cpf = cpf;
    }


    public void imprime() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Endereço ---> Rua: " + this.endereco.getRua() + "; Bairro: " + this.endereco.getBairro());
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
