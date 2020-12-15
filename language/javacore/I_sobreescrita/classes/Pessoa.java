package Estudando.javacore.I_sobreescrita.classes;

public class Pessoa extends Object{
    private String nome;
    private int idade;

//  Sobreescrevendo um método com mãe classe em Object, USADO PELO ALT+INSERT
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
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
