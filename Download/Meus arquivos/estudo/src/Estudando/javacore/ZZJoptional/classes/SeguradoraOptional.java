package Estudando.javacore.ZZJoptional.classes;

import java.util.Optional;

public class SeguradoraOptional {
    String nome;

    public SeguradoraOptional(String nome) {
        this.nome = nome;
    }

    public SeguradoraOptional() {
    }

    @Override
    public String toString() {
        return "SeguradoraOptional{" +
                "nome='" + nome + '\'' +
                '}';
    }

    // Para o caso do nome da seguradora poder vir nulo,
    // é adicionado o Optional. Isso
    // não muda relevantemente, apenas faz com que
    // desenvolvedores entendam que aquela variável
    // pode vir nula só de olhar
    public Optional<String> getNome() {
        return Optional.ofNullable(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
