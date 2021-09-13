package br.com.abc.javacore.Oexception.objetocontaparateste.classes;

public class Pessoa {
    private String nome;

    @Override
    public String toString() {
        return "PessoaOptional{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
