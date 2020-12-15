package Estudando.javacore.ZZJoptional.classes;

import java.util.Optional;

public class PessoaOptional {
    private CarroOptional carroOptional;
    private String nome;
    private int idade;

    public PessoaOptional(CarroOptional carroOptional, String nome, int idade) {
        this.carroOptional = carroOptional;
        this.nome = nome;
        this.idade = idade;
    }

    public PessoaOptional() {
    }

    @Override
    public String toString() {
        return "PessoaOptional{" +
                "carroOptional=" + carroOptional +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

    // getCarroOptional opcional(optional) porque nem sempre
    // uma pessoa pode ter carroOptional
    public Optional<CarroOptional> getCarroOptional() {
        return Optional.ofNullable(carroOptional);
    }

    public void setCarroOptional(CarroOptional carroOptional) {
        this.carroOptional = carroOptional;
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
