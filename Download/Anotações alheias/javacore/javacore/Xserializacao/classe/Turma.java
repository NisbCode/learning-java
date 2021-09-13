package br.com.abc.javacore.Xserializacao.classe;

import sun.plugin2.message.Serializer;

import java.io.Serializable;

// Se for numa associação, todas as classes
        // devem implementar a serialização
public class Turma implements Serializable {
    private String nome;

    public Turma(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Turma{" +
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
