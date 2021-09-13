package Estudando.javacore.ZZKstreams.classes;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Pessoa {
    private String nome;
    private int idade;
    private double salario;
    private Genero genero;

    public Pessoa(String nome, int idade, double salario, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public static List<Pessoa> bancoDePessoas(){
        return asList(
            new Pessoa("William", 22, 2000, Genero.MASCULINO),
            new Pessoa("Naty", 17, 1500, Genero.FEMININO),
            new Pessoa("Adri", 19, 1500, Genero.FEMININO),
            new Pessoa("Carlos", 16, 950, Genero.MASCULINO),
            new Pessoa("Thor", 23, 1980, Genero.MASCULINO),
            new Pessoa("Hulk", 35, 8000, Genero.MASCULINO),
            new Pessoa("Flash", 29, 3200, Genero.MASCULINO),
            new Pessoa("Batman", 37, 10000, Genero.MASCULINO),
            new Pessoa("Lanterna Verde", 24, 5000, Genero.MASCULINO)

        );
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
